/**
 * An unchecked exception for insufficient quantities of product.
 *
 * @author Tyler Holland
 * @version Program 5
 * @version CPE102-5
 * @version Winter 2009
 */

public class InsufficientProductException extends RuntimeException
{
   public InsufficientProductException(int has, int need)
   {
      super("Product only has " + has + " units, need " + need);
   }
}
