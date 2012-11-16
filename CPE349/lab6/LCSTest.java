import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Written by Tyler Holland and Spencer Ellsworth */
public class LCSTest
{
   public static void main(String args[]) throws FileNotFoundException
   {
      File infile1 = null;
      File infile2 = null;
      Scanner scan1 = null;
      Scanner scan2 = null;
      if(args.length >= 1)
      {
         infile1 = new File(args[0]);
         scan1 = new Scanner(infile1);
      }
      if (args.length == 2)
      {
         infile2 = new File(args[1]);
         scan2 = new Scanner(infile2);
      }
      
      String s1 = new String("");
      String s2 = new String("");
      
      if(infile2 == null) // one file
      {
         if(scan1.hasNextLine())
         {
            s1 = scan1.nextLine();
         }
         if(scan1.hasNextLine())
         {
            s2 = scan1.nextLine();
         }
      }
      else //two files
      {
         while(scan1.hasNext())
         {
            s1 += scan1.next();
            s1.replaceAll("\n","");
            s1.replaceAll("\r","");
         }
         while(scan2.hasNext())
         {
            s2 += scan2.next();
            s2.replaceAll("\n","");
            s2.replaceAll("\r","");
         }
      }
      
      LCS test = new LCS();
      
      test.findLCS(s1, s2);
      String temp = new String("");
      temp = test.getLCS();
      System.out.println(temp.length() + " : " + temp);
   }
}
