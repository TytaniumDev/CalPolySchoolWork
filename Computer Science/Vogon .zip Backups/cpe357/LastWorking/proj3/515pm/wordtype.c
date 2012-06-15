/**
 * @file
 * <pre> CPE 357 Winter 2010
 * -------------------
 *
 * The class-like file for the word abstract data type.
 *
 * Last Modified: Wed Feb  3 09:34:33 PST 2010
 * @author Tyler Holland
 */
 
#include "freq.h"

word_t* makeword()
{
   word_t* thedata;
   
   thedata = (word_t*)malloc(sizeof(struct word));
   thedata->times = 1;
   
   return thedata;
}

int compareword(const void *first, const void *second)
{
   if((*(struct word*)first).times > (*(struct word*)second).times)
   {
      return 1;
   }
   else if((*(struct word*)first).times == (*(struct word*)second).times)
   {
      return 0;
   }
   else
   {
      return -1;
   }
}
