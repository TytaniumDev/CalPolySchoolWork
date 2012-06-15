import org.junit.Test;

// The following import allows you to call the static methods
// of the Assert class without specifying the class name
import static org.junit.Assert.*;

public class ShrinkingStringTests
{
   // Develop a test method for each method of the class.
   // A common naming convention is to prepend the word "test"
   // to the name of the method you are testing.
   @Test
   public void testConstructor()
   {
      ShrinkingString ss = new ShrinkingString("lolconstructthis");
      
      assertEquals(true, ss.toString().equals("lolconstructthis"));
      
      ss = new ShrinkingString("");
      
      assertEquals(true, ss.toString().equals(""));
   }
   
   @Test
   public void testContains()
   {
      // Create an object to test
      ShrinkingString ss = new ShrinkingString("banana");

      // Using a JUnit method, verify the method being tested returns the expected result
      assertEquals(true, ss.contains('b'));

      // Repeat for logic for all test cases.
      // You may use the slightly different syntactic form used below or the more
      // verbose (but equivalent) form show above, as you prefer.
      
      // Test for a character that appears more than once in the ShrinkingString
      assertEquals(true, (new ShrinkingString("banana")).contains('a'));
      
      // Test for a character that does not appear in the ShrinkingString
      assertEquals(false, (new ShrinkingString("banana")).contains('x'));
      
      // Test for an empty ShrinkingString
      assertEquals(false, (new ShrinkingString("")).contains('a'));
   }

   // Remember, you can and should write additional and separate methods,
   // one for each method of the class you are testing. 
   @Test
   public void testLength()
   {
      ShrinkingString ss = new ShrinkingString("four");
      
      assertEquals(true, ss.length() == 4);
      
      //Other length tests
      assertEquals(true, (new ShrinkingString("verylongname")).length() == 12);
      assertEquals(true, (new ShrinkingString("")).length() == 0);
   }
   
   @Test
   public void testRemoveChar()
   {
      ShrinkingString ss = new ShrinkingString("removeme");
      
      ss.removeChar('r');
      assertEquals(true, ss.toString().equals("emoveme"));
      
      ss.removeChar('e');
      assertEquals(true, ss.toString().equals("moveme"));
      
      ss.removeChar('x');
      assertEquals(true, ss.toString().equals("moveme"));
      
      ShrinkingString ss1 = new ShrinkingString("");
      
      ss1.removeChar('r');
      assertEquals(true, ss1.toString().equals(""));
      
   }
   
   @Test
   public void testRemoveIndex()
   {
      ShrinkingString ss = new ShrinkingString("teststring");
      
      ss.removeIndex(7);
      assertEquals(true, ss.toString().equals("teststrng"));
      
      ss.removeIndex(0);
      assertEquals(true, ss.toString().equals("eststrng"));
      
      ss = new ShrinkingString("four");
      
      ss.removeIndex(3);
      assertEquals(true, ss.toString().equals("fou"));
   }
}

