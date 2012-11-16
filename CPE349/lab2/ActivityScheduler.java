//Written by Tyler Holland
public class ActivityScheduler
{
   public int NRequests;
   public int maxTime;
   public Request[] Requests;
   
   public ActivityScheduler(int time)
   {
      maxTime = time;
      NRequests = 0;
      Requests = null;
   }
   
   public void setRequests(int N, Request[] R)
   {
      NRequests = N;
      Requests = R;
   }
   
   public int[] findBestSchedule()
   {
      int[] S = new int[NRequests];
      int currentEndTime = -1;
      int i = 1;
      while(i < NRequests)
      {
         //Check to see if current activity can be scheduled
         if(Requests[i].start >= currentEndTime)
         {
            S[i] = 1; //Select it
            S[0] = S[0] + 1; //update scheduled activity count
            currentEndTime = Requests[i].getFinish();
         }
         i++;
      }
      return S;
   }
}
