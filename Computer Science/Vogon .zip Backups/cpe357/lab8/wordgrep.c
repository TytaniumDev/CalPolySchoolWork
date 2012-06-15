/**
 * Lab 8: Short Pipe
 * Made by Tyler Holland
 */
 
 #include <unistd.h>
 #include <stdlib.h>
 #include <stdio.h>
 #include <sys/types.h>
 #include <sys/wait.h>
 #include <errno.h>
 
int main(int argc, char *argv[])
{
   int pfd[2];
   pid_t pid1, pid2;
   pid_t c1,c2;
   int st1,st2;
   int status;
   
   if(pipe(pfd) == -1)
   {
      perror("pipe");
      exit(EXIT_FAILURE);
   }
   
   pid1 = fork();
   if(pid1 < 0)
   {
      perror("pid1");
      exit(EXIT_FAILURE);
   }
   if(!pid1)
   {
      if((dup2(pfd[1], STDOUT_FILENO)) < 0)
      {
         perror("dup2 c1");
         exit(EXIT_FAILURE);
      }
      close(pfd[0]);
      close(pfd[1]);
      if((execlp("ls", "ls", "-l", (char *)NULL)) < 0)
      {
         perror("execlp");
         exit(EXIT_FAILURE);
      }
   }
   
   pid2 = fork();
   if(pid2 < 0)
   {
      perror("pid2");
      exit(EXIT_FAILURE);
   }
   if(!pid2)
   {
      if((dup2(pfd[0], STDIN_FILENO)) < 0)
      {
         perror("dup2 c2");
         exit(EXIT_FAILURE);
      }
      close(pfd[0]);
      close(pfd[1]);
      argv[0] = "grep";
      if((execvp("grep", argv)) < 0)
      {
         perror("execvp");
         exit(EXIT_FAILURE);
      }
   }
   
   close(pfd[0]);
   close(pfd[1]);
   while((c1 = wait(&st1)) < 0)
   {
      if(errno == EINTR || errno == EAGAIN)
      {
         continue;
      }
      perror("child1");
      exit(EXIT_FAILURE);
   }
   while((c2 = wait(&st2)) < 0)
   {
      if(errno == EINTR || errno == EAGAIN)
      {
         continue;
      }
      perror("child2");
      exit(EXIT_FAILURE);
   }
   
   status = (c2 == pid2 ? st2 : st1);
   return (WIFEXITED(status) ? WEXITSTATUS(status):EXIT_FAILURE);
}
