#ifndef LWPH
#define LWPH
#include <sys/types.h>

typedef struct context_st {
  unsigned long pid;            /* lightweight process id  */
  unsigned long *stack;         /* pointer to stack returned by malloc() */
  unsigned long stacksize;      /* Size of allocated stack */
  unsigned long *sp;            /* current stack pointer   */
  /*  .... other things if necessary ... */
} lwp_context;


/* Process context information.  "Normally" these would be declared
 * static so that nobody outside the file could look at them, but
 * since we want to make it possible for the user to supply an external
 * scheduling function we need to make these available.
 *   (Not really.  A better way would be to have the user supply a comparison
 *    function, but that would make the scheduler much more complicated.)
 */
extern lwp_context *lwp_ptable; /* the process table           */
extern int lwp_procs;           /* the current number of LWPs  */
extern int lwp_running;         /* the index of the currently running LWP */


typedef void (*lwpfun)(void *); /* type for lwp function */
typedef int  (*schedfun)(void); /* type for scheduler function */

/* lwp functions */
extern int  new_lwp(lwpfun,void *,size_t);
extern void lwp_exit();
extern int  lwp_getpid();
extern void lwp_yield();
extern void lwp_start();
extern void lwp_stop();
extern void lwp_set_scheduler(schedfun sched);

/* Macros for stack manipulation:
 *
 *  SAVE_STATE()    Pushes all general (non floating-point) registers on the
 *                  stack except the stack pointer.
 *  RESTORE_STATE() Pops all general (non floating-point) registers saved
 *                  by SAVE_STATE() off the stack in reverse order.  RS()
 *                  also copies the base pointer to the stack pointer as
 *                  is done by the "leave" instruction in case the compiler
 *                  optimizes that away.
 *  GetSP(var)      Sets the given variable to the current value of the
 *                  stack pointer.
 *  SetSP(var)      Sets the stack pointer to the current value of the
 *                  given variable.
 *
 * These macros should ONLY be used as the very first or very last
 * act of a function.
 */
#ifdef __i386         /* X86 only code */

#define BAILSIGNAL SIGSTKFLT

#define SAVE_STATE() \
  asm("pushl %%eax":: );\
  asm("pushl %%ebx":: );\
  asm("pushl %%ecx":: );\
  asm("pushl %%edx":: );\
  asm("pushl %%esi":: );\
  asm("pushl %%edi":: );\
  asm("pushl %%ebp":: )

#define GetSP(sp)  asm("movl  %%esp,%0": "=r" (sp) : )

#define SetSP(sp)  asm("movl  %0,%%esp":           : "r" (sp)  )

#define RESTORE_STATE() \
  asm("popl  %%ebp":: );\
  asm("popl  %%edi":: );\
  asm("popl  %%esi":: );\
  asm("popl  %%edx":: );\
  asm("popl  %%ecx":: );\
  asm("popl  %%ebx":: );\
  asm("popl  %%eax":: );\
  asm("movl  %%ebp,%%esp":: )  /* restore esp in case leave is not used */

#else /* END x86 only code */
#error "This stack manipulation code can only be compiled on an x86"
#endif

/* LWP_PROC_LIMIT is the maximum number of LWPs active */
#ifndef LWP_PROC_LIMIT
#define LWP_PROC_LIMIT 30
#endif

#endif
