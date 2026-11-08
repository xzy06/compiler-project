package impl;
import framework.project4.ErrorReporter;
import generated.Splc;
import generated.SplcBaseVisitor;
import impl.symbol.*;
import impl.type.*;
import org.antlr.v4.runtime.Token;
import java.util.List;

// Project 3 declaration, scope, and name-resolution implementation.
// Project 4 type checking remains to be implemented.
public final class SemanticAnalyzer extends SplcBaseVisitor<Void> {
    private final GlobalScope globalScope = new GlobalScope();
    private Scope currentScope = globalScope;
    private final ErrorReporter reporter;
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
    private void defineVariable(Splc.VariableDeclContext ctx, Scope scope) {
        Type type = resolveDeclaredType(ctx);
        if (type == null) return;
        Token name = ctx.Identifier().getSymbol();
        if (!scope.define(new VariableSymbol(name.getText(), type))) {
            reporter.redefinedSymbol(name);
        }
    }
    @Override public Void visitFunctionDef(Splc.FunctionDefContext ctx) {
        Type type = resolveType(ctx.type());
        if (type == null) return null;
        Token name = ctx.Identifier().getSymbol();
        FunctionSymbol function = new FunctionSymbol(name.getText(), type, globalScope);
        if (!globalScope.define(function)) reporter.redefinedSymbol(name);
        Scope previous = currentScope;
        currentScope = function;
        try {
            if (ctx.parameterList() != null) {
                for (Splc.ParameterContext parameter : ctx.parameterList().parameter()) {
                    Splc.VariableDeclContext declaration = parameter.variableDecl();
                    Type parameterType = resolveDeclaredType(declaration);
                    if (parameterType == null) continue;
                    Token parameterName = declaration.Identifier().getSymbol();
                    if (!function.addParameter(new VariableSymbol(parameterName.getText(), parameterType))) {
                        reporter.redefinedSymbol(parameterName);
                    }
                }
            }
            for (Splc.StatementContext statement : ctx.block().statement()) visit(statement);
        } finally {
            currentScope = previous;
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
        defineVariable(ctx.variableDecl(), currentScope);
        // TODO (Project 4): check initializer compatibility; reject array initialization.
        if (ctx.expression() != null) visit(ctx.expression());
        return null;
    }
    @Override public Void visitReturnStatement(Splc.ReturnStatementContext ctx) {
        // TODO (Project 4): check against the current function return type.
        return visitChildren(ctx);
    }
    @Override public Void visitIfStatement(Splc.IfStatementContext ctx) {
        // TODO (Project 4): check the condition type.
        return visitChildren(ctx);
    }
    @Override public Void visitWhileStatement(Splc.WhileStatementContext ctx) {
        // TODO (Project 4): check the condition type.
        return visitChildren(ctx);
    }
    @Override public Void visitExpression(Splc.ExpressionContext ctx) {
        if (ctx.Identifier() != null && ctx.DOT() == null && ctx.LPAREN() == null) {
            Token name = ctx.Identifier().getSymbol();
            if (currentScope.resolve(name.getText()) == null) reporter.undeclaredIdentifier(name);
        }

        if (ctx.ASSIGN() != null) {
            Token assign = ctx.ASSIGN().getSymbol();
            Type leftType = checkAssignmentTarget(ctx.expression(0), assign);
            Type rightType = expressionType(ctx.expression(1));
            if (leftType != null && rightType != null && !sameType(leftType, rightType)) {
                reporter.typeMismatch(assign);
            }
            return null;
        }

        return visitChildren(ctx);
    }

    private Type checkAssignmentTarget(Splc.ExpressionContext ctx, Token assignToken) {
        Type type = lvalueType(ctx);
        if (type == null) return null;
        if (type instanceof ArrayType) {
            reporter.invalidAssignmentTarget(assignToken);
            return null;
        }
        return type;
    }

    private Type lvalueType(Splc.ExpressionContext ctx) {
        if (ctx == null) return null;

        // (e)
        if (ctx.LPAREN() != null && ctx.Identifier() == null && ctx.DOT() == null && ctx.LBRACK() == null
                && ctx.getChildCount() == 3) {
            return lvalueType(ctx.expression(0));
        }

        // 普通变量
        if (ctx.Identifier() != null && ctx.LPAREN() == null && ctx.DOT() == null) {
            Token name = ctx.Identifier().getSymbol();
            Symbol symbol = currentScope.resolve(name.getText());
            if (symbol == null) { reporter.undeclaredIdentifier(name); return null; }
            if (!(symbol instanceof VariableSymbol variable)) { reporter.notVariable(name); return null; }
            return variable.getType();
        }

        // 数组元素 base[index]
        if (ctx.LBRACK() != null) {
            Token bracket = ctx.LBRACK().getSymbol();
            Type base = lvalueType(ctx.expression(0));
            Type index = expressionType(ctx.expression(1));
            if (index != null && index != PrimitiveType.INT) reporter.badIndexType(bracket);
            if (base == null) return null;
            if (!(base instanceof ArrayType array)) { reporter.expectedArray(bracket); return null; }
            return array.getElementType();
        }

        // 成员访问 base.name
        if (ctx.DOT() != null) {
            Token dot = ctx.DOT().getSymbol();
            Token member = ctx.Identifier().getSymbol();
            Type base = lvalueType(ctx.expression(0));
            if (base == null) return null;
            if (!(base instanceof StructType struct)) { reporter.expectedStruct(dot); return null; }
            VariableSymbol field = struct.resolveMember(member.getText());
            if (field == null) { reporter.unknownMember(member); return null; }
            return field.getType();
        }

        // 其他不是左值
        reporter.invalidAssignmentTarget(ctx.getStart());
        return null;
    }

    private Type expressionType(Splc.ExpressionContext ctx) {
        if (ctx == null) return null;
        if (ctx.Number() != null) return PrimitiveType.INT;
        if (ctx.Identifier() != null && ctx.LPAREN() == null && ctx.DOT() == null) {
            Symbol symbol = currentScope.resolve(ctx.Identifier().getText());
            if (symbol instanceof VariableSymbol v) return v.getType();
            return null;
        }
        if (ctx.LPAREN() != null && ctx.getChildCount() == 3) return expressionType(ctx.expression(0));
        if (ctx.DOT() != null) {
            Type base = expressionType(ctx.expression(0));
            if (base instanceof StructType struct) {
                VariableSymbol field = struct.resolveMember(ctx.Identifier().getText());
                return field == null ? null : field.getType();
            }
            return null;
        }
        if (ctx.LBRACK() != null) {
            Type base = expressionType(ctx.expression(0));
            return base instanceof ArrayType array ? array.getElementType() : null;
        }
        if (ctx.Identifier() != null && ctx.LPAREN() != null) {
            Symbol symbol = currentScope.resolve(ctx.Identifier().getText());
            return symbol instanceof FunctionSymbol f ? f.getType() : null;
        }
        if (ctx.ASSIGN() != null) return expressionType(ctx.expression(0));
        return PrimitiveType.INT;
    }

    private boolean sameType(Type a, Type b) {
        if (a == null || b == null) return false;
        if (a == PrimitiveType.INT && b == PrimitiveType.INT) return true;
        if (a instanceof ArrayType aa && b instanceof ArrayType ab) {
            return aa.getLength() == ab.getLength() && sameType(aa.getElementType(), ab.getElementType());
        }
        if (a instanceof StructType && b instanceof StructType) return a == b;
        return false;
    }
}
