/*
 * Read long strings
 *
 *
 * Revision History:
 *
 *    $Log: longstr.c,v $
 *    Revision 1.5  2010-03-11 15:31:32 by Tyler Holland (username: tyhollan)
 *    Fixed the memory leak when ctrl+d was the only input
 *
 *    Revision 1.3  2003-04-12 10:37:33-07  pnico
 *    added config.h to list of inclusions
 *
 *    Revision 1.2  2003-04-12 10:26:41-07  pnico
 *    removed uses of __FUNCTION__ because MINIX doesn't
 *    support it.
 *
 *    Revision 1.1  2003-04-10 19:36:27-07  pnico
 *    Initial revision
 *
 *    Revision 1.1  2002-05-23 14:13:24-07  pnico
 *    Initial revision
 *
 *    Revision 1.1  2002-05-16 15:09:20-07  pnico
 *    Initial revision
 *
 *
 */

#include <unistd.h>
#include <stdlib.h>
#include <string.h>

#include "config.h"
#include "myline.h"
#include "longstr.h"


char *readLongString(FILE *infile){
  /* readLongString() reads a string of arbitrary length from the given
   * file and returns it as a newly allocated string
   *
   * The technique is to use your myline() function, always asking for
   * a new buffer.
   *
   * The caller is responsible for freeing the allocated string
   *
   * returns
   *   on success: a pointer to the newly allocated string.
   *   on EOF without reading something or read-error: NULL
   */
  size_t len = 0;
  char *buff = 0;
  char *ans;
  int ret;

  ret = myline(&buff, &len, infile);
  if (ret <= 0) {
    /* 357 : free the buffer when an EOF is input */
    free(buff);
    /* End 357 */
    return NULL;
  } else {
    ans = strdup(buff);
    free(buff);
    return ans;
  }
}
