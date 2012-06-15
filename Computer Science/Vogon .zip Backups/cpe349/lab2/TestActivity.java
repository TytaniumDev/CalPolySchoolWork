//Written by Tyler Holland
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class TestActivity
{
   public static void printSchedule(ActivityScheduler S, Request[] R)
   {
      //Assuming ActivityScheduler is already filled
      int[] temp = S.findBestSchedule();
      System.out.println("Schedule:");
      for(int i = 0; i < R.length; i++)
      {
         if(temp[i] == 1)
         {
            System.out.print("Activity " + i + "from " + R[i].getStart() +
                  " to " + R[i].getFinish());
         }
         if(i < R.length - 1)
         {
            System.out.print(", ");
         }
      }
      System.out.println();
   }
   public static void main(String args[]) throws IOException
   {
      File outFile = new File("output.csv");
      BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
      Random rando = new Random();
      ActivityScheduler[] thing1 = new ActivityScheduler[200]; //maxtime = 100
      ActivityScheduler[] thing2 = new ActivityScheduler[200]; //maxtime = 55
      ActivityScheduler[] thing3 = new ActivityScheduler[200]; //maxtime = 10
      int[] tempreturn;
      int tempavg;
      int[] numrequests1 = new int[200]; 
      int[] numrequests2 = new int[200]; 
      int[] numrequests3 = new int[200];
      int[] numgranted1 = new int[200];
      int[] numgranted2 = new int[200];
      int[] numgranted3 = new int[200];
      int[] avglength1 = new int[200];
      int[] avglength2 = new int[200];
      int[] avglength3 = new int[200];
      
      Request[] request;
      int temp;
      int[] endtimes;
      int[] duration;
      int[] starttimes;
      
      //Thing1
      for(int j = 0; j < 200; j++)
      {
         temp = rando.nextInt(5000); //Up to 5000 requests
         request = new Request[temp];
         endtimes = new int[temp];
         duration = new int[temp];
         starttimes = new int[temp];
         for(int i = 0; i < temp; i++)
         {
            endtimes[i] = rando.nextInt(100);
            duration[i] = rando.nextInt(9) + 1; //Duration = 1 to 10 
         }
         Arrays.sort(endtimes);
         for(int i = 0; i < temp; i++)
         {
            starttimes[i] = endtimes[i] - duration[i];
            request[i] = new Request(starttimes[i], endtimes[i]);
         }
         //Request is full
         thing1[j] = new ActivityScheduler(100);
         thing1[j].setRequests(temp, request);
         tempreturn = thing1[j].findBestSchedule();
         numgranted1[j] = tempreturn[0];
         numrequests1[j] = temp;
         //Compute avg length of granted requests
         tempavg = 0;
         for(int i = 0; i < tempreturn.length; i++)
         {
            tempavg = (tempavg + duration[i]) / 2;
         }
         avglength1[j] = tempavg;
      }
      //Thing2
      for(int j = 0; j < 200; j++)
      {
         temp = rando.nextInt(5000); //Up to 5000 requests
         request = new Request[temp];
         endtimes = new int[temp];
         duration = new int[temp];
         starttimes = new int[temp];
         for(int i = 0; i < temp; i++)
         {
            endtimes[i] = rando.nextInt(55);
            duration[i] = rando.nextInt(9) + 1; //Duration = 1 to 10 
         }
         Arrays.sort(endtimes);
         for(int i = 0; i < temp; i++)
         {
            starttimes[i] = endtimes[i] - duration[i];
            request[i] = new Request(starttimes[i], endtimes[i]);
         }
         //Request is full
         thing2[j] = new ActivityScheduler(100);
         thing2[j].setRequests(temp, request);
         tempreturn = thing2[j].findBestSchedule();
         numgranted2[j] = tempreturn[0];
         numrequests2[j] = temp;
         //Compute avg length of granted requests
         tempavg = 0;
         for(int i = 0; i < tempreturn.length; i++)
         {
            tempavg = (tempavg + duration[i]) / 2;
         }
         avglength2[j] = tempavg;
      }
      //Thing3
      for(int j = 0; j < 200; j++)
      {
         temp = rando.nextInt(5000); //Up to 5000 requests
         request = new Request[temp];
         endtimes = new int[temp];
         duration = new int[temp];
         starttimes = new int[temp];
         for(int i = 0; i < temp; i++)
         {
            endtimes[i] = rando.nextInt(10);
            duration[i] = rando.nextInt(9) + 1; //Duration = 1 to 10 
         }
         Arrays.sort(endtimes);
         for(int i = 0; i < temp; i++)
         {
            starttimes[i] = endtimes[i] - duration[i];
            request[i] = new Request(starttimes[i], endtimes[i]);
         }
         //Request is full
         thing3[j] = new ActivityScheduler(100);
         thing3[j].setRequests(temp, request);
         tempreturn = thing3[j].findBestSchedule();
         numgranted3[j] = tempreturn[0];
         numrequests3[j] = temp;
         //Compute avg length of granted requests
         tempavg = 0;
         for(int i = 0; i < tempreturn.length; i++)
         {
            tempavg = (tempavg + duration[i]) / 2;
         }
         avglength3[j] = tempavg;
      }
      
      writer.write("MaxTime,Number of Requests Granted,Total Number of Requests," +
      		"Average Duration of a Request,");
      writer.newLine();
      for(int k = 0; k<200; k++)
      {
         writer.write("100,");
         writer.write(numgranted1[k] + "," + numrequests1[k] + "," + 
               avglength1[k] + ",");
         writer.newLine();
      }
      for(int k = 0; k<200; k++)
      {
         writer.write("55,");
         writer.write(numgranted2[k] + "," + numrequests2[k] + "," + 
               avglength2[k] + ",");
         writer.newLine();
      }
      for(int k = 0; k<200; k++)
      {
         writer.write("10,");
         writer.write(numgranted3[k] + "," + numrequests3[k] + "," + 
               avglength3[k] + ",");
         writer.newLine();
      }
      writer.close();
   }
}