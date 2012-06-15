import java.util.Scanner;
public class ArraySummer
{
   public static int arraySum(int[] arr, int first)
   {
      if(first == arr.length - 1)
      {
         return arr[first];
      }
      else
      {
         return arr[first] + arraySum(arr, first + 1);
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
      
      System.out.println("The sum of the values entered is: " + arraySum(array, 0));
   }
}
