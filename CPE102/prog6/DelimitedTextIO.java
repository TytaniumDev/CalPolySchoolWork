/**
 * An interface to read and write from text files using a delimiter.
 *
 * @author Tyler Holland
 * @version Program 6
 * @version CPE102-5
 * @version Winter 2009
 */
import java.util.Scanner;

public interface DelimitedTextIO
{
   //Methods
   public String toText(char delimiter);
   public void toObject(Scanner input);
}
