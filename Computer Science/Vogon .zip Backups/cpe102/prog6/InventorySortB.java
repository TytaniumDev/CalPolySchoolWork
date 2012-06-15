/**
 * A class to help sort an Inventory, ascending ProductID.
 *
 * @author Tyler Holland
 * @version Program 6
 * @version CPE102-5
 * @version Winter 2009
 */
import java.util.Comparator;

public class InventorySortB implements Comparator<Product>
{
   public int compare(Product a, Product b)
   {
      if(!(a.getClass().getName().equals(b.getClass().getName())))
      {
         if(a.getClass().getName().equals("CD"))
         {
            return -1;
         }
         else if(b.getClass().getName().equals("CD"))
         {
            return 1;
         }
         else if(a.getClass().getName().equals("BookOnTape"))
         {
            return -1;
         }
         else if(b.getClass().getName().equals("BookOnTape"))
         {
            return 1;
         }
      }
      else
      {
         if(a.getProductID() < b.getProductID())
         {
            return -1;
         }
         else if(a.getProductID() > b.getProductID())
         {
            return 1;
         }
         else if(a.getProductID() == b.getProductID())
         {
            return 0;
         }
      }
      return 9000;
   }
}
