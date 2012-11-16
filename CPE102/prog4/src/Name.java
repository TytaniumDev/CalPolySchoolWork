/**
 * A Name Class for the storage of complex names.
 *
 * @author Tyler Holland
 * @version Program 4
 * @version CPE102-5
 * @version Winter 2009
 */

public class Name
{
   //Instance Variables
   private String first;
   private String middle;
   private String last;
   
   //Constructors
   public Name()
   {
      this.first = null;
      this.middle = null;
      this.last = null;
   }
   public Name(String last, String first, String middle)
   {
      if(first == null)
      {
         this.first = null;
      }
      else
      {
         this.first = new String(first);
      }
      
      if(middle == null)
      {
         this.middle = null;
      }
      else
      {
         this.middle = new String(middle);
      }

      if(last == null)
      {
         this.last = null;
      }
      else
      {
         this.last = new String(last);
      }
   }
   
   //Methods
   public String getFirst()
   {
      return first;
   }
   public String getMiddle()
   {
      return middle;
   }
   public String getLast()
   {
      return last;
   }
   public boolean match(String last, String first, String middle)
   {
      if(this.last.equals(last) || last == null)
      {
         if(this.first.equals(first) || first == null)
         {
            if(this.middle.equals(middle) || middle == null)
            {
               return true;
            }
            else
            {
               return false;
            }
         }
         else
         {
            return false;
         }
      }
      else
      {
         return false;
      }
   }
   public boolean equals(Object other)
   {
      if (other == null)
      {
         return false;
      }
      if (this.getClass() != other.getClass())
      {
         return false;
      }
      if(!this.first.equals(((Name)other).first))
      {
         return false;
      }
      if(!this.last.equals(((Name)other).last))
      {
         return false;
      }
      if(!this.middle.equals(((Name)other).middle))
      {
         return false;
      }
      return true;
   }
}
