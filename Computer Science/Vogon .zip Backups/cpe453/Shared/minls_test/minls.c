/**
 *  @file minls.c
 *  (short description)
 *  <pre> CPE 453 Spring 2010
 *  -------------------
 *  LONG DESCRIPTION
 *  Last Modified: 06/01/10</pre>
 *  @author Brig Bagley (bbagley) and Tyler Holland (tyhollan)
 */
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <errno.h>
#include <ctype.h>
#include <time.h>
#include "main.h"

/**
 * @fn int main(int argc, char **argv)
 * The main thing.
 * @param argc The number of arguments.
 * @param argv The array of argument names.
 * @return -1 on failure or 1-255 on success.
 */
int main(int argc, char **argv)
{
   /*local variables*/
   int i=0,j = 0,found = 0, verbose=0,partition=-1,subpartition=-1;
   int offset = 0;
   char *imagefile = NULL, *path = NULL, *read_path = NULL;
   char filename[60];
   char modes[11];
   unsigned char signature[2] = {0};
   superblock_t superblock = {0};
   inode_t inode = {0}, temp_inode = {0};
   FILE *image = NULL;
   directory_t temp_dir;
   ptable_t ptable[4] =
   {{{0},{0},{0}},{{0},{0},{0}},{{0},{0},{0}},{{0},{0},{0}}};
   ptable_t sptable[4] =
   {{{0},{0},{0}},{{0},{0},{0}},{{0},{0},{0}},{{0},{0},{0}}};
   /*begin reading the command line*/
   /*range of permitted arguments*/
   if(argc > 8 || argc < 2)
   {
      print_help(argv[0]);
   }
   /*read the arguments in order*/
   for(i=1;i<argc;i++)
   {  /*the help option*/
      if(strcmp(argv[i],"-h") == 0)
      {
         print_help(argv[0]);
      }/*the verbose option*/
      else if(strcmp(argv[i],"-v") == 0)
      {
         verbose = 1;
      }/*the partition option*/
      else if(strcmp(argv[i],"-p") == 0)
      {
         i++;
         if(i>=argc)
         {
            print_help(argv[0]);
         }
         partition = strtol(argv[i],NULL,10);
         if(!isdigit(argv[i][0]))
         {
            fprintf(stderr,"%s badly formed integer\n",argv[i]);
            print_help(argv[0]);
         }
         if(partition < 0 || partition > 3)
         {
            fprintf(stderr,"Partition %d out of range. Must be 0..3\n",
                  partition);
            print_help(argv[0]);
         }
      }/*the subpartition option*/
      else if(strcmp(argv[i],"-s") == 0)
      {
         if(partition < 0)
         {
            print_help(argv[0]);
         }
         i++;
         if(i>=argc)
         {
            print_help(argv[0]);
         }
         subpartition = strtol(argv[i],NULL,10);
         if(!isdigit(argv[i][0]))
         {
            fprintf(stderr,"%s badly formed integer\n",argv[i]);
            print_help(argv[0]);
         }
         if(subpartition < 0 || subpartition > 3)
         {
            fprintf(stderr,"Subpartition %d out of range. Must be 0..3\n",
                  subpartition);
            print_help(argv[0]);
         }
      }/*assuming the argument is the imagefile*/
      else
      {
         imagefile = argv[i];
         i++;
         if(i < argc)
         {
            path = argv[i];
            i++;
            if(i<argc)
            {
               print_help(argv[0]);
            }
         }
      }
   }/*if no imagefile found, print help*/
   if(!imagefile)
   {
      print_help(argv[0]);
   }/*this is for consistency... the beginning must be root*/
   if(path && path[0] == '/')
   {
      path++;
   }
   else
   {
      path = "";
   }
   print2("Verbose(1=on,0=off):\t%d\n",verbose);
   print3("Partition:\t\t%d\nSub-partition:\t\t%d\n",partition,subpartition);
   print3("Image:\t\t\t%s\nPath:\t\t\t/%s\n",imagefile,path);

   /*here is where the reading of the image begins*/
   if((image = fopen(imagefile,"r")) == NULL)
   {
      perror("fopen");
      return -1;
   }
   /*read the partition tables*/
   if(partition >=0)
   {/*check that the byte 510 and 511 signatures are good.*/
      if(fseek(image, 510, SEEK_SET) == -1)
      {
         perror("fseek 1");
         fclose(image);
         return -1;
      }
      print3("510 = %#x, 511 = %#hx\n",signature[0],signature[1]);
      if(fread(signature,1,2,image) == -1)
      {
         perror("fread 1");
         fclose(image);
         return -1;
      }
      print3("510 = %#x, 511 = %#x\n",signature[0],signature[1]);
      if(signature[0] != 0x55 || (signature[1]) != 0xAA)
      {
         fprintf(stderr,"Invalid partition table.\nUnable to open ");
         fprintf(stderr,"disk image \"%s\".\n",imagefile);
         fclose(image);
         return -1;
      }
      /*This is a proper partition table, read on */
      if(fseek(image, 0x1BE, SEEK_SET) == -1)
      {
         perror("fseek 2");
         fclose(image);
         return -1;
      }
      for(i=0;i<4;i++)
      {
         if(fread(&(ptable[i].firsteight),1,8,image) == -1)
         {
            perror("fread 2");
            fclose(image);
            return -1;
         }
         if(fread(&(ptable[i].lasttwo),4,2,image) == -1)
         {
            perror("fread 3");
            fclose(image);
            return -1;
         }
         ptable[i].cyl[0] = ptable[i].firsteight[3] |
            ((ptable[i].firsteight[2] & 0xc0) <<2);
         ptable[i].firsteight[2] &= 0x3f;
         ptable[i].cyl[1] = ptable[i].firsteight[7] |
            ((ptable[i].firsteight[6] & 0xc0) <<2);
         ptable[i].firsteight[6] &= 0x3f;
      }
      /*print the table read*/
      if(verbose)
      {
         fprintf(stderr,"\nPartition table:\n");
         print_ptable(&(ptable[0]));
      }
      /*make sure the wanted partition is a Minix partition*/
      if(ptable[partition].firsteight[4] != 0x81)
      {
         fprintf(stderr,"Not a Minix partition.\nUnable to open ");
         fprintf(stderr,"disk image \"%s\".\n",imagefile);
         fclose(image);
         return -1;
      }
      /*read subpartition table (only read if a good partition found*/
      if(subpartition >= 0)
      {
         print2("offset: %li\n",ptable[partition].lasttwo[0]);
         if(fseek(image, (ptable[partition].lasttwo[0]<<9)+
                  0x1BE, SEEK_SET) == -1)
         {
            perror("fseek 3");
            fclose(image);
            return -1;
         }
         for(i=0;i<4;i++)
         {
            if(fread(&(sptable[i].firsteight),1,8,image) == -1)
            {
               perror("fread 4");
               fclose(image);
               return -1;
            }
            if(fread(&(sptable[i].lasttwo),4,2,image) == -1)
            {
               perror("fread 5");
               fclose(image);
               return -1;
            }
            sptable[i].cyl[0] = sptable[i].firsteight[3] |
               ((sptable[i].firsteight[2] & 0xc0) <<2);
            sptable[i].firsteight[2] &= 0x3f;
            sptable[i].cyl[1] = sptable[i].firsteight[7] |
               ((sptable[i].firsteight[6] & 0xc0) <<2);
            sptable[i].firsteight[6] &= 0x3f;
         }
         /*print the table read*/
         if(verbose)
         {
            fprintf(stderr,"\nSubpartition table:\n");
            print_ptable(&(sptable[0]));
         }
         /*make sure the wanted partition is a Minix partition*/
         if(sptable[subpartition].firsteight[4] != 0x81)
         {
            fprintf(stderr,"Not a Minix subpartition.\nUnable to open ");
            fprintf(stderr,"disk image \"%s\".\n",imagefile);
            fclose(image);
            return -1;
         }
      }
   }
   /*set the offset due to partition choices, default 0*/
   if(partition >= 0)
   {
      if(subpartition >=0)
      {
         offset = (sptable[subpartition].lasttwo[0])<<9;
      }
      else
      {
         offset = (ptable[partition].lasttwo[0])<<9;
      }
   }
   /*seek to the superblock and read the superblock*/
   if(fseek(image, offset + 1024, SEEK_SET) == -1)
   {
      perror("fseek 4");
      fclose(image);
      return -1;
   }
   if(fread(&(superblock.ninodes),sizeof(ino_t),1,image) == -1)
   {
      perror("fread 6");
      fclose(image);
      return -1;
   }
   if(fread(&(superblock.nzones),sizeof(short),6,image) == -1)
   {
      perror("fread 7");
      fclose(image);
      return -1;
   }
   if(fread(&(superblock.max_file),sizeof(off_t),1,image) == -1)
   {
      perror("fread 8");
      fclose(image);
      return -1;
   }
   if(fread(&(superblock.zones),sizeof(short),4,image) == -1)
   {
      perror("fread 9");
      fclose(image);
      return -1;
   }
   if(fread(&(superblock.blocksize),sizeof(unsigned short),1,image) == -1)
   {
      perror("fread 10");
      fclose(image);
      return -1;
   }
   if(fread(&(superblock.subversion),sizeof(char),1,image) == -1)
   {
      perror("fread 11");
      fclose(image);
      return -1;
   }
   /*calculated values based on the read superblock values*/
   superblock.firstIblock = 2 + superblock.z_blocks + superblock.i_blocks;
   superblock.zonesize = superblock.blocksize << superblock.log_zone_size;
   print3("zonesize:%dblocksize:%d\n",superblock.zonesize,superblock.blocksize);
   superblock.ptrs_per_zone = (superblock.zonesize )>>2;
   superblock.ino_per_block = superblock.blocksize >>6;
   superblock.wrongended = 0;
   if(superblock.magic == 0x5a4d)
   {
      superblock.wrongended = 1;
      /*TODO if wrong ended, need to swap order of all data*/
   }
   /*print the superblock if verbose*/
   if(verbose)
   {
      print_superblock(&superblock);
   }
   /*not a minix filesystem*/
   if(superblock.magic != 0x4d5a && superblock.magic != 0x5a4d)
   {
      fprintf(stderr,"Bad magic number. (");
      hex2(superblock.magic);
      fprintf(stderr,")\nThis doesn't look like a MINIX filesystem.\n");
      return -1;
   }
   /*here is where the contents of the directory will be read*/
   /*the root always the first inode*/
   if(fseek(image, offset + (2 + superblock.i_blocks + superblock.z_blocks)
            * superblock.blocksize, SEEK_SET) == -1)
   {
      perror("fseek 5");
      fclose(image);
      return -1;
   }
   /*read the inode at root*/
   if(fread(&(inode.mode),sizeof(unsigned short),4,image) == -1)
   {
      perror("fread 12");
      fclose(image);
      return -1;
   }
   if(fread(&(inode.size),sizeof(unsigned long),13,image) == -1)
   {
      perror("fread 13");
      fclose(image);
      return -1;
   }
   /*while loop here reads down path until specified file is located.*/
   read_path = path;
   while(strlen(read_path) > 0)
   {
      found = 0;
      i=0;
      /*parsing the filepath to get the next dir/file in the path isolated*/
      while(read_path[i] != '/' && read_path[i] != '\0')
      {
         filename[i] = read_path[i];
         i++;
      }
      if(read_path[i] == '/')
      {
         filename[i] = '\0';
         read_path += strlen(filename) + 1;;
      }
      else
      {
         read_path += strlen(filename);
      }
      /*here is where the next file/dir is searched for in the data*/
      j=0;
      /*seek to first data to read contents*/
      while(inode.zone[j] == 0) j++;
      if(fseek(image, offset + (inode.zone[j])
               * superblock.blocksize, SEEK_SET) == -1)
      {
         perror("fseek 6");
         fclose(image);
         return -1;
      }
      /*read through all listings in dir*/
      for(i=0;i<(inode.size)/(sizeof(directory_t));)
      {
         if(fread(&temp_dir,sizeof(directory_t),1,image) == -1)
         {
            perror("fread 14");
            fclose(image);
            return -1;
         }
         /*if the entry read is valid and the one we want*/
         if(temp_dir.inode != 0 && (strcmp(temp_dir.name,filename) == 0))
         {/*seek to the inode it points to - 1*/
            print2("inode #: %lu\n",temp_dir.inode);
            if(fseek(image, offset + (2 + superblock.i_blocks
                        + superblock.z_blocks)* superblock.blocksize
                     + ((temp_dir.inode - 1)<<6), SEEK_SET) == -1)
            {
               perror("fseek 7");
               fclose(image);
               return -1;
            }
            found = 1;
            break;
         }
         else
         {
            i++;
         }
      }
      /*the file/dir in given path is not found*/
      if(!found)
      {
         fprintf(stderr,"%s: File not found.\n",path);
         return -1;
      }
      /*read the inode at current location*/
      if(fread(&(inode.mode),sizeof(unsigned short),4,image) == -1)
      {
         perror("fread 15");
         fclose(image);
         return -1;
      }
      if(fread(&(inode.size),sizeof(unsigned long),13,image) == -1)
      {
         perror("fread 16");
         fclose(image);
         return -1;
      }
      /*now ready to read to next level if there are more levels,
       * otherwise, move on and analyze data at this point*/
   }
   /*if verbose, print the inode info*/
   if(verbose)
   {
      print_inode(&inode);
   }
   /*here is where the contents of the folder, or the file, is listed*/
   /*if this is a regular file*/
   if((inode.mode & 0170000) == 0100000)
   {
      to_mode(inode.mode,modes);
      printf("%s%10lu /%s\n",modes,inode.size,path);
      fclose(image);
      return EXIT_SUCCESS;
   }
   else if((inode.mode & 0170000) == 0040000)
   {/*if this is a directory*/
      printf("/%s:\n",path);
      j=0;
      /*seek to first data to read contents*/
      while(inode.zone[j] == 0) j++;
      if(fseek(image, offset + (inode.zone[j])
               * superblock.blocksize, SEEK_SET) == -1)
      {
         perror("fseek 7");
         fclose(image);
         return -1;
      }
      /*go through all the entries in the directory*/
      for(i=0;i<(inode.size)/(sizeof(directory_t));i++)
      {/*read the next directory entry*/
         if(fread(&temp_dir,sizeof(directory_t),1,image) == -1)
         {
            perror("fread 17");
            fclose(image);
            return -1;
         }
         /*go to the inode specified and read in it's data*/
         if(temp_dir.inode != 0)
         {/*seek to the inode it points to - 1*/
            if(fseek(image, offset + (2 + superblock.i_blocks
                        + superblock.z_blocks)* superblock.blocksize
                     + ((temp_dir.inode - 1)<<6), SEEK_SET) == -1)
            {
               perror("fseek 8");
               fclose(image);
               return -1;
            }
            /*read the inode data in*/
            if(fread(&(temp_inode.mode),sizeof(unsigned short),4,image) == -1)
            {
               perror("fread 18");
               fclose(image);
               return -1;
            }
            if(fread(&(temp_inode.size),sizeof(unsigned long),13,image) == -1)
            {
               perror("fread 19");
               fclose(image);
               return -1;
            }
            /*print the directory entry*/
            to_mode(temp_inode.mode,modes);
            printf("%s%10lu %s\n",modes,temp_inode.size,temp_dir.name);
         }
         /*seek back to the next directory entry*/
         if(fseek(image, offset + (inode.zone[j]) * superblock.blocksize
                  + (i+1)*sizeof(directory_t), SEEK_SET) == -1)
         {
            perror("fseek 9");
            fclose(image);
            return -1;
         }
      }
   }
   else/*This is not a regular file*/
   {
      fprintf(stderr,"%s is not a regular file.\n",path);
      fclose(image);
      return -1;
   }
   fclose(image);
   return EXIT_SUCCESS;
}/*end main*/

