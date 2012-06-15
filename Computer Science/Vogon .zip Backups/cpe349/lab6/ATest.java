import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/* Written by Tyler Holland and Spencer Ellsworth */
public class ATest
{
   public static void main(String args[]) throws FileNotFoundException
   {
      File infile1 = null;
      File infile2 = null;
      Scanner scan1 = null;
      Scanner scan2 = null;
      File infile3 = null;
      Scanner scan3 = null;
      
      if(args.length >= 2)
      {
         infile1 = new File(args[0]);
         scan1 = new Scanner(infile1);
         infile3 = new File(args[1]);
      }
      if (args.length == 3)
      {
         infile2 = new File(args[1]);
         scan2 = new Scanner(infile2);
         infile3 = new File(args[2]);
      }
      
      scan3 = new Scanner(infile3);
      
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
      
      String charline = new String("");
      String temp = new String("");
      Scanner miniscan = new Scanner(charline);
      miniscan.useDelimiter(",");
      
      int i = 0, j = 0, k = 0;
      
      
      int costs[][] = null;
      
      while(scan3.hasNextLine())
      {
         temp = scan3.nextLine();
         miniscan = new Scanner(temp);
         miniscan.useDelimiter(Pattern.compile(","));
         j = 0;
         if (k == 0)
         {
            while(miniscan.hasNext())
            {
               charline += miniscan.next();
               j++;
            }
            costs = new int[charline.length()][charline.length()];
            k = 1;
         }
         else 
         {
            while(miniscan.hasNext())
            {
               costs[i-1][j] = Integer.parseInt(miniscan.next());
               j++;
            }
         }
         i++;
      }
      
      Alignment test = new Alignment();
      test.setMatchingCost(charline, costs);
      
      System.out.println("Alignment Cost: " + test.findAlignment(s1, s2));
      test.getAlignment();
   }
}
