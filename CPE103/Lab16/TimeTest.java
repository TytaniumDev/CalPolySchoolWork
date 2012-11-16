
public class TimeTest
{
   public static void main(String[] args)
   {
      System.out.println("Logarithmic algorithm's running times:");
      for(long i = 10000; i < 100000000; i = i*2)
      {
         System.out.println("T(" + i + ") = " + AlgorithmTimes.logarithmicAlgTime(i));
      }
      
      System.out.println("\nLinear algorithm's running times:");
      for(long i = 10000; i < 100000000; i = i*2)
      {
         System.out.println("T(" + i + ") = " + AlgorithmTimes.linearAlgTime(i));
      }
      
      System.out.println("\nNlogN algorithm's running times:");
      for(long i = 10000; i < 100000000; i = i*2)
      {
         System.out.println("T(" + i + ") = " + AlgorithmTimes.NlogNAlgTime(i));
      }
      
      System.out.println("\nQuadratic algorithm's running times:");
      for(long i = 10000; i < 400000; i = i*2)
      {
         System.out.println("T(" + i + ") = " + AlgorithmTimes.quadraticAlgTime(i));
      }
   }
}
