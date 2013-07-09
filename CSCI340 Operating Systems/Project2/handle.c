#include <assert.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <time.h>
#include <unistd.h>
#include "util.h"


/*
 * First, print out the process ID of this process.
 *
 * Then, set up the signal handler so that ^C causes
 * the program to print "Nice try.\n" and continue looping.
 *
 * Finally, loop forever, printing "Still here\n" once every
 * second.
 */

/* When a SIGUSR1 signal arrives, set this variable.   */
volatile sig_atomic_t usr_interrupt = 1;

void usr1handler(int sig){
    usr_interrupt = 0;//when this changes, exit the loop
    
    ssize_t bytes;
    const int STDOUT = 1;
    bytes = write(STDOUT, "Exiting\n", 10);
    if(bytes != 10)
        exit(-999);
}

void ctrlchandler(int sig){

    ssize_t bytes;
    const int STDOUT = 1;
    bytes = write(STDOUT, "Nice try.\n", 10);
    if(bytes != 10)
        exit(-999);
}


int main(int argc, char **argv)
{
    
    int pid = getpid();
    printf("%d\n", pid);

    struct timespec req, rem; //for nanosleep

    signal(SIGINT, ctrlchandler);
    signal(10, usr1handler);
    
    while (usr_interrupt){
    
    ssize_t bytes;
    const int STDOUT = 1;
    bytes = write(STDOUT, "Still here\n", 12);
    if(bytes != 12)
        exit(-999);
    
    req.tv_sec = 1;
    req.tv_nsec = 0;
    nanosleep(&req, &rem);
    }
    return 1;
}


