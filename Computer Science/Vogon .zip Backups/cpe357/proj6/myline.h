/**
 * @file
 *  <pre>CPE 357 Spring 2009
 *  -------------------
 *  Header for getline() clone
 *
 *  @author Kevin O'Gorman
 *  Last Modified: Thu Feb 25 15:31:54 PST 2010
 */

#ifndef GETLINE_H
#define GETLINE_H
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>

/* Input arbitrary-length text lines. */
ssize_t myline(char **lineptr, size_t *n, FILE *stream);

#endif
