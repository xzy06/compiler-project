// Generated from Splc.g4 by ANTLR 4.13.2
package generated.Splc;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SplcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RETURN=1, ASSIGN=2, PLUS=3, MINUS=4, STAR=5, DIV=6, SEMI=7, COMMA=8, LPAREN=9, 
		RPAREN=10, LBRACE=11, RBRACE=12, LBRACK=13, RBRACK=14, INT=15, CHAR=16, 
		VOID=17, Identifier=18, NUMBER=19, CHAR_VALUE=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"RETURN", "ASSIGN", "PLUS", "MINUS", "STAR", "DIV", "SEMI", "COMMA", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "INT", "CHAR", 
			"VOID", "Identifier", "NUMBER", "CHAR_VALUE", "EscapeChar", "WS"
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


	public SplcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Splc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0015y\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0005"+
		"\u0011_\b\u0011\n\u0011\f\u0011b\t\u0011\u0001\u0012\u0004\u0012e\b\u0012"+
		"\u000b\u0012\f\u0012f\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"l\b\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0004\u0015t\b\u0015\u000b\u0015\f\u0015u\u0001\u0015\u0001"+
		"\u0015\u0000\u0000\u0016\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'"+
		"\u0014)\u0000+\u0015\u0001\u0000\u0006\u0003\u0000AZ__az\u0004\u00000"+
		"9AZ__az\u0001\u000009\u0002\u0000\'\'\\\\\u0005\u0000\'\'00\\\\nntt\u0003"+
		"\u0000\t\n\r\r  {\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000"+
		"%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000+\u0001"+
		"\u0000\u0000\u0000\u0001-\u0001\u0000\u0000\u0000\u00034\u0001\u0000\u0000"+
		"\u0000\u00056\u0001\u0000\u0000\u0000\u00078\u0001\u0000\u0000\u0000\t"+
		":\u0001\u0000\u0000\u0000\u000b<\u0001\u0000\u0000\u0000\r>\u0001\u0000"+
		"\u0000\u0000\u000f@\u0001\u0000\u0000\u0000\u0011B\u0001\u0000\u0000\u0000"+
		"\u0013D\u0001\u0000\u0000\u0000\u0015F\u0001\u0000\u0000\u0000\u0017H"+
		"\u0001\u0000\u0000\u0000\u0019J\u0001\u0000\u0000\u0000\u001bL\u0001\u0000"+
		"\u0000\u0000\u001dN\u0001\u0000\u0000\u0000\u001fR\u0001\u0000\u0000\u0000"+
		"!W\u0001\u0000\u0000\u0000#\\\u0001\u0000\u0000\u0000%d\u0001\u0000\u0000"+
		"\u0000\'h\u0001\u0000\u0000\u0000)o\u0001\u0000\u0000\u0000+s\u0001\u0000"+
		"\u0000\u0000-.\u0005r\u0000\u0000./\u0005e\u0000\u0000/0\u0005t\u0000"+
		"\u000001\u0005u\u0000\u000012\u0005r\u0000\u000023\u0005n\u0000\u0000"+
		"3\u0002\u0001\u0000\u0000\u000045\u0005=\u0000\u00005\u0004\u0001\u0000"+
		"\u0000\u000067\u0005+\u0000\u00007\u0006\u0001\u0000\u0000\u000089\u0005"+
		"-\u0000\u00009\b\u0001\u0000\u0000\u0000:;\u0005*\u0000\u0000;\n\u0001"+
		"\u0000\u0000\u0000<=\u0005/\u0000\u0000=\f\u0001\u0000\u0000\u0000>?\u0005"+
		";\u0000\u0000?\u000e\u0001\u0000\u0000\u0000@A\u0005,\u0000\u0000A\u0010"+
		"\u0001\u0000\u0000\u0000BC\u0005(\u0000\u0000C\u0012\u0001\u0000\u0000"+
		"\u0000DE\u0005)\u0000\u0000E\u0014\u0001\u0000\u0000\u0000FG\u0005{\u0000"+
		"\u0000G\u0016\u0001\u0000\u0000\u0000HI\u0005}\u0000\u0000I\u0018\u0001"+
		"\u0000\u0000\u0000JK\u0005[\u0000\u0000K\u001a\u0001\u0000\u0000\u0000"+
		"LM\u0005]\u0000\u0000M\u001c\u0001\u0000\u0000\u0000NO\u0005i\u0000\u0000"+
		"OP\u0005n\u0000\u0000PQ\u0005t\u0000\u0000Q\u001e\u0001\u0000\u0000\u0000"+
		"RS\u0005c\u0000\u0000ST\u0005h\u0000\u0000TU\u0005a\u0000\u0000UV\u0005"+
		"r\u0000\u0000V \u0001\u0000\u0000\u0000WX\u0005v\u0000\u0000XY\u0005o"+
		"\u0000\u0000YZ\u0005i\u0000\u0000Z[\u0005d\u0000\u0000[\"\u0001\u0000"+
		"\u0000\u0000\\`\u0007\u0000\u0000\u0000]_\u0007\u0001\u0000\u0000^]\u0001"+
		"\u0000\u0000\u0000_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000"+
		"`a\u0001\u0000\u0000\u0000a$\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000"+
		"\u0000ce\u0007\u0002\u0000\u0000dc\u0001\u0000\u0000\u0000ef\u0001\u0000"+
		"\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000g&\u0001"+
		"\u0000\u0000\u0000hk\u0005\'\u0000\u0000il\u0003)\u0014\u0000jl\b\u0003"+
		"\u0000\u0000ki\u0001\u0000\u0000\u0000kj\u0001\u0000\u0000\u0000lm\u0001"+
		"\u0000\u0000\u0000mn\u0005\'\u0000\u0000n(\u0001\u0000\u0000\u0000op\u0005"+
		"\\\u0000\u0000pq\u0007\u0004\u0000\u0000q*\u0001\u0000\u0000\u0000rt\u0007"+
		"\u0005\u0000\u0000sr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000wx\u0006\u0015\u0000\u0000x,\u0001\u0000\u0000\u0000\u0005\u0000"+
		"`fku\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}