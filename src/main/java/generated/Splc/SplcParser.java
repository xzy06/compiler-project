// Generated from Splc.g4 by ANTLR 4.13.2
package generated.Splc;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SplcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RETURN=1, ASSIGN=2, PLUS=3, MINUS=4, STAR=5, DIV=6, SEMI=7, COMMA=8, LPAREN=9, 
		RPAREN=10, LBRACE=11, RBRACE=12, LBRACK=13, RBRACK=14, INT=15, CHAR=16, 
		VOID=17, Identifier=18, NUMBER=19, CHAR_VALUE=20, WS=21;
	public static final int
		RULE_program = 0, RULE_globalDef = 1, RULE_varDec = 2, RULE_specifier = 3, 
		RULE_funcArgs = 4, RULE_statement = 5, RULE_expression = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "globalDef", "varDec", "specifier", "funcArgs", "statement", 
			"expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'return'", "'='", "'+'", "'-'", "'*'", "'/'", "';'", "','", "'('", 
			"')'", "'{'", "'}'", "'['", "']'", "'int'", "'char'", "'void'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "RETURN", "ASSIGN", "PLUS", "MINUS", "STAR", "DIV", "SEMI", "COMMA", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "INT", "CHAR", 
			"VOID", "Identifier", "NUMBER", "CHAR_VALUE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Splc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SplcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SplcParser.EOF, 0); }
		public List<GlobalDefContext> globalDef() {
			return getRuleContexts(GlobalDefContext.class);
		}
		public GlobalDefContext globalDef(int i) {
			return getRuleContext(GlobalDefContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) {
				{
				{
				setState(14);
				globalDef();
				}
				}
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(20);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GlobalDefContext extends ParserRuleContext {
		public SpecifierContext specifier() {
			return getRuleContext(SpecifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(SplcParser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(SplcParser.LPAREN, 0); }
		public FuncArgsContext funcArgs() {
			return getRuleContext(FuncArgsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SplcParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(SplcParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SplcParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SplcParser.SEMI, 0); }
		public GlobalDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterGlobalDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitGlobalDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitGlobalDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalDefContext globalDef() throws RecognitionException {
		GlobalDefContext _localctx = new GlobalDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_globalDef);
		int _la;
		try {
			setState(40);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				specifier();
				setState(23);
				match(Identifier);
				setState(24);
				match(LPAREN);
				setState(25);
				funcArgs();
				setState(26);
				match(RPAREN);
				setState(27);
				match(LBRACE);
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2066946L) != 0)) {
					{
					{
					setState(28);
					statement();
					}
					}
					setState(33);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(34);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				specifier();
				setState(37);
				varDec(0);
				setState(38);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDecContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SplcParser.Identifier, 0); }
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(SplcParser.LBRACK, 0); }
		public TerminalNode NUMBER() { return getToken(SplcParser.NUMBER, 0); }
		public TerminalNode RBRACK() { return getToken(SplcParser.RBRACK, 0); }
		public VarDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterVarDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitVarDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitVarDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDecContext varDec() throws RecognitionException {
		return varDec(0);
	}

	private VarDecContext varDec(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VarDecContext _localctx = new VarDecContext(_ctx, _parentState);
		VarDecContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_varDec, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(43);
			match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VarDecContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_varDec);
					setState(45);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(46);
					match(LBRACK);
					setState(47);
					match(NUMBER);
					setState(48);
					match(RBRACK);
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpecifierContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SplcParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(SplcParser.CHAR, 0); }
		public TerminalNode VOID() { return getToken(SplcParser.VOID, 0); }
		public SpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecifierContext specifier() throws RecognitionException {
		SpecifierContext _localctx = new SpecifierContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncArgsContext extends ParserRuleContext {
		public List<SpecifierContext> specifier() {
			return getRuleContexts(SpecifierContext.class);
		}
		public SpecifierContext specifier(int i) {
			return getRuleContext(SpecifierContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(SplcParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SplcParser.Identifier, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SplcParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SplcParser.COMMA, i);
		}
		public FuncArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterFuncArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitFuncArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitFuncArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncArgsContext funcArgs() throws RecognitionException {
		FuncArgsContext _localctx = new FuncArgsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) {
				{
				setState(56);
				specifier();
				setState(57);
				match(Identifier);
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(58);
					match(COMMA);
					setState(59);
					specifier();
					setState(60);
					match(Identifier);
					}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CombineStmtContext extends StatementContext {
		public TerminalNode LBRACE() { return getToken(SplcParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SplcParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CombineStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterCombineStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitCombineStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitCombineStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LocalVariableStmtContext extends StatementContext {
		public SpecifierContext specifier() {
			return getRuleContext(SpecifierContext.class,0);
		}
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SplcParser.SEMI, 0); }
		public TerminalNode ASSIGN() { return getToken(SplcParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LocalVariableStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterLocalVariableStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitLocalVariableStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitLocalVariableStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(SplcParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SplcParser.SEMI, 0); }
		public ReturnStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStmtContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SplcParser.SEMI, 0); }
		public ExpressionStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterExpressionStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitExpressionStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitExpressionStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		int _la;
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				_localctx = new CombineStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(LBRACE);
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2066946L) != 0)) {
					{
					{
					setState(70);
					statement();
					}
					}
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(76);
				match(RBRACE);
				}
				break;
			case INT:
			case CHAR:
			case VOID:
				_localctx = new LocalVariableStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				specifier();
				setState(78);
				varDec(0);
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(79);
					match(ASSIGN);
					setState(80);
					expression(0);
					}
				}

				setState(83);
				match(SEMI);
				}
				break;
			case RETURN:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				match(RETURN);
				setState(86);
				expression(0);
				setState(87);
				match(SEMI);
				}
				break;
			case LPAREN:
			case Identifier:
			case NUMBER:
			case CHAR_VALUE:
				_localctx = new ExpressionStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
				expression(0);
				setState(90);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(SplcParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(SplcParser.RPAREN, 0); }
		public TerminalNode Identifier() { return getToken(SplcParser.Identifier, 0); }
		public TerminalNode NUMBER() { return getToken(SplcParser.NUMBER, 0); }
		public TerminalNode CHAR_VALUE() { return getToken(SplcParser.CHAR_VALUE, 0); }
		public TerminalNode STAR() { return getToken(SplcParser.STAR, 0); }
		public TerminalNode DIV() { return getToken(SplcParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(SplcParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SplcParser.MINUS, 0); }
		public TerminalNode ASSIGN() { return getToken(SplcParser.ASSIGN, 0); }
		public TerminalNode LBRACK() { return getToken(SplcParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(SplcParser.RBRACK, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				setState(95);
				match(LPAREN);
				setState(96);
				expression(0);
				setState(97);
				match(RPAREN);
				}
				break;
			case Identifier:
				{
				setState(99);
				match(Identifier);
				}
				break;
			case NUMBER:
				{
				setState(100);
				match(NUMBER);
				}
				break;
			case CHAR_VALUE:
				{
				setState(101);
				match(CHAR_VALUE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(118);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(104);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(105);
						_la = _input.LA(1);
						if ( !(_la==STAR || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(106);
						expression(4);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(107);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(108);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(109);
						expression(3);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(110);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(111);
						match(ASSIGN);
						setState(112);
						expression(1);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(113);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(114);
						match(LBRACK);
						setState(115);
						expression(0);
						setState(116);
						match(RBRACK);
						}
						break;
					}
					} 
				}
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return varDec_sempred((VarDecContext)_localctx, predIndex);
		case 6:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean varDec_sempred(VarDecContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		case 4:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0015|\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0005\u0000\u0010"+
		"\b\u0000\n\u0000\f\u0000\u0013\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001\u001e\b\u0001\n\u0001\f\u0001!\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001)\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u00022\b\u0002\n\u0002\f\u00025\t\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004?\b\u0004\n\u0004\f\u0004B\t\u0004\u0003"+
		"\u0004D\b\u0004\u0001\u0005\u0001\u0005\u0005\u0005H\b\u0005\n\u0005\f"+
		"\u0005K\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005R\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005]\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006g\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006w\b\u0006\n\u0006\f\u0006z\t\u0006\u0001"+
		"\u0006\u0000\u0002\u0004\f\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000\u0003"+
		"\u0001\u0000\u000f\u0011\u0001\u0000\u0005\u0006\u0001\u0000\u0003\u0004"+
		"\u0086\u0000\u0011\u0001\u0000\u0000\u0000\u0002(\u0001\u0000\u0000\u0000"+
		"\u0004*\u0001\u0000\u0000\u0000\u00066\u0001\u0000\u0000\u0000\bC\u0001"+
		"\u0000\u0000\u0000\n\\\u0001\u0000\u0000\u0000\ff\u0001\u0000\u0000\u0000"+
		"\u000e\u0010\u0003\u0002\u0001\u0000\u000f\u000e\u0001\u0000\u0000\u0000"+
		"\u0010\u0013\u0001\u0000\u0000\u0000\u0011\u000f\u0001\u0000\u0000\u0000"+
		"\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0014\u0001\u0000\u0000\u0000"+
		"\u0013\u0011\u0001\u0000\u0000\u0000\u0014\u0015\u0005\u0000\u0000\u0001"+
		"\u0015\u0001\u0001\u0000\u0000\u0000\u0016\u0017\u0003\u0006\u0003\u0000"+
		"\u0017\u0018\u0005\u0012\u0000\u0000\u0018\u0019\u0005\t\u0000\u0000\u0019"+
		"\u001a\u0003\b\u0004\u0000\u001a\u001b\u0005\n\u0000\u0000\u001b\u001f"+
		"\u0005\u000b\u0000\u0000\u001c\u001e\u0003\n\u0005\u0000\u001d\u001c\u0001"+
		"\u0000\u0000\u0000\u001e!\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000"+
		"\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \"\u0001\u0000\u0000\u0000"+
		"!\u001f\u0001\u0000\u0000\u0000\"#\u0005\f\u0000\u0000#)\u0001\u0000\u0000"+
		"\u0000$%\u0003\u0006\u0003\u0000%&\u0003\u0004\u0002\u0000&\'\u0005\u0007"+
		"\u0000\u0000\')\u0001\u0000\u0000\u0000(\u0016\u0001\u0000\u0000\u0000"+
		"($\u0001\u0000\u0000\u0000)\u0003\u0001\u0000\u0000\u0000*+\u0006\u0002"+
		"\uffff\uffff\u0000+,\u0005\u0012\u0000\u0000,3\u0001\u0000\u0000\u0000"+
		"-.\n\u0001\u0000\u0000./\u0005\r\u0000\u0000/0\u0005\u0013\u0000\u0000"+
		"02\u0005\u000e\u0000\u00001-\u0001\u0000\u0000\u000025\u0001\u0000\u0000"+
		"\u000031\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u00004\u0005\u0001"+
		"\u0000\u0000\u000053\u0001\u0000\u0000\u000067\u0007\u0000\u0000\u0000"+
		"7\u0007\u0001\u0000\u0000\u000089\u0003\u0006\u0003\u00009@\u0005\u0012"+
		"\u0000\u0000:;\u0005\b\u0000\u0000;<\u0003\u0006\u0003\u0000<=\u0005\u0012"+
		"\u0000\u0000=?\u0001\u0000\u0000\u0000>:\u0001\u0000\u0000\u0000?B\u0001"+
		"\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000"+
		"AD\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000C8\u0001\u0000\u0000"+
		"\u0000CD\u0001\u0000\u0000\u0000D\t\u0001\u0000\u0000\u0000EI\u0005\u000b"+
		"\u0000\u0000FH\u0003\n\u0005\u0000GF\u0001\u0000\u0000\u0000HK\u0001\u0000"+
		"\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JL\u0001"+
		"\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000L]\u0005\f\u0000\u0000MN\u0003"+
		"\u0006\u0003\u0000NQ\u0003\u0004\u0002\u0000OP\u0005\u0002\u0000\u0000"+
		"PR\u0003\f\u0006\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000"+
		"RS\u0001\u0000\u0000\u0000ST\u0005\u0007\u0000\u0000T]\u0001\u0000\u0000"+
		"\u0000UV\u0005\u0001\u0000\u0000VW\u0003\f\u0006\u0000WX\u0005\u0007\u0000"+
		"\u0000X]\u0001\u0000\u0000\u0000YZ\u0003\f\u0006\u0000Z[\u0005\u0007\u0000"+
		"\u0000[]\u0001\u0000\u0000\u0000\\E\u0001\u0000\u0000\u0000\\M\u0001\u0000"+
		"\u0000\u0000\\U\u0001\u0000\u0000\u0000\\Y\u0001\u0000\u0000\u0000]\u000b"+
		"\u0001\u0000\u0000\u0000^_\u0006\u0006\uffff\uffff\u0000_`\u0005\t\u0000"+
		"\u0000`a\u0003\f\u0006\u0000ab\u0005\n\u0000\u0000bg\u0001\u0000\u0000"+
		"\u0000cg\u0005\u0012\u0000\u0000dg\u0005\u0013\u0000\u0000eg\u0005\u0014"+
		"\u0000\u0000f^\u0001\u0000\u0000\u0000fc\u0001\u0000\u0000\u0000fd\u0001"+
		"\u0000\u0000\u0000fe\u0001\u0000\u0000\u0000gx\u0001\u0000\u0000\u0000"+
		"hi\n\u0003\u0000\u0000ij\u0007\u0001\u0000\u0000jw\u0003\f\u0006\u0004"+
		"kl\n\u0002\u0000\u0000lm\u0007\u0002\u0000\u0000mw\u0003\f\u0006\u0003"+
		"no\n\u0001\u0000\u0000op\u0005\u0002\u0000\u0000pw\u0003\f\u0006\u0001"+
		"qr\n\u0004\u0000\u0000rs\u0005\r\u0000\u0000st\u0003\f\u0006\u0000tu\u0005"+
		"\u000e\u0000\u0000uw\u0001\u0000\u0000\u0000vh\u0001\u0000\u0000\u0000"+
		"vk\u0001\u0000\u0000\u0000vn\u0001\u0000\u0000\u0000vq\u0001\u0000\u0000"+
		"\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000"+
		"\u0000\u0000y\r\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000\f\u0011"+
		"\u001f(3@CIQ\\fvx";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}