/**
 *  @file
 *  <pre>CPE 357 Winter 2010
 *  -------------------
 *  freq: will return a sorted list of the n most common words in all the files in a specified 
 *        directory, where n is given on the command line.
 *
 *  @author Tyler Holland
 *  Last Modified: Wed Feb  3 09:34:33 PST 2010
 */

#include "freq.h"

/**
 * @param argc the number of tokens on the input line.
 * @param argv an array of tokens.
 * @return 0 on success, 1-255 on failure
 */

int main(int argc, char *argv[])
{
   char **arg = argv;
   char *argp;
   int words = 0;
   int i = 0; /* Misc. Loop counter */
   word_t *storage[MAXENTRY]; /* No more than 1,000,000 words */

   /* First argument is number of words to give output */
   if ((argp = *++arg))
   {
      while((isdigit(argp[i])) != 0)
      {
         if(i > 0) /* Multiply by 10 for place values */
         {
            words = (words * 10);
         }
         words = words + (argp[i] - CHARV);
         i++;
      }  
      if(words < 1 || i == 0)
      {
         fprintf(stderr, "Usage: freq limit {file ... | dir}\n");
         exit(EXIT_FAILURE);
      }
   }
   else
   {
      fprintf(stderr, "Usage: freq limit {file ... | dir}\n");
      exit(EXIT_FAILURE);
   }
   
   /* File arguments */
   while ((argp = *++arg)) 
   {
      if (argp[0] == '-') 
      {
         if (argp[1] == '-') 
         {
         /* Long options */
            if (strcmp(argp, "--help") == 0) 
            {
               printf("Usage: freq limit {file ... | dir}\n");
               exit(EXIT_SUCCESS);
            }
            else if (strcmp(argp, "--version") == 0) 
            {
               printf("Project 3: freq for CPE 357\n");
               printf("If I had a Copyright I would put it here\n");
               printf("Written by Tyler Holland\n");
               exit(EXIT_SUCCESS);
            } 
            else 
            {
               FATALTEST2(1, "Invalid option: %s\n", argp);
            }
         } 
      /* end options */
      } 
      else 
      {
         /* if it's not an option, it must be a file name */
         newfile(argp, storage);
      }
   }
   
   /* Sort the words */
   qsort(&storage[0], MAXENTRY, sizeof(word_t*), compareword);
   
   /* The printout and free*/
   i = 0;
   while(storage[i])
   {
      /*Need to figure out how to print 0's in front */
      /* Less than 20 char word */
      printf("%26s ", storage[i]->name);
      
      /* Occurances */
      printf("%d\n", storage[i]->times);
      
      /* Free the malloc'd memory */
      free(storage[i]);
      i++;
   }
   return EXIT_SUCCESS;
}
