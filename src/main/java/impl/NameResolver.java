package impl;
import framework.project3.ErrorReporter;
import generated.Splc;
import generated.SplcBaseVisitor;
import impl.symbol.*;
import impl.type.*;
import org.antlr.v4.runtime.Token;
import java.util.List;

// Student's main semantic-analysis implementation.
public final class NameResolver extends SplcBaseVisitor<Void> {
    private final GlobalScope globalScope = new GlobalScope();
    private Scope currentScope = globalScope;
    private final ErrorReporter reporter;
    public NameResolver(ErrorReporter reporter) { this.reporter = reporter; }
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
        if (ctx.expression() != null) visit(ctx.expression());
        return null;
    }
    @Override public Void visitExpression(Splc.ExpressionContext ctx) {
        if (ctx.Identifier() != null && ctx.DOT() == null) {
            Token name = ctx.Identifier().getSymbol();
            if (currentScope.resolve(name.getText()) == null) reporter.undeclaredIdentifier(name);
        }
        return visitChildren(ctx);
    }
}
