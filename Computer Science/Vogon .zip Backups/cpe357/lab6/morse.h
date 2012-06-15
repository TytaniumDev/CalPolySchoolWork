/**
 * @file
 * <pre> CPE 357 Fall 2008
 * -------------------
 *
 * Header for functions for transcribing morse code.
 *
 * Last Modified: Wed Oct 28 12:55:48 PDT 2009</pre>
 * @author Kevin O'Gorman
 */

#ifndef MORSE_H
#define MORSE_H

#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>

#include <string.h>
#include <ctype.h>

/** Transcribe an ASCII char to a morse string. */
char *toMorse(char c);

/** Transcribe a morse unit to a char. */
char toChar(char *dits);

#endif
