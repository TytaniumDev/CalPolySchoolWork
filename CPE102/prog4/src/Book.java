/**
 * A Book Class that uses AbstractBook to store extra info on books.
 *
 * @author Tyler Holland
 * @version Program 4
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
}