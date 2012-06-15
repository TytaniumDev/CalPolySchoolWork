//Written by Tyler Holland
public class MoneyChanger
{
   public int NCoins;
   public int[] Money;
   
   public MoneyChanger(int N)
   {
      Money = new int[N];
      NCoins = 0;
   }
   
   public void setCurrencyArray(int[] Coins)
   {
      for(int i = 0; i < Coins.length; i++)
      {
         Money[i] = Coins[i];
      }
   }
   
   public int[] makeChangeGreedy(int amount)
   {
      int[] Change = new int[Money.length];
      int i = 0;
      while(amount > 0) 
      {
         Change[i] = amount/Money[i];
         NCoins = NCoins + Change[i];
         amount = amount - Change[i] * Money[i];
         i++;
      }
      return Change;
   }
   
   public int[] makeChangeDP(int amount)
   {
      int[] Change = new int[amount+1];
      int[] Solution = new int[amount+1];
      int[] Final = new int[Money.length];
      Change[0] = 0;
      int min = 0;
      int coin = 0;
      for(int j = 1; j <= amount; j++)
      {
         min = Integer.MAX_VALUE; //Make it as large as possible
         for(int i = 0; i < Money.length; i++)
         {
            if(Money[i] <= j)
            {
               if((1 + Change[j - Money[i]]) < min)
               {
                  min = 1 + Change[j - Money[i]];
                  coin = i;
               }
            }
         }
         Change[j] = min;
         Solution[j] = coin;
      }
      NCoins = Change[amount];
      
      int temp = amount;
      while(temp > 0)
      {
         Final[Solution[temp]]++;
         temp = temp - Money[Solution[temp]];
      }
      return Final;
   }
}