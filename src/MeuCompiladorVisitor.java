// src/MeuCompiladorVisitor.java

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Importa classes ANTLR (ajuste o prefixo 'linguagem.' se você não usou pacote ou usou outro)
import linguagem.MinhaLinguagemBaseVisitor;
import linguagem.MinhaLinguagemParser;


public class MeuCompiladorVisitor extends MinhaLinguagemBaseVisitor<Object> {

    private final Scanner scanner = new Scanner(System.in);
    // Tabela de Símbolos: Mapeia o nome da variável para o objeto Simbolo
    private final Map<String, Simbolo> tabelaSimbolos = new HashMap<>();

    // Método auxiliar para mapear o token de tipo para nosso enum Tipo
    private Tipo stringParaTipo(String tipoStr) {
        if (tipoStr == null) return Tipo.INVALIDO;
        switch (tipoStr.toUpperCase()) {
            case "INT": return Tipo.INTEIRO;
            case "FLOAT": return Tipo.REAL;
            case "STRING": return Tipo.TEXTO;
            default: return Tipo.INVALIDO;
        }
    }

    // --- LÓGICA DO COMPILADOR: VISITA À DECLARAÇÃO ---
    @Override
    public Object visitDeclaracao(MinhaLinguagemParser.DeclaracaoContext ctx) {
        // 1. Capturar informações da regra (Nome e Tipo)
        String nomeVar = ctx.ID().getText();
        // CORREÇÃO: Usa ctx.tipo() para acessar a sub-regra 'tipo'
        String tipoToken = ctx.tipo().getText();
        Tipo tipo = stringParaTipo(tipoToken); // Seu método auxiliar

        // 2. Análise Semântica: Verificar Redeclaração
        if (tabelaSimbolos.containsKey(nomeVar)) {
            System.err.println("ERRO SEMÂNTICO: Variável '" + nomeVar + "' já foi declarada!");
            // Aqui você deve registrar o erro e parar o processamento (opcionalmente).
            return null;
        }

        // 3. Análise Semântica: Verificar Tipo Válido
        if (tipo == Tipo.INVALIDO) {
            System.err.println("ERRO SEMÂNTICO: Tipo de variável '" + tipoToken + "' inválido.");
            return null;
        }

        // 4. Armazenar na Tabela de Símbolos
        Simbolo novoSimbolo = new Simbolo(nomeVar, tipo);
        tabelaSimbolos.put(nomeVar, novoSimbolo);

        System.out.println("[Análise Semântica]: Variável '" + nomeVar + "' (" + tipo + ") registrada com sucesso.");
        return null;
    }

    // Implemente visitPrograma para iniciar a travessia
    @Override
    public Object visitPrograma(MinhaLinguagemParser.ProgramaContext ctx) {
        System.out.println("Iniciando a Análise Semântica do programa...");
        return super.visitPrograma(ctx);
    }

    @Override
    public Object visitAtribuicao(MinhaLinguagemParser.AtribuicaoContext ctx) {
        String nomeVar = ctx.ID().getText();

        // 1. ANÁLISE SEMÂNTICA: A variável existe?
        if (!tabelaSimbolos.containsKey(nomeVar)) {
            System.err.println("ERRO SEMÂNTICO: Variável '" + nomeVar + "' não foi declarada antes de ser usada.");
            return null;
        }

        // Pega o tipo declarado (Simbolo)
        Simbolo simbolo = tabelaSimbolos.get(nomeVar);
        Tipo tipoDeclarado = simbolo.getTipo();

        // 2. AVALIAÇÃO: Calcula o valor do lado direito (recursivamente)
        // Chamamos o visit(ctx.expressao()) para obter o resultado em Valor.
        Valor valorDaExpressao = (Valor) visit(ctx.expressao());

        // Se a expressão falhou ou é nula
        if (valorDaExpressao == null) {
            System.err.println("ERRO: Expressão inválida no lado direito da atribuição.");
            return null;
        }

        // 3. ANÁLISE DE TIPOS: O tipo da expressão é compatível com o tipo declarado?
        Tipo tipoExpressao = valorDaExpressao.getTipo();

        // Verificações básicas de compatibilidade (você pode aprimorar isso)
        boolean tiposCompativeis =
            (tipoDeclarado == tipoExpressao) || // Tipos são iguais
            (tipoDeclarado == Tipo.REAL && tipoExpressao == Tipo.INTEIRO); // REAL aceita INTEIRO (promoção)

        if (!tiposCompativeis) {
            System.err.println("ERRO SEMÂNTICO: Tentativa de atribuir " + tipoExpressao + " à variável '" + nomeVar + "' do tipo " + tipoDeclarado);
            return null;
        }

        // 4. GERAÇÃO DE CÓDIGO (SIMULAÇÃO): Armazena o valor

        System.out.println("[Análise Semântica]: Atribuição válida. Variável '" + nomeVar + "' recebeu um valor do tipo " + tipoExpressao);

        simbolo.setValor(valorDaExpressao.getValor());
        System.out.println("[Análise Semântica]: Atribuição válida. Variável '" + nomeVar + "' recebeu valor.");

        return null;
    }

