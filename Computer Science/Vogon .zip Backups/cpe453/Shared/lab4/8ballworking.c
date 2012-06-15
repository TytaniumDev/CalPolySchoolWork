#include "../drivers.h"
#include "../libdriver/driver.h"
#include <stdio.h>
#include <stdlib.h>
#include <minix/ds.h>
#include "8ball.h"

/*
 *  * Function prototypes for the ball driver.
 *   */
_PROTOTYPE( PRIVATE char * ball_name,   (void) );
_PROTOTYPE( PRIVATE int ball_open,      (struct driver *d, message *m) );
_PROTOTYPE( PRIVATE int ball_close,     (struct driver *d, message *m) );
_PROTOTYPE( PRIVATE struct device * ball_prepare, (int device) );
_PROTOTYPE( PRIVATE int ball_transfer,  (int procnr, int opcode,
                                          u64_t position, iovec_t *iov,
                                          unsigned nr_req) );
_PROTOTYPE( PRIVATE void ball_geometry, (struct partition *entry) );

/* SEF functions and variables. */
PRIVATE void sef_local_startup(void); 
PRIVATE int sef_cb_init_fresh(int type, sef_init_info_t *info);

/* Entry points to the ball driver. */
PRIVATE struct driver ball_tab =
{
    ball_name,
    ball_open,
    ball_close,
    nop_ioctl,
    ball_prepare,
    ball_transfer,
    nop_cleanup,
    ball_geometry,
    nop_signal,
    nop_alarm,
    nop_cancel,
    nop_select,
    nop_ioctl,
    do_nop,
};

/** Represents the /dev/8ball device. */
PRIVATE struct device ball_device;

PRIVATE int ball_test(void)
{
   printf("It's in test\n");
   return OK;
}
PRIVATE char * ball_name(void)
{
    printf("8ball_name()\n");
    
    return "8ball";
}

PRIVATE int ball_open(d, m)
    struct driver *d;
    message *m;
{

    printf("8ball_open()\n");
    
    return OK;
}

PRIVATE int ball_close(d, m)
    struct driver *d;
    message *m;
{

    printf("8ball_close()\n");
    
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
    int bytes, ret;

    printf("8ball_transfer()\n");

    bytes = strlen(BALL_MESSAGE) - position.lo < iov->iov_size ?
            strlen(BALL_MESSAGE) - position.lo : iov->iov_size;

    if (bytes <= 0)
    {
        return OK;
    }
    switch (opcode)
    {
        case DEV_GATHER_S:
            ret = sys_safecopyto(proc_nr, iov->iov_addr, 0,
                                (vir_bytes) (BALL_MESSAGE + position.lo),
                                 bytes, D);
            iov->iov_size -= bytes;
            break;

        default:
            return EINVAL;
    }
    return ret;
}

PRIVATE void ball_geometry(entry)
    struct partition *entry;
{
    printf("8ball_geometry()\n");
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
            printf("%s", BALL_MESSAGE);
        break;

        case SEF_INIT_LU:
            printf("Driver Updated!\n");
        break;

        case SEF_INIT_RESTART:
            printf("Driver restarted!\n");
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
    sef_local_startup();

 /*
 *Run the main loop.
 */
    driver_task(&ball_tab, DRIVER_STD);
    return OK;
}
/*
int main(int argc, char **argv)
{
	int i;
	unsigned int iseed = (unsigned int)time(NULL);
	char *reply[] = 
	{
			"Signs point to yes.",
			"Without a doubt.",
			"You may rely on it.",
			"It is decidedly so.",
			"Yes-definitely.",
			"Most likely",
			"Outlook good.",
			"Yes.",
			"My sources say no.",
			"Concentrate and ask again.",
			"Better not tell you now.",
			"It is certain.",
			"Ask again later.",
			"Don't count on it.",
			"Reply hazy, try again.",
			"As I see it, yes.",
			"Outlook not so good.",
			"Very doubtful.",
			"Cannot predict now.",
			"My reply is no."
	};
	srand(iseed);
	printf("%s\n",reply[rand()%20]);
		
	return EXIT_SUCCESS;
}
*/
