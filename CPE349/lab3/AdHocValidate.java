import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Written by Tyler Holland (tyhollan)

public class AdHocValidate
{
   public static void main(String args[]) throws FileNotFoundException
   {
      AdHocCode thing = new AdHocCode();
      CodeMap map = thing.getAdHocCodeMap();
      map.print();
      //Encode it
      File infile = new File(args[0]);
      Scanner scan = new Scanner(infile);
      String temp = "";
      while(scan.hasNext())
      {
         temp = temp.concat(map.convertText(scan.next()));
      }
      System.out.println("Encoded file length: " + temp.length());
      System.out.println("Reduction ratio: " + temp.length() + " / " 
            + (infile.length() * 16));
      System.out.println("Encoded file:");
      System.out.println("" + temp);
   }
}
