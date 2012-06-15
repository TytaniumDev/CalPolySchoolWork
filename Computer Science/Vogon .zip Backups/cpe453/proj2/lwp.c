/**
 * Project 2 : lwp
 * Made by Tyler Holland (tyhollan)
 * Has all the functions defined in lwp.h
 */
 
#include "lwp.h"
#include <stdlib.h>
#include <stdio.h>

/*Function prototypes*/
int roundRobin();

lwp_context *lwp_ptable = NULL;    /* the process table           */
int lwp_procs = 0;           /* the current number of LWPs  */
int lwp_running = -1;         /* the index of the currently running LWP */
schedfun scheduler = roundRobin;      /* the scheduler */

/* for lwp_stop() */
unsigned long *realsp;

int new_lwp(lwpfun function,void * args,size_t size)
{
   unsigned long *temp;
   if(lwp_procs == LWP_PROC_LIMIT)
   {
      return -1;
   }
   /* Initialize things */
   lwp_ptable = (lwp_context*)realloc(lwp_ptable, 
                                      sizeof(lwp_context) * (lwp_procs + 1));
   lwp_ptable[lwp_procs].pid = (lwp_procs + 10); /* pids start at 10 */
   lwp_ptable[lwp_procs].stack = malloc(sizeof(char) * size);
   lwp_ptable[lwp_procs].stacksize = size;
   lwp_ptable[lwp_procs].sp=&(lwp_ptable[lwp_procs].stack[(sizeof(char)*size)]);
   
   /* Make the stack */
   /* Start pushing the opposite direction */
   *(lwp_ptable[lwp_procs].sp) = (unsigned long) args;
   lwp_ptable[lwp_procs].sp--;
   *(lwp_ptable[lwp_procs].sp) = (unsigned long) lwp_exit;
   lwp_ptable[lwp_procs].sp--;
   *(lwp_ptable[lwp_procs].sp) = (unsigned long) function;
   lwp_ptable[lwp_procs].sp--;
   /* Space for "old bp" plus 7 registers */
   temp = lwp_ptable[lwp_procs].sp;
   *(lwp_ptable[lwp_procs].sp) = (unsigned long) lwp_ptable[lwp_procs].stack[0]; 
   lwp_ptable[lwp_procs].sp--;
   /* Registers */
   lwp_ptable[lwp_procs].sp = lwp_ptable[lwp_procs].sp - 7;
   /* Pointer pointing to "old bp" */
   *(lwp_ptable[lwp_procs].sp) = (unsigned long) temp;
   /* Increment things */
   lwp_procs++;
   return lwp_ptable[lwp_procs - 1].pid;
}
void lwp_exit()
{
   int i;
   int oldrun = lwp_running;
   int oldprocs = lwp_procs;
   lwp_running = scheduler();
   SetSP(lwp_ptable[lwp_running].sp);
   /* Free stuff */
   /*free(&lwp_ptable[oldrun]);*/
   /*lwp_procs--;*/
   if(lwp_procs == 0) /* No other threads */
   {
      lwp_stop();
   }
   /* Move old processes up in ptable */
   /*for(i = oldrun; i < oldprocs; i++)
   {
      lwp_ptable[i] = lwp_ptable[i+1];
   }*/
}
int lwp_getpid()
{
   return (lwp_ptable[lwp_running]).pid;
}
void lwp_yield()
{
   SAVE_STATE();
   GetSP(lwp_ptable[lwp_running].sp);
   /* Set SP to next proc's sp based on scheduler */
   /*change lwp_running*/
   lwp_running = scheduler();
   SetSP(lwp_ptable[lwp_running].sp);
   RESTORE_STATE();
}
void lwp_start()
{
   GetSP(realsp);
   /*change lwp_running*/
   lwp_running = scheduler();
   if(lwp_running == -1)
   {
      return;
   }
   SetSP(lwp_ptable[lwp_running].sp);
   RESTORE_STATE();
}
void lwp_stop()
{
   SAVE_STATE();
   GetSP(lwp_ptable[lwp_running].sp);
   lwp_running = -1;
   SetSP(realsp);
   RESTORE_STATE();
}
void lwp_set_scheduler(schedfun sched)
{
   if(sched != NULL)
   {
      scheduler = sched;
   }
}

int roundRobin() /*Default scheduler*/
{
   int i = 0;
   /* Set i to next process */
   if(lwp_running < (lwp_procs - 1)) /* Go to next proc */
   {
      i = (lwp_running + 1);  
   }
   else if(lwp_running == (lwp_procs - 1)) /* Go to first proc */
   {
      i = 0;
   }
   else
   {
      /*Error*/
      fprintf(stderr, "Scheduling error\n");
      i = -1;
      return i;
   }
   
   return i;
}
