
public class TreeWork
{
   public static <T extends Comparable<? super T>> boolean isHeap(T[] arr, int N)
   {
      for(int i = 0; i < N; i++)
      {
         if(2*i + 1 < N)
         {
            if(arr[2*i + 1].compareTo(arr[i]) < 0)
            {
               return false;
            } 
         }
         if(2*i + 2 < N)
         {
            if(arr[2*i + 2].compareTo(arr[i]) < 0)
            {
               return false;
            }
         }
      }
      return true;
   }
   
   public static <T> void printTree(T[] arr, int N)
   {
      int height = (int)(Math.log(N)/Math.log(2));
      for(int i = 0; i < height; i++)
      {
         for(int j = 0; j < Math.pow(2, i); j++)
         {
            System.out.print("" + arr[(int)(Math.pow(2, i) - 1)+ j] + " ");
         }
         System.out.println();
      }
      for(int i = (int)Math.pow(2, height) - 1; i < N; i++)
      {
         System.out.print("" + arr[i] + " ");
      }
      System.out.println();
   }
}
