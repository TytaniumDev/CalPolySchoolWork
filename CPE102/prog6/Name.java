import java.util.Scanner;

/**
 * A Name Class for the storage of complex names.
 *
 * @author Tyler Holland
 * @version Program 6
 * @version CPE102-5
 * @version Winter 2009
 */

public class Name implements DelimitedTextIO
{
   //Instance Variables
   private String first = new String();
   private String middle = new String();
   private String last = new String();
   
   //Constructors
   public Name()
   {
      this.first = "";
      this.middle = "";
      this.last = "";
   }
   public Name(String last, String first, String middle)
   {
      if(first == null)
      {
         this.first = "";
      }
      else
      {
         this.first = first;
      }
      
      if(middle == null)
      {
         this.middle = "";
      }
      else
      {
         this.middle = middle;
      }

      if(last == null)
      {
         this.last = "";
      }
      else
      {
         this.last = last;
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


   
   //Methods from interface
   public void toObject(Scanner scan2)
   {
      this.last = scan2.next().trim();
      this.first = scan2.next().trim();
      this.middle = scan2.next().trim();
   }

   public String toText(char delimiter)
   {
      String result = new String();
      
      result = result.concat(last  + " " + delimiter  + " " + first + " " + 
                             delimiter  + " " + middle);
      
      return result;
   }
}
