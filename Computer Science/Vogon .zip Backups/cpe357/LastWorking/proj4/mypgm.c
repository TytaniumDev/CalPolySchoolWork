/**
 *  @file
 *  <pre>CPE 357 Winter 2010
 *  -------------------
 *  mypgm: a program that reads and writes PGM (Portable GrayMap) files, 
 *  and performs simple operations on them.
 *
 *  @author Tyler Holland
 *  Last Modified: Sat Feb 13 09:34:33 PST 2010
 */
 
#include "mypgm.h"

int main(int argc, char *argv[])
{
   char ** arg = argv;
   char *argp;
   int fd = -2;
   int i = 0;
   int j = 0;
   int k = 0;
   int l = 0;
   int m = 0;
   /*Variables that are changed through console commands*/
   int raw = 0;
   int plain = 0;
   int maxval = -1;
   int smooth = 0;
   int brighten = 0;
   int darken = 0;
   int outputoccur = 0;
   char *outfile = NULL;
   /*Variables for file reading and manipulation of image*/
   int **array;
   int height;
   int width;
   int rlen;
   char buf[BUFL];
   int pval; /*2 = plain, 5 = raw*/
   int inputcount = 0;
   int stopit = 0;
   char holder[LONGHOLD] = ""; /*Mini-token holder*/
   int readmaxval = 0;
   double scaler = 0.0;
   double tempdoub = 0.0;
   /*For RAW images*/
   unsigned char high = 0;
   unsigned char low = 0;
   /*For writing output*/
   FILE *outputfile;

   /*From Kevin O'Gorman's myline solution*/
   while ((argp = *++arg)) 
   {
      if (argp[0] == '-') 
      {
         if (argp[1] == '-') 
         {
            /* Long options */
            if (strcmp(argp, "--help") == 0) 
            {
               usage(argv[0]);
               exit(EXIT_SUCCESS);
            } 
            else if (strcmp(argp, "--version") == 0) 
            {
               fprintf(stdout, "Project 4, mypgm, CPE 357, Winter 2010\n");
               fprintf(stdout, "If I had a copyright it would go here.\n");
               fprintf(stdout, "Written by Tyler Holland\n");
               exit(EXIT_SUCCESS);
            } 
            else if (strcmp(argp, "--raw") == 0) 
            {
               raw = 1;
            }
            else if (strcmp(argp, "--plain") == 0) 
            {
               plain = 1;
            } 
            else if (strncmp(argp, "--maxval=", 9) == 0) 
            {
               maxval = getval(argp+9);
            } 
            else if (strncmp(argp, "--output-file=", 14) == 0) 
            {
               outfile = strcpy(argp, (argp+14));
               outputoccur++;
            } 
            else if (strncmp(argp, "--smooth", 8) == 0) 
            {
               if(strncmp(argp, "--smooth=", 9) == 0)
               {
                  smooth = getval(argp+9);
               }
               else
               {
                  smooth = 1; /*Default*/
               }
            }
            else if (strncmp(argp, "--brighten", 10) == 0) 
            {
               if(strncmp(argp, "--brighten=", 11) == 0)
               {
                  brighten = getval(argp+11);
               }
               else
               {
                  brighten = 1; /*Default*/
               }
            }
            else if (strncmp(argp, "--darken", 8) == 0) 
            {
               if(strncmp(argp, "--darken=", 9) == 0)
               {
                  darken = getval(argp+9);
               }
               else
               {
                  darken = 1; /*Default*/
               }
            } 
            else 
            {
               FATALTEST2(1, "Invalid option: %s\n", argp);
            }
         } /*End long options*/
         else 
         {
            /* Short options */
            if (strcmp(argp, "-h") == 0) 
            {
               usage(argv[0]);
               exit(EXIT_SUCCESS);
            } 
            else if (strcmp(argp, "-v") == 0) 
            {
               printf("Project 4, mypgm, CPE 357, Winter 2010\n");
               printf("If I had a copyright it would go here.\n");
               printf("Written by Tyler Holland\n");
               exit(EXIT_SUCCESS);
            } 
            else if (strcmp(argp, "-r") == 0) 
            {
               raw = 1;
            }
            else if (strcmp(argp, "-p") == 0) 
            {
               plain = 1;
            } 
            else if (strncmp(argp, "-m", 2) == 0) 
            {
               maxval = getval(argp+2);
            } 
            else if (strncmp(argp, "-o", 2) == 0) 
            {
               outfile = strcpy(argp, (argp+2));
               outputoccur++;
            }          
            else if (strncmp(argp, "-s", 2) == 0) 
            {
               if((argp+3) != '\0')
               {
                  smooth = getval(argp+3);
               }
               else
               {
                  smooth = 1; /*Default*/
               }
            }
            else if (strncmp(argp, "-b", 2) == 0) 
            {
               if((argp+3) != '\0')
               {
                  brighten = getval(argp+3);
               }
               else
               {
                  brighten = 1; /*Default*/
               }
            }
            else if (strncmp(argp, "-d", 2) == 0) 
            {
               if((argp+3) != '\0')
               {
                  darken = getval(argp+3);
               }
               else
               {
                  darken = 1; /*Default*/
               }
            } 
            else if (argp[1] == '\0') 
            {
               /* READ FROM STDIN */
               fd = 0;
               if((argp = *++arg))
               {
                  /*Input after file name*/
                  fprintf(stderr, "Input given after the file name\n");
                  exit(MULTINFILEERR);
               }
               break;
            } 
            else 
            {
               fprintf(stderr, "Incompatible or unintelligible options on the command line\n");
               exit(CMDLINEERR);
            }
         } /* end short options */
      } /* end options */ 
      else 
      {
         /* if it's not an option, it must be a file name */
         fd = open(argp, O_RDONLY);
         /* do error checks */
         if(fd == -1)
         {
            perror("Error on file open");
            exit(EXIT_FAILURE);
         }
         if((argp = *++arg))
         {
            /*Input after file name*/
            fprintf(stderr, "Input given after the file name\n");
            exit(MULTINFILEERR);
         }
         break;
      }
      if(outputoccur > 1)
      {
         fprintf(stderr, "--output-file occured more than once\n");
         exit(EXIT_FAILURE);
      }
   }
   if((raw == 0 && plain == 0) || (raw == 1 && plain == 1))
   {
      fprintf(stderr, "Output form is specified more than once or not at all (options p and r)\n");
      exit(OUTPUTFORMERR);
   }
   if (fd == -2) /*Never saw a file name*/ 
   {
      /*READ FROM STDIN*/
      fd = 0;
      /* do error checks */
      if(fd == -1)
      {
         perror("Error on file open");
         exit(EXIT_FAILURE);
      }
   }
   /* Input Portion Done */
   
   /*Start File Stuff*/
   rlen = read(fd, buf, BUFL);
   if(rlen == -1)
   {
      perror("read from file");
      exit(EXIT_FAILURE);
   }
   /* Get P value, width, height, and maxval */
   while(rlen > 0) /*Still something in the file*/
   {
      for(i = 0; i < rlen; i++)
      {
         if(isspace(buf[i]) == 0) /*Not whitespace*/
         {
            if(buf[i] == '#') /*Don't copy comments*/
            {
               stopit = 1;
            }
            if(stopit == 0)
            {
               holder[j] = buf[i];
               j++;
            }
         }
         else /*It is whitespace*/
         {
            if(stopit == 1)
            {
               if(buf[i] == '\n') /*End of comment*/
               {
                  stopit = 0;
               }
               else
               {
                  continue;
               }
            }
            /*Parsing Logic*/
            if(strncmp(holder, "P", 1) == 0) /*P value*/
            {
               pval = getval(holder+1);
               inputcount = 1;
            }
            else /*Must be width, height, and maxval, in that order*/
            {
               if(inputcount == 1)/*Width*/
               {
                  width = getval(holder);
                  inputcount++;
               }
               else if(inputcount == 2)/*Length*/
               {
                  height = getval(holder);
                  inputcount++;
               }
               else if(inputcount == 3)/*readMaxval*/
               {
                  readmaxval = getval(holder);
                  inputcount++;
               }
               else /*Get out*/
               {
                  break;
               }
            }
            
            /*Reset Variables*/
            j = 0;
            for(m = 0; m < LONGHOLD; m++)
            {
               holder[m] = '\0';
            }
         }
         if(inputcount == 4)
         {
            break;
         }
      }
      if(inputcount == 4)
      {
         break;
      }
   
      rlen = read(fd, buf, BUFL);
      if(rlen == -1)
      {
         perror("read from file");
         exit(EXIT_FAILURE);
      }
   }
   /*Malloc the array*/
   array = malloc(height * sizeof(int *));
   if(array == NULL)
   {
      fprintf(stderr, "out of memory\n");
      freeall(width, array);
      exit(OTHERERR);
   }
   for(m = 0; m < height; m++)
   {
      array[m] = malloc(width * sizeof(int));
      if(array[m] == NULL)
      {
         fprintf(stderr, "out of memory\n");
         freeall(width, array);
         exit(OTHERERR);
      }
   }
   /*Rest of file must be input*/
   for(m = 0; m < LONGHOLD; m++)
   {
      holder[m] = '\0';
   }
   if(pval == 2) /*Plain file input*/
   {
      j = 0;
      k = 0;
      l = 0;
      while(rlen > 0) /*Still something in the file*/
      {
         for(; i < rlen; i++) /*No i initializer to keep buf space*/
         {
            if(isspace(buf[i]) == 0) /*Not whitespace*/
            {
               if(buf[i] == '#') /*Don't copy comments*/
               {
                  stopit = 1;
               }
               if(stopit == 0)
               {
                  holder[j] = buf[i];
                  j++;
               }
            }
            else /*It is whitespace*/
            {
               if(stopit == 1)
               {
                  if(buf[i] == '\n') /*End of comment*/
                  {
                     stopit = 0;
                  }
                  else
                  {
                     continue;
                  }
               }
               /*Parsing Logic, all must be grey values*/
               array[k][l] = getval(holder);
               
               if(array[k][l] > readmaxval)
               {
                  readmaxval = array[k][l];
               }
               
               if(l < (width - 1)) /*Still filling row*/
               {
                  l++;
               }
               else if(l == (width - 1) && k < (height - 1)) /*End of row hit, go down a column*/
               {
                  l = 0;
                  k++;
               }
               else if(!(l == (width - 1) && k == (height - 1)))/*Error in dimensions given*/
               {
                  fprintf(stderr, "Error: dimensions given are incorrect\n");
                  freeall(width, array);
                  exit(OTHERERR);
               }
               
               /*Reset Variables*/
               j = 0;
               for(m = 0; m < LONGHOLD; m++)
               {
                  holder[m] = '\0';
               }
            }
         }
         rlen = read(fd, buf, BUFL);
         i = 0;
         if(rlen == -1)
         {
            perror("read from file");
            freeall(width, array);
            exit(EXIT_FAILURE);
         }
      }
   }
   else if (pval == 5) /*Binary file input*/
   {
      k = 0;
      l = 0;
      while(rlen > 0) /*Still something in the file*/
      {
         for(; i < rlen; i++) /*No i initializer to keep buf space*/
         {
            /*Parsing Logic, all must be grey values*/
            if(readmaxval < SMALLBYTE)
            {
               low = buf[i];
               array[k][l] = low;
            }
            else /*Compensate for endianness*/
            {
               high = buf[i];
               array[k][l] = (high << 8);
               i++;
               low = buf[i];
               array[k][l] = array[k][l] + low;
               
            }
            if(array[k][l] > readmaxval)
            {
               readmaxval = array[k][l];
            }
            
            if(l < (width - 1)) /*Still filling row*/
            {
               l++;
            }
            else if(l == (width - 1) && k < (height - 1)) /*End of row hit, go down a column*/
            {
               l = 0;
               k++;
            }
            else if(!(l == (width - 1) && k == (height - 1)))/*Error in dimensions given*/
            {
               fprintf(stderr, "Error: dimensions given are incorrect\n");
               freeall(width, array);
               exit(OTHERERR);
            }
         }
         rlen = read(fd, buf, BUFL);
         i = 0;
         if(rlen == -1)
         {
            perror("read from file");
            freeall(width, array);
            exit(EXIT_FAILURE);
         }
      }
   }
   else /*Unrecognized input type*/
   {
      fprintf(stderr, "Unrecognized P value\n");
      freeall(width, array);
      exit(INCFILEERR);
   }

   if(!(k == (height - 1) && l == (width - 1))) /*File ended too early*/
   {
      fprintf(stderr, "Incomplete input file, early EOF\n");
      freeall(width, array);
      exit(INCFILEERR);
   }
   
   /*Manipulate image*/
   /*Maxval scaling*/
   if(maxval == -1)
   {
      maxval = readmaxval;
   }
   if(maxval != readmaxval) /*Scale the values*/
   {
      scaler = (double)maxval / (double)readmaxval;
      for(i = 0; i < height; i++)
      {
         for(j = 0; j < width; j++)
         {
            tempdoub = array[i][j];
            tempdoub = tempdoub * scaler;
            array[i][j] = round(tempdoub);
         }
      }
   }
   
   
   
   /*Write image*/
   if(outputoccur > 0)
   {
      outputfile = fopen(outfile, "w");
      if(outputfile == NULL)
      {
         perror("write to output file");
         freeall(width, array);
         exit(OTHERERR);
      }
      if(raw == 1)
      {
         fprintf(outputfile, "P5\n");/*P value*/
         fprintf(outputfile, "%d %d %d\n", width, height, maxval);
         if(maxval < SMALLBYTE)/*1 byte values*/
         {
            for(i = 0; i < height; i++)
            {
               for(j = 0; j < width; j++)
               {
                  fprintf(outputfile, "%c", array[i][j]);
               }
            }
         }
         else/*2 byte values*/
         {
            for(i = 0; i < height; i++)
            {
               for(j = 0; j < width; j++)
               {
                  fprintf(outputfile, "%c", (array[i][j] >> 8));
                  fprintf(outputfile, "%c", (array[i][j]));
               }
            }
         }
      }
      else if(plain == 1)
      {
         fprintf(outputfile, "P2\n");/*P value*/
         fprintf(outputfile, "%d %d %d\n", width, height, maxval);
         for(i = 0; i < height; i++)
         {
            for(j = 0; j < width; j++)
            {
               fprintf(outputfile, "%d", array[i][j]);
               if(((j + 1) % PRINTWIDTH) > 0)
               {
                  fprintf(outputfile, " ");
               }
               else
               {
                  fprintf(outputfile, "\n");
               }
            }
            fprintf(outputfile, "\n");
         }
      }
      fclose(outputfile);
   }
   else /*Write to stdout*/
   {
      if(raw == 1)
      {
         fprintf(stdout, "P5\n");/*P value*/
         fprintf(stdout, "%d %d %d\n", width, height, maxval);
         if(maxval < SMALLBYTE)/*1 byte values*/
         {
            for(i = 0; i < height; i++)
            {
               for(j = 0; j < width; j++)
               {
                  fprintf(stdout, "%c", array[i][j]);
               }
            }
         }
         else/*2 byte values*/
         {
            for(i = 0; i < height; i++)
            {
               for(j = 0; j < width; j++)
               {
                  fprintf(stdout, "%c", (array[i][j] >> 8));
                  fprintf(stdout, "%c", (array[i][j]));
               }
            }
         }
      }
      else if(plain == 1)
      {
         fprintf(stdout, "P2\n");/*P value*/
         fprintf(stdout, "%d %d %d\n", width, height, maxval);
         for(i = 0; i < height; i++)
            {
               for(j = 0; j < width; j++)
               {
                  fprintf(stdout, "%d", array[i][j]);
                  if(((j + 1) % PRINTWIDTH) > 0)
                  {
                     fprintf(stdout, " ");
                  }
                  else
                  {
                     fprintf(stdout, "\n");
                  }
               }
            }
      }
   }
   
   freeall(width, array);
   return EXIT_SUCCESS;
}

