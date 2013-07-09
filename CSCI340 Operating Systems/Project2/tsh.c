/* 
 * tsh - A tiny shell program with job control
 * 
 * <Put your name and login ID here>
 */
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <ctype.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <errno.h>
#include "util.h"
#include "jobs.h"


/* Global variables */
int verbose = 0;            /* if true, print additional output */

extern char **environ;      /* defined in libc */
static char prompt[] = "tsh> ";    /* command line prompt (DO NOT CHANGE) */
static struct job_t jobs[MAXJOBS]; /* The job list */
/* End global variables */


/* Function prototypes */

/* Here are the functions that you will implement */
void eval(char *cmdline);
int builtin_cmd(char **argv);
void do_bgfg(char **argv);
void waitfg(pid_t pid);

void sigchld_handler(int sig);
void sigtstp_handler(int sig);
void sigint_handler(int sig);

/* Here are helper routines that we've provided for you */
void usage(void);
void sigquit_handler(int sig);



/*
 * main - The shell's main routine 
 */
int main(int argc, char **argv) 
{
    char c;
    char cmdline[MAXLINE];
    int emit_prompt = 1; /* emit prompt (default) */

    /* Redirect stderr to stdout (so that driver will get all output
     * on the pipe connected to stdout) */
    dup2(1, 2);

    /* Parse the command line */
    while ((c = getopt(argc, argv, "hvp")) != EOF) {
        switch (c) {
        case 'h':             /* print help message */
            usage();
	    break;
        case 'v':             /* emit additional diagnostic info */
            verbose = 1;
	    break;
        case 'p':             /* don't print a prompt */
            emit_prompt = 0;  /* handy for automatic testing */
	    break;
	default:
            usage();
	}
    }

    /* Install the signal handlers */

    /* These are the ones you will need to implement */
    Signal(SIGINT,  sigint_handler);   /* ctrl-c */
    Signal(SIGTSTP, sigtstp_handler);  /* ctrl-z */
    Signal(SIGCHLD, sigchld_handler);  /* Terminated or stopped child */

    /* This one provides a clean way to kill the shell */
    Signal(SIGQUIT, sigquit_handler); 

    /* Initialize the job list */
    initjobs(jobs);

    /* Execute the shell's read/eval loop */
    while (1) {

	/* Read command line */
	if (emit_prompt) {
	    printf("%s", prompt);
	    fflush(stdout);
	}
	if ((fgets(cmdline, MAXLINE, stdin) == NULL) && ferror(stdin))
	    app_error("fgets error");
	if (feof(stdin)) { /* End of file (ctrl-d) */
	    fflush(stdout);
	    exit(0);
	}

	/* Evaluate the command line */
	eval(cmdline);
	fflush(stdout);
	fflush(stdout);
    } 

    exit(0); /* control never reaches here */
}
  
/* 
 * eval - Evaluate the command line that the user has just typed in
 * 
 * If the user has requested a built-in command (quit, jobs, bg or fg)
 * then execute it immediately. Otherwise, fork a child process and
 * run the job in the context of the child. If the job is running in
 * the foreground, wait for it to terminate and then return.  Note:
 * each child process must have a unique process group ID so that our
 * background children don't receive SIGINT (SIGTSTP) from the kernel
 * when we type ctrl-c (ctrl-z) at the keyboard.  
*/
void eval(char *cmdline) 
{

    pid_t child;
    //build argv
    char ** argv = (char **) malloc(sizeof(char *) * MAXLINE);
    int bg = 0;//foreground until proven guilty
    sigset_t block;

    bg = parseline(cmdline,argv);
    //printf("first: %s \n", argv[0]+1);
    //if not a built-in command
    if (strcmp(argv[0],"\n") == 0){
        exit(1);
    }else{   
 
    if(!builtin_cmd(argv)){
       
        //this block should block the signal blockers....from blocking block 
        if(sigemptyset(&block) != 0){
            unix_error("sigemptyset");
        }
        if(sigaddset(&block, SIGCHLD) != 0){
            unix_error("sigaddset");
        }
        if(sigprocmask(SIG_BLOCK, &block, NULL) != 0){
            unix_error("sigprocmask");
        }


        child = fork();//forking
        //child
        if(child == 0){
            //unblock for exec
            if (sigprocmask(SIG_UNBLOCK, &block, NULL) != 0){
                unix_error("sigprocmask");
            }

            if(execvp(argv[0], argv) < 0){
                printf("%s: Command not found\n", argv[0]);
                exit(1);
            }
        //parent
        }else{
            //adding to jobs
            if (!bg) {
                addjob(jobs, child, FG, cmdline);
            }else{
                addjob(jobs, child, BG, cmdline);
            }
            //unblock sig
            if (sigprocmask(SIG_UNBLOCK, &block, NULL) != 0){
                unix_error("sigprocmask error");
            }
            //wait for the foreground to finish
            if (!bg){
                waitfg(child);
            } 
            else {
                printf("[%d] (%d) %s", pid2jid(jobs, child), child, cmdline);
            }
        }
    free(argv);
        }      
    }
}

