/**
 * A Roller for rolling Die.
 *
 * @author Tyler Holland
 * @version Lab 3
 * @version CPE102-5
 * @version Winter 2009
 */
public class Roller
{
   //Instance variables
   private Die[] dice;
   
   //Constructors
   public Roller(int numberOfDie)
   {
      this.dice = new Die[numberOfDie];
      for(int i = 0; i < numberOfDie; i++)
      {
         this.dice[i] = new Die();
      }
   }
   
   public Roller(int numberOfDie, int numberOfSides)
   {
      this.dice = new Die[numberOfDie];
      for(int i = 0; i < numberOfDie; i++)
      {
         this.dice[i] = new Die(numberOfSides);
      }
   }
   
   public Roller(int numberOfDie, int numberOfSides, long[] seeds)
   {
      this.dice = new Die[numberOfDie];
      for(int i = 0; i < numberOfDie; i++)
      {
         this.dice[i] = new Die(numberOfSides, seeds[i]);
      }
   }
   
   public Roller(int numberOfDie, long[] seeds)
   {
      this.dice = new Die[numberOfDie];
      for(int i = 0; i < numberOfDie; i++)
      {
         this.dice[i] = new Die(seeds[i]);
      }
   }
   
   //Methods
   public int[] roll()
   {
      int[] result = new int[dice.length];
      
      for(int i = 0; i < dice.length; i++)
      {
         result[i] = dice[i].roll();
      }
      
      return result;
   }
   
   public int[] roll(int numberOfDice)
   {
      int[] result = new int[dice.length];
      
      for(int i = 0; i < numberOfDice; i++)
      {
         result[i] = dice[i].roll();
      }
      
      return result;
   }
}
