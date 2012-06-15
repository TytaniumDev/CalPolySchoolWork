#ifndef STRINGLISTH
#define STRINGLISTH

#include <stdio.h>

typedef struct list_st *slist;
struct list_st {
  char *str;
  slist next;
};

extern void       free_slist(slist l);
extern slist new_slist_node(char *string, slist next);
extern slist reverse_slist(slist l);
extern slist append_slist(slist s, slist t);
extern void       print_slist(FILE* where, slist l);
extern int        slist_length(slist l);
extern char **    make_slist_argv(slist l);

#ifndef TRUE
#define TRUE 1
#endif
#ifndef FALSE
#define FALSE 0
#endif

#endif



