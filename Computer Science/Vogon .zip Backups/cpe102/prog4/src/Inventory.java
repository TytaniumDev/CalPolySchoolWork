/**
 * A Product Class for storing Products.
 *
 * @author Tyler Holland
 * @version Program 4
 * @version CPE102-5
 * @version Winter 2009
 */
import java.util.ArrayList;

public class Inventory
{
   //Instance Variables
   private ArrayList<Product> store;
   
   //Constructors
   /**
    * Creates a new Inventory ArrayList.
    * ArrayList<Product> is created.
    */
   public Inventory()
   {
      store = new ArrayList<Product>();
   }
   
   //Methods
   /**
    * Adds a new product to the inventory.
    * @param product The product to be added.
    * @return Returns a boolean statement about whether the product was added or not.
    */
   public boolean addNew(Product product)
   {
      for(int i = 0; i < store.size(); i++)
      {
         if((store.get(i)).equals(product) || 
            (store.get(i)).getProductID() == product.getProductID())
         {
            return false;
         }
      }
      store.add(product);
      return true;
   }
   
   /**
    * Adds a certain quantity to a product in inventory.
    * @param ProductID The product ID of the product whose quantity is changing.
    * @param quantity The amount of product to be changed.
    * @return Returns a boolean statement on the success of the addition.
    */
   public boolean addInventory(int ProductID, int quantity)
   {
      for(int i = 0; i < store.size(); i++)
      {
         if(store.get(i).getProductID() == ProductID)
         {
            if((store.get(i).getQuantity() + quantity) < 0)
            {
               return false;
            }
            else
            {
               store.get(i).setQuantity(store.get(i).getQuantity() + quantity);
               return true;
            }
         }
      }
      return false;
   }
   
   /**
    * Finds an ArrayList of books by author.
    * @param last Last name of the author.
    * @param first First name of the author.
    * @param middle Middle name of the author.
    * @return Returns an ArrayList<Book> of books by that author.
    */
   public ArrayList<Book> findBooksByAuthor(String last, String first, String middle)
   {
      ArrayList<Book> result = new ArrayList<Book>();
      int j = 0;
      
      for(int i = 0; i < store.size(); i++)
      {
         if(store.get(i) instanceof Book)
         {
            if((((AbstractBook)store.get(i)).getAuthor().match(last, first, middle)))
            {
               result.add(j, ((Book)store.get(i)));
               j++;
            }
         }
      }
      return result;
   }
   
   /**
    * Finds an ArrayList of books by title.
    * @param title The title to be searched for.
    * @return Returns an ArrayList<Book> of books by that title.
    */
   public ArrayList<Book> findBooksByTitle(String title)
   {
      ArrayList<Book> result = new ArrayList<Book>();
      int j = 0;
      
      for(int i = 0; i < store.size(); i++)
      {
         if(store.get(i) instanceof Book)
         {
            if(((AbstractBook)store.get(i)).getTitle().equals(title))
            {
               result.add(j, (Book)store.get(i));
               j++;
            }
         }
      }
      return result;
   }
   
   /**
    * Finds an ArrayList of books on tape by Reader.
    * @param last Reader's last name.
    * @param first Reader's first name.
    * @param middle Reader's middle name.
    * @return Returns an ArrayList<BookOnTape> of books on tape by that reader.
    */
   public ArrayList<BookOnTape> findBookOnTapeByReader(String last, String first, String middle)
   {
      ArrayList<BookOnTape> result = new ArrayList<BookOnTape>();
      int j = 0;
      
      for(int i = 0; i < store.size(); i++)
      {
         if(store.get(i) instanceof BookOnTape)
         {
            if(((BookOnTape)store.get(i)).getReader().match(last, first, middle))
            {
               result.add(j, ((BookOnTape)store.get(i)));
               j++;
            }
         }
      }
      return result;
   }
   
   /**
    * Finds an ArrayList of CDs by artist.
    * @param last Last name of the artist.
    * @param first First name of the artist.
    * @param middle Middle name of the artist.
    * @return Returns an ArrayList<CD> of CDs by that artist.
    */
   public ArrayList<CD> findCDsByArtist(String last, String first, String middle)
   {
      ArrayList<CD> result = new ArrayList<CD>();
      int j = 0;
      
      for(int i = 0; i < store.size(); i++)
      {
         if(store.get(i) instanceof CD)
         {
            if(((CD)store.get(i)).getArtist().match(last, first, middle))
               {
               result.add(j, ((CD)store.get(i)));
               j++;
            }
         }
      }
      return result;
   }
   
   /**
    * Finds an ArrayList of CDs by title.
    * @param title The title of the CD.
    * @return Returns an ArrayList<CD> of the CDs by that title.
    */
   public ArrayList<CD> findCDsByTitle(String title)
   {
      ArrayList<CD> result = new ArrayList<CD>();
      
      for(int i = 0; i < store.size(); i++)
      {
         if(store.get(i) instanceof CD)
         {
            if(((CD)store.get(i)).getTitle().equals(title))
            {
               result.add((CD)store.get(i));
            }
         }
      }
      return result;
   }
}
