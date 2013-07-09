// $ANTLR 3.4 C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g 2011-10-09 20:25:22

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class cminusLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__6=6;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int ID=4;
    public static final int NUM=5;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public cminusLexer() {} 
    public cminusLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public cminusLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g"; }

    // $ANTLR start "T__6"
    public final void mT__6() throws RecognitionException {
        try {
            int _type = T__6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:2:6: ( '!' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:2:8: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__6"

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:3:6: ( '(' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:3:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:4:6: ( ')' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:4:8: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:5:6: ( '*' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:5:8: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:6:7: ( '+' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:6:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:7:7: ( ',' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:7:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:8:7: ( '-' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:8:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:9:7: ( '/' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:9:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:10:7: ( ';' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:10:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:11:7: ( '<' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:11:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:12:7: ( '<=' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:12:9: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:13:7: ( '=' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:13:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:14:7: ( '==' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:14:9: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:15:7: ( '>' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:15:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:16:7: ( '>=' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:16:9: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:17:7: ( '[' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:17:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:18:7: ( ']' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:18:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:19:7: ( 'else' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:19:9: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:20:7: ( 'if' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:20:9: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:21:7: ( 'int' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:21:9: 'int'
            {
            match("int"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:22:7: ( 'return' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:22:9: 'return'
            {
            match("return"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:23:7: ( 'void' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:23:9: 'void'
            {
            match("void"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:24:7: ( 'while' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:24:9: 'while'
            {
            match("while"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:25:7: ( '{' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:25:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:26:7: ( '}' )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:26:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:103:4: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:103:6: ( 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:103:6: ( 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:
            	    {
            	    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "NUM"
    public final void mNUM() throws RecognitionException {
        try {
            int _type = NUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:105:5: ( ( '0' .. '9' )+ )
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:105:7: ( '0' .. '9' )+
            {
            // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:105:7: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:8: ( T__6 | T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | ID | NUM )
        int alt3=27;
        switch ( input.LA(1) ) {
        case '!':
            {
            alt3=1;
            }
            break;
        case '(':
            {
            alt3=2;
            }
            break;
        case ')':
            {
            alt3=3;
            }
            break;
        case '*':
            {
            alt3=4;
            }
            break;
        case '+':
            {
            alt3=5;
            }
            break;
        case ',':
            {
            alt3=6;
            }
            break;
        case '-':
            {
            alt3=7;
            }
            break;
        case '/':
            {
            alt3=8;
            }
            break;
        case ';':
            {
            alt3=9;
            }
            break;
        case '<':
            {
            int LA3_10 = input.LA(2);

            if ( (LA3_10=='=') ) {
                alt3=11;
            }
            else {
                alt3=10;
            }
            }
            break;
        case '=':
            {
            int LA3_11 = input.LA(2);

            if ( (LA3_11=='=') ) {
                alt3=13;
            }
            else {
                alt3=12;
            }
            }
            break;
        case '>':
            {
            int LA3_12 = input.LA(2);

            if ( (LA3_12=='=') ) {
                alt3=15;
            }
            else {
                alt3=14;
            }
            }
            break;
        case '[':
            {
            alt3=16;
            }
            break;
        case ']':
            {
            alt3=17;
            }
            break;
        case 'e':
            {
            int LA3_15 = input.LA(2);

            if ( (LA3_15=='l') ) {
                int LA3_30 = input.LA(3);

                if ( (LA3_30=='s') ) {
                    int LA3_36 = input.LA(4);

                    if ( (LA3_36=='e') ) {
                        int LA3_42 = input.LA(5);

                        if ( ((LA3_42 >= 'A' && LA3_42 <= 'Z')||(LA3_42 >= 'a' && LA3_42 <= 'z')) ) {
                            alt3=26;
                        }
                        else {
                            alt3=18;
                        }
                    }
                    else {
                        alt3=26;
                    }
                }
                else {
                    alt3=26;
                }
            }
            else {
                alt3=26;
            }
            }
            break;
        case 'i':
            {
            switch ( input.LA(2) ) {
            case 'f':
                {
                int LA3_31 = input.LA(3);

                if ( ((LA3_31 >= 'A' && LA3_31 <= 'Z')||(LA3_31 >= 'a' && LA3_31 <= 'z')) ) {
                    alt3=26;
                }
                else {
                    alt3=19;
                }
                }
                break;
            case 'n':
                {
                int LA3_32 = input.LA(3);

                if ( (LA3_32=='t') ) {
                    int LA3_38 = input.LA(4);

                    if ( ((LA3_38 >= 'A' && LA3_38 <= 'Z')||(LA3_38 >= 'a' && LA3_38 <= 'z')) ) {
                        alt3=26;
                    }
                    else {
                        alt3=20;
                    }
                }
                else {
                    alt3=26;
                }
                }
                break;
            default:
                alt3=26;
            }

            }
            break;
        case 'r':
            {
            int LA3_17 = input.LA(2);

            if ( (LA3_17=='e') ) {
                int LA3_33 = input.LA(3);

                if ( (LA3_33=='t') ) {
                    int LA3_39 = input.LA(4);

                    if ( (LA3_39=='u') ) {
                        int LA3_44 = input.LA(5);

                        if ( (LA3_44=='r') ) {
                            int LA3_48 = input.LA(6);

                            if ( (LA3_48=='n') ) {
                                int LA3_51 = input.LA(7);

                                if ( ((LA3_51 >= 'A' && LA3_51 <= 'Z')||(LA3_51 >= 'a' && LA3_51 <= 'z')) ) {
                                    alt3=26;
                                }
                                else {
                                    alt3=21;
                                }
                            }
                            else {
                                alt3=26;
                            }
                        }
                        else {
                            alt3=26;
                        }
                    }
                    else {
                        alt3=26;
                    }
                }
                else {
                    alt3=26;
                }
            }
            else {
                alt3=26;
            }
            }
            break;
        case 'v':
            {
            int LA3_18 = input.LA(2);

            if ( (LA3_18=='o') ) {
                int LA3_34 = input.LA(3);

                if ( (LA3_34=='i') ) {
                    int LA3_40 = input.LA(4);

                    if ( (LA3_40=='d') ) {
                        int LA3_45 = input.LA(5);

                        if ( ((LA3_45 >= 'A' && LA3_45 <= 'Z')||(LA3_45 >= 'a' && LA3_45 <= 'z')) ) {
                            alt3=26;
                        }
                        else {
                            alt3=22;
                        }
                    }
                    else {
                        alt3=26;
                    }
                }
                else {
                    alt3=26;
                }
            }
            else {
                alt3=26;
            }
            }
            break;
        case 'w':
            {
            int LA3_19 = input.LA(2);

            if ( (LA3_19=='h') ) {
                int LA3_35 = input.LA(3);

                if ( (LA3_35=='i') ) {
                    int LA3_41 = input.LA(4);

                    if ( (LA3_41=='l') ) {
                        int LA3_46 = input.LA(5);

                        if ( (LA3_46=='e') ) {
                            int LA3_50 = input.LA(6);

                            if ( ((LA3_50 >= 'A' && LA3_50 <= 'Z')||(LA3_50 >= 'a' && LA3_50 <= 'z')) ) {
                                alt3=26;
                            }
                            else {
                                alt3=23;
                            }
                        }
                        else {
                            alt3=26;
                        }
                    }
                    else {
                        alt3=26;
                    }
                }
                else {
                    alt3=26;
                }
            }
            else {
                alt3=26;
            }
            }
            break;
        case '{':
            {
            alt3=24;
            }
            break;
        case '}':
            {
            alt3=25;
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'f':
        case 'g':
        case 'h':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 's':
        case 't':
        case 'u':
        case 'x':
        case 'y':
        case 'z':
            {
            alt3=26;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt3=27;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 3, 0, input);

            throw nvae;

        }

        switch (alt3) {
            case 1 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:10: T__6
                {
                mT__6(); 


                }
                break;
            case 2 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:15: T__7
                {
                mT__7(); 


                }
                break;
            case 3 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:20: T__8
                {
                mT__8(); 


                }
                break;
            case 4 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:25: T__9
                {
                mT__9(); 


                }
                break;
            case 5 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:30: T__10
                {
                mT__10(); 


                }
                break;
            case 6 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:36: T__11
                {
                mT__11(); 


                }
                break;
            case 7 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:42: T__12
                {
                mT__12(); 


                }
                break;
            case 8 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:48: T__13
                {
                mT__13(); 


                }
                break;
            case 9 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:54: T__14
                {
                mT__14(); 


                }
                break;
            case 10 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:60: T__15
                {
                mT__15(); 


                }
                break;
            case 11 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:66: T__16
                {
                mT__16(); 


                }
                break;
            case 12 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:72: T__17
                {
                mT__17(); 


                }
                break;
            case 13 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:78: T__18
                {
                mT__18(); 


                }
                break;
            case 14 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:84: T__19
                {
                mT__19(); 


                }
                break;
            case 15 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:90: T__20
                {
                mT__20(); 


                }
                break;
            case 16 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:96: T__21
                {
                mT__21(); 


                }
                break;
            case 17 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:102: T__22
                {
                mT__22(); 


                }
                break;
            case 18 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:108: T__23
                {
                mT__23(); 


                }
                break;
            case 19 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:114: T__24
                {
                mT__24(); 


                }
                break;
            case 20 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:120: T__25
                {
                mT__25(); 


                }
                break;
            case 21 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:126: T__26
                {
                mT__26(); 


                }
                break;
            case 22 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:132: T__27
                {
                mT__27(); 


                }
                break;
            case 23 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:138: T__28
                {
                mT__28(); 


                }
                break;
            case 24 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:144: T__29
                {
                mT__29(); 


                }
                break;
            case 25 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:150: T__30
                {
                mT__30(); 


                }
                break;
            case 26 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:156: ID
                {
                mID(); 


                }
                break;
            case 27 :
                // C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\cminus.g:1:159: NUM
                {
                mNUM(); 


                }
                break;

        }

    }


 

}