    // --- MÉTODOS DE EXPRESSÃO ATUALIZADOS (Hierarquia de Precedência) ---

    @Override
    // Nova regra para SOMA e SUBTRAÇÃO (mais baixa precedência)
    public Valor visitExpressao(MinhaLinguagemParser.ExpressaoContext ctx) {
        // Começa com o primeiro 'termo' (o lado esquerdo da primeira operação)
        Valor resultado = (Valor) visit(ctx.termo(0));

        // Itera sobre todos os operadores e termos restantes (loop da regra gramatical)
        for (int i = 1; i < ctx.termo().size(); i++) {
            // Os operadores estão em índices ímpares (1, 3, 5...) na lista de filhos
            String op = ctx.getChild(2 * i - 1).getText();
            Valor direita = (Valor) visit(ctx.termo(i));

            if (resultado == null || direita == null) return new Valor(Tipo.INVALIDO, null);

            // 1. ANÁLISE DE TIPOS: Verifica se é possível somar/subtrair
            if (resultado.getTipo() == Tipo.TEXTO || direita.getTipo() == Tipo.TEXTO) {
                if (op.equals("+")) {
                    // Permite concatenação de strings
                    String resultadoStr = resultado.asString() + direita.asString();
                    resultado = new Valor(Tipo.TEXTO, resultadoStr);
                } else {
                    // Não permite subtração de strings
                    System.err.println("ERRO SEMÂNTICO: Não é possível subtrair textos (strings).");
                    return new Valor(Tipo.INVALIDO, null);
                }
            } else {
                // 2. CÁLCULO: Se houver REAL, promove tudo para Double
                if (resultado.getTipo() == Tipo.REAL || direita.getTipo() == Tipo.REAL) {
                    double valEsquerda = resultado.asDouble();
                    double valDireita = direita.asDouble();
                    double novoResultado = op.equals("+") ? valEsquerda + valDireita : valEsquerda - valDireita;
                    resultado = new Valor(Tipo.REAL, novoResultado);
                }
                // 3. CÁLCULO: Se ambos forem INTEIRO
                else if (resultado.getTipo() == Tipo.INTEIRO && direita.getTipo() == Tipo.INTEIRO) {
                    int valEsquerda = resultado.asInteger();
                    int valDireita = direita.asInteger();
                    int novoResultado = op.equals("+") ? valEsquerda + valDireita : valEsquerda - valDireita;
                    resultado = new Valor(Tipo.INTEIRO, novoResultado);
                }
                // 4. Tipos incompatíveis (ex: Tipo.INVALIDO)
                else {
                    System.err.println("ERRO SEMÂNTICO: Tipos incompatíveis para operação: " + resultado.getTipo() + " " + op + " " + direita.getTipo());
                    return new Valor(Tipo.INVALIDO, null);
                }
            }
        }
        return resultado;
    }


    @Override
    // Nova regra para MULTIPLICAÇÃO e DIVISÃO (média precedência)
    public Valor visitTermo(MinhaLinguagemParser.TermoContext ctx) {
        // Começa com o primeiro 'fator'
        Valor resultado = (Valor) visit(ctx.fator(0));

        // Itera sobre todos os operadores e fatores restantes (loop da regra gramatical)
        for (int i = 1; i < ctx.fator().size(); i++) {
            // Os operadores estão em índices ímpares (1, 3, 5...) na lista de filhos
            String op = ctx.getChild(2 * i - 1).getText();
            Valor direita = (Valor) visit(ctx.fator(i));

            if (resultado == null || direita == null) return new Valor(Tipo.INVALIDO, null);

            // 1. ANÁLISE DE TIPOS: Não permite operações matemáticas em TEXTO
            if (resultado.getTipo() == Tipo.TEXTO || direita.getTipo() == Tipo.TEXTO) {
                System.err.println("ERRO SEMÂNTICO: Operação " + op + " inválida para textos (strings).");
                return new Valor(Tipo.INVALIDO, null);
            }

            // 2. CÁLCULO: Se houver REAL, promove para Double
            if (resultado.getTipo() == Tipo.REAL || direita.getTipo() == Tipo.REAL) {
                double valEsquerda = resultado.asDouble();
                double valDireita = direita.asDouble();

                if (op.equals("/") && valDireita == 0.0) {
                    System.err.println("ERRO EM TEMPO DE EXECUÇÃO: Divisão por zero.");
                    return new Valor(Tipo.INVALIDO, null);
                }

                double novoResultado = op.equals("*") ? valEsquerda * valDireita : valEsquerda / valDireita;
                resultado = new Valor(Tipo.REAL, novoResultado);
            }
            // 3. CÁLCULO: Se ambos forem INTEIRO
            else if (resultado.getTipo() == Tipo.INTEIRO && direita.getTipo() == Tipo.INTEIRO) {
                int valEsquerda = resultado.asInteger();
                int valDireita = direita.asInteger();

                if (op.equals("/") && valDireita == 0) {
                    System.err.println("ERRO EM TEMPO DE EXECUÇÃO: Divisão por zero.");
                    return new Valor(Tipo.INVALIDO, null);
                }

                int novoResultado = op.equals("*") ? valEsquerda * valDireita : valEsquerda / valDireita;
                resultado = new Valor(Tipo.INTEIRO, novoResultado);
            } else {
                 System.err.println("ERRO SEMÂNTICO: Tipos incompatíveis para operação: " + resultado.getTipo() + " " + op + " " + direita.getTipo());
                 return new Valor(Tipo.INVALIDO, null);
            }
        }
        return resultado;
    }

