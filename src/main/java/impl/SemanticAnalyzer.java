package impl;
import framework.project4.ErrorReporter;
import generated.Splc;
import generated.SplcBaseVisitor;
import impl.symbol.*;
import impl.type.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

// Resolve names and check types in source order.
public final class SemanticAnalyzer extends SplcBaseVisitor<Void> {
    private final GlobalScope globalScope = new GlobalScope();
    private Scope currentScope = globalScope;
    private final ErrorReporter reporter;
    private Type currentReturnType;
    // Preserve argument positions when some declarations could not be registered.
    private final Map<FunctionSymbol, List<Type>> incompleteSignatures = new IdentityHashMap<>();
    public SemanticAnalyzer(ErrorReporter reporter) { this.reporter = reporter; }
    public GlobalScope getGlobalScope() { return globalScope; }

    public void analyze(Splc.ProgramContext program) {
        visit(program);
    }
    private Type resolveType(Splc.TypeContext ctx) {
        if (ctx.INT() != null) return PrimitiveType.INT;
        Token name = ctx.Identifier().getSymbol();
        Type type = globalScope.resolveStruct(name.getText());
        if (type == null) reporter.undefinedStruct(name);
        return type;
    }
    private Type resolveDeclaredType(Splc.VariableDeclContext ctx) {
        Type type = resolveType(ctx.type());
        if (type == null) return null;
        List<Splc.ArrayDimensionContext> dimensions = ctx.arrayDimension();
        for (int i = dimensions.size() - 1; i >= 0; i--) {
            type = new ArrayType(type, Integer.parseInt(dimensions.get(i).Number().getText()));
        }
        return type;
    }
    private void enterScope() { currentScope = new Scope(currentScope); }
    private void exitScope() { currentScope = currentScope.getParent(); }