/* @fn void print_help(char *argv)
 * prints the usage of the progam.
 * *argv The string that represents the first argument from the main.
 */
void print_help(char *argv)
{
   fprintf(stderr,"usage: %s [ -v ] [ -p num [ -s num ] ]",argv);
   fprintf(stderr," imagefile [ path ]\nOptions:\n");
   fprintf(stderr,"\t-p\t part    --- select partition for filesystem");
   fprintf(stderr," (default: none)\n\t-s\t sub     --- select");
   fprintf(stderr," partition for filesystem (default: none)\n");
   fprintf(stderr,"\t-h\t help    --- print usage information and exit\n");
   fprintf(stderr,"\t-v\t verbose --- increase verbosity level\n");
   exit(-1);
}

/* @fn void to_mode(unsigned short mode, char *ch)
 * Turns a mode of bits into a mode string.
 * mode the bits to be read for mode.
 * *ch the buffer to edit for the mode string. only use ch[0] -ch[9]
 *    ch[10] will be set to null. ch must be an array of 11 chars.
 */
void to_mode(unsigned short mode, char *ch)
{
   unsigned short temp,i;
   /*mask to see if this is a directory*/
   if((mode & 0170000) == 0040000)
   {
      ch[0] = 'd';
   }
   else
   {
      ch[0] = '-';
   }
   /*mask all the other bits to find rwx stati*/
   temp = mode;
   for(i=0;i<3;i++)
   {
      if(temp & (0000400>>(i*3)))
      {
         ch[3*i+1] = 'r';
      }
      else
      {
         ch[3*i+1] = '-';
      }
      if(temp & (0000200>>(i*3)))
      {
         ch[3*i+2] = 'w';
      }
      else
      {
         ch[3*i+2] = '-';
      }
      if(temp & (0000100>>(i*3)))
      {
         ch[3*i+3] = 'x';
      }
      else
      {
         ch[3*i+3] = '-';
      }
   }
   /*make sure the end of this specified char is a null byte*/
   ch[10] = '\0';
}

