/* 8 Ball Driver
 * Written by Tyler Holland and Brig Bagley
 * Project 3 for CPE 453
 */
#include "../drivers.h"
#include "../libdriver/driver.h"
#include <stdio.h>
#include <stdlib.h>
#include <minix/ds.h>
#include <time.h>
#include "8ball.h"

/*
 *  Function prototypes for the ball driver.
 */
_PROTOTYPE( PRIVATE char * ball_name,   (void) );
_PROTOTYPE( PRIVATE int ball_open,      (struct driver *d, message *m) );
_PROTOTYPE( PRIVATE int ball_close,     (struct driver *d, message *m) );
_PROTOTYPE( PRIVATE struct device * ball_prepare, (int device) );
_PROTOTYPE( PRIVATE int ball_transfer,  (int procnr, int opcode,
                                          u64_t position, iovec_t *iov,
                                          unsigned nr_req) );
_PROTOTYPE( PRIVATE void ball_geometry, (struct partition *entry) );

/* Added prototypes: */
_PROTOTYPE( PRIVATE int ball_ioctl, (struct driver *dp, message *m_ptr) );
_PROTOTYPE( PRIVATE void ball_signal, (struct driver *dp, message *m_ptr) );
_PROTOTYPE( PRIVATE int ball_cancel, (struct driver *dp, message *m_ptr) );
_PROTOTYPE( PRIVATE int ball_hardint, (struct driver *dp, message *m_ptr) );


/* SEF functions and variables. */
PRIVATE void sef_local_startup(void); 
PRIVATE int sef_cb_init_fresh(int type, sef_init_info_t *info);

/* Entry points to the ball driver. */
PRIVATE struct driver ball_tab =
{
    ball_name, /* Current Device's name */
    ball_open, /* open or mount */
    ball_close, /* close */
    ball_ioctl, /* Just return EINVAL */
    ball_prepare, /* prepare for I/O on a given minor device */
    ball_transfer, /* do the I/O */
    nop_cleanup, /* Cleanup */
    ball_geometry, /* device "geometry" */
    nop_signal, /* SYS_SIG ? */
    nop_alarm, /* get randomness from kernel (from random's main.c) */
    ball_cancel, /* CANCEL */
    nop_select,
    nop_ioctl,
    ball_hardint, /* HARD_INT */
};

/** Represents the /dev/8ball device. */
PRIVATE struct device ball_device;

/**Message data structure and random generator**/
PRIVATE unsigned int iseed;
PRIVATE int questions = 0;
PRIVATE char *reply[] = 
{
	"Signs point to yes.\n",
	"Without a doubt.\n",
	"You may rely on it.\n",
	"It is decidedly so.\n",
	"Yes-definitely.\n",
	"Most likely\n",
	"Outlook good.\n",
	"Yes.\n",
	"My sources say no.\n",
	"Concentrate and ask again.\n",
	"Better not tell you now.\n",
	"It is certain.\n",
	"Ask again later.\n",
	"Don't count on it.\n",
	"Reply hazy, try again.\n",
	"As I see it, yes.\n",
	"Outlook not so good.\n",
	"Very doubtful.\n",
	"Cannot predict now.\n",
	"My reply is no.\n"
};

/* Buffer for the /dev/8ball 8ball driver */
#define BALL_BUF_SIZE 1024
PRIVATE char ball_buf[BALL_BUF_SIZE];

/* based on r_ioctl from main.c in the random driver */
/* We only need to return EINVAL */
PRIVATE int ball_ioctl(dp, m_ptr)
    struct driver *dp;			/* pointer to driver structure */
    message *m_ptr;   		/* pointer to control message */
{
     struct device *dv;
     if ((dv = ball_prepare(m_ptr->DEVICE)) == NIL_DEV) return(ENXIO);

     switch (m_ptr->REQUEST) {

       default:
     	return(do_diocntl(&ball_tab, m_ptr));
     }
     return(OK);
   /*return EINVAL;*/
}

PRIVATE void ball_signal (struct driver *dp, message *m_ptr)
    /*struct driver *dp;*/			/* pointer to driver structure */
    /*message *m_ptr;*/   		/* pointer to control message */
{
   /* From printer.c */
  sigset_t sigset;

  if (getsigset(&sigset) != 0) return;
  
  /* Expect a SIGTERM signal when this server must shutdown. */
  if (sigismember(&sigset, SIGTERM)) {
	exit(0);
  } 
  /* Ignore all other signals. */
}

PRIVATE int ball_cancel (dp, m_ptr)
    struct driver *dp;			/* pointer to driver structure */
    message *m_ptr;   		/* pointer to control message */
{
   return EINTR;
}

PRIVATE int ball_hardint (dp, m_ptr)
    struct driver *dp;			/* pointer to driver structure */
    message *m_ptr;   		/* pointer to control message */
{
   return OK; /* Not sure what to do here */
}