    @Override public Void visitStructDef(Splc.StructDefContext ctx) {
        Token name = ctx.Identifier().getSymbol();
        if (globalScope.resolveStruct(name.getText()) != null) {
            reporter.redefinedStruct(name);
            return null;
        }
        StructType struct = new StructType(name.getText());
        boolean valid = true;
        for (Splc.FieldDefContext field : ctx.fieldDef()) {
            Splc.VariableDeclContext declaration = field.variableDecl();
            Type type = resolveDeclaredType(declaration);
            if (type == null) {
                valid = false;
                continue;
            }
            Token member = declaration.Identifier().getSymbol();
            if (!struct.defineMember(new VariableSymbol(member.getText(), type))) {
                reporter.duplicateMember(member);
                valid = false;
            }
        }
        if (valid) globalScope.defineStruct(struct);
        return null;
    }
    @Override public Void visitGlobalVarDef(Splc.GlobalVarDefContext ctx) {
        defineVariable(ctx.variableDecl(), globalScope);
        return null;
    }
    private Type defineVariable(Splc.VariableDeclContext ctx, Scope scope) {
        Type type = resolveDeclaredType(ctx);
        if (type == null) return null;
        Token name = ctx.Identifier().getSymbol();
        if (!scope.define(new VariableSymbol(name.getText(), type))) {
            reporter.redefinedSymbol(name);
        }
        return type;
    }
    @Override public Void visitFunctionDef(Splc.FunctionDefContext ctx) {
        Type type = resolveType(ctx.type());
        Token name = ctx.Identifier().getSymbol();
        FunctionSymbol function = new FunctionSymbol(name.getText(), type, globalScope);
        if (type != null && !globalScope.define(function)) reporter.redefinedSymbol(name);
        Scope previous = currentScope;
        Type previousReturnType = currentReturnType;
        currentScope = function;
        currentReturnType = type;
        try {
            if (ctx.parameterList() != null) {
                List<Type> slots = new ArrayList<>();
                for (Splc.ParameterContext parameter : ctx.parameterList().parameter()) {
                    Splc.VariableDeclContext declaration = parameter.variableDecl();
                    Type parameterType = resolveDeclaredType(declaration);
                    slots.add(parameterType);
                    if (parameterType == null) continue;
                    Token parameterName = declaration.Identifier().getSymbol();
                    if (!function.addParameter(new VariableSymbol(parameterName.getText(), parameterType))) {
                        reporter.redefinedSymbol(parameterName);
                    }
                }
                if (slots.size() != function.getParameters().size()) {
                    incompleteSignatures.put(function, slots);
                }
            }
            for (Splc.StatementContext statement : ctx.block().statement()) visit(statement);
        } finally {
            currentScope = previous;
            currentReturnType = previousReturnType;
        }
        return null;
    }
    @Override public Void visitBlock(Splc.BlockContext ctx) {
        enterScope();
        try {
            for (Splc.StatementContext statement : ctx.statement()) visit(statement);
        } finally {
            exitScope();
        }
        return null;
    }
    @Override public Void visitLocalVarDef(Splc.LocalVarDefContext ctx) {
        Type declared = defineVariable(ctx.variableDecl(), currentScope);
        if (ctx.expression() != null) {
            Type initializer = checkExpression(ctx.expression()).type();
            if (declared instanceof ArrayType) {
                reporter.arrayInitializerNotSupported(ctx.variableDecl().Identifier().getSymbol());
            } else if (declared != null && initializer != null && !sameType(declared, initializer)) {
                reporter.typeMismatch(ctx.ASSIGN().getSymbol());
            }
        }
        return null;
    }
    @Override public Void visitReturnStatement(Splc.ReturnStatementContext ctx) {
        Type actual = checkExpression(ctx.expression()).type();
        if (actual != null && currentReturnType != null && !sameType(currentReturnType, actual)) {
            reporter.typeMismatch(ctx.RETURN().getSymbol());
        }
        return null;
    }
    @Override public Void visitIfStatement(Splc.IfStatementContext ctx) {
        checkCondition(ctx.expression(), ctx.IF().getSymbol());
        for (Splc.BlockContext block : ctx.block()) visit(block);
        return null;
    }
    @Override public Void visitWhileStatement(Splc.WhileStatementContext ctx) {
        checkCondition(ctx.expression(), ctx.WHILE().getSymbol());
        visit(ctx.block());
        return null;
    }
    private void checkCondition(Splc.ExpressionContext ctx, Token keyword) {
        Type type = checkExpression(ctx).type();
        if (type != null && type != PrimitiveType.INT) reporter.badConditionType(keyword);
    }
    @Override public Void visitExpression(Splc.ExpressionContext ctx) {
        checkExpression(ctx);
        return null;
    }

    // A variable-backed array cannot be assigned as a whole, but indexing it
    // can produce an assignment target.
    private record ExprInfo(Type type, boolean variablePath) {}
    private static final ExprInfo ERROR = new ExprInfo(null, false);
    private static final ExprInfo INT_VALUE = new ExprInfo(PrimitiveType.INT, false);

