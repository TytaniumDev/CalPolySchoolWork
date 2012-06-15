import java.util.Scanner;

/**
 * A Book Class that uses AbstractBook to store extra info on books.
 *
 * @author Tyler Holland
 * @version Program 5
 * @version CPE102-5
 * @version Winter 2009
 */
public class Book extends AbstractBook
{
   //Instance Variables
   public static int HARD_COVER = 2;
   public static int PAPERBACK = 1;
   private int pages;
   private int binding;

   //Constructors
   public Book()
   {
      super();
      this.pages = 0;
      this.binding = 2;
   }

   public Book(int productID)
   {
      super(productID);
      this.pages = 0;
      this.binding = 2;
   }

   //Methods
   public int getPages()
   {
      return pages;
   }
   public void setPages(int pages)
   {
      this.pages = pages;
   }
   public int getBinding()
   {
      return binding;
   }
   public void setBinding(int bind)
   {
      this.binding = bind;
   }
   public boolean equals(Object other)
   {
      if(!super.equals(other))
      {
         return false;
      }
      if(this.pages != ((Book)other).pages)
      {
         return false;
      }
      if(this.binding != ((Book)other).binding)
      {
         return false;
      }
      return true;
   }
   
   public void toObject(Scanner scan2)
   {
      super.toObject(scan2);
      this.pages = Integer.parseInt(scan2.next().trim());
      this.binding = Integer.parseInt(scan2.next().trim());
   }
   
   public String toText(char delimiter)
   {
      String result = new String();
      result = super.toText(delimiter);
      
      result = result.concat("" + pages + " " + delimiter + " ");
      result = result.concat("" + binding + " " + delimiter);
      
      return result;
   }
}
