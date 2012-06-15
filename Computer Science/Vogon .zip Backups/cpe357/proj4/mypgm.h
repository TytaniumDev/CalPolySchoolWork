/**
 * @file
 * <pre> CPE 357 Winter 2010
 * -------------------
 *
 * Header for Project 4, mypgm
 *
 * Last Modified: Sat Feb 13 10:19:46 PST 2010
 * @author Tyler Holland
 */

#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <errno.h>
#include <math.h>

#define MAXVALUE 65535
#define BUFL 1024
#define LONGHOLD 10
#define SMALLBYTE 256
#define PRINTWIDTH 10
#define STORAGE 300 /*Assuming less than 300 arguments on command line*/

/* Error codes */
#define OTHERERR 1 /*Any error not mentioned below*/
#define CMDLINEERR 2 /*Incompatible or unintelligible options on the command line, 
                       including unparseable numbers*/
#define MAXVALOUTERR 4 /*Maxvalue is too large for the output format. Detect only at the end 
                         of processing just before output begins*/
#define MAXVALOVERERR 8 /*Any intermediate maxval or data value becomes larger than 65535*/
#define MULTINFILEERR 16 /*Multiple input files named on the command line*/
#define INCFILEERR 32 /*Unintelligible (in the ASCII portion) or incomplete input file 
                        (too short: gets an early EOF), except that once a raw input file 
                        has produced at least one useable image, report this error on standard 
                        output and process the images that are present*/
#define OUTPUTFORMERR 64 /*Output form is specified more than once or not at all (options p and r)*/

void usage(char *cmd);
int getval(char *p);
void freeall(int width, int **array);
int brightenfunc(int maxval, int **array, int value, int height, int width);
int darkenfunc(int maxval, int **array, int value, int height, int width);
void smoothfunc(int **array, int height, int width);
int maxvaledit(int maxval, int readmaxval, int **array, int height, int width);
int divandround(int value1, int value2);
int round(double number);

#define FATALCALL(cond, complaint) \
      if (cond) {           \
        perror(complaint);  \
        exit(EXIT_FAILURE); \
      }

#define FATALTEST(cond, complaint) \
      if (cond) {           \
        fprintf(stderr, complaint);  \
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

