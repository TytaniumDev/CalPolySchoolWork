/**
 * Test Driver for Program 6
 *
 * @author Kurt Mammen
 * @version CPE 102
 */
import java.util.Scanner;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.*;
import java.util.Random;

public class P6TestDriver
{
   private static final String RESULTS_FOR = "Results for Program 6";


   public static void main(String[] args) throws 
      DuplicateProductIDException,
      DuplicateProductException,
      FileNotFoundException,
      IOException,
      ClassNotFoundException
   {
      boolean pass = true;
  
      printHeader(args);
  
      // Architecture tests...
      //
      pass &= testBookArch();
      pass &= testBookOnTapeArch();
      pass &= testCDArch();
      pass &= testAbstractBookArch();
      pass &= testProductArch();
      pass &= testNameArch();
      pass &= testInventoryArch();

      // Behavior tests...
      //
      pass &= test1();
      pass &= test2();
      pass &= test3();
      pass &= test4();
      pass &= test5();
      pass &= test6();
      pass &= test7();
      pass &= test8();
      pass &= test9();

      Inventory inventory = makeARandomInventory(1000);

      pass &= test10(inventory);
      pass &= test11(inventory);
      pass &= test12();
      pass &= test13(inventory);
      pass &= test14(inventory);

      printResults(pass);
      
      if (!pass)
      {
         System.exit(-1);
      }
   }

