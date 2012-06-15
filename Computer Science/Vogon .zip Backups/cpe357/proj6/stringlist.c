/*
 * stringlist: Some facilities for managing lists of strings
 *
 * Author: Dr. Phillip Nico
 *         Department of Computer Science
 *         California Polytechnic State Univernnnnnnsity
 *         One Grand Avenue.
 *         San Luis Obispo, CA  93407  USA
 *
 * Email:  pnico@csc.calpoly.edu
 *
 * Revision History:
 *         $Log: stringlist.c,v $
 *         Revision 1.5  2003-04-15 18:11:34-07  pnico
 *         Checkpointing before distribution
 *
 *         Revision 1.4  2003-04-12 10:36:29-07  pnico
 *         added config.h to list of inclusions
 *
 *         Revision 1.3  2003-04-12 10:25:34-07  pnico
 *         removed uses of __FUNCTION__ because MINIX doesn't
 *         support it.
 *
 *         Revision 1.2  2003-04-11 08:37:09-07  pnico
 *         removed calls to strdup() for portability to minix
 *
 *         Revision 1.1  2003-04-10 19:36:16-07  pnico
 *         Initial revision
 *
 *         Revision 1.1  2002-05-23 14:13:01-07  pnico
 *         Initial revision
 *
 *
 */
#include "config.h"

#include <ctype.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

#include "stringlist.h"

extern void free_stringnode(slist n){
  /* free the string if non-null */
  if ( n ) {
    if ( n->str)
      free(n->str);
    free(n);
  }
}

extern void free_slist(slist l){
  /* free the given slist.  Freeing of the strings is
   * left to the original owner of the list
   */
  slist next;
  for (;l;l=next ) {
    next = l->next;
    free_stringnode(l);
  }
}

extern slist reverse_slist(slist l){
  /* reverse the given slist
   */
  slist next,ret=NULL;

  for(;l;l=next){
    next = l->next;
    l->next = ret;
    ret = l;
  }
  return ret;
}

extern slist new_slist_node(char *string, slist next){
  /* allocate a new slist node with "string" as its data
   * and "next" as its next field
   * attaches a copy of the given string to the node
   */
  slist new;
  if ( (new = (slist)malloc(sizeof(struct list_st))) == NULL ) {
    perror("new_slist_node");
    exit(-1);
  }
  new->str  = (char*)malloc(strlen(string)+1);
  if ( new->str )
    strcpy(new->str,string);
  new->next = next;

  return new;
}

extern void print_slist(FILE* where, slist l) {
  /* print the given list for debugging purposes */
  int i;

  for ( i = 0 ; l ; l = l -> next ) {
    fprintf(where,"%4d) \"%s\"\n",i++,l->str);
  }

}

extern int slist_length(slist l) {
  int len;
  for ( len = 0; l ; l = l->next )
    len ++;
  return len;
}

extern char **    make_slist_argv(slist l){
  /* take the passed slist and make it into vector
   * form.
   */
  char **argv;
  int i;
  argv = (char **) malloc(slist_length(l)+1);
  if ( argv ) {
    for(i=0; l ; i++) {
      argv[i] = (char *)malloc(strlen(l->str)+1);
      if ( argv[i] ) {          /* all is well, do the copy   */
        strcpy(argv[i],l->str);
        l=l->next;
      } else {                  /* out of memory--return NULL */
        argv=NULL;
        break;
      }
    }
    argv[i]=NULL;               /* add the final NULL         */
  }
  return argv;
}

extern slist append_slist(slist s, slist t) {
  /* append the list t to s and return the result */
  slist res,l;
  if ( !s )
    res = t;
  else if ( !t )
    res = s;
  else {
    res = s;
    for(l=s; l->next; l=l->next )
      /* find the end of s */;
    l->next = t;                /* append t */
  }

  return res;
}