    @Override
    // Nova regra para Parênteses, Variáveis (ID) e Literais (NUMERO, STRING)
    public Object visitFator(MinhaLinguagemParser.FatorContext ctx) {
        // Caso 1: Expressão entre parênteses
        if (ctx.expressao() != null) {
            // Apenas continua a visita recursivamente na expressão interna
            return visit(ctx.expressao());
        }

        // Caso 2: Variável (ID)
        if (ctx.ID() != null) {
             String nomeVar = ctx.ID().getText();

            // Lógica de visitVariavel
            if (!tabelaSimbolos.containsKey(nomeVar)) {
                System.err.println("ERRO SEMÂNTICO: Variável '" + nomeVar + "' não declarada.");
                return new Valor(Tipo.INVALIDO, null);
            }

            Simbolo simbolo = tabelaSimbolos.get(nomeVar);

            if (simbolo.getValor() == null) {
                System.err.println("ERRO SEMÂNTICO: Variável '" + nomeVar + "' usada antes da atribuição de um valor.");
                return new Valor(Tipo.INVALIDO, null);
            }

            // Retorna o valor armazenado, empacotado como Valor
            return new Valor(simbolo.getTipo(), simbolo.getValor());
        }

        // Caso 3: Número Literal (NUMERO)
        if (ctx.NUMERO() != null) {
            // Lógica de visitNumero
            String texto = ctx.NUMERO().getText();

            // Se contém ponto, é REAL (Double). Caso contrário, é INTEIRO.
            if (texto.contains(".")) {
                // O requisito de aceitar números decimais
                return new Valor(Tipo.REAL, Double.parseDouble(texto));
            } else {
                return new Valor(Tipo.INTEIRO, Integer.parseInt(texto));
            }
        }

        // Caso 4: String Literal (STRING)
        if (ctx.STRING() != null) {
            // Lógica de visitTexto
            String texto = ctx.STRING().getText();
            // Remove as aspas (ex: "olá" -> olá)
            String valorString = texto.substring(1, texto.length() - 1);
            return new Valor(Tipo.TEXTO, valorString);
        }

        // Deve sempre retornar um valor se uma sub-regra foi encontrada.
        return new Valor(Tipo.INVALIDO, null);
    }

    // --- FIM DOS MÉTODOS DE EXPRESSÃO ATUALIZADOS ---

    @Override
    public Object visitEscrita(MinhaLinguagemParser.EscritaContext ctx) {
        // 1. Avalia a expressão dentro do printf. O resultado é um objeto Valor.
        Valor valorAImprimir = (Valor) visit(ctx.expressao());

        if (valorAImprimir == null || valorAImprimir.getTipo() == Tipo.INVALIDO) {
            System.err.println("ERRO: Tentativa de imprimir uma expressão inválida.");
            return null;
        }

        // 2. Imprime o valor na saída padrão (terminal)
        // Usamos System.out.println para mostrar o resultado da avaliação da expressão.
        System.out.println("[Saída do Programa]: " + valorAImprimir.getValor());

        return null;
    }

    private boolean isConditionTrue(Valor condicao) {
        if (condicao == null || condicao.getTipo() == Tipo.INVALIDO) {
            return false;
        }

        // Lógica: Qualquer INT/REAL diferente de zero é TRUE
        if (condicao.getTipo() == Tipo.INTEIRO && condicao.asInteger() != 0) {
            return true;
        } else if (condicao.getTipo() == Tipo.REAL && condicao.asDouble() != 0.0) {
            return true;
        }

        // Se for zero, texto, ou qualquer outro valor
        return false;
    }

