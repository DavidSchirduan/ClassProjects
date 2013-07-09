/* words program to print out words from command line
David Schirduan
PROMPT
Write program words that prints out the words from the command line on different lines

> make words
...
> ./words To be or not to be? That is the question.
To
be
or
not
*/

#include <stdio.h>
int main(int argc, char **argv){
	int i;
	for (i=1; i<argc; i++){
		printf("%s\n", argv[i]);
	}
	return 0;
}

	
 
