/* Minls and minget header file
 * Written by Tyler Holland and Brig Bagley
 * Project 4 for CPE 453
 */
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#define DEBUG
#undef DEBUG

#ifdef DEBUG
#define print1(x) printf(x); fflush(stdout)
#define print2(x,y) printf(x,y); fflush(stdout)
#define print3(x,y,z) printf(x,y,z); fflush(stdout)
#define print4(w,x,y,z) printf(w,x,y,z); fflush(stdout)
#else
#define print1(x) 
#define print2(x,y) 
#define print3(x,y,z) 
#define print4(w,x,y,z)
#endif

#define hex(x) ((x)==(0)?(fprintf(stderr,"0x00")):(fprintf(stderr,"%#4x",x)))
#define hex2(x) ((x)==(0)?(fprintf(stderr,"0x0000")):(fprintf(stderr,"%#4x",x)))
typedef struct superblock
{
   ino_t ninodes;
   short nzones;
   short i_blocks;
   short z_blocks;
   short firstdata;
   short log_zone_size;
   short pad;
   off_t max_file;
   long zones;
   short magic;
   short pad2;
   unsigned short blocksize;
   char subversion;
   short firstIblock;
   unsigned int zonesize;
   short ptrs_per_zone;
   short ino_per_block;
   short wrongended;
} superblock_t;

typedef struct inode
{
   unsigned short mode;
   unsigned short links;
   unsigned short uid;
   unsigned short gid;
   unsigned long size;
   time_t atime;
   time_t mtime;
   time_t ctime;
   unsigned long zone[7];/*not sure if this is definite or needs to be dynamic*/
   unsigned long indirect;
   unsigned long d_indirect;
}inode_t;

typedef struct ptable
{
   unsigned char firsteight[8];
   unsigned long lasttwo[2];
   short cyl[2];
}ptable_t;

typedef struct directory
{
   unsigned long inode;
   char name[60];
}directory_t;

void print_help(char *argv);
void to_mode(unsigned short mode, char *ch);
void print_ptable(ptable_t *ptable);
void print_superblock(superblock_t *superblock);
void print_inode(inode_t *inode);
