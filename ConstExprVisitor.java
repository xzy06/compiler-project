import framework.project2.ConstExprResult;
import generated.SplcBaseVisitor;
import generated.SplcParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConstExprVisitor extends SplcBaseVisitor<Integer> {

    private final List<ConstExprResult> results = new ArrayList<>();

    public final List<ConstExprResult> getResults() {
        return Collections.unmodifiableList(results);
    }

    protected final void addResult(String expression, int value) {
        results.add(new ConstExprResult(expression, value));
    }

    @Override
    public Integer visitLocalVarDef(SplcParser.LocalVarDefContext ctx) {
        SplcParser.ExpressionContext initializer = ctx.expression();
        if (initializer != null) {
            Integer value = visitExpression(initializer);
            if (value != null) {
                addResult(initializer.getText(), value);
            }
        }
        return null;
    }

    /** Return null for every expression outside the specified constexpr subset. */
    @Override
    public Integer visitExpression(SplcParser.ExpressionContext ctx) {
        if (ctx.getChildCount() == 1 && ctx.Number() != null) {
            return Integer.valueOf(ctx.Number().getText());
        }

        List<SplcParser.ExpressionContext> operands = ctx.expression();

        if (ctx.getChildCount() == 3
                && ctx.LPAREN() != null
                && ctx.RPAREN() != null
                && operands.size() == 1) {
            return visitExpression(operands.get(0));
        }

        if (ctx.getChildCount() == 2
                && operands.size() == 1
                && (ctx.PLUS() != null || ctx.MINUS() != null)) {
            Integer value = visitExpression(operands.get(0));
            if (value == null) {
                return null;
            }
            return ctx.MINUS() != null ? -value : value;
        }

        if (ctx.getChildCount() != 3
                || operands.size() != 2
                || !(ctx.PLUS() != null
                || ctx.MINUS() != null
                || ctx.STAR() != null
                || ctx.DIV() != null
                || ctx.MOD() != null)) {
            return null;
        }

        Integer left = visitExpression(operands.get(0));
        Integer right = visitExpression(operands.get(1));
        if (left == null || right == null) {
            return null;
        }

        if (ctx.PLUS() != null) {
            return left + right;
        }
        if (ctx.MINUS() != null) {
            return left - right;
        }
        if (ctx.STAR() != null) {
            return left * right;
        }
        if (ctx.DIV() != null) {
            return left / right;
        }
        return left % right;
    }
}
