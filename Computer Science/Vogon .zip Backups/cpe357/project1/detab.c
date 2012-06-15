/* Project 1: detab (a clone of expand)
 * Created by: Tyler Holland
 * Course: CPE357
 */

#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define DEFAULTTAB 8
#define MAXINPUT 10
#define INTCONVERT 48
#define PLACEVALUE 10

#define FATAL(cond, message)\
   if(cond){\
      perror(message);\
      exit(EXIT_FAILURE);\
   }

int main (int argc, char* argv[])
{
   int tabstop = DEFAULTTAB; /* How large the tabstop is, default 8, changes with --tabs */
   int inTabCount = 0; /* If tab amount is given, this is used to count it */
   int initialToggle = 0; /* 1 if initial is enabled */
   int column = 1; /* The current column */
   int futurecolumn = 0; /* for counting column */
   char input = ' '; /* Used in detab algorithm */
   char* inputOrder[MAXINPUT]; /* Stores input that needs to be read, for FILE or stdin */
   int totalInput = 0; /* for the last loop */
   int i; /* For loop counter */
   int j; /* Inner loop counter */
   FILE *infile; /* For file IO */
   int fileIO = 0; /* 1 if file IO occured */
   int newlineLast = 0; /* for initial */
   int r; /* For error checking */
   
   /* Initialize inputOrder */
   for(i = 0; i < MAXINPUT; i++)
   {
      inputOrder[i] = '\0';
   }
   
   /* Input portion */
   for(i = 1; i < argc; i++) /* i = 1 to start after "detab" in console */
   {
      inTabCount = 0;
      /* Check for invalid terminal input */
      if(strncmp("-", argv[i], 1) == 0)
      {
         if(strncmp("-i", argv[i], 2) == 0)
         {
            initialToggle = 1;
            if(strncmp("-it", argv[i], 3) == 0)  /* 3 is how many characters "-it" takes up */
            {
               j = 3; /* 3 is how many characters -it takes up */
               /* Test for something like -it2 */
               while(argv[i][j] != '\0')
               {
                  if(((argv[i][j]) - INTCONVERT) < 0 || ((argv[i][j]) - INTCONVERT) > 9)
                  {
                     fputs("-it : tab size contains an invalid character (non-int)\n", stderr);
                     return 1;
                  } 
                  inTabCount = inTabCount * PLACEVALUE;
                  inTabCount = inTabCount + ((argv[i][j]) - INTCONVERT);
                  j++;
               }
               tabstop = inTabCount;
               /* Test for number in next string */
               if(j == 3)
               {
                  if(i < argc)
                  {
                     j = 0; /* Reset j */
                     i++; /* Next string after --tabs must be a number */
                     while(argv[i][j] != '\0')
                     {
                        if(((argv[i][j]) - INTCONVERT) < 0 || ((argv[i][j]) - INTCONVERT) > 9)
                        {
                           fputs("-it : tab size contains an invalid character (non-int)\n", stderr);
                           return 1;
                        } 
                        inTabCount = inTabCount * PLACEVALUE;
                        inTabCount = inTabCount + ((argv[i][j]) - INTCONVERT);
                        j++;
                     }
                     tabstop = inTabCount;
                  }
                  else
                  {
                     fputs("-it: missing a number after -it\n", stderr);
                  }
               }
            }
         }
         else if(strncmp("--initial", argv[i], 9) == 0) /* 9 for length of string "--initial"*/
         {
            initialToggle = 1;
         }
         else if(strncmp("-t", argv[i], 2) == 0)
         {
            j = 2; /* 2 is how many characters -t takes up */
            /* Test for something like -t2 */
            while(argv[i][j] != '\0')
            {
               if(((argv[i][j]) - INTCONVERT) < 0 || ((argv[i][j]) - INTCONVERT) > 9)
               {
                  fputs("-t : tab size contains an invalid character (non-int)\n", stderr);
                  return 1;
               } 
               inTabCount = inTabCount * PLACEVALUE;
               inTabCount = inTabCount + ((argv[i][j]) - INTCONVERT);
               j++;
            }
            tabstop = inTabCount;
            /* Test for number in next string */
            if(j == 2)
            {
               if(i < argc)
               {
                  j = 0; /* Reset j */
                  i++; /* Next string after --tabs must be a number */
                  while(argv[i][j] != '\0')
                  {
                     if(((argv[i][j]) - INTCONVERT) < 0 || ((argv[i][j]) - INTCONVERT) > 9)
                     {
                        fputs("-t : tab size contains an 2invalid character (non-int)\n", stderr);
                        return 1;
                     } 
                     inTabCount = inTabCount * PLACEVALUE;
                     inTabCount = inTabCount + ((argv[i][j]) - INTCONVERT);
                     j++;
                 }
                  tabstop = inTabCount;
               }
               else
               {
                  fputs("-t: missing a number after --tabs\n", stderr);
               }
            }
         }
         else if(strncmp("--tabs", argv[i], 6) == 0) /* 6 for length of string "--tabs"*/
         {
            if(strncmp("--tabs=", argv[i], 7) == 0) /* 7 for length of string "--tabs="*/
            {
               j = 7; /* 7 is how many characters --tabs= takes up */
               while(argv[i][j] != '\0')
               {
                  if(((argv[i][j]) - INTCONVERT) < 0 || ((argv[i][j]) - INTCONVERT) > 9)
                  {
                     fputs("--tabs= : tab size contains an invalid character (non-int)\n", stderr);
                     return 1;
                  } 
                  inTabCount = inTabCount * PLACEVALUE;
                  inTabCount = inTabCount + ((argv[i][j]) - INTCONVERT);
                  j++;
               }
               tabstop = inTabCount;
            }
            else
            {
               j = 0; /* start at beginning of string */
               if(i < argc)
               {
                  j = 0; /* Reset j */
                  i++; /* Next string after --tabs must be a number */
                  while(argv[i][j] != '\0')
                  {
                     if(((argv[i][j]) - INTCONVERT) < 0 || ((argv[i][j]) - INTCONVERT) > 9)
                     {
                        fputs("--tabs: tab size contains an invalid character (non-int)\n", stderr);
                        return 1;
                     } 
                     inTabCount = inTabCount * PLACEVALUE;
                     inTabCount = inTabCount + ((argv[i][j]) - INTCONVERT);
                     j++;
                  }
                  tabstop = inTabCount;
               }
               else
               {
                  fputs("--tabs: missing a number after --tabs\n", stderr);
               }
            }
         }
         /* Check for --help and --version */
         else if(strcmp("--help", argv[i]) == 0)
         {
            printf("NAME\n     detab - convert tabs to spaces\n\n");
            printf("SYNOPSIS\n     detab [OPTION]... [FILE]...\n\n");
            printf("DESCRIPTION\n     Convert tabs in each FILE to spaces, writing to standard");
            printf(" output. With no FILE, or when FILE is -, read standard input.\n\n     ");
            printf("Mandatory arguments to long options are mandatory for short options too.\n");
            printf("\n     -i, --initial\n");
            printf("          do not convert tabs after non blanks\n\n");
            printf("     -t, --tabs=NUMBER\n");
            printf("          have tabs NUMBER characters apart, not 8\n\n");
            printf("     --help display this help and exit\n\n");
            printf("     --version output version information and exit\n\n");
            printf("AUTHOR\n     Written by Tyler Holland.\n\n");
            printf("REPORTING BUGS\n     Report bugs to <tyhollan@calpoly.edu>\n\n");
            printf("COPYRIGHT\n     I would put a Copyright here if I had one.\n");
            return 0;
         }
         else if(strcmp("--version", argv[i]) == 0)
         {
            printf("Detab Program\nWritten by student: Tyler Holland\n");
            printf("Course: CPE 357 - 05\n");
            return 0;
         }
         else
         {
            j = 1; /* 1 is how many characters - takes up */
            while(argv[i][j] != '\0')
            {
               if(((argv[i][j]) - INTCONVERT) < 0 || ((argv[i][j]) - INTCONVERT) > 9)
               {
                  if(j >= 2) /* There was a number first */
                  {
                     fputs("detab : tab size contains an invalid character (non-int)\n", stderr);
                     return 0;
                  }
                  else /* Just some random input */
                  {
                     fputs("detab: invalid option found\n", stderr);
                     fputs("Try 'detab --help' for more information\n", stderr);
                     return 0;
                  }
               } 
               inTabCount = inTabCount * PLACEVALUE;
               inTabCount = inTabCount + ((argv[i][j]) - INTCONVERT);
               tabstop = inTabCount;
               j++;
            }
            if(j == 1)
            {
               inputOrder[totalInput] = "stdin"; /* - reads stdin */
               totalInput++;
            }
         }
      }
      else
      {
         inputOrder[totalInput] = argv[i];
         totalInput++;
      }
   }
   
   if(argc == 1)
   {
      inputOrder[totalInput] = "stdin"; /* blank reads stdin */
      totalInput++;
   }

   for(i = 0; i < totalInput; i++)
   {
      /* Detab algorithm */
      while(input != EOF)
      { 
         if(strcmp(inputOrder[i], "stdin") == 0)
         {
            input = getc(stdin);
         }
         else
         {
            if(fileIO == 0)
            {
               infile = fopen(inputOrder[i], "r");
               if(infile == NULL)
               {
                  fprintf(stderr, "detab: %s, No such file or directory\n", inputOrder[i]);
                  break;
               }
            }
            input = getc(infile);
            fileIO = 1;
         }
         /*Read in a character*/
         if(input == '\n')
         {
            column = 1;
            newlineLast = 1;
            r = putchar('\n');
            FATAL(r==EOF, "putchar");
         }
         else if(input == '\b')
         {
            newlineLast = 0;
            column--;
            r = putchar('\b');
            FATAL(r==EOF, "putchar");
         }
         else if(input == '\t')
         {
            if(initialToggle == 1)
            {
               if(column == 1 && newlineLast == 1)
               {
                  futurecolumn = 1;
                  for(j = column; j <= tabstop; j++)
                  {
                     r = putchar(' ');
                     FATAL(r==EOF, "putchar");
                     futurecolumn++;
                  }
                  column = futurecolumn;
               }
               else
               {
                  newlineLast = 0;
                  r = putchar('\t');
                  FATAL(r==EOF, "putchar");
                  column = column + 2; /* \t takes up 2 columns */
               }
            }
            else
            {
               newlineLast = 0;
               for(j = column; j <= tabstop; j++)
               {
                  r = putchar(' ');
                  FATAL(r==EOF, "putchar");
                  column++;
               }
            }
         }
         else
         {
            newlineLast = 0;
            if(input != EOF)
            {
               r = putchar(input);
               FATAL(r==EOF, "putchar");
            }
            column++;;
         }
         /* Column logic*/
         if(column > tabstop)
         {
            column = 1; /* Reset column for easy for loops */
         }
      }
      if(fileIO == 1)
      {
         fclose(infile);
         FATAL(r==EOF, "fclose");
      }
      fileIO = 0;
      column = 1;
      input = ' ';
      newlineLast = 0;
   }
   return 0;
}
