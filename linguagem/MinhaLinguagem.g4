grammar MinhaLinguagem;

@header {
    package linguagem; // Nome do pacote
}

// --- REGRAS SINTÁTICAS (Parser) ---

programa : (declaracao | comando)* EOF ;

declaracao : tipo ID ';' ;

// Note: A regra 'tipo' agora usa os tokens léxicos (em maiúsculo)
tipo : TIPO_INT | TIPO_FLOAT | TIPO_STRING ;

comando
    : atribuicao
    | condicional
    | repeticao
    | leitura
    | escrita
    ;

atribuicao : ID '=' expressao ';' ;

condicional : 'if' '(' expressao ')' bloco ('else' bloco)? ;
repeticao : whileLoop | forLoop | doWhileLoop ;

whileLoop : 'while' '(' expressao ')' bloco ;
forLoop : 'for' '(' atribuicao expressao ';' atribuicao ')' bloco ;
doWhileLoop : 'do' bloco 'while' '(' expressao ')' ';' ;

leitura : 'scanf' '(' ID ')' ';' ;
escrita : 'printf' '(' expressao ')' ';' ;

bloco : '{' (comando)* '}' ;

expressao
    : expressao ('*' | '/') expressao    #MulDiv
    | expressao ('+' | '-') expressao    #AddSub
    | '(' expressao ')'                  #Parenteses
    | NUMERO                             #Numero
    | ID                                 #Variavel
    | STRING                             #Texto
    ;


// --- REGRAS LÉXICAS (Lexer) ---
// Regras de Tokens (em maiúsculas)

// 1. Palavras-chave (Literais) - Colocadas antes do ID para garantir prioridade
TIPO_INT    : 'int' ;
TIPO_FLOAT  : 'float' ;
TIPO_STRING : 'string' ;
KW_IF       : 'if' ;
KW_ELSE     : 'else' ;
KW_WHILE    : 'while' ;
KW_FOR      : 'for' ;
KW_DO       : 'do' ;
KW_SCANF    : 'scanf' ;
KW_PRINTF   : 'printf' ;


// 2. Tokens Genéricos
ID      : [a-zA-Z_][a-zA-Z_0-9]* ;
NUMERO  : [0-9]+('.'[0-9]+)? ;
STRING  : '"' .*? '"' ;
WS      : [ \t\r\n]+ -> skip ;