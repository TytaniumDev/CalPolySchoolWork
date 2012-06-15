import java.util.Random;

//Written by Tyler Holland (tyhollan)

public class TestChangeQ5
{
   public static void main(String args[])
   {
      Random rando = new Random();
      int[] RandoFill;
      MoneyChanger[] r5 = new MoneyChanger[20];
      MoneyChanger[] r10 = new MoneyChanger[20];
      MoneyChanger[] r20 = new MoneyChanger[20];
      MoneyChanger[] r50 = new MoneyChanger[20];
      MoneyChanger[] r100 = new MoneyChanger[20];
      MoneyChanger[] r200 = new MoneyChanger[20];
      MoneyChanger[] r500 = new MoneyChanger[20];
      MoneyChanger[] r1000 = new MoneyChanger[20];
      MoneyChanger[] r2000 = new MoneyChanger[20];
      MoneyChanger[] r5000 = new MoneyChanger[20];
      MoneyChanger[] r10000 = new MoneyChanger[20];
      int i;
      int j;
      long[][] runtimeGreedy = new long[11][4];
      long[][] runtimeDP = new long[11][4];
      long start, end;
      
      for(i = 0; i < 11; i++)
      {
         runtimeGreedy[i][0] = 0;
         runtimeGreedy[i][1] = 0;
         runtimeGreedy[i][2] = 0;
         runtimeGreedy[i][3] = 0;
         runtimeDP[i][0] = 0;
         runtimeDP[i][1] = 0;
         runtimeDP[i][2] = 0;
         runtimeDP[i][3] = 0;
      }
      
      RandoFill = new int[5];
      for(j = 0; j < 20; j++)
      {
         r5[j] = new MoneyChanger(5);
         RandoFill[0] = rando.nextInt(25000) + 100;
         for(i = 1; i < 4; i++)
         {
            RandoFill[i] = rando.nextInt(RandoFill[i-1]) + 1;
         }
         RandoFill[i] = 1; //Has to have a 1 value
         r5[j].setCurrencyArray(RandoFill);
         //Get running times
         start = System.currentTimeMillis();
         r5[j].makeChangeGreedy(100);
         end = System.currentTimeMillis();
         runtimeGreedy[0][0] += end - start;
         start = System.currentTimeMillis();
         r5[j].makeChangeGreedy(10000);
         end = System.currentTimeMillis();
         runtimeGreedy[0][1] += end - start;
         start = System.currentTimeMillis();
         r5[j].makeChangeGreedy(1000000);
         end = System.currentTimeMillis();
         runtimeGreedy[0][2] += end - start;
         start = System.currentTimeMillis();
         r5[j].makeChangeGreedy(2 * r5[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeGreedy[0][3] += end - start;
         start = System.currentTimeMillis();
         r5[j].makeChangeDP(100);
         end = System.currentTimeMillis();
         runtimeDP[0][0] += end - start;
         start = System.currentTimeMillis();
         r5[j].makeChangeDP(10000);
         end = System.currentTimeMillis();
         runtimeDP[0][1] += end - start;
         start = System.currentTimeMillis();
         r5[j].makeChangeDP(1000000);
         end = System.currentTimeMillis();
         runtimeDP[0][2] += end - start;
         start = System.currentTimeMillis();
         r5[j].makeChangeDP(2 * r5[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeDP[0][3] += end - start;
      }
      
      RandoFill = new int[10];
      for(j = 0; j < 20; j++)
      {
         r10[j] = new MoneyChanger(10);
         RandoFill[0] = rando.nextInt(25000) + 100;
         for(i = 1; i < 9; i++)
         {
            RandoFill[i] = rando.nextInt(RandoFill[i-1]) + 1;
         }
         RandoFill[i] = 1; //Has to have a 1 value
         r10[j].setCurrencyArray(RandoFill);
         //Get running times
         start = System.currentTimeMillis();
         r10[j].makeChangeGreedy(100);
         end = System.currentTimeMillis();
         runtimeGreedy[1][0] += end - start;
         start = System.currentTimeMillis();
         r10[j].makeChangeGreedy(10000);
         end = System.currentTimeMillis();
         runtimeGreedy[1][1] += end - start;
         start = System.currentTimeMillis();
         r10[j].makeChangeGreedy(1000000);
         end = System.currentTimeMillis();
         runtimeGreedy[1][2] += end - start;
         start = System.currentTimeMillis();
         r10[j].makeChangeGreedy(2 * r10[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeGreedy[1][3] += end - start;
         start = System.currentTimeMillis();
         r10[j].makeChangeDP(100);
         end = System.currentTimeMillis();
         runtimeDP[1][0] += end - start;
         start = System.currentTimeMillis();
         r10[j].makeChangeDP(10000);
         end = System.currentTimeMillis();
         runtimeDP[1][1] += end - start;
         start = System.currentTimeMillis();
         r10[j].makeChangeDP(1000000);
         end = System.currentTimeMillis();
         runtimeDP[1][2] += end - start;
         start = System.currentTimeMillis();
         r10[j].makeChangeDP(2 * r10[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeDP[1][3] += end - start;
      }
      
      RandoFill = new int[20];
      for(j = 0; j < 20; j++)
      {
         r20[j] = new MoneyChanger(20);
         RandoFill[0] = rando.nextInt(25000) + 100;
         for(i = 1; i < 19; i++)
         {
            RandoFill[i] = rando.nextInt(RandoFill[i-1]) + 1;
         }
         RandoFill[i] = 1; //Has to have a 1 value
         r20[j].setCurrencyArray(RandoFill);
         //Get running times
         start = System.currentTimeMillis();
         r20[j].makeChangeGreedy(100);
         end = System.currentTimeMillis();
         runtimeGreedy[2][0] += end - start;
         start = System.currentTimeMillis();
         r20[j].makeChangeGreedy(10000);
         end = System.currentTimeMillis();
         runtimeGreedy[2][1] += end - start;
         start = System.currentTimeMillis();
         r20[j].makeChangeGreedy(1000000);
         end = System.currentTimeMillis();
         runtimeGreedy[2][2] += end - start;
         start = System.currentTimeMillis();
         r20[j].makeChangeGreedy(2 * r20[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeGreedy[2][3] += end - start;
         start = System.currentTimeMillis();
         r20[j].makeChangeDP(100);
         end = System.currentTimeMillis();
         runtimeDP[2][0] += end - start;
         start = System.currentTimeMillis();
         r20[j].makeChangeDP(10000);
         end = System.currentTimeMillis();
         runtimeDP[2][1] += end - start;
         start = System.currentTimeMillis();
         r20[j].makeChangeDP(1000000);
         end = System.currentTimeMillis();
         runtimeDP[2][2] += end - start;
         start = System.currentTimeMillis();
         r20[j].makeChangeDP(2 * r20[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeDP[2][3] += end - start;
      }
      
      RandoFill = new int[50];
      for(j = 0; j < 20; j++)
      {
         r50[j] = new MoneyChanger(50);
         RandoFill[0] = rando.nextInt(25000) + 100;
         for(i = 1; i < 49; i++)
         {
            RandoFill[i] = rando.nextInt(RandoFill[i-1]) + 1;
         }
         RandoFill[i] = 1; //Has to have a 1 value
         r50[j].setCurrencyArray(RandoFill);
         //Get running times
         start = System.currentTimeMillis();
         r50[j].makeChangeGreedy(100);
         end = System.currentTimeMillis();
         runtimeGreedy[3][0] += end - start;
         start = System.currentTimeMillis();
         r50[j].makeChangeGreedy(10000);
         end = System.currentTimeMillis();
         runtimeGreedy[3][1] += end - start;
         start = System.currentTimeMillis();
         r50[j].makeChangeGreedy(1000000);
         end = System.currentTimeMillis();
         runtimeGreedy[3][2] += end - start;
         start = System.currentTimeMillis();
         r50[j].makeChangeGreedy(2 * r50[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeGreedy[3][3] += end - start;
         start = System.currentTimeMillis();
         r50[j].makeChangeDP(100);
         end = System.currentTimeMillis();
         runtimeDP[3][0] += end - start;
         start = System.currentTimeMillis();
         r50[j].makeChangeDP(10000);
         end = System.currentTimeMillis();
         runtimeDP[3][1] += end - start;
         start = System.currentTimeMillis();
         r50[j].makeChangeDP(1000000);
         end = System.currentTimeMillis();
         runtimeDP[3][2] += end - start;
         start = System.currentTimeMillis();
         r50[j].makeChangeDP(2 * r50[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeDP[3][3] += end - start;
      }
      
      RandoFill = new int[100];
      for(j = 0; j < 20; j++)
      {
         r100[j] = new MoneyChanger(100);
         RandoFill[0] = rando.nextInt(25000) + 100;
         for(i = 1; i < 99; i++)
         {
            RandoFill[i] = rando.nextInt(RandoFill[i-1]) + 1;
         }
         RandoFill[i] = 1; //Has to have a 1 value
         r100[j].setCurrencyArray(RandoFill);
         //Get running times
         start = System.currentTimeMillis();
         r100[j].makeChangeGreedy(100);
         end = System.currentTimeMillis();
         runtimeGreedy[4][0] += end - start;
         start = System.currentTimeMillis();
         r100[j].makeChangeGreedy(10000);
         end = System.currentTimeMillis();
         runtimeGreedy[4][1] += end - start;
         start = System.currentTimeMillis();
         r100[j].makeChangeGreedy(1000000);
         end = System.currentTimeMillis();
         runtimeGreedy[4][2] += end - start;
         start = System.currentTimeMillis();
         r100[j].makeChangeGreedy(2 * r100[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeGreedy[4][3] += end - start;
         start = System.currentTimeMillis();
         r100[j].makeChangeDP(100);
         end = System.currentTimeMillis();
         runtimeDP[4][0] += end - start;
         start = System.currentTimeMillis();
         r100[j].makeChangeDP(10000);
         end = System.currentTimeMillis();
         runtimeDP[4][1] += end - start;
         start = System.currentTimeMillis();
         r100[j].makeChangeDP(1000000);
         end = System.currentTimeMillis();
         runtimeDP[4][2] += end - start;
         start = System.currentTimeMillis();
         r100[j].makeChangeDP(2 * r100[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeDP[4][3] += end - start;
      }

      RandoFill = new int[200];
      for(j = 0; j < 20; j++)
      {
         r200[j] = new MoneyChanger(200);
         RandoFill[0] = rando.nextInt(25000) + 100;
         for(i = 1; i < 199; i++)
         {
            RandoFill[i] = rando.nextInt(RandoFill[i-1]) + 1;
         }
         RandoFill[i] = 1; //Has to have a 1 value
         r200[j].setCurrencyArray(RandoFill);
         //Get running times
         start = System.currentTimeMillis();
         r200[j].makeChangeGreedy(100);
         end = System.currentTimeMillis();
         runtimeGreedy[5][0] += end - start;
         start = System.currentTimeMillis();
         r200[j].makeChangeGreedy(10000);
         end = System.currentTimeMillis();
         runtimeGreedy[5][1] += end - start;
         start = System.currentTimeMillis();
         r200[j].makeChangeGreedy(1000000);
         end = System.currentTimeMillis();
         runtimeGreedy[5][2] += end - start;
         start = System.currentTimeMillis();
         r200[j].makeChangeGreedy(2 * r200[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeGreedy[5][3] += end - start;
         start = System.currentTimeMillis();
         r200[j].makeChangeDP(100);
         end = System.currentTimeMillis();
         runtimeDP[5][0] += end - start;
         start = System.currentTimeMillis();
         r200[j].makeChangeDP(10000);
         end = System.currentTimeMillis();
         runtimeDP[5][1] += end - start;
         start = System.currentTimeMillis();
         r200[j].makeChangeDP(1000000);
         end = System.currentTimeMillis();
         runtimeDP[5][2] += end - start;
         start = System.currentTimeMillis();
         r200[j].makeChangeDP(2 * r200[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeDP[5][3] += end - start;
      }
      
      RandoFill = new int[500];
      for(j = 0; j < 20; j++)
      {
         r500[j] = new MoneyChanger(500);
         RandoFill[0] = rando.nextInt(25000) + 100;
         for(i = 1; i < 499; i++)
         {
            RandoFill[i] = rando.nextInt(RandoFill[i-1]) + 1;
         }
         RandoFill[i] = 1; //Has to have a 1 value
         r500[j].setCurrencyArray(RandoFill);
         //Get running times
         start = System.currentTimeMillis();
         r500[j].makeChangeGreedy(100);
         end = System.currentTimeMillis();
         runtimeGreedy[6][0] += end - start;
         start = System.currentTimeMillis();
         r500[j].makeChangeGreedy(10000);
         end = System.currentTimeMillis();
         runtimeGreedy[6][1] += end - start;
         start = System.currentTimeMillis();
         r500[j].makeChangeGreedy(1000000);
         end = System.currentTimeMillis();
         runtimeGreedy[6][2] += end - start;
         start = System.currentTimeMillis();
         r500[j].makeChangeGreedy(2 * r500[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeGreedy[6][3] += end - start;
         start = System.currentTimeMillis();
         r500[j].makeChangeDP(100);
         end = System.currentTimeMillis();
         runtimeDP[6][0] += end - start;
         start = System.currentTimeMillis();
         r500[j].makeChangeDP(10000);
         end = System.currentTimeMillis();
         runtimeDP[6][1] += end - start;
         start = System.currentTimeMillis();
         r500[j].makeChangeDP(1000000);
         end = System.currentTimeMillis();
         runtimeDP[6][2] += end - start;
         start = System.currentTimeMillis();
         r500[j].makeChangeDP(2 * r500[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeDP[6][3] += end - start;
      }  
      
      RandoFill = new int[1000];
      for(j = 0; j < 20; j++)
      {
         r1000[j] = new MoneyChanger(1000);
         RandoFill[0] = rando.nextInt(25000) + 100;
         for(i = 1; i < 999; i++)
         {
            RandoFill[i] = rando.nextInt(RandoFill[i-1]) + 1;
         }
         RandoFill[i] = 1; //Has to have a 1 value
         r1000[j].setCurrencyArray(RandoFill);
         //Get running times
         start = System.currentTimeMillis();
         r1000[j].makeChangeGreedy(100);
         end = System.currentTimeMillis();
         runtimeGreedy[7][0] += end - start;
         start = System.currentTimeMillis();
         r1000[j].makeChangeGreedy(10000);
         end = System.currentTimeMillis();
         runtimeGreedy[7][1] += end - start;
         start = System.currentTimeMillis();
         r1000[j].makeChangeGreedy(1000000);
         end = System.currentTimeMillis();
         runtimeGreedy[7][2] += end - start;
         start = System.currentTimeMillis();
         r1000[j].makeChangeGreedy(2 * r1000[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeGreedy[7][3] += end - start;
         start = System.currentTimeMillis();
         r1000[j].makeChangeDP(100);
         end = System.currentTimeMillis();
         runtimeDP[7][0] += end - start;
         start = System.currentTimeMillis();
         r1000[j].makeChangeDP(10000);
         end = System.currentTimeMillis();
         runtimeDP[7][1] += end - start;
         start = System.currentTimeMillis();
         r1000[j].makeChangeDP(1000000);
         end = System.currentTimeMillis();
         runtimeDP[7][2] += end - start;
         start = System.currentTimeMillis();
         r1000[j].makeChangeDP(2 * r1000[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeDP[7][3] += end - start;
      }
      
      RandoFill = new int[2000];
      for(j = 0; j < 20; j++)
      {
         r2000[j] = new MoneyChanger(2000);
         RandoFill[0] = rando.nextInt(25000) + 100;
         for(i = 1; i < 1999; i++)
         {
            RandoFill[i] = rando.nextInt(RandoFill[i-1]) + 1;
         }
         RandoFill[i] = 1; //Has to have a 1 value
         r2000[j].setCurrencyArray(RandoFill);
         //Get running times
         start = System.currentTimeMillis();
         r2000[j].makeChangeGreedy(100);
         end = System.currentTimeMillis();
         runtimeGreedy[8][0] += end - start;
         start = System.currentTimeMillis();
         r2000[j].makeChangeGreedy(10000);
         end = System.currentTimeMillis();
         runtimeGreedy[8][1] += end - start;
         start = System.currentTimeMillis();
         r2000[j].makeChangeGreedy(1000000);
         end = System.currentTimeMillis();
         runtimeGreedy[8][2] += end - start;
         start = System.currentTimeMillis();
         r2000[j].makeChangeGreedy(2 * r2000[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeGreedy[8][3] += end - start;
         start = System.currentTimeMillis();
         r2000[j].makeChangeDP(100);
         end = System.currentTimeMillis();
         runtimeDP[8][0] += end - start;
         start = System.currentTimeMillis();
         r2000[j].makeChangeDP(10000);
         end = System.currentTimeMillis();
         runtimeDP[8][1] += end - start;
         start = System.currentTimeMillis();
         r2000[j].makeChangeDP(1000000);
         end = System.currentTimeMillis();
         runtimeDP[8][2] += end - start;
         start = System.currentTimeMillis();
         r2000[j].makeChangeDP(2 * r2000[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeDP[8][3] += end - start;
      }
      
      RandoFill = new int[5000];
      for(j = 0; j < 20; j++)
      {
         r5000[j] = new MoneyChanger(5000);
         RandoFill[0] = rando.nextInt(25000) + 100;
         for(i = 1; i < 4999; i++)
         {
            RandoFill[i] = rando.nextInt(RandoFill[i-1]) + 1;
         }
         RandoFill[i] = 1; //Has to have a 1 value
         r5000[j].setCurrencyArray(RandoFill);
         //Get running times
         start = System.currentTimeMillis();
         r5000[j].makeChangeGreedy(100);
         end = System.currentTimeMillis();
         runtimeGreedy[9][0] += end - start;
         start = System.currentTimeMillis();
         r5000[j].makeChangeGreedy(10000);
         end = System.currentTimeMillis();
         runtimeGreedy[9][1] += end - start;
         start = System.currentTimeMillis();
         r5000[j].makeChangeGreedy(1000000);
         end = System.currentTimeMillis();
         runtimeGreedy[9][2] += end - start;
         start = System.currentTimeMillis();
         r5000[j].makeChangeGreedy(2 * r5000[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeGreedy[9][3] += end - start;
         start = System.currentTimeMillis();
         r5000[j].makeChangeDP(100);
         end = System.currentTimeMillis();
         runtimeDP[9][0] += end - start;
         start = System.currentTimeMillis();
         r5000[j].makeChangeDP(10000);
         end = System.currentTimeMillis();
         runtimeDP[9][1] += end - start;
         start = System.currentTimeMillis();
         r5000[j].makeChangeDP(1000000);
         end = System.currentTimeMillis();
         runtimeDP[9][2] += end - start;
         start = System.currentTimeMillis();
         r5000[j].makeChangeDP(2 * r5000[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeDP[9][3] += end - start;
      }
      
      RandoFill = new int[10000];
      for(j = 0; j < 20; j++)
      {
         r10000[j] = new MoneyChanger(10000);
         RandoFill[0] = rando.nextInt(25000) + 100;
         for(i = 1; i < 9999; i++)
         {
            RandoFill[i] = rando.nextInt(RandoFill[i-1]) + 1;
         }
         RandoFill[i] = 1; //Has to have a 1 value
         r10000[j].setCurrencyArray(RandoFill);
         //Get running times
         start = System.currentTimeMillis();
         r10000[j].makeChangeGreedy(100);
         end = System.currentTimeMillis();
         runtimeGreedy[10][0] += end - start;
         start = System.currentTimeMillis();
         r10000[j].makeChangeGreedy(10000);
         end = System.currentTimeMillis();
         runtimeGreedy[10][1] += end - start;
         start = System.currentTimeMillis();
         r10000[j].makeChangeGreedy(1000000);
         end = System.currentTimeMillis();
         runtimeGreedy[10][2] += end - start;
         start = System.currentTimeMillis();
         r10000[j].makeChangeGreedy(2 * r10000[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeGreedy[10][3] += end - start;
         start = System.currentTimeMillis();
         r10000[j].makeChangeDP(100);
         end = System.currentTimeMillis();
         runtimeDP[10][0] += end - start;
         start = System.currentTimeMillis();
         r10000[j].makeChangeDP(10000);
         end = System.currentTimeMillis();
         runtimeDP[10][1] += end - start;
         start = System.currentTimeMillis();
         r10000[j].makeChangeDP(1000000);
         end = System.currentTimeMillis();
         runtimeDP[10][2] += end - start;
         start = System.currentTimeMillis();
         r10000[j].makeChangeDP(2 * r10000[j].Money[0] - 1);
         end = System.currentTimeMillis();
         runtimeDP[10][3] += end - start;
      }
      
      System.out.println("Greedy, 100, 10000, 1000000, 2 * Max - 1,"
                         + "DP, 100, 10000, 1000000, 2 * Max - 1,");
      for(i = 0; i < 11; i++)
      {
         System.out.print(i + "," + runtimeGreedy[i][0] + "," 
                               + runtimeGreedy[i][1] + ","
                               + runtimeGreedy[i][2] + ","
                               + runtimeGreedy[i][3] + ",");
         System.out.print(i + "," + runtimeDP[i][0] + "," 
                               + runtimeDP[i][1] + ","
                               + runtimeDP[i][2] + ","
                               + runtimeDP[i][3] + ",");
         System.out.println();
      }
   }
}
