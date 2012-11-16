//Written by Tyler Holland and Spencer Ellsworth
public class Finds
{
   public int counter = 0;
   
   public Finds()
   {
      counter = 0;
   }
   public Integer findMax(Integer size, Integer[] array)
   {
      return (findMaxRecursive(0, size, array));
   }
   
   private Integer findMaxRecursive(Integer I, Integer J, Integer[] A)
   {
      Integer max2;
      if(I == J)
      {
         this.counter++;
         return A[I];
      }
      Integer max1 = findMaxRecursive(I, I+(J-I)/2, A);
      if(1+I+(J-I)/2 >= A.length)
      {
         max2 = findMaxRecursive(I, I+(J-I)/2, A);
      }
      else
      {
         max2 = findMaxRecursive(1+I+(J-I)/2, J, A);
      }
      
      if(max1 > max2)
      {
         this.counter++;
         return max1;
      }
      else
      {
         this.counter++;
         return max2;
      }
   }
   
   public Integer findSecondMax(Integer size, Integer[] array)
   {
      Integer[] Compared = findMaxTournament(0, size, array, size);
      Integer[] temp = new Integer[Compared[0] - 2];
      for(int i = 0; i < Compared[0] - 2; i++)
      {
         temp[i] = Compared[i + 2];
      }
      Integer[] Compared2 = findMaxTournament(1, Compared[0], temp, size);
      return Compared2[1];
   }
   
   private Integer[] findMaxTournament(Integer I, Integer J, Integer[] A, Integer N)
   {
      Integer Compared2[];
      if(I == J)
      {
         this.counter++;
         Integer[] Compared = new Integer[N];
         Compared[0] = 1;
         Compared[1] = A[I];
         return Compared;
      }
      
      Integer[] Compared1 = findMaxTournament(I, I+(J-I)/2, A, N);
      if(1+I+(J-I)/2 >= A.length)
      {
         Compared2 = findMaxTournament(I, I+(J-I)/2, A, N);
      }
      else
      {
         Compared2 = findMaxTournament(1+I+(J-I)/2, J, A, N);
      }
      
      if(Compared1[1] > Compared2[1])
      {
         this.counter++;
         Integer K = Compared1[0] + 1;
         Compared1[0] = K;
         Compared1[K] = Compared2[1];
         return Compared1;
      }
      else
      {
         this.counter++;
         Integer K = Compared2[0] + 1;
         Compared2[0] = K;
         Compared2[K] = Compared1[1];
         return Compared2;
      }
   }
}
