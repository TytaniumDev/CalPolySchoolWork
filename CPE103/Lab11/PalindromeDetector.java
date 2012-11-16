import java.util.Scanner;
import java.util.Iterator;
public class PalindromeDetector
{
   public static boolean isPalindrome(String word)
   {
      if(word.length() == 0 || word.length() == 1)
      {
         return true;
      }
      else
      {
         if(word.charAt(0) == word.charAt(word.length() - 1))
         {
            return isPalindrome(word.substring(1, word.length() - 1));
         }
         return false;
      }
   }
   
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      LList<String> list = new LList<String>();
      while(scan.hasNext())
      {
         String temp = scan.next();
         if(isPalindrome(temp))
         {
            list.add(temp);
         }
      }
      System.out.print("Palindromes: ");
      Iterator tempiter = list.iterator();
      if(tempiter.hasNext())
      {
         System.out.print("" + tempiter.next());
      }
      while(tempiter.hasNext())
      {
         System.out.print(", " + tempiter.next());
      }
      System.out.println();
   }
}
