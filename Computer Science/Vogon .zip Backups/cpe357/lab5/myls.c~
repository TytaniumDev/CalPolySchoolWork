/* Lab 5: recreate the ls command
 * Made by: Tyler Holland
 * Assignment: Lab 5
 * CPE357
 */
 
 #include <unistd.h>
 #include <stdlib.h>
 #include <stdio.h>
 #include <errno.h>
 #include <dirent.h>
 #include <sys/types.h>
 #include <sys/stat.h>
 #include <libgen.h>
 
 int main (int argc, char* argv[])
 {
   char *buf = NULL;
   size_t size = 4096;
   struct dirent *direct;
   struct stat info;
   DIR *directory = NULL;
   
      /*This program takes no arguments*/
   if(argc > 1)
   {
      printf("This program takes NO arguments\nUsage: ./myls\n");
      return -1;
   }
   
   /* Get common working directory */
   buf = malloc((size_t)size);
   getcwd(buf, size);
   
   directory = opendir(buf);
   
   while((direct = readdir(directory)) != NULL)
   {
      lstat(direct->d_name, &info);
      /*Mode field*/
      printf("%10o ",info.st_mode);
      /*Link Count*/
      printf("%2u ",(unsigned int)info.st_nlink);
      /*Owner*/
      printf("%8d ",info.st_uid);
      /*Group*/
      printf("%8d ",info.st_gid);
      /*Size*/
      printf("%8u ",(unsigned int)info.st_size);
      /*Date*/
      printf("%16u ",(unsigned int)info.st_mtime);
      /*File name*/
      printf("%s\n",direct->d_name);
   }
   printf("\n");
   if(buf)
   {
      free(buf);
   }
   return (closedir(directory));
 }