    @Override
    public Object visitLeitura(MinhaLinguagemParser.LeituraContext ctx) {
        // 1. Obtém o nome da variável a ser lida
        String nomeVar = ctx.ID().getText();

        // 2. Análise Semântica: A variável existe?
        if (!tabelaSimbolos.containsKey(nomeVar)) {
            System.err.println("ERRO SEMÂNTICO: Variável '" + nomeVar + "' usada no scanf não foi declarada.");
            return null;
        }

        Simbolo simbolo = tabelaSimbolos.get(nomeVar);
        Tipo tipoEsperado = simbolo.getTipo();

        System.out.print("[Leitura scanf]: Digite um valor para a variável " + nomeVar + " (" + tipoEsperado + "): ");

        // 3. Lê a entrada e armazena o valor (Lógica do Compilador/Interpretador)
        try {
            Object valorLido = null;
            String entrada = scanner.nextLine(); // Leitura da linha completa

            switch (tipoEsperado) {
                case INTEIRO:
                    valorLido = Integer.parseInt(entrada.trim());
                    break;
                case REAL:
                    // Trata vírgula como ponto para compatibilidade com Java
                    entrada = entrada.replace(',', '.');
                    valorLido = Double.parseDouble(entrada.trim());
                    break;
                case TEXTO:
                    valorLido = entrada;
                    break;
                case INVALIDO:
                    System.err.println("ERRO SEMÂNTICO: Tentativa de leitura em tipo inválido.");
                    return null;
            }

            // 4. Armazena o valor lido na Tabela de Símbolos
            simbolo.setValor(valorLido);
            System.out.println("[Análise Semântica]: Variável '" + nomeVar + "' recebeu valor lido do tipo " + tipoEsperado);

        } catch (NumberFormatException e) {
            System.err.println("ERRO EM TEMPO DE EXECUÇÃO: Entrada inválida. Esperado " + tipoEsperado + ", recebido valor incompatível.");
        }

        return null;
    }

    @Override
    public Object visitWhileLoop(MinhaLinguagemParser.WhileLoopContext ctx) {
        System.out.println("[Fluxo de Controle]: Iniciando loop WHILE.");

        // Avalia a condição inicial (a primeira expressao no contexto)
        Valor condicao = (Valor) visit(ctx.expressao());
        boolean isTrue = isConditionTrue(condicao);

        // Loop: enquanto a condição for verdadeira
        while (isTrue) {
            // 1. Executa o corpo do loop (bloco)
            visit(ctx.bloco());

            // 2. Reavalia a condição (CRUCIAL para evitar loop infinito)
            condicao = (Valor) visit(ctx.expressao());
            isTrue = isConditionTrue(condicao);
        }

        System.out.println("[Fluxo de Controle]: Finalizando loop WHILE.");
        return null;
    }

    @Override
    public Object visitDoWhileLoop(MinhaLinguagemParser.DoWhileLoopContext ctx) {
        System.out.println("[Fluxo de Controle]: Iniciando loop DO-WHILE.");

        boolean isTrue;

        do {
            // 1. Executa o corpo do loop (bloco) antes de qualquer verificação
            visit(ctx.bloco());

            // 2. Avalia a condição no final (a primeira e única expressao no contexto)
            Valor condicao = (Valor) visit(ctx.expressao());
            isTrue = isConditionTrue(condicao);

        } while (isTrue);

        System.out.println("[Fluxo de Controle]: Finalizando loop DO-WHILE.");
        return null;
    }

    @Override
    public Object visitCondicional(MinhaLinguagemParser.CondicionalContext ctx) {
        // 1. Avalia a condição (expressao)
        Valor condicao = (Valor) visit(ctx.expressao());

        if (condicao == null || condicao.getTipo() == Tipo.INVALIDO) {
            System.err.println("ERRO SEMÂNTICO: Condição do IF inválida.");
            return null;
        }

        // Utiliza o método auxiliar que verifica se o valor é TRUE (diferente de zero)
        boolean resultadoCondicao = isConditionTrue(condicao);

        // 2. Executa o bloco IF (Primeiro 'bloco' no contexto, índice 0)
        if (resultadoCondicao) {
            System.out.println("[Fluxo de Controle]: Condição TRUE. Executando bloco IF.");
            return visit(ctx.bloco(0));
        } else {
            // 3. Verifica e executa o bloco ELSE (Segundo 'bloco', índice 1, se existir)
            // ctx.bloco().size() > 1 verifica se existe um segundo bloco (o 'else')
            if (ctx.bloco().size() > 1) {
                System.out.println("[Fluxo de Controle]: Condição FALSE. Executando bloco ELSE.");
                return visit(ctx.bloco(1));
            }
        }

        return null;
    }
}
