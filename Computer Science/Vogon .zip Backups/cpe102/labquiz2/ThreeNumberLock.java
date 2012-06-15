/**
 * @author Tyler Holland
 * @version Lab Quiz 2
 */

public class ThreeNumberLock implements java.lang.Comparable<ThreeNumberLock>

{
   //Instance Variables
   private int first;
   private int second;
   private int third;
   private boolean unlock; //True = unlocked, False = locked
   
   //Constructors
   public ThreeNumberLock(int first, int second, int third)
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
      this.unlock = false;
   }

   //Methods
   public boolean open(int one, int two, int three)
   {
      if(this.first == one)
      {
         if(this.second == two)
         {
            if(this.third == three)
            {
               this.unlock = true;
               return true;
            }
         }
      }
      return false;
   }

   public boolean isOpen()
   {
      return unlock;
   }

   public void close()
   {
      this.unlock = false;
   }

   public boolean equals(Object other)
   {
      if(other == null)
      {
         return false;
      }
      if(this.getClass() != other.getClass())
      {
         return false;
      }
      if(this.first != ((ThreeNumberLock)other).first)
      {
         return false;
      }
      if(this.second != ((ThreeNumberLock)other).second)
      {
         return false;
      }
      if(this.third != ((ThreeNumberLock)other).third)
      {
         return false;
      }
      return true;
   }
                                                                                    
   public int compareTo(Object o)
   {
      if(first < ((ThreeNumberLock)o).first)
      {
         return -1;
      }
      else if(first > ((ThreeNumberLock)o).first)
      {
         return 1;
      }
      else if(first == ((ThreeNumberLock)o).first)
      {
         if(second < ((ThreeNumberLock)o).second)
         {
            return -1;
         }
         else if(second > ((ThreeNumberLock)o).second)
         {
            return 1;
         }
         else if(second == ((ThreeNumberLock)o).second)
         {
            if(third < ((ThreeNumberLock)o).third)
            {
               return -1;
            }
            else if(third > ((ThreeNumberLock)o).third)
            {
               return 1;
            }
            else if(third == ((ThreeNumberLock)o).third)
            {
               return 0;
            }
         }
      }
      return 0;
   }
}