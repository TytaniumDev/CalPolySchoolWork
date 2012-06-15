/**
 * @file
 * <pre> CPE 357 Fall 2008
 * -------------------
 *
 * Header for dedit.c
 *
 * Last Modified: Sat Feb  7 17:56:25 PST 2009</pre>
 * @author Kevin O'Gorman
 */

#ifndef DEDIT_H
#define DEDIT_H

#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>

#include <termios.h>

#include <stdio.h>
#include <string.h>

/** @typedef ditstate_e
 * States of the de-ditter that turns a sound stream back into dits and dahs.
 */
typedef enum {BEGIN, NEW, GOT1, GOT11, GOT111, GOT0, GOT00} ditstate_e;

#endif