   private static boolean testBookArch()
   {
      boolean pass = true;
      int test = 1;
      int cnt;
      Class cl;
      Class[] temp;
      Book ref = new Book(0);

      System.out.println("Book architecture tests...");

      cl = ref.getClass();
      pass &= test(cl.getConstructors().length == 2, test++);
      pass &= test(ref instanceof AbstractBook, test++);
      pass &= test(ref instanceof Product, test++);

      String[] names = {"getPages", "setPages", "getBinding", "setBinding",
                        "toText", "toObject", "equals"};

      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
      pass &= test(cnt == names.length, test++);
      pass &= test(verifyNames(cl.getDeclaredMethods(), Modifier.PUBLIC, names), test++);
      
      pass &= test(verifyEqualsMethodSignature(cl), test++);
      
      cnt = cl.getFields().length;
      pass &= test(cnt == 4, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      pass &= test(cnt == 2, test++);
      
      // Count and test number of of PACKAGE fields
      cnt = countPackage(cl.getDeclaredFields());
      pass &= test(cnt == 2, test++);

      return pass;
   }

   private static boolean testBookOnTapeArch()
   {
      boolean pass = true;
      int test = 1;
      int cnt;
      Class cl;
      Class[] temp;
      BookOnTape ref = new BookOnTape(0);

      System.out.println("BookOnTape architecture tests...");

      cl = ref.getClass();
      pass &= test(cl.getConstructors().length == 2, test++);
      pass &= test(ref instanceof AbstractBook, test++);
      pass &= test(ref instanceof Product, test++);

      String[] names = {"getReader", "setReader", "getLength", "setLength",
                        "getFormat","setFormat","toText","toObject","equals"};

      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
      pass &= test(cnt == names.length, test++);
      pass &= test(verifyNames(cl.getDeclaredMethods(), Modifier.PUBLIC, names), test++);
      
      pass &= test(verifyEqualsMethodSignature(cl), test++);
      
      cnt = cl.getFields().length;
      pass &= test(cnt == 5, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      pass &= test(cnt == 3, test++);
      
      // Count and test number of of PACKAGE fields
      cnt = countPackage(cl.getDeclaredFields());
      pass &= test(cnt == 3, test++);

      return pass;
   }

   private static boolean testCDArch()
   {
      boolean pass = true;
      int test = 1;
      int cnt;
      Class cl;
      Class[] temp;
      CD ref = new CD(0);

      System.out.println("CD architecture tests...");

      cl = ref.getClass();
      pass &= test(cl.getConstructors().length == 2, test++);
      pass &= test(ref instanceof Product, test++);

      String[] names = {"getTitle", "setTitle", "getArtist", "setArtist",
                        "toText", "toObject", "equals"};

      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
      pass &= test(cnt == names.length, test++);
      pass &= test(verifyNames(cl.getDeclaredMethods(), Modifier.PUBLIC, names), test++);
      
      pass &= test(verifyEqualsMethodSignature(cl), test++);
      
      cnt = cl.getFields().length;
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      pass &= test(cnt == 2, test++);
      
      // Count and test number of of PACKAGE fields
      cnt = countPackage(cl.getDeclaredFields());
      pass &= test(cnt == 0, test++);

      return pass;
   }

   private static boolean testAbstractBookArch() throws ClassNotFoundException
   {
      boolean pass = true;
      int test = 1;
      int cnt;
      Class cl;
      Class[] temp;
      
      System.out.println("AbstractBook architecture tests...");
      
      cl = Class.forName("AbstractBook");
      pass &= test(cl.getConstructors().length == 2, test++);
      
      temp = cl.getInterfaces();
      pass &= test(temp.length == 0, test++);

      String[] names = {"getTitle", "setTitle", "getPublisher",
                        "setPublisher", "getAuthor", "setAuthor", "getType",
                        "setType", "toText", "toObject", "equals"};

      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
      pass &= test(cnt == names.length, test++);
      pass &= test(verifyNames(cl.getDeclaredMethods(), Modifier.PUBLIC, names), test++);
      
      pass &= test(verifyEqualsMethodSignature(cl), test++);
      
      cnt = cl.getFields().length;
      pass &= test(cnt == 2, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      pass &= test(cnt == 4, test++);
      
      // Count and test number of of PACKAGE fields
      cnt = countPackage(cl.getDeclaredFields());
      pass &= test(cnt == 2, test++);
      
      return pass;
   }

   private static boolean testProductArch() throws ClassNotFoundException
   {
      boolean pass = true;
      int test = 1;
      int cnt;
      Class cl;
      Class[] temp;
      
      System.out.println("Product architecture tests...");
      
      cl = Class.forName("Product");
      pass &= test(cl.getConstructors().length == 2, test++);
      
      temp = cl.getInterfaces();
      pass &= test(temp.length == 2, test++);

      String name = temp[0].getName();
      pass &= test(name.equals("java.lang.Comparable") || name.equals("DelimitedTextIO"), test++);
      
      name = temp[1].getName();
      pass &= test(name.equals("java.lang.Comparable") || name.equals("DelimitedTextIO"), test++);

      String[] names = {"getQuantity", "setQuantity", "getProductID",
                        "getDescription", "setDescription", "getWholesalePrice",
                        "setWholesalePrice", "getRetailPrice", "setRetailPrice",
                        "toText", "toObject", "compareTo", "equals"};

      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
      pass &= test(cnt == names.length, test++);
      pass &= test(verifyNames(cl.getDeclaredMethods(), Modifier.PUBLIC, names), test++);
      
      pass &= test(verifyEqualsMethodSignature(cl), test++);
      
      cnt = cl.getFields().length;
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      pass &= test(cnt == 5, test++);
      
      // Count and test number of of PACKAGE fields
      cnt = countPackage(cl.getDeclaredFields());
      pass &= test(cnt == 1, test++);
      
      return pass;
   }

   private static boolean testNameArch() throws ClassNotFoundException
   {
      boolean pass = true;
      int test = 1;
      int cnt;
      Class cl;
      Class[] temp;
      
      System.out.println("Name architecture tests...");
      
      cl = Class.forName("Name");
      pass &= test(cl.getConstructors().length == 2, test++);
      
      temp = cl.getInterfaces();
      pass &= test(temp.length == 1, test++);

      pass &= test(temp[0].getName().equals("DelimitedTextIO"), test++);

      String[] names = {"getFirst", "getMiddle", "getLast", "match",
                        "toText", "toObject", "equals"};

      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
      pass &= test(cnt == names.length, test++);
      pass &= test(verifyNames(cl.getDeclaredMethods(), Modifier.PUBLIC, names), test++);
      
      pass &= test(verifyEqualsMethodSignature(cl), test++);
      
      cnt = cl.getFields().length;
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      pass &= test(cnt == 3, test++);
      
      // Count and test number of of PACKAGE fields
      cnt = countPackage(cl.getDeclaredFields());
      pass &= test(cnt == 0, test++);
      
      return pass;
   }

   private static boolean testInventoryArch()
   {
      boolean pass = true;
      int test = 1;
      int cnt;
      Class cl;
      Class[] temp;
      Inventory ref = new Inventory();

      System.out.println("Inventory architecture tests...");

      cl = ref.getClass();
      pass &= test(cl.getConstructors().length == 1, test++);

      // Note that addNew and addInventory are overloaded in P6.
      String[] names = {"addNew", "addInventory", "findBooksByAuthor",
                        "findBooksByTitle", "findCDsByArtist",
                        "findCDsByTitle", "findBookOnTapeByReader",
                        "contains", "writeInventory", "addInventory",
                        "addNew", "sort", "sort", "getInventory", "equals" };

      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);
      
      // Remember, there are some overloaded methods!
      pass &= test(cnt == names.length, test++);
      pass &= test(verifyNames(cl.getDeclaredMethods(), Modifier.PUBLIC, names), test++);
      
      pass &= test(verifyEqualsMethodSignature(cl), test++);
      
      cnt = cl.getFields().length;
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      pass &= test(cnt == 1, test++);
      
      // Count and test number of of PACKAGE fields
      cnt = countPackage(cl.getDeclaredFields());
      pass &= test(cnt == 0, test++);

      return pass;
   }

    /**
     * Tests the Book class and all of its super classes
     */
    private static boolean test1()
    {
        // Test no longer applicable - removed!
        System.out.println("test 1...");
        return true;
    }

    /**
     * Tests the Book class and all of its super classes
     */
    private static boolean test2()
    {
        Book b1 = new Book();
        Book b2 = new Book();

        System.out.println("test 2...");

        String description1 = new String("xyz");
        String description2 = new String("xyz");
        int quantity = 11;
        double wholesalePrice = 8.50;
        double retailPrice = 16.99;

        String title1 = new String("Big Rock Candy Mountain");
        String title2 = new String("Big Rock Candy Mountain");
        String publisher1 = new String("Simon & Schuster");
        String publisher2 = new String("Simon & Schuster");
        Name author1 = new Name(new String("Stegner"), new String("Wallace"), new String("A"));
        Name author2 = new Name(new String("Stegner"), new String("Wallace"), new String("A"));
        int type = AbstractBook.FICTION;

        int pages = 279;
        int binding = Book.HARD_COVER;

        b1.setDescription(description1);
        b1.setQuantity(quantity);
        b1.setWholesalePrice(wholesalePrice);
        b1.setRetailPrice(retailPrice);

        b1.setTitle(title1);
        b1.setPublisher(publisher1);
        b1.setAuthor(author1);
        b1.setType(type);

        b1.setPages(pages);
        b1.setBinding(binding);

        b2.setDescription(description2);
        b2.setQuantity(quantity);
        b2.setWholesalePrice(wholesalePrice);
        b2.setRetailPrice(retailPrice);

        b2.setTitle(title2);
        b2.setPublisher(publisher2);
        b2.setAuthor(author2);
        b2.setType(type);

        b2.setPages(pages);
        b2.setBinding(binding);

        boolean success = true;

        // Did you remember that we are not including the ProductID and
        // Quantity when determining equality?
        if(!b1.equals(b1))
        {
            System.out.println("\tFAILED: test2() #1");
            success = false;
        }

        // Did you remember that we are not including the ProductID and
        // Quantity when determining equality?
        if(!b1.equals(b2))
        {
            System.out.println("\tFAILED: test2() #2");
            success = false;
        }

        if(!b1.getDescription().equals(description2))
        {
            System.out.println("\tFAILED: test2() #3");
            success = false;
        }

        if(b1.getQuantity() != quantity)
        {
            System.out.println("\tFAILED: test2() #4");
            success = false;
        }

        if(b1.getWholesalePrice() != wholesalePrice)
        {
            System.out.println("\tFAILED: test2() #5");
            success = false;
        }

        if(b1.getRetailPrice() != retailPrice)
        {
            System.out.println("\tFAILED: test2() #6");
            success = false;
        }

        if(!b1.getTitle().equals(title2))
        {
            System.out.println("\tFAILED: test2() #7");
            success = false;
        }

        if(!b1.getPublisher().equals(publisher2))
        {
            System.out.println("\tFAILED: test2() #8");
            success = false;
        }

        if(!b1.getAuthor().equals(author2))
        {
            System.out.println("\tFAILED: test2() #9");
            success = false;
        }

        if(b1.getType() != type)
        {
            System.out.println("\tFAILED: test2() #10");
            success = false;
        }

        if(b1.getPages() != pages)
        {
            System.out.println("\tFAILED: test2() #11");
            success = false;
        }

        if(b1.getBinding() != binding)
        {
            System.out.println("\tFAILED: test2() #12");
            success = false;
        }

        b2.setDescription(new String("junk"));

        if(b1.equals(b2))
        {
            System.out.println("\tFAILED: test2() #13");
            success = false;
        }

        b2.setDescription(description2);
        b2.setQuantity(33);

        if(!b1.equals(b2))
        {
            System.out.println("\tFAILED: test2() #14");
            success = false;
        }

        b2.setQuantity(quantity);
        b2.setWholesalePrice(.01);

        if(b1.equals(b2))
        {
            System.out.println("\tFAILED: test2() #15");
            success = false;
        }

        b2.setWholesalePrice(wholesalePrice);
        b2.setRetailPrice(.02);

        if(b1.equals(b2))
        {
            System.out.println("\tFAILED: test2() #16");
            success = false;
        }

        b2.setRetailPrice(retailPrice);
        b2.setTitle(new String("Moon"));

        if(b1.equals(b2))
        {
            System.out.println("\tFAILED: test2() #17");
            success = false;
        }

        b2.setTitle(title2);
        b2.setPublisher(new String("Whatever"));

        if(b1.equals(b2))
        {
            System.out.println("\tFAILED: test2() #18");
            success = false;
        }

        b2.setPublisher(publisher2);
        b2.setAuthor(new Name(new String("Blow"), new String("Joe"), new String("Z")));

        if(b1.equals(b2))
        {
            System.out.println("\tFAILED: test2() #19");
            success = false;
        }

        b2.setAuthor(author2);
        b2.setType(AbstractBook.NONFICTION);

        if(b1.equals(b2))
        {
            System.out.println("\tFAILED: test2() #20");
            success = false;
        }

        b2.setType(AbstractBook.FICTION);
        b2.setPages(99999);

        if(b1.equals(b2))
        {
            System.out.println("\tFAILED: test2() #21");
            success = false;
        }

        b2.setPages(pages);
        b2.setBinding(Book.PAPERBACK);

        if(b1.equals(b2))
        {
            System.out.println("\tFAILED: test2() #22");
            success = false;
        }

        b2.setBinding(Book.HARD_COVER);

        if(!b1.equals(b2))
        {
            System.out.println("\tFAILED: test2() #23");
            success = false;
        }

        if(b1.getProductID() != 100000)
        {
            System.out.println("\tFAILED: test2() #24");
            success = false;
        }

        if(b2.getProductID() != 100001)
        {
            System.out.println("\tFAILED: test2() #25");
            success = false;
        }

        Book b3 = new Book(99);
        Book b4 = new Book(99);

        if(!b3.equals(b4))
        {
            System.out.println("\tFAILED: test2() #26");
            success = false;
        }

        if(b3.getProductID() != 99)
        {
            System.out.println("\tFAILED: test2() #27");
            success = false;
        }

        // New test added Spring 2004
        b3.setDescription(null);
        b3.setAuthor(new Name(null, null, null));
        b3.setTitle(null);
        b3.setPublisher(null);

        if(!b3.equals(b4))
        {
            System.out.println("\tFAILED: test2() #28");
            success = false;
        }

        // New test added Spring 2004
        b4.setDescription(null);
        b4.setAuthor(new Name(null, null, null));
        b4.setTitle(null);
        b4.setPublisher(null);

        if(!b3.equals(b4))
        {
            System.out.println("\tFAILED: test2() #29");
            success = false;
        }

        Book b5 = new Book();

        if(b5.getProductID() != 100002)
        {
            System.out.println("\tFAILED: test2() #30");
            success = false;
        }
        
        return success;
    }

    /**
     * Tests the BookOnTape class
     */
    private static boolean test3()
    {
        boolean success = true;

        BookOnTape b1 = new BookOnTape();
        BookOnTape b2 = new BookOnTape();

        System.out.println("test 3...");

        // Did you remember that we are not including the ProductID and
        // Quantity when determining equality?
        if(!b1.equals(b1))
        {
            System.out.println("\tFAILED: test3() #1");
            success = false;
        }

        // Did you remember that we are not including the ProductID and
        // Quantity when determining equality?
        if(!b2.equals(b1))
        {
            System.out.println("\tFAILED: test3() #2");
            success = false;
        }

        Name name = new Name("Nemoi", "Leonard", "Hmmmm");
        int length = 120;
        int format1 = BookOnTape.CD;
        int format2 = BookOnTape.DVD;
        int format3 = BookOnTape.TAPE;

        b1.setReader(name);
        b2.setReader(name);

        b1.setLength(length);
        b2.setLength(length);

        b1.setFormat(format1);
        b2.setFormat(format1);

        if(!b1.equals(b1))
        {
            System.out.println("\tFAILED: test3() #3");
            success = false;
        }

        if(!b1.equals(b2))
        {
            System.out.println("\tFAILED: test3() #4");
            success = false;
        }

        if(!b1.getReader().equals(name))
        {
            System.out.println("\tFAILED: test3() #5");
            success = false;
        }

        if(b1.getLength() != length)
        {
            System.out.println("\tFAILED: test3() #6");
            success = false;
        }

        if(b1.getFormat() != format1)
        {
            System.out.println("\tFAILED: test3() #7");
            success = false;
        }

        b2.setReader(new Name( new String("a"), new String("b"), new String("c")));

        if(b1.equals(b2))
        {
            System.out.println("\tFAILED: test3() #8");
            success = false;
        }

        b2.setReader(name);
        b2.setLength(33);

        if(b1.equals(b2))
        {
            System.out.println("\tFAILED: test3() #9");
            success = false;
        }

        b2.setLength(length);
        b2.setFormat(format3);

        if(b1.equals(b2))
        {
            System.out.println("\tFAILED: test3() #10");
            success = false;
        }

        b2.setFormat(format3);

        if(b1.equals(b2))
        {
            System.out.println("\tFAILED: test3() #11");
            success = false;
        }

        if(b1.getProductID() != 100003)
        {
            System.out.println("\tFAILED: test3() #12");
            success = false;
        }

        if(b2.getProductID() != 100004)
        {
            System.out.println("\tFAILED: test3() #13");
            success = false;
        }

        BookOnTape b3 = new BookOnTape(99);
        BookOnTape b4 = new BookOnTape(99);

        if(!b3.equals(b4))
        {
            System.out.println("\tFAILED: test3() #14");
            success = false;
        }

        if(b3.getProductID() != 99)
        {
            System.out.println("\tFAILED: test3() #15");
            success = false;
        }

        BookOnTape b5 = new BookOnTape();

        if(b5.getProductID() != 100005)
        {
            System.out.println("\tFAILED: test3() #16");
            success = false;
        }
        
        return success;
    }

    /**
     * Tests the CD class
     */
    private static boolean test4()
    {
        boolean success = true;

        CD c1 = new CD();
        CD c2 = new CD();

        System.out.println("test 4...");

        // Did you remember that we are not including the ProductID and
        // Quantity when determining equality?
        if(!c1.equals(c1))
        {
            System.out.println("\tFAILED: test4() #1");
            success = false;
        }

        // Did you remember that we are not including the ProductID and
        // Quantity when determining equality?
        if(!c2.equals(c1))
        {
            System.out.println("\tFAILED: test4() #2");
            success = false;
        }

        Name name = new Name(new String("Nemoi"), new String("Leonard"), new String("Hmmmm"));
        String title = "Spock Sings the Blues";

        c1.setArtist(name);
        c2.setArtist(name);

        c1.setTitle(title);
        c2.setTitle(title);

        if(!c1.equals(c1))
        {
            System.out.println("\tFAILED: test4() #3");
            success = false;
        }

        if(!c1.equals(c2))
        {
            System.out.println("\tFAILED: test4() #4");
            success = false;
        }

        if(!c1.getArtist().equals(name))
        {
            System.out.println("\tFAILED: test4() #5");
            success = false;
        }

        if(!c1.getTitle().equals(title))
        {
            System.out.println("\tFAILED: test4() #6");
            success = false;
        }

        c2.setArtist(new Name( new String("a"), new String("b"), new String("c")));

        if(c1.equals(c2))
        {
            System.out.println("\tFAILED: test4() #7");
            success = false;
        }

        c2.setArtist(name);
        c2.setTitle(new String("zzzz"));

        if(c1.equals(c2))
        {
            System.out.println("\tFAILED: test4() #8");
            success = false;
        }

        c2.setTitle(title);

        if(!c1.equals(c2))
        {
            System.out.println("\tFAILED: test4() #9");
            success = false;
        }

        if(c1.getProductID() != 100006)
        {
            System.out.println("\tFAILED: test4() #10");
            success = false;
        }

        if(c2.getProductID() != 100007)
        {
            System.out.println("\tFAILED: test4() #11");
            success = false;
        }

        CD c3 = new CD(99);
        CD c4 = new CD(99);

        if(!c3.equals(c4))
        {
            System.out.println("\tFAILED: test4() #12");
            success = false;
        }

        if(c3.getProductID() != 99)
        {
            System.out.println("\tFAILED: test4() #13");
            success = false;
        }

        // Test added Spring 2004
        c3.setDescription(null);
        c3.setTitle(null);

        if(!c3.equals(c4))
        {
            System.out.println("\tFAILED: test4() #14");
            success = false;
        }

        // Test added Spring 2004
        c4.setDescription(null);
        c4.setTitle(null);

        if(!c3.equals(c4))
        {
            System.out.println("\tFAILED: test4() #15");
            success = false;
        }

        CD c5 = new CD();

        if(c5.getProductID() != 100008)
        {
            System.out.println("\tFAILED: test4() #16");
            success = false;
        }
        
        return success;
    }

    /**
     * Tests the Inventory class's addNew() and () methods
     */
    private static boolean test5() throws DuplicateProductIDException, DuplicateProductException
    {
        boolean success = true;
        boolean caught = false;

        System.out.println("test 5...");

        Inventory i = new Inventory();

        Book b1 = new Book(1000);

        i.addNew(b1);

        try
        {
            i.addNew(b1);
        }
        catch(DuplicateProductIDException e1)
        {
            caught = true;
        }
        catch(DuplicateProductException e2)
        {
            caught = true;
        }

        if(!caught)
        {
            System.out.println("\tFAILED: test5() #1");
            success = false;
        }

        Book b2 = new Book(1000);
        b2.setPages(99);
        caught = false;

        try
        {
            i.addNew(b2);
        }
        catch(DuplicateProductIDException e1)
        {
            caught = true;
        }

        if(!caught)
        {
            System.out.println("\tFAILED: test5() #2");
            success = false;
        }

        caught = false;
        b2.setPages(0);
        b2.setDescription(new String("Great Book!"));

        try
        {
            i.addNew(b2);
        }
        catch(DuplicateProductIDException e3)
        {
            caught = true;
        }

        if(!caught)
        {
            System.out.println("\tFAILED: test5() #3");
            success = false;
        }

        Book b3 = new Book(1003);
        b3.setPages(9);
        i.addNew(b3);
        b3.setDescription(new String("Great Book!"));
        Book b4 = new Book(1004);
        b4.setPages(9);
        b4.setDescription(new String("Great Book!"));
        caught = false;

        try
        {
            i.addNew(b4);
        }
        catch(DuplicateProductException e4)
        {
            caught = true;
        }

        if(!caught)
        {
            System.out.println("\tFAILED: test5() #4");
            success = false;
        }

        b4.setDescription(new String("Really Great Book!"));
        i.addNew(b4);
        CD cd1 = new CD(1000);
        caught = false;

        try
        {
            i.addNew(cd1);
        }
        catch(DuplicateProductIDException e5)
        {
            caught = true;
        }

        if(!caught)
        {
            System.out.println("\tFAILED: test5() #5");
            success = false;
        }

        BookOnTape bot1 = new BookOnTape(1003);
        caught = false;

        try
        {
            i.addNew(bot1);
        }
        catch(DuplicateProductIDException e6)
        {
            caught = true;
        }

        if(!caught)
        {
            System.out.println("\tFAILED: test5() #6");
            success = false;
        }

        i.addInventory(1000, 99);

        if(b1.getQuantity() != 99)
        {
            System.out.println("\tFAILED: test5() #7");
            success = false;
        }

        caught = false;

        try
        {
            i.addInventory(1000, -999);
        }
        catch(InsufficientProductException e7)
        {
            caught = true;
        }

        if(!caught)
        {
            System.out.println("\tFAILED: test5() #8");
            success = false;
        }

        if(b1.getQuantity() != 99)
        {
            System.out.println("\tFAILED: test5() #9");
            success = false;
        }
        
        return success;
    }
    
    /**
     * Tests the Inventory class's various find methods
     */
    private static boolean test6() throws DuplicateProductIDException, DuplicateProductException
    {
        boolean success = true;
        java.util.ArrayList list;
        Inventory i = new Inventory();

        System.out.println("test 6...");

        list = i.findBookOnTapeByReader(null, null, null);

        if(list.size() != 0)
        {
            System.out.println("\tFAILED: test6() #1");
            success = false;
        }

        Name name1 = new Name(new String("ReaderSmith"), new String("Sue"), new String("S"));
        Name name2 = new Name(new String("ReaderJones"), new String("John"), new String("J"));
        Name name3 = new Name(new String("ReaderJones"), new String("James"), new String("J"));
        Name name4 = new Name(new String("ReaderZed"), new String("Sue"), new String("J"));

        BookOnTape bot = new BookOnTape();
        bot.setReader(name1);
        i.addNew(bot);

        bot = new BookOnTape();
        bot.setReader(name2);
        i.addNew(bot);

        bot = new BookOnTape();
        bot.setReader(name3);
        i.addNew(bot);

        bot = new BookOnTape();
        bot.setReader(name4);
        i.addNew(bot);

        list = i.findBookOnTapeByReader(new String("ReaderSmith"),
                                        new String("Sue"),
                                        new String("S"));

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test6() #2");
            success = false;
        }

        if(!((BookOnTape)list.get(0)).getReader().equals(name1))
        {
            System.out.println("\tFAILED: test6() #3");
            success = false;
        }

        list = i.findBookOnTapeByReader(null, null, "J");

        if(list.size() != 3)
        {
            System.out.println("\tFAILED: test6() #4");
            success = false;
        }

        list = i.findBookOnTapeByReader(new String("ReaderJones"), null, null);

        if(list.size() != 2)
        {
            System.out.println("\tFAILED: test6() #5");
            success = false;
        }

        list = i.findBookOnTapeByReader(null, new String("Sue"), null);

        if(list.size() != 2)
        {
            System.out.println("\tFAILED: test6() #6");
            success = false;
        }

        CD cd = new CD();
        cd.setArtist(name1);
        cd.setTitle(new String("Legend"));
        i.addNew(cd);

        cd = new CD();
        cd.setArtist(name2);
        cd.setTitle(new String("Rust Never Sleeps"));
        i.addNew(cd);

        cd = new CD();
        cd.setArtist(name3);
        cd.setTitle(new String("The Wall"));
        i.addNew(cd);

        cd = new CD();
        cd.setArtist(name4);
        cd.setTitle(new String("Sketches of Spain"));
        i.addNew(cd);

        list = i.findCDsByArtist(new String("ReaderSmith"), new String("Sue"), new String("S"));

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test6() #7");
            success = false;
        }

        if(!(list.get(0) instanceof CD))
        {
            System.out.println("\tFAILED: test6() #8");
            success = false;
        }

        if(!((CD)list.get(0)).getArtist().equals(name1))
        {
            System.out.println("\tFAILED: test6() #9");
            success = false;
        }

        list = i.findCDsByArtist(null, null, new String("J"));

        if(list.size() != 3)
        {
            System.out.println("\tFAILED: test6() #10");
            success = false;
        }

        list = i.findCDsByArtist(new String("ReaderJones"), null, null);

        if(list.size() != 2)
        {
            System.out.println("\tFAILED: test6() #11");
            success = false;
        }

        list = i.findCDsByArtist(null, new String("Sue"), null);

        if(list.size() != 2)
        {
            System.out.println("\tFAILED: test6() #12");
            success = false;
        }

        Book b = new Book();
        b.setAuthor(name1);
        b.setTitle(new String("War and Peace"));
        i.addNew(b);

        b = new Book();
        b.setAuthor(name2);
        b.setTitle(new String("One Flew Over the CooCoo's Nest"));
        i.addNew(b);

        b = new Book();
        b.setAuthor(name3);
        b.setTitle(new String("Electric Koolaid Acid Trip"));
        i.addNew(b);

        b = new Book();
        b.setAuthor(name4);
        b.setTitle(new String("The Razor's Edge"));
        i.addNew(b);

        list = i.findBooksByAuthor(new String("ReaderSmith"), new String("Sue"), new String("S"));

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test6() #13");
            success = false;
        }

