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
   
   public int[] makeChange(int amount)
   {
      int[] Change = new int[Money.length];
      int i = 0;
      while(amount > 0)
      {
         Change[i] = amount/Money[i];
         amount = amount - Change[i] * Money[i];
         i++;
      }
      return Change;
   }
}
