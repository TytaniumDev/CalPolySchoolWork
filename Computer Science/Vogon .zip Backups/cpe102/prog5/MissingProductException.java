/**
 * An unchecked exception for missing products.
 *
 * @author Tyler Holland
 * @version Program 5
 * @version CPE102-5
 * @version Winter 2009
 */

public class MissingProductException extends RuntimeException
{
   public MissingProductException(int ID)
   {
      super("Can not find Product ID " + ID);
   }
}
