/**
 *  @file
 *  <pre>CPE 357 Winter 2010
 *  -------------------
 *  myline() -- a clone of the GNU getline() function.
 *  See the GNU manpage for details.
 *
 *  @author Kevin O'Gorman
 *  Last Modified: Mon Feb  1 08:04:33 PST 2010
 */
 

#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>

#include "myline.h"

#define BUFL 128

ssize_t myline(char **lineptr, size_t *n, FILE *stream) {
  size_t seen = 0;  /* keep track of how much has been read */
  size_t newlen;
  char *ret;

  if (lineptr == NULL || n == NULL || stream == NULL || (*n == 0 && *lineptr != NULL)) {
    errno = EINVAL;
    return -1;
  }

  /* Reset end condions that are otherwise "stuck" in the stream. */
  clearerr(stream);

  /* Check the initial buffer.  If not usable, supply a new one. */
  if (!*lineptr || !*n) {
    *n = BUFL;
    if (!(*lineptr = (char*)malloc(BUFL))) {
      return -1;
    }
  }

  for (;;) {
    /* '?' is an arbitrary non-NUL byte used to check for long inputs. */
    (*lineptr)[*n - 1] = '?';
    ret = fgets((*lineptr) + seen, *n - seen, stream);
    if (!ret) {
      /* error or eof.  If there's data, return it first,
       and report the condition later. */
      if (seen) {
        (*lineptr)[seen] = '\0';
        return seen;
      } else {
        return -1;
      }
    }
    /* Check to see if the line fit in the buffer. */
    if ((*lineptr)[*n - 1] == '?' || (*lineptr)[*n - 2] == '\n') {
      /* it fit.  Just return the size. */
      return seen + strlen((*lineptr) + seen);
    }
    /* Did not fit. */
    seen = *n - 1;
    newlen = *n * 2;
    ret = (char *)realloc(*lineptr, newlen);
    if (!ret) {
      return -1;
    }
    *lineptr = ret;
    *n = newlen;
  }
  /* Not reached */
}
