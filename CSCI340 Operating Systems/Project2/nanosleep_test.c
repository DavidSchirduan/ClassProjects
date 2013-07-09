#include <stdio.h>     // for printf()
#include <stdlib.h>    // for atoi(), exit()
#include <signal.h>    // for signal()
#include <time.h>      // for nanosleep()
#include <unistd.h>    // for write()

// a signal hander routine
void mysighandler(int signum)
{
  // NOTE:  printf() technically unsafe in signal handler, so use write()
  //printf("got a signal\n");
  const int STDOUT = 1;
  ssize_t bytes;
  bytes = write(STDOUT, "got a signal\n", 13);
  if (bytes != 13)
    exit(-999);
}

int main(int argc, char** argv)
{
  int i, numits;
  struct timespec req, rem;   // needed for nanosleep()
  
  if (argc < 2) {
    fprintf(stderr, "USAGE: %s numits\n", argv[0]);
    return 1;
  }

  // number of iterations to loop
  numits = atoi(argv[1]);   // convert from ASCII to integer

  // time specification requesting one second and NO nanoseconds
  req.tv_sec = 1;
  req.tv_nsec = 0;

  // register the signal handler for SIGINT
  signal(SIGINT, mysighandler);

  // execute numits times...
  for (i = 0; i < numits; i++) {

    // nanosleep returns -1 if interrupted
    if (nanosleep(&req, &rem) == -1) {
      // I got interrupted --- wait remaining fraction of a second next time
      printf("\tgot interrupted --- will wait %d secs and %d nanosecs more",
	     (int) rem.tv_sec, (int) rem.tv_nsec);
      req.tv_sec = rem.tv_sec;
      req.tv_nsec = rem.tv_nsec;
    }
    else {
      printf("slept another second\n");
      // one second and NO nanoseconds
      req.tv_sec = 1;
      req.tv_nsec = 0;
    }
  }

  return 0;
}
