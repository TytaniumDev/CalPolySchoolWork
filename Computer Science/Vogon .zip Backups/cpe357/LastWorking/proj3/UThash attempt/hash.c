/**
 *  @file
 *  <pre>CPE 357 Winter 2010
 *  -------------------
 *  hash: Uses UTHash shown at http://uthash.sourceforge.net/
 *  @author Tyler Holland
 *  Last Modified: Wed Feb  3 09:34:33 PST 2010
 */
 
#include "uthash.h"

/* Formatted similarly to http://uthash.sourceforge.net/userguide.html */
struct my_struct {
   char word[LONGWORD + 1]; /* key */
   int over; /* Length over the 20 char limit */
   int times; /* Number of occurances */
   UT_hash_handle hh; /* makes this structure hashable */
};
