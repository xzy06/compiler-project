import generated.Splc.SplcBaseListener;
import generated.Splc.SplcParser;
import impl.Scope;
import impl.SplcSemanticError;
import impl.type.PrimitiveType;
import impl.type.Type;
import impl.symbol.FunctionSymbol;
import impl.symbol.VariableSymbol;

import java.util.ArrayList;
import java.util.List;

public class SyntaxListener extends SplcBaseListener {
    private Scope globalScope = new Scope(null);
    private Scope currentScope = globalScope;

    private final List<SplcSemanticError> errors = new ArrayList<>();

    public Scope getGlobalScope() {
        return globalScope;
    }

    public Scope getCurrentScope() {
        return currentScope;
    }

    public List<SplcSemanticError> getErrors() {
        return errors;
    }

    @Override
    public void enterGlobalDef(SplcParser.GlobalDefContext ctx) {
        if (ctx.LBRACE() != null && ctx.RBRACE() != null) {
            visitFuncDef(ctx);
        } else {
            visitVariableDec(ctx);
        }
    }

    // Variable Declare:
    private void visitVariableDec(SplcParser.GlobalDefContext ctx) {
        String name = ctx.varDec().getText();
        Type type = resolveType(ctx.specifier());

        VariableSymbol variable = globalScope.defineVariable(name, type);

        if (variable == null) {
            // 报告重复定义错误
            // 可以通过 ctx.Identifier() 或 ctx.varDec() 获取源码位置
        }
    }

    private void visitFuncDef(SplcParser.GlobalDefContext ctx) {
        String funcName = ctx.Identifier().getText();
        Type returnType = resolveType(ctx.specifier());

        List<VariableSymbol> params = new ArrayList<>();
        SplcParser.FuncArgsContext argsCtx = ctx.funcArgs();

        for (int i = 0; i < argsCtx.Identifier().size(); i++) {
            String paramName = argsCtx.Identifier(i).getText();
            Type paramType = resolveType(argsCtx.specifier(i));

            params.add(
                    new VariableSymbol(paramName, paramType));
        }

        FunctionSymbol function = currentScope.defineFunction(funcName, returnType, params);

        if (function == null) {
            // 根据 SplcSemanticError 的构造函数添加错误
            // 错误位置：ctx.Identifier().getSymbol().getLine()
            return;
        }

        for (VariableSymbol param : params) {
            function.defineVariable(param.getName(), param.getType());
        }

        // 后续分析函数体时，切换到函数作用域
        currentScope = function;
    }

    @Override
    public void enterLocalVariableStmt(
            SplcParser.LocalVariableStmtContext ctx) {

        SplcParser.VarDecContext varDecCtx = ctx.varDec();
        while (varDecCtx.varDec() != null) {
            varDecCtx = varDecCtx.varDec();
        }
        String name = varDecCtx.Identifier().getText();
        Type type = resolveType(ctx.specifier());

        VariableSymbol variable = currentScope.defineVariable(name, type);

        if (variable == null) {
            // 记录变量重复定义错误
        }
    }

    private Type resolveType(SplcParser.SpecifierContext ctx) {
        if (ctx.INT() != null) {
            return PrimitiveType.INT;
        } else if (ctx.CHAR() != null) {
            return PrimitiveType.CHAR;
        } else {
            return PrimitiveType.VOID;
        }
    }
}
