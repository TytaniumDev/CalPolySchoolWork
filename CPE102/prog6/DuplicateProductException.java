/**
 * A checked exception for duplicate products.
 *
 * @author Tyler Holland
 * @version Program 6
 * @version CPE102-5
 * @version Winter 2009
 */

public class DuplicateProductException extends Exception
{
   public DuplicateProductException(int add, int there)
   {
      super("Product ID " + add + " is equivalent to existing Product ID " + there);
   }
}