/*From Kevin O'Gorman's myline solution*/
/**
 * Print the usage message for this program.
 * @param cmd the command name.
 */
void usage(char *cmd) 
{
   fprintf(stdout,
    "Usage: %s [OPTION]... [FILE]...\n"
    "Read in images using the pgm formats and edit them, writing to standard output.\n"
    "With no FILE, or when FILE is -, read standard input.\n"
    "\n"
    "Mandatory arguments to long options are mandatory for short options too.\n"
    "\n"    
    "  -h, --help              Provide usage information and exit.\n"
    "  -v, --version           Provide identifying information and exit.\n"
    "  -r, --raw               Request raw output format.\n"
    "  -p, --plain             Request plain output format.\n", cmd);
   fprintf(stdout,
    "  -m, --maxval=n          Change the maximum gray value to n, changing all gray values in\n"
    "                          proportion to the change, rounding results to the nearest integer.\n"
    "                          The parameter n must be present.\n"
    "  -o, --output-file=name  Use the name instead of standard output; but note how multiple\n"
    "                          images are handled. The parameter name must be present.\n");
   fprintf(stdout,
    "  -s, --smooth[=n]        Smooth the image n times (default 1) as described below.\n"
    "  -b, --brighten[=n]      Brighten the image n times (default 1) as described below.\n"
    "  -d, --darken[=n]        Darken the image n times (default 1) as described below. \n"
    "\n"
    "Report bugs to <tyhollan@calpoly.edu>.\n");
}

/*From Kevin O'Gorman's myline solution*/
/**
 * Convert the val size.  This does not check for overflow.
 * Aborts on non-digit characters.
 * @param p a pointer to a decimal-only string.
 * @return the numeric value of the string.
 */
int getval(char *p) 
{
   char *argp = p;
   int tab = 0;
   char ch;

   while((ch = *argp++)) 
   {
      if (isdigit(ch)) 
      {
         tab = tab * 10 + (ch - '0');
      } 
      else 
      {
         FATALTEST3(1, "Illegal character '\\0%o' in size value: %s\n", ch, p);
      }
   }
   FATALTEST2(tab < 0, "Illegal size value (must be positive): %d\n", tab);
   return tab;
}

/**
 * FREE ABSOLUTELY EVERYTHING
 * @param width For freeing the array
 * @param array The array that holds the image
 */
void freeall(int width, int **array)
{
   int i;
   if(width != 0)
   {
      for(i = 0; i < width; i++)
      {
         free(array[i]);
      }
      free(array);
   }
}

/**
 * @param argc the number of tokens on the input line.
 * @param argv an array of tokens.
 * @return 0 on success, 1-255 on failure
 */
