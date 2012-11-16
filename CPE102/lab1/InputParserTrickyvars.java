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
   // Possible scanned in ints
   private int int1;
   private int int2;
   private int int3;
   // Possible scanned in doubles
   private double double1;
   private double double2;
   private double double3;
   // Possible scanned in Strings
   private String s1;
   private String s2;
   private String s3;
   // Number of each type of value
   private int numInt = 0;
   private int numDouble = 0;
   private int numString = 0;

   public static void main(String[] args)
   {
      InputParser ip = new InputParser();
      ip.doit();
   }

   private void doit()
   {
 
   
      // Create a scanner to read in from command line
      Scanner scan = new Scanner(System.in);

      // Prompt for input
      System.out.print("Enter 3 different data values: ");

      // Scanning in logic
      // First input
      if(scan.hasNextInt())
      {
         int int1 = scan.nextInt();
         numInt++;
      }
      else if(scan.hasNextDouble())
      {
         double double1 = scan.nextDouble();
         numDouble++;
      }
      else
      {
         String s1 = scan.nextLine();
         numString++;
      }
      // Second input
      if(scan.hasNextInt())
      {
         int int2 = scan.nextInt();
         numInt++;
      }
      else if(scan.hasNextDouble())
      {
         double double2 = scan.nextDouble();
         numDouble++;
      }
      else
      {
         String s2 = scan.nextLine();
         numString++;
      }
      // Third input
      if(scan.hasNextInt())
      {
         int int3 = scan.nextInt();
         numInt++;
      }
      else if(scan.hasNextDouble())
      {
         double double3 = scan.nextDouble();
         numDouble++;
      }
      else
      {
         String s3 = scan.nextLine();
         numString++;
      }

      // Print out results
      System.out.println("Number of ints: " + numInt);
      System.out.println("Number of doubles: " + numDouble);
      System.out.println("Number of Strings: " + numString);
   }
}