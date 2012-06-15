/**
 * An AbstractBook Abstract Class that uses Product to store info on books.
 *
 * @author Tyler Holland
 * @version Program 4
 * @version CPE102-5
 * @version Winter 2009
 */

public abstract class AbstractBook extends Product
{
   //Instance Variables
   public static int FICTION = 1;
   public static int NONFICTION = 2;
   private String title;
   private String publisher;
   private Name author;
   private int type;

   //Constructors
   public AbstractBook()
   {
      super();
      this.title = null;
      this.publisher = null;
      this.author = new Name();
      this.type = 1;
   }

   public AbstractBook(int productID)
   {
      super(productID);
      this.title = null;
      this.publisher = null;
      this.author = new Name();
      this.type = 1;
   }
   //Methods

   public String getTitle()
   {
      return title;
   }
   
   public void setTitle(String title)
   {
      this.title = title;
   }
   
   public String getPublisher()
   {
      return publisher;
   }
   
   public void setPublisher(String pub)
   {
      this.publisher = pub;
   }
   
   public Name getAuthor()
   {
      return author;
   }
   
   public void setAuthor(Name name)
   {
      this.author = new Name(name.getLast(), name.getFirst(), name.getMiddle());
   }
   
   public int getType()
   {
      return type;
   }
   
   public void setType(int type)
   {
      this.type = type;
   }
   
   public boolean equals(Object other)
   {
      if(!super.equals(other))
      {
         return false;
      }
      if(!(((AbstractBook)other).title == null && this.title == null))
      {
         if(!(this.title.equals(((AbstractBook)other).title)))
         {
            return false;
         }
      }
      if(!(((AbstractBook)other).publisher == null && this.publisher == null))
      {
         if(!(this.publisher.equals(((AbstractBook)other).publisher)))
         {
            return false;
         }
      }
      if(!(((AbstractBook)other).author.getFirst() == null && this.author.getFirst() == null))
      {
         if(!(this.author.getFirst().equals(((AbstractBook)other).author.getFirst())))
         {
            return false;
         }
      }
      if(!(((AbstractBook)other).author.getMiddle() == null && this.author.getMiddle() == null))
      {
         if(!(this.author.getMiddle().equals(((AbstractBook)other).author.getMiddle())))
         {
            return false;
         }
      }
      if(!(((AbstractBook)other).author.getLast() == null && this.author.getLast() == null))
      {
         if(!(this.author.getLast().equals(((AbstractBook)other).author.getLast())))
         {
            return false;
         }
      }
      if(this.type != ((AbstractBook)other).type)
      {
         return false;
      }
      return true;
   }
}
