/**
 * A checked exception for duplicate product IDs.
 *
 * @author Tyler Holland
 * @version Program 5
 * @version CPE102-5
 * @version Winter 2009
 */

public class DuplicateProductIDException extends Exception
{
   public DuplicateProductIDException(int ID)
   {
      super("Product ID " + ID + " is already in the inventory");
   }
}