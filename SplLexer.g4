lexer grammar SplLexer;

// Keywords
INT    : 'int';
STRUCT : 'struct';
RETURN : 'return';
IF     : 'if';
ELSE   : 'else';
WHILE  : 'while';

// Operators
ASSIGN : '=';
LE     : '<=';
LT     : '<';
GE     : '>=';
GT     : '>';
EQ     : '==';
NEQ    : '!=';
NOT    : '!';
AND    : '&&';
OR     : '||';
PLUS   : '+';
MINUS  : '-';
MUL    : '*';
DIV    : '/';
MOD    : '%';
POW    : '^';
DOT    : '.';

// Separators
SEMI   : ';';
COMMA  : ',';
LPAREN : '(';
RPAREN : ')';
LBRACE : '{';
RBRACE : '}';
LBRACK : '[';
RBRACK : ']';

// Identifier
Identifier : [a-zA-Z_] [a-zA-Z0-9_]*;

// Number
Number : '0' | [1-9] [0-9]*;

// Whitespaces & Comments
WS            : [ \t\r\n]+    -> skip;
LINE_COMMENT  : '//' ~[\r\n]* -> skip;
BLOCK_COMMENT : '/*' .*? '*/' -> skip;
