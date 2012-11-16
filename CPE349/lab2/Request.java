//Written by Tyler Holland
public class Request
{
   int start; // start time of the requested activity
   int finish; // end time of the requested activity
   
   Request(int a, int b) { start=a; finish=b;}
   
   public int getStart()
   {
      return start;
   }
   
   public int getFinish()
   {
      return finish;
   }
}
