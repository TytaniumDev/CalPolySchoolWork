/*
 * config.h contains general configutation information for the
 * shell.  It is should be included by all the source files
 * before anything else.
 *
 * Since it will be included in everything, be very selective
 * about what goes here.
 *
 * Revision History:
 *
 *     $Log: config.h,v $
 *     Revision 1.2  2003-04-15 18:11:34-07  pnico
 *     Checkpointing before distribution
 *
 *     Revision 1.1  2003-04-12 10:38:25-07  pnico
 *     Initial revision
 *
 *
 */
#ifndef CONFIGH
#define CONFIGH

#ifndef TRUE
#define TRUE (1==1)
#endif

#ifndef FALSE
#define FALSE (0==1)
#endif




#ifdef __minix
#ifndef _POSIX_SOURCE
#define _POSIX_SOURCE
#endif
#ifndef _MINIX
#define _MINIX
#endif
#endif



#endif
