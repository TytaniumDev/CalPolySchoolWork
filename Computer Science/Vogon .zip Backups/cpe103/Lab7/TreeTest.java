import java.util.Scanner;
public class TreeTest
{
   public static void main(String[] args)
   {
      Integer[] array = new Integer[20];
      Scanner scan = new Scanner(System.in);
      int count = 0;
      
      System.out.println("Input integers: ");
      while(count < 20 && scan.hasNext())
      {
         array[count] = scan.nextInt();
         count++;
      }
      if(count == 0)
      {
         System.out.println("The tree is empty");
      }
      else
      {
         if(TreeWork.isHeap(array, count))
         {
            System.out.println("The tree is a heap");
         }
         else
         {
            System.out.println("The tree is not a heap");
         }
         System.out.println();
         TreeWork.printTree(array, count);
      }
   }
}
