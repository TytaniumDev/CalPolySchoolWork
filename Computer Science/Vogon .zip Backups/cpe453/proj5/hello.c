/* Project 5: Hello World
 * Written by Tyler Holland (tyhollan)
 * Prints out Hello, World!
 */
 
 #include <stdlib.h>
 #include <stdio.h>
 
 #define MSG "Hello, world!\n"
 
 /* The main function. Returns 0 on success, 1-255 on failure.
  * It prints out Hello, World!. That is all. 
  */
 int main(void)
 {
   /* Print Hello World using printf */
   if((printf(MSG)) < 0)
   {
      /* there was a printf error */
      fprintf(stderr, "Error in printf, wow...\n");
   }
   
   /* Return 0 */
   return EXIT_SUCCESS;
 }
