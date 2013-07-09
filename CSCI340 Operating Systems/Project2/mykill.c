#include <assert.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <time.h>
#include <unistd.h>
/*   Now write a program mykill.c that takes a process ID as an argument and that sends the
SIGUSR1 signal to the specifed process ID.
*/

int main(int argc, char **argv)
{

    if (argc != 2) {
    fprintf(stderr, "USAGE:  PID to kill\n");
    return 1;
    }else{

    int pid = atoi(argv[1]);    

    kill(pid, 10);//send SIGUSR1

    return 0;
}
}
