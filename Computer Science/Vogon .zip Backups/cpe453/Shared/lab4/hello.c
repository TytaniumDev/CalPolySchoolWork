#include "../drivers.h"
#include "../libdriver/driver.h"
#include <stdio.h>
#include <stdlib.h>
#include <minix/ds.h>
#include "hello.h"

/*
 *  * Function prototypes for the hello driver.
 *   */
_PROTOTYPE( PRIVATE char * hello_name,   (void) );
_PROTOTYPE( PRIVATE int hello_open,      (struct driver *d, message *m) );
_PROTOTYPE( PRIVATE int hello_close,     (struct driver *d, message *m) );
_PROTOTYPE( PRIVATE struct device * hello_prepare, (int device) );
_PROTOTYPE( PRIVATE int hello_transfer,  (int procnr, int opcode,
                                          u64_t position, iovec_t *iov,
                                          unsigned nr_req) );
_PROTOTYPE( PRIVATE void hello_geometry, (struct partition *entry) );

/* SEF functions and variables. */
_PROTOTYPE( void sef_local_startup, (void) );
_PROTOTYPE( int sef_cb_init_fresh, (int type, sef_init_info_t *info) );

/* Entry points to the hello driver. */
PRIVATE struct driver hello_tab =
{
    hello_name,
    hello_open,
    hello_close,
    nop_ioctl,
    hello_prepare,
    hello_transfer,
    nop_cleanup,
    hello_geometry,
    nop_signal,
    nop_alarm,
    nop_cancel,
    nop_select,
    nop_ioctl,
    do_nop,
};

/** Represents the /dev/hello device. */
PRIVATE struct device hello_device;

PRIVATE char * hello_name(void)
{
    printf("hello_name()\n");
    return "hello";
}

PRIVATE int hello_open(d, m)
    struct driver *d;
    message *m;
{
    printf("hello_open()\n");
    return OK;
}

PRIVATE int hello_close(d, m)
    struct driver *d;
    message *m;
{
    printf("hello_close()\n");
    return OK;
}

PRIVATE struct device * hello_prepare(dev)
    int dev;
{
    hello_device.dv_base.lo = 0;
    hello_device.dv_base.hi = 0;
    hello_device.dv_size.lo = strlen(HELLO_MESSAGE);
    hello_device.dv_size.hi = 0;
    return &hello_device;
}

PRIVATE int hello_transfer(proc_nr, opcode, position, iov, nr_req)
    int proc_nr;
    int opcode;
    u64_t position;
    iovec_t *iov;
    unsigned nr_req;
{
    int bytes, ret;

    printf("hello_transfer()\n");

    bytes = strlen(HELLO_MESSAGE) - position.lo < iov->iov_size ?
            strlen(HELLO_MESSAGE) - position.lo : iov->iov_size;

    if (bytes <= 0)
    {
        return OK;
    }
    switch (opcode)
    {
        case DEV_GATHER_S:
            ret = sys_safecopyto(proc_nr, iov->iov_addr, 0,
                                (vir_bytes) (HELLO_MESSAGE + position.lo),
                                 bytes, D);
            iov->iov_size -= bytes;
            break;

        default:
            return EINVAL;
    }
    return ret;
}

PRIVATE void hello_geometry(entry)
    struct partition *entry;
{
    printf("hello_geometry()\n");
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
/* Initialize the hello driver. */
    u32_t this_proc;

    switch(type) {
        case SEF_INIT_FRESH:
            printf("%s", HELLO_MESSAGE);
        break;

        case SEF_INIT_LU:
            printf("%sHey, I'm a new version!\n", HELLO_MESSAGE);
        break;

        case SEF_INIT_RESTART:
            printf("%sHey, I've just been restarted!\n", HELLO_MESSAGE);
        break;
    }

    /* Lookup our task number. */
    if (ds_retrieve_label_num("hello", &this_proc) != OK)
    {
        printf("hello: ds_retrieve_label_num() failed: %s\n",
                strerror(errno));
        return EXIT_FAILURE;
    }
    /* Map major number to our process. */
    if (mapdriver("hello", HELLO_MAJOR, STYLE_DEV, TRUE) != OK)
    {
        printf("hello: mapdriver() failed: %s\n",
                strerror(errno));
        return EXIT_FAILURE;
    }

    /* Initialization completed successfully. */
    return(OK);
}

PUBLIC int main(int argc, char **argv)
{
    /*
 *      * Perform initialization.
 *           */
    sef_local_startup();

    /*
 *      * Run the main loop.
 *           */
    driver_task(&hello_tab, DRIVER_STD);
    return OK;
}
