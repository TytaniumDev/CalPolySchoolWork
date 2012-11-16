import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import junit.framework.JUnit4TestAdapter;

// Declare your test class or classes here.
@RunWith(Suite.class)
@Suite.SuiteClasses
({ 
   ShrinkingStringTests.class // Be sure you separate multiple classes with commas.
})

public class AllTests
{
   public static void main(String[] args)
   {
      junit.textui.TestRunner.run(suite());
   }

   public static junit.framework.Test suite()
   {
      return new JUnit4TestAdapter(AllTests.class);
   }
}
