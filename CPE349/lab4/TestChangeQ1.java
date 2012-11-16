//Written by Tyler Holland
public class TestChangeQ1
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
      MoneyChanger USmoney;
      MoneyChanger Sovietmoney;
      MoneyChanger CSmoney;
      MoneyChanger USNNmoney;
      MoneyChanger Crazymoney;
      int[] USFill = new int[]{100, 50, 25, 10, 5, 1};
      int[] SovietFill = new int[]{100, 50, 20, 15, 10, 5, 3, 2, 1};
      int[] CSFill = new int[]{64, 32, 16, 8, 4, 2, 1};
      int[] USNNFill = new int[]{100, 50, 25, 10, 1};
      int[] CrazyFill = new int[]{66, 35, 27, 18, 10, 1};
      boolean optimal = true;
      int[][] GreedySize = new int[5][128];
      int[][] DPSize = new int[5][128];

      
      for(int i = 1; i <= 128; i++)
      {
         //US denominations
         USmoney = new MoneyChanger(USFill.length);
         USmoney.setCurrencyArray(USFill);
         USmoney.makeChangeGreedy(i);
         GreedySize[0][i - 1] = USmoney.NCoins;
         USmoney = new MoneyChanger(USFill.length);
         USmoney.setCurrencyArray(USFill);
         USmoney.makeChangeDP(i);
         DPSize[0][i - 1] = USmoney.NCoins;
         
         //Soviet denominations
         Sovietmoney = new MoneyChanger(SovietFill.length);
         Sovietmoney.setCurrencyArray(SovietFill);
         Sovietmoney.makeChangeGreedy(i);
         GreedySize[1][i - 1] = Sovietmoney.NCoins;
         Sovietmoney = new MoneyChanger(SovietFill.length);
         Sovietmoney.setCurrencyArray(SovietFill);
         Sovietmoney.makeChangeDP(i);
         DPSize[1][i - 1] = Sovietmoney.NCoins;
         
         //CS denominations
         CSmoney = new MoneyChanger(CSFill.length);
         CSmoney.setCurrencyArray(CSFill);
         CSmoney.makeChangeGreedy(i);
         GreedySize[2][i - 1] = CSmoney.NCoins;
         CSmoney = new MoneyChanger(CSFill.length);
         CSmoney.setCurrencyArray(CSFill);
         CSmoney.makeChangeDP(i);
         DPSize[2][i - 1] = CSmoney.NCoins;
         
         //USNN denominations
         USNNmoney = new MoneyChanger(USNNFill.length);
         USNNmoney.setCurrencyArray(USNNFill);
         USNNmoney.makeChangeGreedy(i);
         GreedySize[3][i - 1] = USNNmoney.NCoins;
         USNNmoney = new MoneyChanger(USNNFill.length);
         USNNmoney.setCurrencyArray(USNNFill);
         USNNmoney.makeChangeDP(i);
         DPSize[3][i - 1] = USNNmoney.NCoins;
         
         //Crazy denominations
         Crazymoney = new MoneyChanger(CrazyFill.length);
         Crazymoney.setCurrencyArray(CrazyFill);
         Crazymoney.makeChangeGreedy(i);
         GreedySize[4][i - 1] = Crazymoney.NCoins;
         Crazymoney = new MoneyChanger(CrazyFill.length);
         Crazymoney.setCurrencyArray(CrazyFill);
         Crazymoney.makeChangeDP(i);
         DPSize[4][i - 1] = Crazymoney.NCoins;
      }

      for(int i = 0; i < 5; i++)
      {
         for(int j = 0; j < 128; j++)
         {
            if(GreedySize[i][j] != DPSize[i][j])
            {
               optimal = false;
               break;
            }
            if(optimal == false)
            {
               break;
            }
         }
         if(optimal == false)
         {
            break;
         }
      }
      
      System.out.println("Greedy,US,Soviet,CS,USNN,Crazy,");
      for(int i = 0; i < 128; i++)
      {
         System.out.println(i+1 + "," + GreedySize[0][i] + "," 
               + GreedySize[1][i] + "," + GreedySize[2][i] + ","
               + GreedySize[3][i] + "," + GreedySize[4][i] + ",");
      }
      System.out.println("DP,US,Soviet,CS,USNN,Crazy,");
      for(int i = 0; i < 128; i++)
      {
         System.out.println(i+1 + "," + DPSize[0][i] + "," 
               + DPSize[1][i] + "," + DPSize[2][i] + ","
               + DPSize[3][i] + "," + DPSize[4][i] + ",");
      }
   }
}