/* @fn void print_ptable(ptable_t *ptable)
 * Prints contents of a partition table formatted as a table.
 * *ptable the table to be printed.
 */
void print_ptable(ptable_t *ptable)
{
   int i,j;
   /*header*/
   fprintf(stderr,"       ----Start----      ");
   fprintf(stderr,"------End-----\n  Boot head  sec  cyl Type head");
   fprintf(stderr,"  sec  cyl      First       Size\n");
   /*each of the four available partitions printed*/
   for(i=0;i<4;i++)
   {
      fprintf(stderr,"  ");
      hex(ptable[i].firsteight[0]);
      for(j=1;j<3;j++)
      {
         fprintf(stderr," %4d",ptable[i].firsteight[j]);
      }
      fprintf(stderr," %4hi",ptable[i].cyl[0]);
      fprintf(stderr," ");
      hex(ptable[i].firsteight[4]);
      for(j=5;j<7;j++)
      {
         fprintf(stderr," %4d",ptable[i].firsteight[j]);
      }
      fprintf(stderr," %4hi",ptable[i].cyl[1]);
      fprintf(stderr," %10ld",ptable[i].lasttwo[0]);
      fprintf(stderr," %10ld\n",ptable[i].lasttwo[1]);
   }
}

/* @fn void print_superblock(superblock_t *superblock)
 * Prints contents of superblock.
 * *superblock the superblock to be printed.
 */
