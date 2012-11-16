/**
 * Basic input parser to scan in different data values
 *
 * @author Tyler Holland
 * @version Lab 1
 * @version CPE102-5
 * @version Spring 2008
 */
import java.util.Scanner;

public class InputParser
{
   public static void main(String[] args)
   {
      // Possible scanned in ints
      int int1 = 0;
      int int2 = 0;
      int int3 = 0;
      // Possible scanned in doubles
      double double1 = 0.0;
      double double2 = 0.0;
      double double3 = 0.0;
      // Possible scanned in Strings
      String s1 = "";
      String s2 = "";
      String s3 = "";
      // Number of each type of value
      int numInt = 0;
      int numDouble = 0;
      int numString = 0;

      // Create a scanner to read in from command line
      Scanner scan = new Scanner(System.in);

      // Prompt for input
      System.out.print("Enter 3 different data values: ");

      // Scanning in logic
      // First input
      if(scan.hasNextInt())
      {
         int1 = scan.nextInt();
         numInt++;
      }
      else if(scan.hasNextDouble())
      {
         double1 = scan.nextDouble();
         numDouble++;
      }
      else
      {
         s1 = scan.next();
         numString++;
      }
      // Second input
      if(scan.hasNextInt())
      {
         int2 = scan.nextInt();
         numInt++;
      }
      else if(scan.hasNextDouble())
      {
         double2 = scan.nextDouble();
         numDouble++;
      }
      else
      {
         s2 = scan.next();
         numString++;
      }
      // Third input
      if(scan.hasNextInt())
      {
         int3 = scan.nextInt();
         numInt++;
      }
      else if(scan.hasNextDouble())
      {
         double3 = scan.nextDouble();
         numDouble++;
      }
      else
      {
         s3 = scan.next();
         numString++;
      }

      // Print out results
      System.out.println("Number of ints: " + numInt);
      System.out.println("Number of doubles: " + numDouble);
      System.out.println("Number of Strings: " + numString);
      // Added numbers
      System.out.println("Sum: " + (int1 + int2 + int3 + double1 + double2 + double3));
      if(s1 != "" || s2 != "" || s3 != "")
      {
         System.out.println("Strings concatenated: " + s1 + s2 + s3); 
      }
   }
}