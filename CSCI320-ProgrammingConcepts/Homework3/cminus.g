grammar cminus;

program	:	declarationlist;

declarationlist
	: 	(declaration) (declaration)*;
	
declaration
	:	vardeclaration
	|	fundeclaration;
	
vardeclaration
	:	typespecifier ID ';'
	| 	typespecifier ID '[' NUM ']' ';'
	;

typespecifier
	:	'int' | 'void';
	
fundeclaration
	:	typespecifier ID '(' params ')' compoundstmt;
	
params	:	paramlist | 'void';

paramlist
	:	(param) (',' param)*
	;
	
param	:	typespecifier ID
	|	typespecifier ID '[' ']'
	;
	
compoundstmt
	:	'{' localdeclarations statementlist '}';
	
localdeclarations
	:	(vardeclaration)*;
	
statementlist
	:	(statement)*;
	
statement
	:	expressionstmt
	|	compoundstmt
	|	selectionstmt
	|	iterationstmt
	|	returnstmt
	;

expressionstmt
	:	expression ';'
	|	';'
	;

selectionstmt
	:	('if' '(' expression ')' statement) (('else')=>'else' statement)?
	;
	
iterationstmt
	:	'while' '(' expression ')' statement;
	
returnstmt
	:	'return' ';'
	|	'return' expression ';'
	;

expression
	:	(ID ('[' expression ']')?)=>var '=' expression
	| 	simpleexpression
	;
	
var	:	ID ('[' expression ']')?
	;
	
simpleexpression
	:	additiveexpression (relop additiveexpression)?
	;
	
relop	:	'<=' | '<' | '>' | '>=' | '==' | '!' ; 

additiveexpression
	:	(term) (addop term)*;
	
addop	:	'+' | '-' ;

term	:	(factor) (mulop factor)*
	;
	
mulop	:	'*' | '/' ;

factor	:	'(' expression ')'
	|	var
	|	call
	|	NUM
	;
 
 call	:	ID '(' args ')';
 
 args	:	arglist | ();
 
 arglist:	expression (',' expression)*;

ID	:	('a'..'z' | 'A'..'Z')+ ;

NUM	:	'0'..'9'+ ;
 
/*stat	:	expr NEWLINE {System.out.println($expr.value);}
	|	ID '=' expr NEWLINE
		{memory.put($ID.text, new Integer($expr.value));}
	|	NEWLINE
	;
	
expr returns [int value]
	:	e=multExpr {$value = $e.value;}
		(	'+' e=multExpr {$value += $e.value;}
		|	'-' e=multExpr {$value -= $e.value;}
		)*
	;
	
multExpr returns [int value]
	:	e=atom {$value = $e.value;} ('*' e=atom {$value *= $e.value;})*
	;

atom returns [int value]
	: 	INT {$value = Integer.parseInt($INT.text);}
	|	ID
		{
		Integer v = (Integer)memory.get($ID.text);
		if ( v!=null ) $value = v.intValue();
		else System.err.println("undefined variable "+$ID.text);
		}
	|	'(' expr ')' {$value = $expr.value;}
	;
	
ID	:	('a'..'z' | 'A'..'Z')+ ;
INT	:	'0'..'9'+ ;
NEWLINE	:	'\r'? '\n' ;
WS	:	(' '|'\t')+ {skip();} ;
*/