        if(!(list.get(0) instanceof Book))
        {
            System.out.println("\tFAILED: test6() #14");
            success = false;
        }

        if(!((Book)list.get(0)).getAuthor().equals(name1))
        {
            System.out.println("\tFAILED: test6() #15");
            success = false;
        }

        list = i.findBooksByAuthor(null, null, new String("J"));

        if(list.size() != 3)
        {
            System.out.println("\tFAILED: test6() #16");
            success = false;
        }

        list = i.findBooksByAuthor(new String("ReaderJones"), null, null);

        if(list.size() != 2)
        {
            System.out.println("\tFAILED: test6() #17");
            success = false;
        }

        list = i.findBooksByAuthor(null, new String("Sue"), null);

        if(list.size() != 2)
        {
            System.out.println("\tFAILED: test6() #18");
            success = false;
        }

        list = i.findCDsByTitle("Sketches of Spain");

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test6() #19");
            success = false;
        }

        list = i.findCDsByTitle(new String("Blah"));

        if(list.size() != 0)
        {
            System.out.println("\tFAILED: test6() #20");
            success = false;
        }

        list = i.findBooksByTitle(new String("War and Peace"));

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test6() #21");
            success = false;
        }

        list = i.findCDsByTitle(new String("Blah"));

        if(list.size() != 0)
        {
            System.out.println("\tFAILED: test6() #22");
            success = false;
        }
        
        return success;
    }

    private static boolean test7() throws DuplicateProductIDException, DuplicateProductException
    {
        boolean success = true;
        Inventory i1 = new Inventory();
        Inventory i2 = new Inventory();

        System.out.println("test 7...");

        if(!i1.equals(i1))
        {
            System.out.println("\tFAILED: test7() #1");
            success = false;
        }

        if(!i1.equals(i2) || !i2.equals(i1))
        {
            System.out.println("\tFAILED: test7() #2");
            success = false;
        }

        i1.addNew(new Book(798));

        if(i1.equals(i2) || i2.equals(i1))
        {
            System.out.println("\tFAILED: test7() #3");
            success = false;
        }

        i2.addNew(new Book(798));

        if(!i1.equals(i2) || !i2.equals(i1))
        {
            System.out.println("\tFAILED: test7() #4");
            success = false;
        }

        i1.addNew(new BookOnTape(799));

        if(i1.equals(i2) || i2.equals(i1))
        {
            System.out.println("\tFAILED: test7() #5");
            success = false;
        }

        i2.addNew(new BookOnTape(799));

        if(!i1.equals(i2) || !i2.equals(i1))
        {
            System.out.println("\tFAILED: test7() #6");
            success = false;
        }

        i1.addNew(new CD(800));
        i2.addNew(new CD(800));

        if(!i1.equals(i2) || !i2.equals(i1))
        {
            System.out.println("\tFAILED: test7() #7");
            success = false;
        }

        CD cd = new CD(801);
        cd.setArtist(new Name(new String("Dylan"), new String("Bob"), new String("")));

        Book bk = new Book(802);
        bk.setTitle(new String("Electric Kool-Aid Acid Test"));

        i1.addNew(cd);
        i1.addNew(bk);

        i2.addNew(bk);
        i2.addNew(cd);

        if(!i1.equals(i2) && !i2.equals(i1))
        {
            System.out.println("\tFAILED: test7() #8");
            success = false;
        }
        
        return success;
    }

    private static boolean test8() throws DuplicateProductIDException, DuplicateProductException
    {
        boolean success = true;

        Inventory i = new Inventory();

        System.out.println("test 8...");

        Book bk = new Book(800);

        if(i.contains(800) != null)
        {
            System.out.println("\tFAILED: test8() #1");
            success = false;
        }

        i.addNew(bk);

        if(i.contains(800) == null)
        {
            System.out.println("\tFAILED: test8() #2");
            success = false;
        }

        BookOnTape bot = new BookOnTape(801);

        if(i.contains(801) != null)
        {
            System.out.println("\tFAILED: test8() #3");
            success = false;
        }

        i.addNew(bot);

        if(i.contains(801) == null)
        {
            System.out.println("\tFAILED: test8() #4");
            success = false;
        }

        CD cd = new CD(802);
        i.addNew(cd);

        if(i.contains(800) == null)
        {
            System.out.println("\tFAILED: test8() #5");
            success = false;
        }

        if(i.contains(801) == null)
        {
            System.out.println("\tFAILED: test8() #6");
            success = false;
        }

        if(i.contains(802) == null)
        {
            System.out.println("\tFAILED: test8() #7");
            success = false;
        }

        if(i.contains(899) != null)
        {
            System.out.println("\tFAILED: test8() #8");
            success = false;
        }
        
        return success;
    }

    private static boolean test9() throws
     DuplicateProductIDException,
     DuplicateProductException,
     IOException
    {
        boolean success = true;
        int[] dups = {1000, 1020, 4009, 4010, 4011};
        Inventory i1 = new Inventory();
        String fileName = "YourInventory.txt";

        System.out.println("test 9...");

        // Make some products
        for(int i = 0; i < 10; i++)
        {
            i1.addNew(makeABook(1000 + i, false));
        }

        // Make some products
        for(int i = 0; i < 10; i++)
        {
            i1.addNew(makeABookOnTape(2000 + i, false));
        }

        // Make some products
        for(int i = 0; i < 10; i++)
        {
            i1.addNew(makeACD(3000 + i, false));
        }

        i1.writeInventory(fileName, '/');

        // Check for the file's existence...
        if(!(new File(fileName)).exists())
        {
            System.out.println("\tFAILED: test9() #1");
            success = false;
        }

        Inventory i2 = new Inventory();

        i2.addNew(fileName, '/');

        if(!i1.equals(i2))
        {
            System.out.println("\tFAILED: test9() #2");
            success = false;
        }
        
        // Read in inventory again, this time changing iventory
        i2.addInventory(fileName, '/');

        if(!i1.equals(i2))
        {
            System.out.println("\tFAILED: test9() #3");
            success = false;
        }

        // Check some quantities...
        Book book = makeABook(1005, false);

        ArrayList list = i2.findBooksByTitle(book.getTitle());

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test9() #4");
            success = false;
        }

        if(((Book)list.get(0)).getQuantity() != book.getQuantity() * 2)
        {
            System.out.println("\tFAILED: test9() #5");
            success = false;
        }

        // Check some quantities...
        BookOnTape bot = makeABookOnTape(2007, false);

        list = i2.findBookOnTapeByReader(bot.getReader().getLast(),
                                         bot.getReader().getFirst(),
                                         bot.getReader().getMiddle());

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test9() #6");
            success = false;
        }

        if(((BookOnTape)list.get(0)).getQuantity() != bot.getQuantity() * 2)
        {
            System.out.println("\tFAILED: test9() #7");
            success = false;
        }

        // Check some quantities...
        CD cd = makeACD(3009, false);

        list = i2.findCDsByTitle(cd.getTitle());

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test9() #8");
            success = false;
        }

        if(((CD)list.get(0)).getQuantity() != cd.getQuantity() * 2)
        {
            System.out.println("\tFAILED: test9() #9");
            success = false;
        }

        // Read some product that decrements quantity successfully
        list = i2.addInventory("GoodNegativeQuantities.txt", ',');

        if(list.size() != 0)
        {
            System.out.println("\tFAILED: test9() #10");
            success = false;
        }

        // Check some quantities...
        book = makeABook(1000, false);

        list = i2.findBooksByTitle(book.getTitle());

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test9() #11");
            success = false;
        }

        if(((Book)list.get(0)).getQuantity() != 1900)
        {
            System.out.println("\tFAILED: test9() #12");
            success = false;
        }

        // Check some quantities...
        bot = makeABookOnTape(2000, false);

        list = i2.findBookOnTapeByReader(bot.getReader().getLast(),
                                         bot.getReader().getFirst(),
                                         bot.getReader().getMiddle());

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test9() #13");
            success = false;
        }

        if(((BookOnTape)list.get(0)).getQuantity() != 3800)
        {
            System.out.println("\tFAILED: test9() #14");
            success = false;
        }

        // Check some quantities...
        cd = makeACD(3000, false);

        list = i2.findCDsByTitle(cd.getTitle());

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test9() #15");
            success = false;
        }

        if(((CD)list.get(0)).getQuantity() != 5700)
        {
            System.out.println("\tFAILED: test9() #16");
            success = false;
        }

        // Check some quantities...
        book = makeABook(1001, false);

        list = i2.findBooksByTitle(book.getTitle());

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test9() #17");
            success = false;
        }

        if(((Book)list.get(0)).getQuantity() != 0)
        {
            System.out.println("\tFAILED: test9() #18");
            success = false;
        }

        // Check some quantities...
        bot = makeABookOnTape(2001, false);

        list = i2.findBookOnTapeByReader(bot.getReader().getLast(),
                                         bot.getReader().getFirst(),
                                         bot.getReader().getMiddle());

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test9() #19");
            success = false;
        }

        if(((BookOnTape)list.get(0)).getQuantity() != 0)
        {
            System.out.println("\tFAILED: test9() #20");
            success = false;
        }

        // Check some quantities...
        cd = makeACD(3001, false);

        list = i2.findCDsByTitle(cd.getTitle());

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test9() #21");
            success = false;
        }

        if(((CD)list.get(0)).getQuantity() != 0)
        {
            System.out.println("\tFAILED: test9() #22");
            success = false;
        }

        // Read products that will cause an InsufficientProductException
        list = i2.addInventory("BadQuantityBook.txt", ',');

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test9() #23");
            success = false;
        }

        list = i2.addInventory("BadQuantityBookOnTape.txt", ',');

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test9() #24");
            success = false;
        }

        list = i2.addInventory("BadQuantityCD.txt", ',');

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test9() #25");
            success = false;
        }

        list = i2.addInventory("MissingProduct.txt", ',');

        if(list.size() != 1)
        {
            System.out.println("\tFAILED: test9() #26");
            success = false;
        }

        // Read a file that has duplicate products
        list = i2.addNew("Duplicates.txt", ',');

        if(list.size() != dups.length)
        {
            System.out.println("\tFAILED: test9() #27");
            success = false;
        }

        for(int i = 0; i < list.size(); i++)
        {
            Scanner scan = new Scanner((String)list.get(i));
            scan.useDelimiter(",");
            
            scan.next();
            int id = Integer.parseInt(scan.next().trim());

            if(id != dups[i])
            {
                System.out.println("\tFAILED: test9() #27 - Iteration " + i);
                success = false;
            }
        }
        
        return success;
    }

    private static boolean test10(Inventory inventory)
    {
        boolean success = true;

        System.out.println("test 10...");

        if(isSorted(inventory))
        {
            // This inventory should not be sorted -- very unlikely but an
            // extremely low possibility that it will be -- try running again.
            System.out.println("\tFAILED: test10() #1");
            success = false;
        }

        inventory.sort();

        if(!isSorted(inventory))
        {
            System.out.println("\tFAILED: test10() #2");
            success = false;

            // Your sort is not working, I'll use the Collections class sort so
            // I can test you contains method and equals later...
            //
            // MAKE SURE your getInventory method returns type ArrayList<Product>
            java.util.Collections.sort(inventory.getInventory());
        }
        
        return success;
    }

    private static boolean test11(Inventory inventory)
    {
        boolean success = true;

        int[] indices = {33, 124, 278, 391, 456, 789, 997};

        System.out.println("test 11...");

        // Grab a few random product Id's and make sure contains works
        for(int i = 0; i < indices.length; i++)
        {
            int pid = ((Product)inventory.getInventory().get(indices[i])).getProductID();

            if(inventory.contains(pid) == null)
            {
                System.out.println("\tFAILED: test11() #1");
                success = false;
            }
        }

        // Now check for non-existent values
        for(int i = 0; i < indices.length; i++)
        {
            int pid1 = ((Product)inventory.getInventory().get(indices[i])).getProductID();
            int pid2 = ((Product)inventory.getInventory().get(indices[i] + 1)).getProductID();
            int pid = (pid1 + pid2) / 2;

            if(pid1 == pid2)
            {
                System.out.println("\tFAILED: test11() #2 " 
                                 + "- There are duplicate product IDs in your inventory");
                System.out.println("\t        This was probably caused by your sort performed in"
                                 + " the prior test");
                success = false;
                break;
            }
           
            // Truncation of even + odd /2 could result in this when values are close
            if( pid == pid1 || pid == pid2 )
            {
                System.out.println("\tFAILED: test11() #3 " 
                                 + "- This Could be caused by unusual random testing data");
                System.out.println("\n\t  Try running again and notify your instructor"
                                 + " if the problem persists.");
                success = false;
                continue;
            }

            if(inventory.contains(pid) != null)
            {
                System.out.println("\tFAILED: test11() #3");
                success = false;
            }
        }
        
        return success;
    }

    private static boolean test12()
    {
        boolean success = true;

        System.out.println("test 12...");

        // Create two empty inventories and compare for equality
        Inventory i1 = new Inventory();
        Inventory i2 = new Inventory();

        // Compare the two inventories using the Inventory.equals() method.
        if(!i1.equals(i2) || !i2.equals(i1))
        {
            System.out.println("\tFAILED: test12() #1");
            success = false;
        }

        // Add the same product to each and check for equality
        Book book = new Book(200);

        try
        {
            i1.addNew(book);
            i2.addNew(book);
        }
        catch(Exception e)
        {
            System.out.println("\tFAILED: test12() #2");
            success = false;
        }

        // Compare the two inventories using the Inventory.equals() method.
        if(!i1.equals(i2) || !i2.equals(i1))
        {
            System.out.println("\tFAILED: test12() #3");
            success = false;
        }

        // Add some more product, in sorted order, and check for equality
        //
        // NOTE: This test assumes you are adding elements to the END of your
        //       Inventory in the order received (using ArrayList.add(Object)).
        BookOnTape bot = new BookOnTape(300);
        CD cd = new CD(400);

        try
        {
            i1.addNew(bot);
            i2.addNew(bot);

            i1.addNew(cd);
            i2.addNew(cd);
        }
        catch(Exception e)
        {
            System.out.println("\tFAILED: test12() #4");
            success = false;
        }

        // Compare the two inventories using the Inventory.equals() method.
        if(!i1.equals(i2) || !i2.equals(i1))
        {
            System.out.println("\tFAILED: test12() #5");
            success = false;
        }

        // Create a new inventory with the same products but in UNSORTED order.
        // Compare a.equals(b) and b.equals(a) and if either returns true
        // everything is ok.  Must test both ways because I don't know which
        // inventory (this or that) the student has used to loop through.
        i2 = new Inventory();

        try
        {
            i2.addNew(bot);
            i2.addNew(cd);
            i2.addNew(book);
        }
        catch(Exception e)
        {
            System.out.println("\tFAILED: test12() #6");
            success = false;
        }

        // Compare the two inventories using the Inventory.equals() method.
        // i1 is ordered, i2 is not -- one of the tests below should be true!
        if(!i1.equals(i2) && !i2.equals(i1))
        {
            System.out.println("\tFAILED: test12() #7");
            success = false;
        }

        // Now sort the unsorted inventory and compare
        i2.sort();

        // Compare the two inventories using the Inventory.equals() method.
        // Both are ordered, both tests should be true!
        if(!i1.equals(i2) || !i2.equals(i1))
        {
            System.out.println("\tFAILED: test12() #8");
            success = false;
        }
        
        return success;
    }

    private static boolean test13(Inventory inventory) throws IOException //DELETE EXCEPTION
    {
        boolean success = true;

        System.out.println("test 13...");

        ArrayList list = inventory.getInventory();

        int sizeBefore = list.size();

        InventorySortA sortA = new InventorySortA();
        inventory.sort(sortA);
//MY TEST
inventory.writeInventory("test13.txt" , ',');

        if(sizeBefore != inventory.getInventory().size())
        {
            System.out.println("\tFAILED: test13() #1");
            success = false;
        }

        if(!isSortedA(inventory))
        {
            System.out.println("\tFAILED: test13() #2");
            success = false;
        }
        
        return success;
    }

    private static boolean test14(Inventory inventory) throws IOException //DELETE
    {
        boolean success = true;

        System.out.println("test 14...");

        ArrayList list = inventory.getInventory();
        int sizeBefore = list.size();

        InventorySortB sortB = new InventorySortB();
        inventory.sort(sortB);

//MY TEST
inventory.writeInventory("test14.txt" , ',');

        if(sizeBefore != inventory.getInventory().size())
        {
            System.out.println("\tFAILED: test14() #1");
            success = false;
        }

        if(!isSortedB(inventory))
        {
            System.out.println("\tFAILED: test14() #2");
            success = false;
        }
        
        return success;
    }


   private static Book makeABook(int i, boolean randomText)
   {
      String s = (new Integer(i)).toString();

      Book b = new Book(i);

      b.setQuantity(i);
      b.setDescription("Description " + s);
      b.setWholesalePrice(i + 0.11);
      b.setRetailPrice(i + 0.22);

      b.setTitle("Some Title " + s);
      b.setPublisher("Some Publisher " + s);

      if(randomText)
      {
         b.setAuthor(new Name("Author Last" + i % 183,
                              "Author First" + i % 219,
                              "Author Middle" + i % 177));
      }
      else
      {
         b.setAuthor(new Name("Author Last" + s, "Author First" + s, "Author Middle" + s));
      }

      b.setType(AbstractBook.NONFICTION);

      b.setPages(i);
      b.setBinding(Book.PAPERBACK);

      return b;
   }

   private static BookOnTape makeABookOnTape(int i, boolean randomText)
   {
      String s = (new Integer(i)).toString();
      BookOnTape b = new BookOnTape(i);

      b.setQuantity(i);
      b.setDescription("Description " + s);
      b.setWholesalePrice(i + 0.11);
      b.setRetailPrice(i + 0.22);

      b.setTitle("Some Title " + s);
      b.setPublisher("Some Publisher " + s);

      if(randomText)
      {
         b.setAuthor(new Name("Author Last" + i % 183,
                              "Author First" + i % 219,
                              "Author Middle" + i % 177));
         b.setReader(new Name("Reader Last" + i % 183,
                              "Reader First" + i % 219,
                              "Reader Middle" + i % 177));
      }
      else
      {
         b.setAuthor(new Name("Author Last" + s, "Author First" + s, "Author Middle" + s));
         b.setReader(new Name("Reader Last" + s, "Reader First" + s, "Reader Middle" + s));
      }
      b.setType(AbstractBook.NONFICTION);

      b.setLength(i);

      return b;
   }

   private static CD makeACD(int i, boolean randomText)
   {
      String s = (new Integer(i)).toString();
      CD b = new CD(i);

      b.setQuantity(i);
      b.setDescription("Description " + s);
      b.setWholesalePrice(i + 0.11);
      b.setRetailPrice(i + 0.22);

      b.setTitle("Some Title " + s);

      if(randomText)
      {
         b.setArtist(new Name("Artist Last" + i % 183, 
                              "Artist First" + i % 219,
                              "Artist Middle" + i % 177));
      }
      else
      {
         b.setArtist(new Name("Artist Last" + s, "Artist First" + s, "Artist Middle" + s));
      }
      return b;
   }

   private static Inventory makeARandomInventory(int size)
   {
      Random random = new Random();
      Inventory inventory = new Inventory();

      for(int i = 0; i < size; i++)
      {
         try
         {
            // Bound the productID's a bit to avoid problems with
            // compareTo() doing subtraction!
            int id = random.nextInt(500000000);

            if(i % 3 == 0)
            {
               inventory.addNew(makeABook(id, true));
            }
            else if(i % 3 == 1)
            {
               inventory.addNew(makeABookOnTape(id, true));
            }
            else
            {
               inventory.addNew(makeACD(id, true));
            }
         }
         catch(DuplicateProductIDException e1)
         {
            --i;
         }
         catch(DuplicateProductException e2)
         {
            --i;
         }
      }

      return inventory;
   }

   private static boolean isSorted(Inventory inventory)
   {
      ArrayList list = inventory.getInventory();
      Product p1 = (Product)list.get(0);

      for(int i = 1; i < list.size(); i++)
      {
         Product p2 = (Product)list.get(i);

         if(p1.getProductID() > p2.getProductID())
         {
            return false;
         }

         p1 = p2;
      }

      return true;
   }

   private static boolean isSortedA(Inventory inventory)
   {
      ArrayList list = inventory.getInventory();
      Product p1 = (Product)list.get(0);
      Product p2 = p1;

      for(int i = 1; i < list.size(); i++)
      {
         p1 = p2;
         p2 = (Product)list.get(i);

         int order = p1.getClass().getName().compareTo(p2.getClass().getName());

         if(order > 0)
         {
            return false;
         }

         if(order < 0)
         {
            continue;
         }

         // If we get here, p1 and p2 must be the same class type
         if(p1 instanceof Book)
         {
            order = ((Book)p1).getAuthor().getLast().compareTo(((Book)p2).getAuthor().getLast());

            if(order > 0)
            {
               return false;
            }

            if(order < 0)
            {
               continue;
            }

            order=((Book)p1).getAuthor().getFirst().compareTo(((Book)p2).getAuthor().getFirst());

            if(order > 0)
            {
               return false;
            }

            if(order < 0)
            {
               continue;
            }

            order=((Book)p1).getAuthor().getMiddle().compareTo(((Book)p2).getAuthor().getMiddle());

            if(order > 0)
            {
               return false;
            }

            if(order < 0)
            {
               continue;
            }
         }
         else if(p1 instanceof BookOnTape)
         {
            String r1 = ((BookOnTape)p1).getReader().getLast();
            String r2 = ((BookOnTape)p2).getReader().getLast();
            
            order = r1.compareTo(r2);

            if(order > 0)
            {
               return false;
            }

            if(order < 0)
            {
               continue;
            }

            r1 = ((BookOnTape)p1).getReader().getFirst();
            r2 = ((BookOnTape)p2).getReader().getFirst();

            order = r1.compareTo(r2);

            if(order > 0)
            {
               return false;
            }

            if(order < 0)
            {
               continue;
            }

            r1 = ((BookOnTape)p1).getReader().getMiddle();
            r2 = ((BookOnTape)p2).getReader().getMiddle();

            order = r1.compareTo(r2);

            if(order > 0)
            {
               return false;
            }

            if(order < 0)
            {
               continue;
            }
         }
         else if(p1 instanceof CD)
         {
            order = ((CD)p1).getArtist().getLast().compareTo(((CD)p2).getArtist().getLast());

            if(order > 0)
            {
               return false;
            }

            if(order < 0)
            {
               continue;
            }

            order = ((CD)p1).getArtist().getFirst().compareTo(((CD)p2).getArtist().getFirst());

            if(order > 0)
            {
               return false;
            }

            if(order < 0)
            {
               continue;
            }

            order = ((CD)p1).getArtist().getMiddle().compareTo(((CD)p2).getArtist().getMiddle());

            if(order > 0)
            {
               return false;
            }

            if(order < 0)
            {
               continue;
            }
         }
         else
         {
            // Should not be any of these...
            return false;
         }
      }

      return true;
   }

   private static boolean isSortedB(Inventory inventory)
   {
      ArrayList list = inventory.getInventory();
      Product p1 = (Product)list.get(0);
      Product p2 = p1;

      for(int i = 1; i < list.size(); i++)
      {
         p1 = p2;
         p2 = (Product)list.get(i);

         // Should be decending order on class name...
         int order = p1.getClass().getName().compareTo(p2.getClass().getName());

         if(order < 0)
         {
            return false;
         }

         if(order > 0)
         {
            continue;
         }

         // If we get here, p1 and p2 must be the same class type

         // Ascending order on product ID
         if(p1.getProductID() > p2.getProductID())
         {
            return false;
         }
      }

      return true;
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
   
   private static boolean test(boolean pass, int testNum)
   {
      if (!pass)
      {
         System.out.println("   FAILED test #" + testNum);
      }

      return pass;
   }

   private static boolean approx(double a, double b, double epsilon)
   {
      return Math.abs(a - b) < epsilon;
   }
   
   private static boolean verifyNames(Method[] methods, int modifier, String[] names)
   {
      boolean pass = true;
      Arrays.sort(names);
      
      for (Method m : methods)
      {
         if (m.getModifiers() == modifier)
         {
            if (Arrays.binarySearch(names, m.getName()) < 0)
            {
               System.out.print("      Class contains unspecified public ");
               System.out.println("method: " + m.getName());
               pass &= false;
            }
         }
      }
      
      return pass;
   }
   
   private static int countPackage(Field[] fields)
   {
      int cnt = fields.length
                - countModifiers(fields, Modifier.PRIVATE)
                - countModifiers(fields, Modifier.PROTECTED)
                - countModifiers(fields, Modifier.PUBLIC);

      // Adjust for students that have written assert statment(s) in their code
      // The package field specified below gets added to the .class file when
      // assert statements are present in the source.
      for (Field f : fields)
      {
         int mods = f.getModifiers();
         
         if (Modifier.isStatic(mods)
          && Modifier.isFinal(mods)
          && f.getName().equals("$assertionsDisabled"))
         {
            cnt--;
         }
      }
      
      return cnt;
   }
   
   private static boolean verifyEqualsMethodSignature(Class cl)
   {
      Method[] methods = cl.getDeclaredMethods();
      
      for (Method m : methods)
      {
         if (m.getName().equals("equals"))
         {
            Class<?>[] params = m.getParameterTypes();
            
            if (params.length != 1)
            {
               return false;
            }
            
            if (params[0] != Object.class)
            {
               return false;
            }
            
            return true;
         }
      }
      
      // Missing method, not found...
      return false;
   }
}
