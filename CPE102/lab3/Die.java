/**
 * A Die for rolling (in the game Threes).
 *
 * @author Tyler Holland
 * @version Lab 3
 * @version CPE102-5
 * @version Winter 2009
 */

import java.util.Random;

public class Die
{
   //Instance variables
   public static final int DEFAULT_NUMBER_OF_SIDES = 6;
   
   private int sides;
   private Random rando;
   private int result = 0;
   
   //Constructors
   public Die()
   {
      this.sides = DEFAULT_NUMBER_OF_SIDES;
      this.rando = new Random();
      this.result = rando.nextInt(sides) + 1;
   }
   
   public Die(int sides)
   {
      this.sides = sides;
      this.rando = new Random();
      this.result = rando.nextInt(sides) + 1;
   }
   
   public Die(int sides, long seed)
   {
      this.sides = sides;
      this.rando = new Random(seed);
      this.result = rando.nextInt(sides) + 1;
   }
   
   public Die(long seed)
   {
      this.sides = DEFAULT_NUMBER_OF_SIDES;
      this.rando = new Random(seed);
      this.result = rando.nextInt(sides) + 1;
   }
   
   //Methods
   public int roll()
   {
      result = rando.nextInt(sides) + 1;
      return result;
   }
   
   public int sides()
   {
      return sides;
   }
   
   public int value()
   {
      return result;
   }
}