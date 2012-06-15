/* 8 Ball Driver header
 * Written by Tyler Holland and Brig Bagley
 * Project 3 for CPE 453
 */
#ifndef __HELLO_H
#define __HELLO_H

/** The Hello, World! message. */
#define BALL_MESSAGE ""
#undef DEBUG
#define DEBUG

#ifdef DEBUG
#define print1(x) printf(x)
#define print2(x,y) printf(x,y)
#define print3(x,y,z) printf(x,y,z)
#else
#define print1(x) 
#define print2(x,y) 
#define print3(x,y,z) 
#endif

/*Major ID of /dev/8ball. */
#define BALL_MAJOR 18

#endif /*__HELLO_H*/
