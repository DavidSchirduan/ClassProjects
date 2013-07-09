#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <ctype.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <errno.h>

const int MAX = 13;

static void doFib(int n, int doPrint);

/*
 * unix_error - unix-style error routine.
 */
inline static void 
unix_error(char *msg)
{
    fprintf(stdout, "%s: %s\n", msg, strerror(errno));
    exit(1);
}


int main(int argc, char **argv)
{
  int arg;
  int print;

  if(argc != 2){
    fprintf(stderr, "Usage: fib <num>\n");
    exit(-1);
  }

  if(argc >= 3){
    print = 1;
  }

  arg = atoi(argv[1]);
  if(arg < 0 || arg > MAX){
    fprintf(stderr, "number must be between 0 and %d\n", MAX);
    exit(-1);
  }

  doFib(arg, 1);

  return 0;
}

/* 
 * Recursively compute the specified number. If print is
 * true, print it. Otherwise, provide it to my parent process.
 *
 * NOTE: The solution must be recursive and it must fork
 * a new child for each call. Each process should call
 * doFib() exactly once.
 */

static void 
doFib(int n, int doPrint)
{

int status = 0;
int catch1 = 0;
int catch2 = 0;

//base case
    if (n == 0 || n == 1){
        //in case 0/1 is the first thing entered
        if (doPrint){
            printf("%d\n", n);
        }else{
        exit(n);
        }

    }else{

        int fibnum1 = fork(); //first fib loop
        //child1
        if (fibnum1 == 0) {
            doFib(n-1, 0);
        }
        //parent1
        if (fibnum1 != 0){
            waitpid(fibnum1, &status, 0);
            if WIFEXITED(status){//if the child exited correctly
                catch1 = WEXITSTATUS(status);//increment answer
            }else{
                printf("Error, program %i ended incorrectly\n", getpid());
            }
        }

        int fibnum2 = fork(); //second fib loop
        //child2
        if (fibnum2 == 0) {
            doFib(n-2, 0);
        }
        //parent2
        if (fibnum2 != 0){
            waitpid(fibnum2, &status, 0);
            if WIFEXITED(status){//if the child exited correctly
                catch2 = WEXITSTATUS(status);//increment answer
            }else{
                printf("Error, program %i ended incorrectly\n", getpid());
            }
        }

        //final result
        if (doPrint){
            printf("%d\n", catch1+catch2);
        }else{
            exit(catch1+catch2);//if not printing, return the result
        }
    }
}
