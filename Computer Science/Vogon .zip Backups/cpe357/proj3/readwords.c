/**
 * @file
 * <pre> CPE 357 Winter 2010
 * -------------------
 *
 * Reads in words for use in freq.c
 *
 * Last Modified: Wed Feb  3 09:34:33 PST 2010
 * @author Tyler Holland
 */
 
#include "freq.h"
 
/**
 * @param pathname The file or directory path name
 * @param array The array of word_t pointers
 */
void newfile(char *pathname, word_t** array)
{
   int fd;
   unsigned long hashval;
   /*DIR *directory = NULL;*/
   /*struct dirent *direct;*/
   struct stat info;
   char theword[LONGWORD + 1];
   int check = 0;
   char *buffer;
   int location = 0;
   int i;
   int buflength = 0;
   
   buffer = (char*)malloc((size_t)BUFL);
   
   check = stat(pathname, &info);
   
   if(check != 0)
   {
      fprintf(stderr, "%s - %s\n", pathname, strerror(errno));
      exit(EXIT_FAILURE);
   }
   /*If it is a directory just recursive call this function*/
   else if(S_ISDIR(info.st_mode))
   {
      fprintf(stderr, "Unable to work with directories\n");
      /*directory = opendir(pathname);
      while((direct = readdir(directory)) != NULL)
      {
         newfile((direct->d_name), array);
      }
      closedir(directory);*/
   }
   /*The main part, read in words and store based on hash value*/
   else if(S_ISREG(info.st_mode))
   {
      fd = open(pathname, O_RDONLY);
      
      bzero(theword, (LONGWORD + 1));
      check = newword(fd, pathname, theword, buffer, &location, &buflength);
      while(check != -2) /* EOF not reached */
      {
         if(check > -1) /* Word larger than 4 chars */
         {
            hashval = hash((unsigned char*)theword);
            while(hashval > MAXENTRY)
            {
               hashval = hashval / MAXENTRY;
            }
            if(array[hashval])
            {
               array[hashval]->times++;
            }
            else
            {
               array[hashval] = makeword();
               for(i = 0; i < (LONGWORD + 1); i++)
               {
                  (array[hashval]->name)[i] = theword[i];
               }
               array[hashval]->over = check;        
            }
            bzero(theword, (LONGWORD + 1));
            check = newword(fd, pathname, theword, buffer, &location, &buflength);
         }
         else
         {
            break;
         }
      }
      
      if(buffer)
      {
         free(buffer);
      }
      
      close(fd);
   }
}

/**
 * @param fd the file descriptor
 * @param theword a pointer to the word to pass back.
 * @param location the current location in the buffer block
 * @param buflength total length of the buffer
 * @return -2 on failure, -1 on no word, 0-999999 on success, based on 
 *         # of letters beyond the 20 char max.
 */
int newword(int fd, char* pathname, char theword[], char* buffer, int* location, int* buflength)
{
   char templetter;
   int truelocation;
   int counter = 0;
   int newcharcheck;
   char realword[LONGWORD + 1];
   int i;
   
   bzero(realword, (LONGWORD + 1));
   truelocation = *location;
   
    /*First call on new file*/
   if(*buflength == 0)
   {
      *buflength = newblock(fd, buffer);
      if(*buflength == -1) /* Read Error */
      {
         fprintf(stderr, "%s - %s\n", pathname, strerror(errno));
         exit(EXIT_FAILURE);
      }
      truelocation = 0;
      if(*buflength == 0)
      {
         *location = truelocation;
         return -2;
      }
   }
   
   newcharcheck = newchar(&templetter, buffer, truelocation);
   truelocation++;
   while(newcharcheck == 1)
   {
      if(truelocation == *buflength) /* Maybe change to buflength + 1*/
      {
         *buflength = newblock(fd, buffer);
         if(*buflength == -1) /* Read Error */
         {
            fprintf(stderr, "%s - %s\n", pathname, strerror(errno));
            exit(EXIT_FAILURE);
         }
         truelocation = 0;
         if(*buflength == 0)
         {
            *location = truelocation;
            return -2;
         }
      }
      
      if(counter < LONGWORD)
      {
         realword[counter] = templetter;
         counter++;
      }
      if(counter >= LONGWORD) /* More than 20 chars */
      {
         counter++;
      }
      
      newcharcheck = newchar(&templetter, buffer, truelocation);
      truelocation++;
   }
   /* It was not an alphabetic character */
   if(counter < 4)
   {
      *location = truelocation;
      return -1;
   }
   else if(counter >= 4 && counter <= 20)
   {
      for(i = 0; i < counter; i++)
      {
         theword[i] = realword[i];
      }
      *location = truelocation;
      return 0;
   }
   else
   {
      for(i = 0; i < LONGWORD; i++)
      {
         theword[i] = realword[i];
      }
      *location = truelocation;
      return (counter - 20);
   }
}
 
/**
* @param letter the new character
* @param buffer the latest block of bytes
* @param location the current location in the buffer
* @return 1 on successful character got, 0 if it was not an alphabetic character
*/
int newchar(char* letter, char* buffer, int location)
{
   if(isalpha(buffer[location]) != 0)
   {
      *letter = tolower(buffer[location]);
      return 1;
   }
   return 0;
}
 
/**
* @param fd the file descriptor
* @param buffer the latest block of bytes
* @return number of bytes read in to buffer, or the return value of read
*/
int newblock(int fd, char* buffer)
{
   int bytesin;
   
   bytesin = read(fd, buffer, BUFL);
   return bytesin;
}
 
