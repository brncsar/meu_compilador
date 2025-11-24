// Generated from linguagem/MinhaLinguagem.g4 by ANTLR 4.13.2

    package linguagem; // Nome do pacote

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MinhaLinguagemLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, TIPO_INT=11, TIPO_FLOAT=12, TIPO_STRING=13, KW_IF=14, KW_ELSE=15, 
		KW_WHILE=16, KW_FOR=17, KW_DO=18, KW_SCANF=19, KW_PRINTF=20, ID=21, NUMERO=22, 
		STRING=23, WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "TIPO_INT", "TIPO_FLOAT", "TIPO_STRING", "KW_IF", "KW_ELSE", 
			"KW_WHILE", "KW_FOR", "KW_DO", "KW_SCANF", "KW_PRINTF", "ID", "NUMERO", 
			"STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'('", "')'", "'{'", "'}'", "'*'", "'/'", "'+'", 
			"'-'", "'int'", "'float'", "'string'", "'if'", "'else'", "'while'", "'for'", 
			"'do'", "'scanf'", "'printf'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "TIPO_INT", 
			"TIPO_FLOAT", "TIPO_STRING", "KW_IF", "KW_ELSE", "KW_WHILE", "KW_FOR", 
			"KW_DO", "KW_SCANF", "KW_PRINTF", "ID", "NUMERO", "STRING", "WS"
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


	public MinhaLinguagemLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MinhaLinguagem.g4"; }

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
		"\u0004\u0000\u0018\u009c\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0005\u0014{\b\u0014\n\u0014\f\u0014~\t\u0014\u0001\u0015"+
		"\u0004\u0015\u0081\b\u0015\u000b\u0015\f\u0015\u0082\u0001\u0015\u0001"+
		"\u0015\u0004\u0015\u0087\b\u0015\u000b\u0015\f\u0015\u0088\u0003\u0015"+
		"\u008b\b\u0015\u0001\u0016\u0001\u0016\u0005\u0016\u008f\b\u0016\n\u0016"+
		"\f\u0016\u0092\t\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0004\u0017"+
		"\u0097\b\u0017\u000b\u0017\f\u0017\u0098\u0001\u0017\u0001\u0017\u0001"+
		"\u0090\u0000\u0018\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016-\u0017/\u0018\u0001\u0000\u0004\u0003\u0000AZ__az\u0004\u0000"+
		"09AZ__az\u0001\u000009\u0003\u0000\t\n\r\r  \u00a1\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u0001"+
		"1\u0001\u0000\u0000\u0000\u00033\u0001\u0000\u0000\u0000\u00055\u0001"+
		"\u0000\u0000\u0000\u00077\u0001\u0000\u0000\u0000\t9\u0001\u0000\u0000"+
		"\u0000\u000b;\u0001\u0000\u0000\u0000\r=\u0001\u0000\u0000\u0000\u000f"+
		"?\u0001\u0000\u0000\u0000\u0011A\u0001\u0000\u0000\u0000\u0013C\u0001"+
		"\u0000\u0000\u0000\u0015E\u0001\u0000\u0000\u0000\u0017I\u0001\u0000\u0000"+
		"\u0000\u0019O\u0001\u0000\u0000\u0000\u001bV\u0001\u0000\u0000\u0000\u001d"+
		"Y\u0001\u0000\u0000\u0000\u001f^\u0001\u0000\u0000\u0000!d\u0001\u0000"+
		"\u0000\u0000#h\u0001\u0000\u0000\u0000%k\u0001\u0000\u0000\u0000\'q\u0001"+
		"\u0000\u0000\u0000)x\u0001\u0000\u0000\u0000+\u0080\u0001\u0000\u0000"+
		"\u0000-\u008c\u0001\u0000\u0000\u0000/\u0096\u0001\u0000\u0000\u00001"+
		"2\u0005;\u0000\u00002\u0002\u0001\u0000\u0000\u000034\u0005=\u0000\u0000"+
		"4\u0004\u0001\u0000\u0000\u000056\u0005(\u0000\u00006\u0006\u0001\u0000"+
		"\u0000\u000078\u0005)\u0000\u00008\b\u0001\u0000\u0000\u00009:\u0005{"+
		"\u0000\u0000:\n\u0001\u0000\u0000\u0000;<\u0005}\u0000\u0000<\f\u0001"+
		"\u0000\u0000\u0000=>\u0005*\u0000\u0000>\u000e\u0001\u0000\u0000\u0000"+
		"?@\u0005/\u0000\u0000@\u0010\u0001\u0000\u0000\u0000AB\u0005+\u0000\u0000"+
		"B\u0012\u0001\u0000\u0000\u0000CD\u0005-\u0000\u0000D\u0014\u0001\u0000"+
		"\u0000\u0000EF\u0005i\u0000\u0000FG\u0005n\u0000\u0000GH\u0005t\u0000"+
		"\u0000H\u0016\u0001\u0000\u0000\u0000IJ\u0005f\u0000\u0000JK\u0005l\u0000"+
		"\u0000KL\u0005o\u0000\u0000LM\u0005a\u0000\u0000MN\u0005t\u0000\u0000"+
		"N\u0018\u0001\u0000\u0000\u0000OP\u0005s\u0000\u0000PQ\u0005t\u0000\u0000"+
		"QR\u0005r\u0000\u0000RS\u0005i\u0000\u0000ST\u0005n\u0000\u0000TU\u0005"+
		"g\u0000\u0000U\u001a\u0001\u0000\u0000\u0000VW\u0005i\u0000\u0000WX\u0005"+
		"f\u0000\u0000X\u001c\u0001\u0000\u0000\u0000YZ\u0005e\u0000\u0000Z[\u0005"+
		"l\u0000\u0000[\\\u0005s\u0000\u0000\\]\u0005e\u0000\u0000]\u001e\u0001"+
		"\u0000\u0000\u0000^_\u0005w\u0000\u0000_`\u0005h\u0000\u0000`a\u0005i"+
		"\u0000\u0000ab\u0005l\u0000\u0000bc\u0005e\u0000\u0000c \u0001\u0000\u0000"+
		"\u0000de\u0005f\u0000\u0000ef\u0005o\u0000\u0000fg\u0005r\u0000\u0000"+
		"g\"\u0001\u0000\u0000\u0000hi\u0005d\u0000\u0000ij\u0005o\u0000\u0000"+
		"j$\u0001\u0000\u0000\u0000kl\u0005s\u0000\u0000lm\u0005c\u0000\u0000m"+
		"n\u0005a\u0000\u0000no\u0005n\u0000\u0000op\u0005f\u0000\u0000p&\u0001"+
		"\u0000\u0000\u0000qr\u0005p\u0000\u0000rs\u0005r\u0000\u0000st\u0005i"+
		"\u0000\u0000tu\u0005n\u0000\u0000uv\u0005t\u0000\u0000vw\u0005f\u0000"+
		"\u0000w(\u0001\u0000\u0000\u0000x|\u0007\u0000\u0000\u0000y{\u0007\u0001"+
		"\u0000\u0000zy\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000|z\u0001"+
		"\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}*\u0001\u0000\u0000\u0000"+
		"~|\u0001\u0000\u0000\u0000\u007f\u0081\u0007\u0002\u0000\u0000\u0080\u007f"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0080"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u008a"+
		"\u0001\u0000\u0000\u0000\u0084\u0086\u0005.\u0000\u0000\u0085\u0087\u0007"+
		"\u0002\u0000\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001"+
		"\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001"+
		"\u0000\u0000\u0000\u0089\u008b\u0001\u0000\u0000\u0000\u008a\u0084\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b,\u0001\u0000"+
		"\u0000\u0000\u008c\u0090\u0005\"\u0000\u0000\u008d\u008f\t\u0000\u0000"+
		"\u0000\u008e\u008d\u0001\u0000\u0000\u0000\u008f\u0092\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000"+
		"\u0000\u0091\u0093\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0005\"\u0000\u0000\u0094.\u0001\u0000\u0000\u0000"+
		"\u0095\u0097\u0007\u0003\u0000\u0000\u0096\u0095\u0001\u0000\u0000\u0000"+
		"\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0006\u0017\u0000\u0000\u009b0\u0001\u0000\u0000\u0000\u0007"+
		"\u0000|\u0082\u0088\u008a\u0090\u0098\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}