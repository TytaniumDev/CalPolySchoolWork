import java.util.Scanner;


public class ArrayMaxFinder
{
   public static int arrayMax(int[] arr, int first)
   {
      if(first == arr.length - 1)
      {
         return arr[first];
      }
      else
      {
         int max = arrayMax(arr, first + 1);
         if(max > arr[first])
         {
            return max;
         }
         else
         {
            return arr[first];
         }
      }
   }
   
   public static void main(String[] args)
   {
      int[] array = new int[10];
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Enter 10 integers: ");
      for(int i = 0; i < 10; i++)
      {
         array[i] = scan.nextInt();
      }
      
      System.out.println("The max value of the integers is: " + arrayMax(array, 0));
   }
}
