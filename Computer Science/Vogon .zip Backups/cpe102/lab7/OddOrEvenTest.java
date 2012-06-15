import org.junit.Test;

// The following import allows you to call the static methods
// of the Assert class without specifying the class name
import static org.junit.Assert.*;

public class OddOrEvenTest
{
   // Develop a test method for each method of the class.
   // A common naming convention is to prepend the word "test"
   // to the name of the method you are testing.
   @Test
   public void testOddOrEven()
   {
      // Create an object to test
      OddOrEven ooe = new OddOrEven(5);

      // Using a JUnit method, verify the method being tested returns the expected result
      assertEquals("ODD", ooe.oddOrEven());

      // Repeat for logic for all test cases.
      // You may use the slightly different syntactic form used below or the more
      // verbose (but equivalent) form show above, as you prefer.
      assertEquals("ODD", (new OddOrEven(-7)).oddOrEven());
      assertEquals("EVEN", (new OddOrEven(28)).oddOrEven());
      assertEquals("EVEN", (new OddOrEven(2)).oddOrEven());
      assertEquals("EVEN", (new OddOrEven(0)).oddOrEven());
   }

   // Remember, you can and should write additional and separate methods,
   // one for each method of the class you are testing.
}