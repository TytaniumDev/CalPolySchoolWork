/**
 * @file
 * <pre> CPE 357 Fall 2008
 * -------------------
 *
 * Header for demorse.c
 *
 * Last Modified: Sat Feb  7 17:56:29 PST 2009</pre>
 * @author Kevin O'Gorman
 */

#ifndef MORSER_H
#define MORSER_H

#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>

#include <termios.h>

#include <stdio.h>
#include <string.h>

/**
 * \def TOKENLEN
 * the maximum size of a token.  Actually
 * 7 should do it (and detect any overlong tokens) because
 * no code defined code sequence has more than 6 dits and dahs.
 */
#define TOKENLEN 10

#endif
