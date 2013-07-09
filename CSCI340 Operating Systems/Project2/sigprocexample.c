/*
  Compile this file as follows:

  $ gcc -Wall sigprocmask_test.c -o sigprocmask_test

  Then, run it two separate times as follows:

  $ ./sigprocmask_test 10 0

  $ ./sigprocmask_test 10 1

  The command line argument, "0" indicates whether we use sigprocmask
  or not.  The "10" argument indicates how many times we want to
  repeat the process of forking a child and doing some work.

  Can you explain the output?  What's happening?  How does
  sigprocmask() solve the problem?
*/

#include <stdio.h>     // for printf()
#include <stdlib.h>    // for atoi(), exit()
#include <signal.h>    // for signal()
#include <unistd.h>    // for write(), fork()
#include <string.h>    // for strlen()
#include <sys/types.h>
#include <sys/wait.h>  // for wait()

double sum;            // global sum variable
int use_sigprocmask;   // 1 if we will use sigprocmask(); 0 otherwise

// a signal hander routine for SIGCHLD (i.e. parent receives when child exits)
void sigchld_handler(int signum)
{
  // NOTE:  printf() technically unsafe in signal handler, so use write()
  //printf("got a signal\n");
  const char* msg = "received SIGCHLD signal\n";
  const int STDOUT = 1;
  ssize_t bytes;

  sum = 2;   // SET sum = 2 to demonstrate affect of signal on dosomework() !

  bytes = write(STDOUT, msg, strlen(msg));
  if (bytes != strlen(msg))
    exit(-999);
}

/*
  Do some work --- specifically, we add 1/increment, increment times.
  This should sum to approximately 1.0, assuming we aren't interrupted
  by a signal that affects the value of sum during the computation.

  NOTE: dosomework() can be interrupted by a signal.  If the child
  exits during the computation of dosomework(), then a SIGCHLD will be
  sent to the parent process.  The SIGCHLD handler changes the value
  of sum (see code above), thus the computation "may not go as
  planned".
*/
void dosomework(double increment)
{
  const int NUMITS = 1.0 / increment;
  int j;
  sigset_t s;                // set of signals to block

  if (use_sigprocmask) {
    sigemptyset(&s);         // initialize to empty
    sigaddset(&s, SIGCHLD);  // add SIGCHLD signal to set
    sigprocmask(SIG_BLOCK, &s, NULL);    // block on signals in the set, s
  }

  for (j = 0; j < NUMITS; j++) {
    sum += increment;
  }

  if (use_sigprocmask) {     // unblock signals in the set, s (i.e. SIGCHLD)
    sigprocmask(SIG_UNBLOCK, &s, NULL);
  }
}

int main(int argc, char** argv)
{
  int i, numits;
  int status;
  
  if (argc < 3) {
    fprintf(stderr, "USAGE: %s numits use_sigprocmask\n", argv[0]);
    return 1;
  }

  numits = atoi(argv[1]);  // number of iterations to loop
  use_sigprocmask = atoi(argv[2]);   // whether to use sigprocmask or not

  // register the signal handler for SIGCHLD
  signal(SIGCHLD, sigchld_handler);

  // execute numits times...
  for (i = 0; i < numits; i++) {
    sum = 0;     // initialize sum to zero before each fork()/wait()

    if (fork() == 0) {
      // child
      dosomework(1e-6);
      printf("child sum = %f\n", sum);
      exit(0);
    }

    // parent
    dosomework(1e-7);
    printf("parent sum = %f\n", sum);
    wait(&status);

    printf("\n");     // print newline to seperate each child/parent run
  }

  return 0;
}