void print_superblock(superblock_t *superblock)
{
   /*the superblock section*/
   fprintf(stderr,"\nSuperblock Contents:\nStored Fields:\n");
   fprintf(stderr,"  ninodes%13li\n  i_blocks%12hi\n  z_blocks%12hi\n",
         superblock->ninodes, superblock->i_blocks, superblock->z_blocks);
   fprintf(stderr,"  firstdata%11hi\n  log_zone_size%7hi (zone size: %u)\n",
         superblock->firstdata,superblock->log_zone_size,
         superblock->zonesize);
   fprintf(stderr,"  max_file%12lu\n  magic%#15hx\n  zones%15li\n",
         superblock->max_file, superblock->magic, superblock->zones);
   fprintf(stderr,"  blocksize%11hi\n  subversion%10hi\n",
         superblock->blocksize, superblock->subversion);
   fprintf(stderr,"Computed Fields:\n  firstIblock%9hi\n  zonesize%12u\n",
         superblock->firstIblock, superblock->zonesize);
   fprintf(stderr,"  ptrs_per_zone%7hi\n  ino_per_block%7hi\n",
         superblock->ptrs_per_zone, superblock->ino_per_block);
   fprintf(stderr,"  wrongended%10hi\n",
         superblock->wrongended);
}

/* @fn void print_inode(inode_t *inode)
 * Prints contents of inode.
 * *inode the inode to be printed.
 */
