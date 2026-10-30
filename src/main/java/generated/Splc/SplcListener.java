// Generated from Splc.g4 by ANTLR 4.13.2
package generated.Splc;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SplcParser}.
 */
public interface SplcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SplcParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SplcParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SplcParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SplcParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SplcParser#globalDef}.
	 * @param ctx the parse tree
	 */
	void enterGlobalDef(SplcParser.GlobalDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SplcParser#globalDef}.
	 * @param ctx the parse tree
	 */
	void exitGlobalDef(SplcParser.GlobalDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link SplcParser#varDec}.
	 * @param ctx the parse tree
	 */
	void enterVarDec(SplcParser.VarDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link SplcParser#varDec}.
	 * @param ctx the parse tree
	 */
	void exitVarDec(SplcParser.VarDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link SplcParser#specifier}.
	 * @param ctx the parse tree
	 */
	void enterSpecifier(SplcParser.SpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SplcParser#specifier}.
	 * @param ctx the parse tree
	 */
	void exitSpecifier(SplcParser.SpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SplcParser#funcArgs}.
	 * @param ctx the parse tree
	 */
	void enterFuncArgs(SplcParser.FuncArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SplcParser#funcArgs}.
	 * @param ctx the parse tree
	 */
	void exitFuncArgs(SplcParser.FuncArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CombineStmt}
	 * labeled alternative in {@link SplcParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCombineStmt(SplcParser.CombineStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CombineStmt}
	 * labeled alternative in {@link SplcParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCombineStmt(SplcParser.CombineStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LocalVariableStmt}
	 * labeled alternative in {@link SplcParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableStmt(SplcParser.LocalVariableStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LocalVariableStmt}
	 * labeled alternative in {@link SplcParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableStmt(SplcParser.LocalVariableStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link SplcParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(SplcParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link SplcParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(SplcParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionStmt}
	 * labeled alternative in {@link SplcParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStmt(SplcParser.ExpressionStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionStmt}
	 * labeled alternative in {@link SplcParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStmt(SplcParser.ExpressionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SplcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SplcParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SplcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SplcParser.ExpressionContext ctx);
}