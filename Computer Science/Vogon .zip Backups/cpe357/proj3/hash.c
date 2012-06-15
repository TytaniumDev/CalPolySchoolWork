/**
 *  @file
 *  <pre>CPE 357 Winter 2010
 *  -------------------
 *  hash: Uses Dan Bernstein's string hash algorithm shown at http://www.cse.yorku.ca/~oz/hash.html
 *    Algorithm also availiable at http://fr.wikipedia.org/wiki/Table_de_hachage#Fonction_de_Hachage
 *  @author Tyler Holland
 *  Last Modified: Wed Feb  3 09:34:33 PST 2010
 */
 
 
 /**
 * Create a hash value for the string, used for storage
 * @param *str The string to get the hash value of
 * @return hash value of the string
 */
 unsigned long hash(unsigned char *str)
 {
   unsigned long hash = 5381;
   int c;
   
   while((c = *str++))
   {
      hash = ((hash << 5) + hash) + c; /* hash * 33 + c */
   }
   
   return hash;
 }
