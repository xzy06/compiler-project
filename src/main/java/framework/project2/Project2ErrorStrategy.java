package framework.project2;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.IntervalSet;

/**
 * Project 2 TODO.
 *
 * ANTLR's DefaultErrorStrategy is still responsible for the actual recovery
 * algorithm. Do NOT reimplement recoverInline(), single-token insertion, or
 * single-token deletion.
 *
 * Your task is to adapt ANTLR's missing-token and unwanted-token reports to
 * ErrorReporter using the line-number rules defined in the Project 2 spec.
 */
public final class Project2ErrorStrategy extends DefaultErrorStrategy {

    private final ErrorReporter reporter;

    public Project2ErrorStrategy(ErrorReporter reporter) {
        this.reporter = reporter;
    }

    @Override
    protected void reportMissingToken(Parser recognizer) {
        if (inErrorRecoveryMode(recognizer)) {
            return;
        }

        beginErrorCondition(recognizer);

        /*
         * TODO:
         * Report the missing symbol through ErrorReporter.
         *
         * You need to determine:
         * 1. which token is missing;
         * 2. which line should be reported.
         */

        // 获取当前尚未消费的 Lookahead Token
        Token currentToken = recognizer.getCurrentToken();

        // 获取 Parser 当前期望的 Token 集合
        IntervalSet expecting = getExpectedTokens(recognizer);

        // 获取缺失的 Token 类型
        int tokenType = expecting.getMinElement();

        // 获取错误行号
        int line = currentToken.getLine() - 1;

        // 报告错误
        reporter.reportMissing(tokenType, line);
    }

    @Override
    protected void reportUnwantedToken(Parser recognizer) {
        if (inErrorRecoveryMode(recognizer)) {
            return;
        }

        beginErrorCondition(recognizer);

        /*
         * TODO:
         * Report the extraneous symbol through ErrorReporter.
         *
         * You need to determine:
         * 1. which token is extraneous;
         * 2. which line should be reported.
         */

        Token token = recognizer.getCurrentToken();

        // 行号从 0 开始
        int line = token.getLine() - 1;

        // 报告多余 Token
        reporter.reportExtraneous(token.getType(), line);
    }
}
