/* David Schirduan
Write a program fact.c that uses recursion to calculate and print the factorial of the positive integer value passed in or prints the line"Huh?" if no argument is passed or if the first argument passed is not a positive integer. If the value passed in exceeds 12, you can simply print "Overflow". 
*/
#include <stdio.h>
#include <stdlib.h> //just fiddling with some stuff
int main(int argc, char **argv){
	int a = 1;//where argv is stored
	int answer = 1; //result from recursion
	const char *argvstring = argv[1];
	
	//check that only one number was entered
	if ( argc != 2 ){
    printf( "Huh?\n" );
	return 1;
  	}

	//need to check if argv[1] is an int
	if( sscanf(argv[1],"%i", &a) != 1 ){
	printf("Huh?\n");
	return 1;
	}//for some reason, this accepts floats, hence the check later down

	//need to make sure the number is positive
	if (a<1){
	printf("Huh?\n");
	return 1;
	}
	else if (a>12){
    printf("Huh?\n");
    return 1;
    }

	//need to check for decimal numbers as a string(easier than checking the type)
	if (argvstring[0]=='.'){
    printf("Huh?\n");
    return 1;
    }
	else if (argvstring[1]=='.'){
	printf("Huh?\n");
	return 1;
	}
	else if (argvstring[2]=='.'){
    printf("Huh?\n");
    return 1;
    }


	int factor(int x){
		if (x<1){
			return 1;
		}

		else{
			x = x * factor(x-1);
			return x;
		}
	}
	
	answer = factor(a);
	
	printf("%i\n", answer);
	
	return 0;
}
	
