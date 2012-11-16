import java.util.Scanner;
import java.lang.reflect.*;

public class P1TestDriver
{
   private static final String RESULTS_FOR = "Results for Program 1";
   private static final double EPSILON = 0.000000000000001;
   
   public static void main(String[] args)
   {
      boolean pass = true;
      
      printHeader(args);
      
      pass &= testArchitecture();
      
      if (pass)
      {
         pass &= testDefaultConstructor();
         pass &= testNumeratorConstructor();
         pass &= testNumeratorDenominatorConstructor();
         pass &= testToString();
         pass &= testEquals();
         pass &= testAdd();
         pass &= testSub();
         pass &= testMul();
         pass &= testDiv();    
      }
      
      printResults(pass);
      
       // Added for to support robust script checking
      if (!pass)
      {
         System.exit(-1);
      }
   }
   
   // Test default constructor
   private static boolean testDefaultConstructor()
   {
      boolean pass = true;
      System.out.println("   Testing default constructor - Fraction()...");
      
      pass &= test(new Fraction(), 0, 1);
     
      return pass;
   }

   // Test numerator consructor
   private static boolean testNumeratorConstructor()
   {
      boolean pass = true;
      System.out.println("   Testing constructor - Fraction(int)...");
      String msg = "      FAILED: ";
      
      pass &= test(new Fraction(864), 864, 1);      
      pass &= test(new Fraction(-368), -368, 1);
      pass &= test(new Fraction(0), 0, 1);

      return pass;
   }
   
   // Test numerator/denominator consructor
   private static boolean testNumeratorDenominatorConstructor()
   {
      boolean pass = true;
      System.out.println("   Testing constructor - Fraction(int, int)...");
      
      pass &= test(new Fraction(1, 2), 1, 2);
      pass &= test(new Fraction(2, 1), 2, 1);
      
      pass &= test(new Fraction(4, 8), 1, 2);
      pass &= test(new Fraction(8, 4), 2, 1);
           
      pass &= test(new Fraction(15, 75), 1, 5);
      pass &= test(new Fraction(75, 15), 5, 1);

      pass &= test(new Fraction(-6, 9), -2, 3);
      pass &= test(new Fraction(0, 3), 0, 1);
      pass &= test(new Fraction(255255, 1616615), 3, 19);

      
      boolean caught = false;
      try
      {
         new Fraction(9, -6);
      }
      catch(IllegalArgumentException e)
      {
         caught = true;
      }
      pass &= test(caught, "      FAILED: IllegalArgumentExcpetion not thrown");
            
      caught = false;
      try
      {
         new Fraction(3, 0);
      }
      catch(IllegalArgumentException e)
      {
         caught = true;
      }
      pass &= test(caught, "      FAILED: IllegalArgumentExcpetion not thrown");
      
     
      return pass;
   }
   
   // Test toString
   private static boolean testToString()
   {
      boolean pass = true;
      String msg = "      FAILED: ";
      System.out.println("   Testing toString()...");
      
      Fraction f = new Fraction(5, 6);
      pass &= test(f.toString().equals("5/6"), msg +
         "toString() is " + f.toString() + ", expected 5/6");
         
      f = new Fraction(49, 56);
      pass &= test(f.toString().equals("7/8"), msg +
         "toString() is " + f.toString() + ", expected 7/8");

      f = new Fraction(13, 5);
      pass &= test(f.toString().equals("13/5"), msg +
         "toString() is " + f.toString() + ", expected 13/5");
               
      return pass;
   }

   // Test equals
   private static boolean testEquals()
   {
      boolean pass = true;
      String msg = "      FAILED: ";
      System.out.println("   Testing equals(Fraction)...");
      
      Fraction f1 = new Fraction(5, 6);
      Fraction f2 = new Fraction(10, 12);
      Fraction f3 = new Fraction(1, 2);
      
      pass &= test(f1.equals(f1), msg + "equals() is true, expected false");
      pass &= test(f1.equals(f2), msg + "equals() is true, expected false");
      pass &= test(!f2.equals(f3), msg + "equals() is false, expected true");
         
      return pass;
   }