    private ExprInfo checkExpression(Splc.ExpressionContext ctx) {
        if (ctx.Number() != null) return INT_VALUE;
        if (ctx.DOT() != null) {
            ExprInfo base = checkExpression(ctx.expression(0));
            if (base.type() == null) return ERROR;
            if (!(base.type() instanceof StructType struct)) {
                reporter.expectedStruct(ctx.DOT().getSymbol());
                return ERROR;
            }
            Token name = ctx.Identifier().getSymbol();
            VariableSymbol member = struct.resolveMember(name.getText());
            if (member == null) {
                reporter.unknownMember(name);
                return ERROR;
            }
            return new ExprInfo(member.getType(), base.variablePath());
        }
        if (ctx.LBRACK() != null) {
            ExprInfo base = checkExpression(ctx.expression(0));
            Type index = checkExpression(ctx.expression(1)).type();
            Token bracket = ctx.LBRACK().getSymbol();
            if (base.type() != null && !(base.type() instanceof ArrayType)) reporter.expectedArray(bracket);
            if (index != null && index != PrimitiveType.INT) reporter.badIndexType(bracket);
            if (!(base.type() instanceof ArrayType array) || index != PrimitiveType.INT) return ERROR;
            return new ExprInfo(array.getElementType(), base.variablePath());
        }
        if (ctx.Identifier() != null) {
            Token name = ctx.Identifier().getSymbol();
            Symbol symbol = currentScope.resolve(name.getText());
            if (symbol == null) reporter.undeclaredIdentifier(name);
            if (ctx.LPAREN() != null) return checkCall(ctx, name, symbol);
            if (symbol instanceof VariableSymbol variable) return new ExprInfo(variable.getType(), true);
            if (symbol != null) reporter.notVariable(name);
            return ERROR;
        }
        if (ctx.LPAREN() != null) return checkExpression(ctx.expression(0));
        if (ctx.ASSIGN() != null) return checkAssignment(ctx);

        if (ctx.expression().size() == 1) {
            Type operand = checkExpression(ctx.expression(0)).type();
            if (operand == null) return ERROR;
            if (operand == PrimitiveType.INT) return INT_VALUE;
            reporter.badUnaryOperand(ctx.getStart());
            return ERROR;
        }
        Type left = checkExpression(ctx.expression(0)).type();
        Type right = checkExpression(ctx.expression(1)).type();
        if (left == null || right == null) return ERROR;
        if (left == PrimitiveType.INT && right == PrimitiveType.INT) return INT_VALUE;
        reporter.badBinaryOperand(((TerminalNode) ctx.getChild(1)).getSymbol());
        return ERROR;
    }

    private ExprInfo checkAssignment(Splc.ExpressionContext ctx) {
        ExprInfo left = checkExpression(ctx.expression(0));
        Token assign = ctx.ASSIGN().getSymbol();
        boolean validTarget = left.variablePath() && !(left.type() instanceof ArrayType);
        if (left.type() != null && !validTarget) reporter.invalidAssignmentTarget(assign);
        Type right = checkExpression(ctx.expression(1)).type();
        if (!validTarget || right == null) return ERROR;
        if (!sameType(left.type(), right)) {
            reporter.typeMismatch(assign);
            return ERROR;
        }
        return new ExprInfo(left.type(), false);
    }

    private ExprInfo checkCall(Splc.ExpressionContext ctx, Token name, Symbol symbol) {
        List<Splc.ExpressionContext> args = ctx.argumentList() == null
                ? List.of() : ctx.argumentList().expression();
        FunctionSymbol function = symbol instanceof FunctionSymbol f ? f : null;
        if (symbol != null && function == null) reporter.notFunction(name);
        List<Type> slots = function == null ? null : incompleteSignatures.get(function);
        boolean matchingCount = function != null
                && (slots == null ? function.getParameters().size() : slots.size()) == args.size();
        if (function != null && !matchingCount) reporter.badArgumentCount(name);

        boolean valid = matchingCount;
        for (int i = 0; i < args.size(); i++) {
            Splc.ExpressionContext arg = args.get(i);
            Type actual = checkExpression(arg).type();
            if (actual == null) {
                valid = false;
            } else if (matchingCount) {
                Type expected = slots == null ? function.getParameters().get(i).getType() : slots.get(i);
                if (expected == null) {
                    valid = false;
                } else if (!sameType(expected, actual)) {
                    reporter.badArgumentType(arg.getStart());
                    valid = false;
                }
            }
        }
        return valid ? new ExprInfo(function.getType(), false) : ERROR;
    }

    private boolean sameType(Type a, Type b) {
        if (a == b) return true; // int and registered struct types have canonical objects.
        if (a instanceof ArrayType aa && b instanceof ArrayType ab) {
            return aa.getLength() == ab.getLength() && sameType(aa.getElementType(), ab.getElementType());
        }
        return false;
    }
}
