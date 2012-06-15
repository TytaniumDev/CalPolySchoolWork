/* Lab 2: malloc and free
 * Created by: Tyler Holland
 * Course: CPE357
 */

#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

struct element
{
   char letter;
   struct element *next;
};

int main(void)
{
   struct element *head = NULL;
   struct element *current = NULL;
   char input = ' ';
   int r; /* for error checking */
   
   while(input != EOF)
   {
      input = getchar();
      if(input == EOF)
      {
         return 0;
      }
      if(input == '\n')
      {
         while(head != NULL)
         {
            current = (*head).next;
            r = putchar((*head).letter);
            if(r == EOF)
            {
               perror("Error with putchar\n");
               return 1;
            }
            free(head);
            head = current;
         }
         r = putchar('\n');
         if(r == EOF)
         {
            perror("Error with putchar\n");
            return 1;
         }
      }
      else
      {
         current = (struct element*)malloc(sizeof(struct element));
         /* Initialize values */
         (*current).next = head;
         input = getchar();
         if(input == EOF)
         {
            return 0;
         }
         (*current).letter = input;
         /* End initialization */
         head = current;
      }
   }
   return 0;
}
