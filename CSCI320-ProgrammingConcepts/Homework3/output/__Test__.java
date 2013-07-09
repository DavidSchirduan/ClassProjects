import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        cminusLexer lex = new cminusLexer(new ANTLRFileStream("C:\\Users\\Mercy\\Dropbox\\college stuff\\Computer science\\CSCI320-ProgrammingConcepts\\Homework3\\output\\__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        cminusParser g = new cminusParser(tokens, 49100, null);
        try {
            g.program();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}