/* 
 * builtin_cmd - If the user has typed a built-in command then execute
 *    it immediately.  
 * Return 1 if a builtin command was executed; return 0
 * if the argument passed in is *not* a builtin command.
 */
int builtin_cmd(char **argv) 
{  
    //printf("First argv: %s\n", argv[0]);
 
    if(strcmp(argv[0],"quit") == 0){
        exit(0);
        return(1);
    } else if(strcmp(argv[0],"jobs") == 0){
        listjobs(jobs);
        return (1);
    } else if((strcmp(argv[0],"fg") == 0) || (strcmp(argv[0],"bg") == 0)){
        //printf("bgfg crap");
        do_bgfg(argv);
        return (1);

    } else {
        return(0);
    }
}

/* 
 * do_bgfg - Execute the builtin bg and fg commands
 * changes the state of a program from foreground to background
 */
void do_bgfg(char **argv) 
{
    struct job_t* job;
    int id;    
    //if nothing after fg/bg
    if (argv[1] == NULL){
        printf("%s command requires PID or %%jobid argument\n", argv[0]);
        return;
    }
    //dealing with job id
    if (*argv[1] == '%'){
        id = atoi(argv[1]+1);
        //in case no jid exists
        if (!(job = getjobjid(jobs, id))){
            printf("%%%d: No such job\n", id);
            return;
        }
    //dealing with pid
    }else if (isdigit(*argv[1])){
        id = atoi(argv[1]);
        //in case no process exists
        if (!(job = getjobpid(jobs, id))){
            printf("(%d): No such process\n", id);
            return;
        }
    } else {
        printf("%s: argument must be a PID or %%jobid\n", argv[0]);
        return;
    }

    //job acquired
    kill(job->pid, SIGCONT);
    //foreground
    if(strcmp(argv[0],"fg") == 0){
        job->state = 1;     
        waitfg(job->pid);
    //background
    } else {
        job->state = 2;   
    }
}

/* 
 * waitfg - Block until process pid is no longer the foreground process
 */
void waitfg(pid_t pid)
{
    while(pid == fgpid(jobs)){
        usleep(5);
    }
}

/*****************
 * Signal handlers
 *****************/

/* 
 * sigchld_handler - The kernel sends a SIGCHLD to the shell whenever
 *     a child job terminates (becomes a zombie), or stops because it
 *     received a SIGSTOP or SIGTSTP signal. The handler reaps all
 *     available zombie children, but doesn't wait for any other
 *     currently running children to terminate.  
 */
void sigchld_handler(int sig) 
{
    int execsig;
    pid_t pid;

    while((pid = waitpid(-1, &execsig, WNOHANG|WUNTRACED))> 0){
        if (WIFSTOPPED(execsig)){
            sigtstp_handler(20);
        } else if (WIFSIGNALED(execsig)){
            sigint_handler(-2);
        } else if (WIFEXITED(execsig)){
            deletejob(jobs, pid);
        }
    }
    return;
}

/* 
 * sigint_handler - The kernel sends a SIGINT to the shell whenver the
 *    user types ctrl-c at the keyboard.  Catch it and send it along
 *    to the foreground job.  
 */
void sigint_handler(int sig) 
{
    int pid = fgpid(jobs);

    if (pid != 0){
        kill(-pid, SIGINT);
        if(sig<0){
            deletejob(jobs, pid);
        }
    }
    return;
}

/*
 * sigtstp_handler - The kernel sends a SIGTSTP to the shell whenever
 *     the user types ctrl-z at the keyboard. Catch it and suspend the
 *     foreground job by sending it a SIGTSTP.  
 */
void sigtstp_handler(int sig) 
{
    int pid = fgpid(jobs);

    if (pid != 0){
        kill(-pid, SIGTSTP);
        getjobpid(jobs, pid)->state = 3; //stop the child 
    }
    return;
}

/*********************
 * End signal handlers
 *********************/



/***********************
 * Other helper routines
 ***********************/

/*
 * usage - print a help message
 */
void usage(void) 
{
    printf("Usage: shell [-hvp]\n");
    printf("   -h   print this message\n");
    printf("   -v   print additional diagnostic information\n");
    printf("   -p   do not emit a command prompt\n");
    exit(1);
}

/*
 * sigquit_handler - The driver program can gracefully terminate the
 *    child shell by sending it a SIGQUIT signal.
 */
void sigquit_handler(int sig) 
{
    printf("Terminating after receipt of SIGQUIT signal\n");
    exit(1);
}
