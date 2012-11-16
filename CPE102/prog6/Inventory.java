/**
 * A Product Class for storing Products.
 *
 * @author Tyler Holland
 * @version Program 6
 * @version CPE102-5
 * @version Winter 2009
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

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
    * @throws DuplicateProductIDException When a product with that ID is already in inventory.
    * @throws DuplicateProductException When an identical product is in inventory.
    */
   public void addNew(Product product) throws DuplicateProductIDException, 
                                              DuplicateProductException
   {
      for(int i = 0; i < store.size(); i++)
      {
         if((store.get(i)).equals(product)) 
         {
            throw new DuplicateProductException(product.getProductID(), 
                                               (store.get(i)).getProductID());
         }
         if((store.get(i)).getProductID() == product.getProductID())
         {
            throw new DuplicateProductIDException(product.getProductID());
         }
      }
      store.add(product);
   }
   
   /**
    * Adds a certain quantity to a product in inventory.
    * @param ProductID The product ID of the product whose quantity is changing.
    * @param quantity The amount of product to be changed.
    * @throws InsufficientProductException When the quantity would be reduced to less than 0.
    * @throws MissingProductException When the specified product ID is not found.
    */
   public void addInventory(int ProductID, int quantity)
   {
      int missing = 1;
      for(int i = 0; i < store.size(); i++)
      {
         if(store.get(i).getProductID() == ProductID)
         {
            if((store.get(i).getQuantity() + quantity) < 0)
            {
              throw new InsufficientProductException(store.get(i).getQuantity(), quantity);
            }
            else
            {
               store.get(i).setQuantity(store.get(i).getQuantity() + quantity);
            }
            missing = 0;
         }
      }
      if(missing == 1)
      {
         throw new MissingProductException(ProductID);
      }
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
      
      for(int i = 0; i < store.size(); i++)
      {
         if(store.get(i) instanceof Book)
         {
            if(((Book)store.get(i)).getTitle().equals(title))
            {
               result.add((Book)store.get(i));
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
      
      for(int i = 0; i < store.size(); i++)
      {
         if(store.get(i) instanceof BookOnTape)
         {
            if(first == null || middle == null || last == null)
            {
               if(((BookOnTape)store.get(i)).getReader().match(last, first, middle))
               {
                  result.add((BookOnTape)store.get(i));
               }
            }
            else if(((BookOnTape)store.get(i)).getReader().match(last.trim(), first.trim(),
                  middle.trim()))
            {
               result.add((BookOnTape)store.get(i));
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
      
      for(int i = 0; i < store.size(); i++)
      {
         if(store.get(i) instanceof CD)
         {
            if(first == null || middle == null || last == null)
            {
               if(((CD)store.get(i)).getArtist().match(last, first, middle))
               {
                  result.add(((CD)store.get(i)));
               }
            }
            else if(((CD)store.get(i)).getArtist().match(last.trim(), first.trim(), middle.trim()))
            {
               result.add(((CD)store.get(i)));
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
            if(((CD)store.get(i)).getTitle().trim().equals(title.trim()))
            {
               result.add((CD)store.get(i));
            }
         }
      }
      return result;
   }
   /**
    * Finds if two inventories are equal.
    * @param other The inventory to be compared to.
    * @return Returns true if the inventory has the same objects in the same order and same class.
    */
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
      if (this.store.size() != ((Inventory)other).store.size())
      {
         return false;
      }
      for(int i = 0; i < this.store.size(); i++)
      {
         Product temp;
         temp = this.contains(((Inventory)other).store.get(i).getProductID());
            if(temp != null);
            {
               if(!(temp.equals(((Inventory)other).store.get(i))))
               {
                  return false;
               }
            }
      }
      return true;
   }
   
   /**
    * Checks to see if inventory contains a certain ProductID.
    * @param productID The productID to be searched for.
    * @return True if it does exist, false otherwise.
    */
   public Product contains(int productID)
   {
      int bot = 0;
      int top = store.size() - 1;

      while(bot <= top)
      {
         int mid = (bot + top) / 2;
         int dif = store.get(mid).getProductID() - productID;
         
         if(dif == 0)
         {
            return store.get(mid);
         }
         else if(dif < 0)
         {
            bot = mid + 1;
         }
         else if(dif > 0)
         {
            top = mid - 1;
         }
      }
      return null;
   }
      
   /**
    * Converts inventory into a delimited text file.
    * @param filename File to be written to.
    * @param delimiter Way to separate each value.
    * @throws IOException When File can not be created.
    */
   public void writeInventory(String filename, char delimiter) throws IOException
   {
      File file = new File(filename);
      file.setWritable(true);
      FileWriter writer = new FileWriter(file);
      store.trimToSize();
      
      for(int i = 0; i < store.size(); i++)
      {
         writer.write((store).get(i).toText(delimiter));
         if(i != store.size() - 1)
         {
            writer.write("\n");
         }
      }
      writer.close();
   }
   
   /**
    * Adds new products to inventory through a delimited text file.
    * @param filename The file to be read from.
    * @param delimiter The way the values are separated.
    * @return ArrayList<String> with all errors and where they occurred.
    * @throws FileNotFoundException When a file can not be found.
    */
   public ArrayList<String> addNew(String filename, char delimiter) throws FileNotFoundException
   {
      Scanner scan1 = new Scanner(new File(filename));
      ArrayList<String> error = new ArrayList<String>(); 
      int line = 1;
      
      while(scan1.hasNextLine())
      {
         String temp3 = new String(scan1.nextLine());
         Scanner scan2 = new Scanner(temp3);
         scan2 = scan2.useDelimiter("[" + delimiter + "]");
         String temp = new String(scan2.next().trim());
         if(temp.equals("Book"))
         {
            Book addBook = new Book();
            addBook.toObject(scan2);
            try
            {
               addNew(addBook);
            }
            catch(DuplicateProductIDException exep)
            {
               String temp2 = new String();
               temp2 = temp2.concat("Line " + line + "- " + temp3);
               error.add(temp2);
            }
            catch(DuplicateProductException exep2)
            {
               String temp2 = new String();
               temp2 = temp2.concat("Line " + line + "- " + temp3);
               error.add(temp2);
            }
         }
         if(temp.equals("BookOnTape"))
         {
            BookOnTape addBookOnTape = new BookOnTape();
            addBookOnTape.toObject(scan2);
            try
            {
               addNew(addBookOnTape);
            }
            catch(DuplicateProductIDException exep)
            {
               String temp2 = new String();
               temp2 = temp2.concat("Line " + line + "- " + temp3);
               error.add(temp2);
            }
            catch(DuplicateProductException exep2)
            {
               String temp2 = new String();
               temp2 = temp2.concat("Line " + line + "- " + temp3);
               error.add(temp2);
            }
         }
         if(temp.equals("CD"))
         {
            CD addCD = new CD();
            addCD.toObject(scan2);
            try
            {
               addNew(addCD);
            }
            catch(DuplicateProductIDException exep)
            {
               String temp2 = new String();
               temp2 = temp2.concat("Line " + line + "- " + temp3);
               error.add(temp2);
            }
            catch(DuplicateProductException exep2)
            {
               String temp2 = new String();
               temp2 = temp2.concat("Line " + line + "- " + temp3);
               error.add(temp2);
            }
         }
         line++;
      }
      return error;
   }
   
   /**
    * Adds quantities of products to inventory.
    * @param filename File to be read from.
    * @param delimiter Way the values are separated.
    * @return ArrayList<String> with errors and what line they occurred on.
    * @throws FileNotFoundException When a file can not be found.
    */
   public ArrayList<String> addInventory(String filename, char delimiter) 
      throws FileNotFoundException
   {
      Scanner scan1 = new Scanner(new File(filename));
      ArrayList<String> error = new ArrayList<String>(); 
      int line = 1;
      
      while(scan1.hasNextLine())
      {
         String temp = new String(scan1.nextLine());
         Scanner scan2 = new Scanner(temp);
         scan2.useDelimiter("[" + delimiter + "]");
         scan2.next();
         try
         {
            addInventory(Integer.parseInt(scan2.next().trim()), 
                         Integer.parseInt(scan2.next().trim()));
         }
         catch(InsufficientProductException exep)
         {
            String temp2 = new String();
            temp2.concat("Line " + line + "- " + temp);
            error.add(temp2);
         }
         catch(MissingProductException exep2)
         {
            String temp2 = new String();
            temp2.concat("Line " + line + "- " + temp);
            error.add(temp2);
         }
         
         line++;
      }
      return error;
   }
   
   /**
    * Sorts the inventory by ProductID.
    * Uses Insertion sort.
    */
   public void sort() //Insertion Sort
   {
      for(int i = 1; i < store.size(); i++)
      {
         Product next = store.get(i);
         
         int j = i;
         while(j > 0 && store.get(j-1).getProductID() > next.getProductID())
         {
            store.set(j, store.get(j-1));
            j--;
         }
         store.set(j, next);
      }
   }
   
   /**
    * Sorts the inventory through a comparator.
    * @param comparator The comparator to use to sort the inventory.
    */
   public void sort(Comparator<Product> comparator)
   {
      for(int i = 1; i < store.size(); i++)
      {
         Product next = store.get(i);
         
         int j = i;
         while(j > 0 && (comparator.compare(store.get(j-1), next) > 0))
         {
            store.set(j, store.get(j-1));
            j--;
         }
         store.set(j, next);
      }
   }
   
   /**
    * Returns the inventory for testing.
    * @return ArrayList<Product> with the inventory.
    */
   public ArrayList<Product> getInventory()
   {
      return store;
   }
}
