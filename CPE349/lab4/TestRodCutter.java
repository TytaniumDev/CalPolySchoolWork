//Written by Tyler Holland (tyhollan)
import java.util.Random;
public class TestRodCutter
{
   public static void main(String args[])
   {
      RodCutter[] rods = new RodCutter[2000];
      Random rando = new Random();
      int[] temprando = new int[2000];
      int[] temparray;
      
      long[] runtimeIter = new long[2000];
      long[] runtimeRecur = new long[2000];
      long[] runtimeRecurMem = new long[2000];
      int[] compIter = new int[2000];
      int[] compRecur = new int[2000];
      int[] compRecurMem = new int[2000];
      long start, end;
      
      for(int i = 0; i < rods.length; i++)
      {
         temprando[i] = rando.nextInt(10) + 2;
         temparray = new int[temprando[i]];
         temparray[0] = 0;
         for(int j = 1; j < temparray.length; j++)
         {
            temparray[j] = rando.nextInt(10);
         }
         rods[i] = new RodCutter(temparray,temprando[i]);
      }
      
      for(int i = 0; i < rods.length; i++)
      {
         start = System.currentTimeMillis();
         rods[i].cutIterative(temprando[i] - 1);
         end = System.currentTimeMillis();
         runtimeIter[i] = end - start;
         compIter[i] = rods[i].comp;
         rods[i].ResetComparison();
         
         start = System.currentTimeMillis();
         rods[i].cutRecursive(temprando[i] - 1);
         end = System.currentTimeMillis();
         runtimeRecur[i] = end - start;
         compRecur[i] = rods[i].comp;
         rods[i].ResetComparison();
         
         start = System.currentTimeMillis();
         rods[i].cutRecursiveMem(temprando[i] - 1);
         end = System.currentTimeMillis();
         runtimeRecurMem[i] = end - start;
         compRecurMem[i] = rods[i].comp;
         rods[i].ResetComparison();
      }
      
      System.out.println("Input Size, Iterative Comp, Recursive Comp,"
                          +" RecursiveMem Comp, Iterative Runtime,"
                          +" Recursive Runtime, RecursiveMem Runtime,");
      for(int i = 0; i < rods.length; i++)
      {
         System.out.println((temprando[i] - 1) + "," + compIter[i] + "," +
               compRecur[i] + "," + compRecurMem[i] + "," + runtimeIter[i] +
               "," + runtimeRecur[i] + "," + runtimeRecurMem[i] + ",");
      }
   }
}
