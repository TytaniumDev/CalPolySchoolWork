//Written by Tyler Holland
import java.util.Random;
public class TestChangeQ3
{
   public static void printChange(MoneyChanger money, int amount)
   {
      System.out.println("Greedy:");
      int[] array = money.makeChangeGreedy(amount);
      for(int i = 0; i < array.length; i++)
      {
         System.out.print(array[i] + " " + money.Money[i] + "'s");
         if(i < array.length - 1)
         {
            System.out.print(", ");
         }
      }
      System.out.println();
      
      System.out.println("Dynamic Programming:");
      array = money.makeChangeDP(amount);
      for(int i = 0; i < array.length; i++)
      {
         System.out.print(array[i] + " " + money.Money[i] + "'s");
         if(i < array.length - 1)
         {
            System.out.print(", ");
         }
      }
      System.out.println();
   }
   
   public static void main(String args[])
   {
      Random rando = new Random();
      MoneyChanger randomoney;
      int[] RandoFill = new int[10];
      int temp = 0;
      int tempDP = 0;
      int tempGreedy = 0;
      int totalDP = 0;
      int totalGreedy = 0;
      int diff = 0;
      System.out.println("Size, Number optimal, Difference Total, Greedy, DP,");
      for(int j = 0; j < 200; j++)
      {
         //Random denominations
         temp = 0;
         diff = 0;
         totalDP = 0;
         totalGreedy = 0;
         RandoFill[0] = rando.nextInt(1000) + 100;
         for(int i = 1; i < 9; i++)
         {
            RandoFill[i] = rando.nextInt(RandoFill[i-1]) + 1;
         }
         RandoFill[9] = 1; //Has to have a 1 value
         for(int i = 1; i <= (RandoFill[0] * 2); i++)
         {
            randomoney = new MoneyChanger(10);
            randomoney.setCurrencyArray(RandoFill);
            randomoney.makeChangeGreedy(i);
            tempGreedy = randomoney.NCoins;
            randomoney = new MoneyChanger(10);
            randomoney.setCurrencyArray(RandoFill);
            randomoney.makeChangeDP(i);
            tempDP = randomoney.NCoins;
            if(tempDP == tempGreedy)
            {
               //Greedy was optimal
               temp++;
            }
            totalDP = totalDP + tempDP;
            totalGreedy = totalGreedy + tempGreedy;
            diff = diff + (tempGreedy - tempDP);
         }
         System.out.println((RandoFill[0]*2) + "," + temp + "," + diff + ","
                             + totalGreedy + "," + totalDP + ",");
      }
   }
}
