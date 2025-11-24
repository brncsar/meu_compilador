Este é o código-fonte do compilador da MinhaLinguagem, desenvolvido em Java utilizando o ANTLR 4.13.2 para as fases de Análise Léxica e Sintática. O projeto implementa um Visitor para realizar a Análise Semântica e a Execução (Interpretação) do código.

✅ Requisitos Implementados

O compilador atende aos requisitos mínimos de uma linguagem de programação, incluindo:

    Tipos de Dados: int (INTEIRO), float (REAL), string (TEXTO).

    Controle de Fluxo: Estruturas if/else, while, do/while e for.

    Expressões: Prioridade de operadores (multiplicação/divisão antes de adição/subtração) e regras de promoção de tipos (int + float = float).

    I/O: Comandos de leitura (scanf) e escrita (printf).

    Análise Semântica: Uso de Tabela de Símbolos para verificar declaração de variáveis e atribuições válidas.

🚀 Como Compilar e Executar o Projeto

Pré-requisitos: É necessário ter o Java Development Kit (JDK) 8+ e o Git instalados.

1. Clonar o Repositório

Abra o terminal e clone o projeto:
Bash

git clone [URL_DO_SEU_REPOSITORIO]
cd meu_compilador

2. Estrutura do Projeto

    src/: Contém o código-fonte principal (Main.java, MeuCompiladorVisitor.java, Simbolo.java, Tipo.java, Valor.java).

    src/linguagem/: Contém os arquivos Java gerados pelo ANTLR (MinhaLinguagemLexer.java, MinhaLinguagemParser.java, etc.).

    lib/: Contém a dependência do ANTLR (antlr-4.13.2-complete.jar).

    exemplos/: Contém o arquivo de teste exemplo_correto.txt.

3. Compilação (Passo a Passo)

A compilação deve ser feita no diretório raiz (meu_compilador), referenciando o JAR do ANTLR e todos os arquivos .java das pastas src e src/linguagem.
Bash

# Comando de compilação:
javac -cp "lib/antlr-4.13.2-complete.jar" src/*.java src/linguagem/*.java

    Sucesso Esperado: O comando não deve retornar erros (a menos que haja warnings), e vários arquivos .class serão gerados.

4. Execução

Após a compilação, execute o programa Main, fornecendo o classpath correto para encontrar a classe Main (dentro de src/) e o JAR do ANTLR.
Bash

# Comando de execução:
java -cp "src;lib/antlr-4.13.2-complete.jar" Main exemplos/exemplo_correto.txt

Exemplo de Saída Esperada:

O programa exibirá o log da Análise Semântica e as saídas (printf e scanf) do arquivo de teste:

Iniciando a Análise Semântica do programa...
[Análise Semântica]: Variável 'resultado' (REAL) registrada com sucesso.
...
[Saída do Programa]: 22.5
[Fluxo de Controle]: Iniciando loop WHILE.
[Saída do Programa]: 3
...
[Leitura scanf]: Digite um valor para a variável idade (INTEIRO): 20
[Saída do Programa]: 20
Compilação concluída com sucesso!

⚙️ Configuração Adicional (VS Code)

Se você estiver utilizando o VS Code, o arquivo .vscode/settings.json já está incluído no repositório. Ele configura automaticamente o caminho para o antlr-4.13.2-complete.jar, facilitando a navegação e o desenvolvimento dentro do IDE.

📜 Detalhes da Linguagem
