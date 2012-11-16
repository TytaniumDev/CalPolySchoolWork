/**
 * @author Tyler Holland
 * @version Lab Quiz 2
 */

public class FourNumberLock extends ThreeNumberLock
{
   private int fourth;

   //Constructor
   public FourNumberLock(int first, int second, int third, int fourth)
   {
      if(first > 99 || first < 0)
      {
         throw new java.lang.IllegalArgumentException();
      }
      else
      {
         this.first = first;
      }
      if(second > 99 || second < 0)
      {
         throw new java.lang.IllegalArgumentException();
      }
      else
      {
         this.second = second;
      }
      if(third > 99 || third < 0)
      {
         throw new java.lang.IllegalArgumentException();
      }
      else
      {
         this.third = third;
      }
      if(fourth > 99 || fourth < 0)
      {
         throw new java.lang.IllegalArgumentException();
      }
      else
      {
         this.fourth = fourth;
      }
      this.unlock = false; 
   }

   //Methods
   public boolean open(int one, int two, int three, int four)
   {
      if(this.first == one)
      {
         if(this.second == two)
         {
            if(this.third == three)
            {
               if(this.fourth == four)
               {
                  this.unlock = true;
                  return true;
               }
            }
         }
      }
      return false;
   }
}