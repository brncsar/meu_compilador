
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import linguagem.MinhaLinguagemLexer;
import linguagem.MinhaLinguagemParser;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputFile = args.length > 0 ? args[0] : "exemplos/exemplo_correto.txt";
        InputStream is = new FileInputStream(inputFile);

        CharStream input = CharStreams.fromStream(is);
        MinhaLinguagemLexer lexer = new MinhaLinguagemLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MinhaLinguagemParser parser = new MinhaLinguagemParser(tokens);

        ParseTree tree = parser.programa(); // regra inicial da gramática

        MeuCompiladorVisitor visitor = new MeuCompiladorVisitor();
        visitor.visit(tree); // Inicia a visita da árvore
        
        System.out.println("Compilação concluída com sucesso!");
    }
}