void print_inode(inode_t *inode)
{
   int i;
   char modes[11];
   fprintf(stderr,"\nFile inode:\n");
   to_mode(inode->mode,modes);
   fprintf(stderr,"  unsigned short mode%#15hx\t(%s)",
         inode->mode,modes);
   fprintf(stderr,"\n  unsigned short links%14hi\n",
         inode->links);
   fprintf(stderr,"  unsigned short uid%16hi\n  unsigned short gid%16hi\n",
         inode->uid, inode->gid);
   fprintf(stderr,"  unsigned long  size%15li\n",
         inode->size);
   fprintf(stderr,"  unsigned long  atime%14li\t--- %s",
         inode->atime,ctime(&(inode->atime)));
   fprintf(stderr,"  unsigned long  mtime%14li\t--- %s",
         inode->mtime,ctime(&(inode->mtime)));
   fprintf(stderr,"  unsigned long  ctime%14li\t--- %s",
         inode->ctime,ctime(&(inode->ctime)));
   fprintf(stderr,"\n  Direct zones:\n");
   for(i=0;i<7;i++)
   {
      fprintf(stderr,"              zone[%d]   =%11lu\n",i,inode->zone[i]);
   }
   fprintf(stderr,"  unsigned long  indirect%11li\n",inode->indirect);
   fprintf(stderr,"  unsigned long  double%13li\n",inode->d_indirect);
}
