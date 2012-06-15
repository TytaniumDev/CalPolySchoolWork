//Written by Tyler Holland
import java.util.Random;
public class TestChange
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
      MoneyChanger USmoney;
      int[] USFill = new int[]{10000, 5000, 2000, 1000, 500, 100, 25, 10, 5, 1};
      int[] RandoFill = new int[10];
      int temp;
      //Random denominations
      randomoney = new MoneyChanger(10);
      RandoFill[0] = rando.nextInt(rando.nextInt(1000000) + 100);
      for(int i = 1; i < 9; i++)
      {
         RandoFill[i] = rando.nextInt(RandoFill[i-1]);
      }
      RandoFill[9] = 1; //Has to have a 1 value
      randomoney.setCurrencyArray(RandoFill);
      for(int i = 0; i < 10; i++)
      {
         temp = rando.nextInt(1000000);
         System.out.println("Random: Value = " + temp + ", Change = ");
         printChange(randomoney, temp);
      }
      //US denominations
      USmoney = new MoneyChanger(10);
      USmoney.setCurrencyArray(USFill);
      for(int i = 0; i < 10; i++)
      {
         temp = rando.nextInt(1000000);
         System.out.println("US: Value = " + temp + ", Change = ");
         printChange(USmoney, temp);
      }
   }
}
