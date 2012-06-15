/*
 * stringstuff contains routines useful for manipulating strings.
 *
 * Revision History:
 *
 *     $Log: stringstuff.c,v $
 *     Revision 1.5  2003-04-15 18:11:34-07  pnico
 *     Checkpointing before distribution
 *
 *     Revision 1.4  2003-04-12 10:36:16-07  pnico
 *     added config.h to list of inclusions
 *
 *
 */
#include "config.h"

#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include "stringstuff.h"
#include "parser.h"

int countlines(char *str) {
  /* return the number of lines contained in the given string */
  int rvalue=0;
  char *s;

  if (str) {
    for(s = str; *s ; s++)
      if ( *s == '\n' )
        rvalue++;
  }
  return rvalue;
}

int matchquotes(char *str) {
  /* check to be sure all non-escaped quotes match */
  int matched=1;
  char *s;

  if (str) {
    for(s = str; *s ; s++) {
      if ( *s=='\\' )           /* backslash ecapes whatever's next */
        s++;                    /* skip it */
      else if ( *s == '\"' )
        matched = !matched;     /* keep track of parity on quotes */
    }
  }
  return matched;
}

char *cleancpystring(char *str) {
  /* remove all quotes not escaped by a backslash from the given
   * string.  Compacts the string toward the front and returns
   * a pointer to it.
   *   A backslash escapes the next character, whatever it is.
   *
   * Returns: a newly malloc()ed copy of the string, cleaned up.
   *
   */
  char *s;
  int h,t;                      /* head and tail */
  if ( str ) {
    h = 0;
    t = 0;
    do {
      if ( str[h] == '\\' ) {
        /* a backslash escapes the next character, whatever it is. */
        ++h;                    /* skip the backslash */
        str[t++] = str[h++];
      } else if ( str[h] == '\"' ) {
        /* if it is a quote, not preceeded by a backslash, skip it. */
        ++h;
      } else {
        /* copy the current character toward the front and move on */
        str[t++] = str[h++];
      }
    } while (str[t] != '\0' );  /* will have copied the null before test */

    /* The string has been cleaned, now make a copy */
    s = (char *)malloc( strlen(str) + 1 );
    strcpy(s,str);
    str = s;                    /* so the return value will be right */
  }
  return str;
}

