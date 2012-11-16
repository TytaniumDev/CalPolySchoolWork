/**
 * A Product Abstract Class for use on items to be stored.
 *
 * @author Tyler Holland
 * @version Program 6
 * @version CPE102-5
 * @version Winter 2009
 */
import java.util.Scanner;

public abstract class Product implements DelimitedTextIO, Comparable<Product>
{
   //Instance Variables
   private static int STARTID = 100000;
   private int ID;
   private int stock;
   private String descrip = new String();
   private double wholesale;
   private double retail;

   //Constructors
   /**
    * Creates a new product.
    * ID Starts at 100000 and goes up by one for each product.
    * Stock starts at 0. Wholesale and Retail price start at 0.
    * Description is blank.
    */
   public Product()
   {
      this.ID = STARTID;
      STARTID++;
      this.stock = 0;
      this.descrip = "";
      this.wholesale = 0;
      this.retail = 0;
   }
   
   /**
    * Creates a new product with a specified product ID.
    * Stock starts at 0. Wholesale and Retail price start at 0.
    * Description is blank.
    * @param productID The product ID to be set.
    */
   public Product(int productID)
   {
      this.ID = productID;
      this.stock = 0;
      this.descrip = "";
      this.wholesale = 0;
      this.retail = 0;
   }

   //Methods
   /**
    * Returns the product ID of the product.
    * @return Returns an int value representing the Product ID.
    */
   public int getProductID()
   {
      return ID;
   }
   
   /**
    * Returns the quantity of the product.
    * @return Returns an int of how much of the product is in stock.
    */
   public int getQuantity()
   {
      return stock;
   }
   
   /**
    * Sets the quantity of the product.
    * @param quantity The amount of the product.
    */
   public void setQuantity(int quantity)
   {
         this.stock = quantity;
   }
   
   /**
    * Returns the description of the product.
    * @return Returns a String with the product description.
    */
   public String getDescription()
   {
      return descrip;
   }
   
   /**
    * Sets the description of the product.
    * @param description The description of the product.
    */
   public void setDescription(String description)
   { 
      if(description == null)
      {
         this.descrip = "";
      }
      else
      {
         this.descrip = description;  
      }
   }
   
   /**
    * Returns the wholesale price for the product.
    * @return Returns a double with the wholesale price.
    */
   public double getWholesalePrice()
   {
      return wholesale;
   }
   /**
    * Sets the wholesale price of the product.
    * @param price The wholesale price of the product.
    */
   public void setWholesalePrice(double price)
   {
      this.wholesale = price;
   }
   
   /**
    * Returns the retail price of the product.
    * @return Returns a double with the retail price.
    */
   public double getRetailPrice()
   {
      return retail;
   }
   
   /**
    * Sets the retail price of the product.
    * @param price The retail price of the product.
    */
   public void setRetailPrice(double price)
   {
      this.retail = price;
   }
   
   /**
    * Checks to see if two products are equal to each other.
    * @param other The object being compared to.
    * @return Returns a boolean statement about the equality of the products.
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
      if(this.wholesale != ((Product)other).wholesale)
      {
         return false;
      }
      if(this.retail != ((Product)other).retail)
      {
         return false;
      }
      if(((Product)other).descrip == null && this.descrip == null)
      {
         return true;
      }
      else if(!((Product)other).descrip.equals(this.descrip))
      {
         return false;
      }
      return true;
   }
   
   //Methods from interface
   /** 
    * Converts a Product into delimited text.
    * @param delimiter The delimiter to use.
    * @return A String with the delimited text.
    */
   public String toText(char delimiter)
   {
      String result = new String();
      
      result = result.concat(this.getClass().getName() + " " + delimiter + " ");
      result = result.concat("" + ID + " " + delimiter + " ");
      result = result.concat("" + stock + " " + delimiter + " ");
      result = result.concat("" + descrip + " " + delimiter + " ");
      result = result.concat("" + wholesale + " " + delimiter + " ");
      result = result.concat("" + retail + " " + delimiter + " ");
      
      return result;
   }
   /**
    * Converts a text file into a Product.
    * Note: scan2 must already have a delimiter set.
    * @param scan2 The Scanner to be used to find each token.
    */
   public void toObject(Scanner scan2)
   {
      this.ID = Integer.parseInt(scan2.next().trim());
      this.stock = Integer.parseInt(scan2.next().trim());
      this.descrip = scan2.next().trim();
      this.wholesale = Double.parseDouble(scan2.next().trim());
      this.retail = Double.parseDouble(scan2.next().trim());
   }
   
   //Method from Comparable
   /**
    * Compares two products through ProductID.
    * @param o The product to be compared to.
    * @return Returns an int, -1 if o is larger, 1 if o is smaller, 0 if they are equal.
    */
   public int compareTo(Product o)
   {
      if(this.ID < o.getProductID())
      {
         return -1;
      }
      else if(this.ID > o.getProductID())
      {
         return 1;
      }
      else if(this.ID == o.getProductID())
      {
         return 0;
      }
      return 9000;
   }
}