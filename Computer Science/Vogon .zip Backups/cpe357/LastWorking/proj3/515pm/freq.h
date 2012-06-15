/**
 * @file
 * <pre> CPE 357 Winter 2010
 * -------------------
 *
 * Header for project 3
 *
 * Last Modified: Wed Feb  3 09:34:33 PST 2010
 * @author Tyler Holland
 */

#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <errno.h>
#include <dirent.h>
#include <libgen.h>

#define BUFL 1024
#define CHARV 48
#define LONGWORD 20
#define MAXENTRY 1000002

#define FATALCALL(cond, complaint) \
      if (cond) {           \
        perror(complaint);  \
        exit(EXIT_FAILURE); \
      }

#define FATALTEST(cond, complaint) \
      if (cond) {           \
        fputs(complaint, stderr);  \
        exit(EXIT_FAILURE); \
      }

#define FATALTEST2(cond, complaint, p1) \
      if (cond) {           \
        fprintf(stderr, complaint, p1);  \
        exit(EXIT_FAILURE); \
      }

#define FATALTEST3(cond, complaint, p1, p2) \
      if (cond) {           \
        fprintf(stderr, complaint, p1, p2);  \
        exit(EXIT_FAILURE); \
      }
      
typedef struct word
{
   char* name; /* Actual string of the word */
   int over; /* Number of letters over the 20 char limit */
   int times; /* Number of occurances of the word */
} word_t;

/*hash.c*/
 unsigned long hash(unsigned char *str);

/*readwords.c*/
void newfile(char *pathname, word_t** array);
int newword(int fd, char* pathname, char theword[], char* buffer, int* location, int* buflength);
int newchar(char* letter, char* buffer, int location);
int newblock(int fd, char* buffer);

/*wordtype.c*/
word_t* makeword();
int compareword(const void *first, const void *second);