   // Test add
   private static boolean testAdd()
   {
      boolean pass = true;
      String msg = "      FAILED: ";
      System.out.println("   Testing add(Fraction)...");
      
      Fraction f1 = new Fraction(5, 6);
      Fraction f2 = new Fraction(25, 30);
      Fraction f3 = new Fraction(1, 2);
      Fraction f4 = new Fraction(5, 10);

      pass &= test(f1.add(f1), 5, 3);
      pass &= test(f1, 5, 6);
      
      pass &= test(f1.add(f2), 5, 3);
      pass &= test(f1, 5, 6);
      pass &= test(f2, 5, 6);
            
      pass &= test(f1.add(f3), 4, 3);
      pass &= test(f1, 5, 6);
      pass &= test(f3, 1, 2);
      
      pass &= test(f1.add(f4), 4, 3);
      pass &= test(f1, 5, 6);
      pass &= test(f4, 1, 2);
      
      pass &= test(f3.add(f4), 1, 1);
      pass &= test(f3, 1, 2);
      pass &= test(f4, 1, 2);

      return pass;
   }
   
   // Test sub
   private static boolean testSub()
   {
      boolean pass = true;
      String msg = "      FAILED: ";
      System.out.println("   Testing sub(Fraction)...");
      
      Fraction f1 = new Fraction(5, 6);
      Fraction f2 = new Fraction(25, 30);
      Fraction f3 = new Fraction(1, 2);
      Fraction f4 = new Fraction(5, 10);

      pass &= test(f1.sub(f1), 0, 1);
      pass &= test(f1, 5, 6);
      
      pass &= test(f1.sub(f2), 0, 1);
      pass &= test(f1, 5, 6);
      pass &= test(f2, 5, 6);

      pass &= test(f1.sub(f3), 1, 3);
      pass &= test(f1, 5, 6);
      pass &= test(f3, 1, 2);
      
      pass &= test(f1.sub(f4), 1, 3);
      pass &= test(f1, 5, 6);
      pass &= test(f4, 1, 2);
      
      pass &= test(f3.sub(f4), 0, 1);
      pass &= test(f3, 1, 2);
      pass &= test(f4, 1, 2);
      

      return pass;
   }
   
   // Test mul
   private static boolean testMul()
   {
      boolean pass = true;
      String msg = "      FAILED: ";
      System.out.println("   Testing mul(Fraction)...");
      
      Fraction f1 = new Fraction(5, 6);
      Fraction f2 = new Fraction(25, 30);
      Fraction f3 = new Fraction(1, 2);
      Fraction f4 = new Fraction(5, 10);
      Fraction f5 = new Fraction(1, 6);
      Fraction f6 = new Fraction(3, 1);

      pass &= test(f1.mul(f1), 25, 36);
      pass &= test(f1, 5, 6);

      pass &= test(f1.mul(f2), 25, 36);
      pass &= test(f1, 5, 6);
      pass &= test(f2, 5, 6);

      pass &= test(f1.mul(f3), 5, 12);
      pass &= test(f1, 5, 6);
      pass &= test(f3, 1, 2);

      pass &= test(f1.mul(f4), 5, 12);
      pass &= test(f1, 5, 6);
      pass &= test(f4, 1, 2);

      pass &= test(f3.mul(f4), 1, 4);
      pass &= test(f3, 1, 2);
      pass &= test(f4, 1, 2);
      
      pass &= test(f5.mul(f6), 1, 2);
      pass &= test(f5, 1, 6);
      pass &= test(f6, 3, 1);

      return pass;
   }
   
