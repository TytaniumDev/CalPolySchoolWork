//Written by Tyler Holland (tyhollan)
public class RodCutter
{
   public int[] Price;
   public int comp;
   public RodCutter(int[] P, int N)
   {
      Price = P;
      comp = 0;
   }
   
   public int cutIterative(int N)
   {
      int[] Cost = new int[N + 1];
      Cost[1] = Price[1];
      for(int j = 2; j <= N; j++)
      {
         Cost[j] = Price[j];
         for(int i = 1; i < j; i++)
         {
            if(Cost[j] < (Cost[i] + Cost[j-i]))
            {
               Cost[j] = Cost[i] + Cost[j-i];
            }
            comp++;
         }
      }
      return max(Cost);
   }
   
   public int cutRecursive(int N)
   {
      int[] Cost = new int[N + 1];
      Cost[0] = Price[N];
      for(int i = 1; i < N; i++)
      {
         Cost[i] = cutRecursive(i) + cutRecursive(N-i);
         comp++;
      }
      return max(Cost);
   }
   
   public int cutRecursiveMem(int N)
   {
      int[] Solutions = new int[N + 1];
      for(int i = 0; i < Solutions.length; i++)
      {
         Solutions[i] = Integer.MIN_VALUE;
      }
      return MemorizedSolution(Solutions, N);
   }
   
   private int MemorizedSolution(int[] Solutions, int i)
   {
      if(Solutions[i] != Integer.MIN_VALUE)
      {
         return Solutions[i];
      }
      else
      {
         if(i == 0)
         {
            Solutions[i] = 0;
         }
         else
         {
            int temp = Price[i];
            for(int j = 1; j < i; j++)
            {
               temp = Math.max(temp,Price[j]+MemorizedSolution(Solutions, i-j));
               comp++;
            }
            Solutions[i] = temp;
         }
      }
      comp++; //if statement
      return Solutions[i];
   }
   
   public void PrintSolution(int N)
   {
      System.out.println("Iterative: " + cutIterative(N));
      System.out.println("Recursive: " + cutRecursive(N));
      System.out.println("Recursive with Memorization: " + cutRecursiveMem(N));
   }
   
   public void ResetComparison()
   {
      comp = 0;
   }
   
   private int max(int[] array)
   {
      int max = array[0];
      for(int i = 1; i < array.length; i++)
      {
         if(array[i] > max)
         {
            max = array[i];
         }
      }
      return max;
   }
}
