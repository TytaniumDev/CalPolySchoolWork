
public class AlgorithmTimes
{
   public static long linearAlgTime(long N)
   {
      long startTime = System.nanoTime();
      int x = 0;
      for(int i = 1; i < N; i++)
      {
         x++;
      }
      long endTime = System.nanoTime();
      return (endTime - startTime) / 1000000;
   }
   
   public static long quadraticAlgTime(long N)
   {
      long startTime = System.nanoTime();
      int x = 0;
      for(int i = 1; i < N; i++)
      {
         for(int j = 1; j < N; j++)
         {
            x++;
         }
      }
      long endTime = System.nanoTime();
      return (endTime - startTime) / 1000000;
   }
   
   public static long logarithmicAlgTime(long N)
   {
      long startTime = System.nanoTime();
      int x = 0;
      for(int i = (int)N; i >= 1; i = i / 2)
      {
         x++;
      }
      long endTime = System.nanoTime();
      return (endTime - startTime) / 1000000;
   }
   
   public static long NlogNAlgTime(long N)
   {
      long startTime = System.nanoTime();
      int x = 0;
      for(int i = 1; i < N; i++)
      {
         for(int j = (int)N; j >= 1; j = j / 2)
         {
            x++;
         }
      }
      long endTime = System.nanoTime();
      return (endTime - startTime) / 1000000;
   }
}
