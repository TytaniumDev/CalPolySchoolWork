import java.util.Scanner;
import java.util.Iterator;
public class SeperateAndMerge
{
   public static void main (String[] args)
   {
      LList<Integer> intList = new LList<Integer>();
      LList<Float> floatList = new LList<Float>();
      Scanner scan = new Scanner(System.in);
      
      while(scan.hasNext())
      {
         if(scan.hasNextInt())
         {
            intList.add(scan.nextInt());
         }
         else if(scan.hasNextFloat())
         {
            floatList.add(scan.nextFloat());
         }
         else
         {
            scan.next();
         }
      }
      
      System.out.print("Inputted Values: ");
      Iterator integer = intList.iterator();
      Iterator floats = floatList.iterator();
      
      while(integer.hasNext() && floats.hasNext())
      {
         System.out.print("" + integer.next() + " " + floats.next() + " ");
      }
      while(integer.hasNext())
      {
         System.out.print("" + integer.next() + " ");
      }
      while(floats.hasNext())
      {
         System.out.print("" + floats.next() + " ");
      }
      System.out.println();
   }
}