   // Test div
   private static boolean testDiv()
   {
      boolean pass = true;
      String msg = "      FAILED: ";
      System.out.println("   Testing div(Fraction)...");
      
      Fraction f1 = new Fraction(5, 6);
      Fraction f2 = new Fraction(25, 30);
      Fraction f3 = new Fraction(1, 2);
      Fraction f4 = new Fraction(5, 10);

      pass &= test(f1.div(f1), 1, 1);
      pass &= test(f1, 5, 6);

      pass &= test(f1.div(f2), 1, 1);
      pass &= test(f1, 5, 6);
      pass &= test(f2, 5, 6);

      pass &= test(f1.div(f3), 5, 3);
      pass &= test(f1, 5, 6);
      pass &= test(f3, 1, 2);

      pass &= test(f1.div(f4), 5, 3);
      pass &= test(f1, 5, 6);
      pass &= test(f4, 1, 2);

      pass &= test(f3.div(f4), 1, 1);
      pass &= test(f3, 1, 2);
      pass &= test(f4, 1, 2);

      return pass;
   }
   
   private static boolean testArchitecture()
   {
      boolean pass = true;
      String msg = "      FAILED: ";
      Fraction f;
      Class cl;
      Class[] temp;
      
      System.out.println("   Testing Fraction architecture...");
      
      f = new Fraction();
      
      cl = f.getClass();

      int cnt = cl.getConstructors().length;     
      pass &= test(cnt == 3, msg + cnt + " constructors, expected 3");
      
      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
      pass &= test(cnt == 9, msg + cnt + " public methods, expected 9");
      
      cnt = cl.getFields().length;
      pass &= test(cnt == 0, msg + cnt + " public fields, expected 0");
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      pass &= test(cnt == 0, msg + cnt + " protected fields, expected 0");
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      pass &= test(cnt <= 3, msg + cnt 
         + " private fields, expected 3 or fewer");
         
      cnt = cl.getDeclaredFields().length
          - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE)
          - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED)
          - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC);
      pass &= test(cnt == 0, msg + cnt + " package fields, expected 0");
 
      return pass;
   }
   
   private static void printHeader(String[] args)
   {
      if (args.length == 1)
      {
         System.out.println(args[0]);
      }
      
      System.out.println(RESULTS_FOR + "\n");
   }
   
   private static void printResults(boolean pass)
   {
      String msg;
      
      if(pass)
      {
         msg = "\nCongratulations, you passed all the tests!\n\n"
            + "Your grade will be based on when you turn in your functionally\n"
            + "correct solution and any deductions for the quality of your\n"
            + "implementation.  Quality is based on, but not limited to,\n"
            + "coding style, documentation requirements, compiler warnings,\n"
            + "and the efficiency and elegance of your code.\n";
      }
      else
      {
         msg = "\nNot done yet - you failed one or more tests!\n";
      }
      
      System.out.print(msg);       
   }
   
   private static boolean approx(double a, double b)
   {
      return Math.abs(a - b) < EPSILON;
   }
   
   private static boolean test(boolean pass, String msg)
   {
      if(!pass)
      {
         System.out.println(msg);
      }
      
      return pass;
   }
   
   private static boolean test(Fraction f, int n, int d)
   {
      boolean pass = true;
      String msg = "      FAILED: ";
      
      pass &= test(f.getNumerator() == n, msg +
         "Numerator is " + f.getNumerator() + ", expected " + n);
         
      pass &= test(f.getDenominator() == d, msg + 
         "Denominator is " + f.getDenominator() + ", expected " + d);
         
      pass &= test(approx(f.value(), (double)n/d), msg +
         "Value is " + f.value() + ", expected " + (double)n/d);
         
      return pass;     
   }
   
   private static int countModifiers(Field[] fields, int modifier)
   {
      int count = 0;
      
      for (Field f : fields)
      {
         if (f.getModifiers() == modifier)
         {
            count++;
         }
      }
      
      return count;
   }
   
   private static int countModifiers(Method[] methods, int modifier)
   {
      int count = 0;
      
      for (Method m : methods)
      {
         if (m.getModifiers() == modifier)
         {
            count++;
         }
      }
      
      return count;
   }

}