PRIVATE char * ball_name(void)
{
    return "8ball";
}

PRIVATE int ball_open(d, m)
    struct driver *d;
    message *m;
{
    return OK;
}

PRIVATE int ball_close(d, m)
    struct driver *d;
    message *m;
{
    return OK;
}

PRIVATE struct device * ball_prepare(dev)
    int dev;
{
    ball_device.dv_base.lo = 0;
    ball_device.dv_base.hi = 0;
    ball_device.dv_size.lo = strlen(BALL_MESSAGE);
    ball_device.dv_size.hi = 0;
    return &ball_device;
}

PRIVATE int ball_transfer(proc_nr, opcode, position, iov, nr_req)
    int proc_nr;
    int opcode;
    u64_t position;
    iovec_t *iov;
    unsigned nr_req;
{
    /*From hello.c, plus SCATTER logic and question counter*/
    int bytes, ret, i;
    char *fortune;
    
    /* Set up fortune */
	 fortune = reply[rand() % 20];
    /* from hello.c, get smallest length */
    bytes = strlen(fortune) - position.lo < iov->iov_size ?
            strlen(fortune) - position.lo : iov->iov_size;
    
    if (iov->iov_size <= 0 || position.lo > strlen(fortune))
    {
        return OK;
    }
    /* Decide if it is a read, write, or EINVAL */
    switch (opcode)
    {
        case DEV_GATHER_S: /* Writing out */
            ret = 0;
            if(questions > 0)
            
               ret = sys_safecopyto(proc_nr, iov->iov_addr, 0,
                                   (vir_bytes) fortune,
                                    bytes, D);
               if(questions) questions--;
               iov->iov_size -= bytes;
            
            /*ret = sys_safecopyto(proc_nr, iov->iov_addr, 0,
                               (vir_bytes) (reply[0] + position.lo),
                                 bytes, D);*/
            break;
        case DEV_SCATTER_S: /* Reading in */
          	ret = sys_safecopyfrom(proc_nr, iov->iov_addr, 0,
                 (vir_bytes) ball_buf, (phys_bytes) iov->iov_size, D);
            print2("----------\nBUFFER\n---------\n%s---------\n",ball_buf);
            print2("Questions read before:%d\n",questions);
            for(i = 0; i < iov->iov_size; i++) /*TODO*/
            {
             	if(ball_buf[i] == '\n')
               {
                			questions++;
               }
            }
            iov->iov_size = 0;
            print2("Questions read after:%d\n",questions);
            break;
        default:
           return EINVAL; /* Invalid opcode */
    }
    return ret;
    
}

PRIVATE void ball_geometry(entry)
    struct partition *entry;
{
    entry->cylinders = 0;
    entry->heads     = 0;
    entry->sectors   = 0;
}

PRIVATE void sef_local_startup()
{
    /* Register init callbacks. */
    sef_setcb_init_fresh(sef_cb_init_fresh);
    sef_setcb_init_lu(sef_cb_init_fresh);      /* treat live updates as fresh inits */
    sef_setcb_init_restart(sef_cb_init_fresh); /* treat restarts as fresh inits */

    /* Register live update callbacks. */
    sef_setcb_lu_prepare(sef_cb_lu_prepare_always_ready);         /* agree to update immediately when a LU request is received in a supported state */
    sef_setcb_lu_state_isvalid(sef_cb_lu_state_isvalid_standard); /* support live update starting from any standard state */

    /* Let SEF perform startup. */
    sef_startup();
}

PRIVATE int sef_cb_init_fresh(int type, sef_init_info_t *info)
{
/* Initialize the 8ball driver. */
    u32_t this_proc;

    switch(type) {
        case SEF_INIT_FRESH:
            print2("%s", BALL_MESSAGE);
        break;

        case SEF_INIT_LU:
            print1("Driver Updated!\n");
        break;

        case SEF_INIT_RESTART:
            print1("Driver restarted!\n");
        break;
    }

    /* Lookup our task number. */
    if (ds_retrieve_label_num("8ball", &this_proc) != OK)
    {
        printf("8ball: ds_retrieve_label_num() failed: %s\n",
                strerror(errno));
        return EXIT_FAILURE;
    }
    /* Map major number to our process. */
    if (mapdriver("8ball", BALL_MAJOR, STYLE_DEV, TRUE) != OK)
    {
        printf("8ball: mapdriver() failed: %s\n",
                strerror(errno));
        return EXIT_FAILURE;
    }

    /* Initialization completed successfully. */
    return(OK);
}

PUBLIC int main(int argc, char **argv)
{
/*
 *Perform initialization.
 */
  	iseed = (unsigned int)time(NULL);
	srand(iseed);
	sef_local_startup(); 

 /*
 *Run the main loop.
 */
    driver_task(&ball_tab, DRIVER_STD);
    return OK;
}
