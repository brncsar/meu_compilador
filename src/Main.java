import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import linguagem.MinhaLinguagemLexer;
import linguagem.MinhaLinguagemParser;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        
        // 1. Configuração inicial (fornecendo o arquivo de entrada)
        String inputFile = args.length > 0 ? args[0] : "exemplos/exemplo_correto.txt";
        InputStream is = new FileInputStream(inputFile);

        // 2. INÍCIO DO BLOCO TRY
        try {
            CharStream input = CharStreams.fromStream(is);
            MinhaLinguagemLexer lexer = new MinhaLinguagemLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MinhaLinguagemParser parser = new MinhaLinguagemParser(tokens);

            // Adiciona listener para tratar erros de sintaxe
            parser.removeErrorListeners(); 
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                    throw new RuntimeException("ERRO SINTÁTICO na linha " + line + ":" + charPositionInLine + " - " + msg);
                }
            });


            ParseTree tree = parser.programa(); // regra inicial da gramática

            MeuCompiladorVisitor visitor = new MeuCompiladorVisitor();
            visitor.visit(tree); // Inicia a visita da árvore (ponto onde SemanticError será lançado)
            
            // Esta linha só será executada se NENHUM erro for lançado no bloco try
            System.out.println("Compilação concluída com sucesso!");

        } catch (SemanticError e) {
            // FIM DO BLOCO TRY. INÍCIO DO CATCH PARA ERROS SEMÂNTICOS
            System.err.println(e.getMessage()); // Imprime a mensagem de erro formatada de SemanticError.java
            System.err.println("Execução interrompida devido a erro semântico.");

        } catch (RuntimeException e) {
            // Captura erros de Sintaxe, Lexer ou outros erros de runtime que não são SemanticError
            System.err.println(e.getMessage());
            System.err.println("Execução interrompida.");
            
        } catch (Exception e) {
            // Captura erros gerais (como problemas de arquivo)
            System.err.println("ERRO INESPERADO: " + e.getMessage());
        }
    }
}