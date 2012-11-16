/**
 * Test Driver for Project 4
 * @author Kurt Mammen
 */
import java.lang.reflect.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class P4TestDriver
{
   private static final String RESULTS_FOR = "Results for Program 4";

   public static void main(String[] args) throws ClassNotFoundException
   {
      boolean pass = true;
      
      printHeader(args);
      
      pass &= testBookArch();
      pass &= testBookOnTapeArch();
      pass &= testCDArch();
      pass &= testAbstractBookArch();
      pass &= testProductArch();
      pass &= testNameArch();
      pass &= testInventoryArch();
      
      pass &= testBook();
      pass &= testBookOnTape();
      pass &= testCD();
      pass &= testInventoryAdds();
      pass &= testInventoryFinds();
      
      printResults(pass);
      
      // Added for to support robust script checking
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
                        "equals"};

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
      int assertAdjustment = assertAdjustment(cl.getDeclaredFields());
      
      cnt = cl.getDeclaredFields().length
          - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE)
          - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED)
          - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC)
          - assertAdjustment;
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
                        "getFormat", "setFormat", "equals"};

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
      int assertAdjustment = assertAdjustment(cl.getDeclaredFields());
      
      cnt = cl.getDeclaredFields().length
          - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE)
          - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED)
          - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC)
          - assertAdjustment;
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
                        "equals"};

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
      int assertAdjustment = assertAdjustment(cl.getDeclaredFields());
      
      cnt = cl.getDeclaredFields().length
          - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE)
          - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED)
          - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC)
          - assertAdjustment;
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
                        "setType", "equals"};

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
      int assertAdjustment = assertAdjustment(cl.getDeclaredFields());
      
      cnt = cl.getDeclaredFields().length
          - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE)
          - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED)
          - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC)
          - assertAdjustment;
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
      pass &= test(temp.length == 0, test++);

      String[] names = {"getQuantity", "setQuantity", "getProductID",
                        "getDescription", "setDescription", "getWholesalePrice",
                        "setWholesalePrice", "getRetailPrice", "setRetailPrice",
                        "equals"};

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
      int assertAdjustment = assertAdjustment(cl.getDeclaredFields());
      
      cnt = cl.getDeclaredFields().length
          - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE)
          - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED)
          - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC)
          - assertAdjustment;
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

      String[] names = {"getFirst", "getMiddle", "getLast",
                        "match", "equals"};

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
      int assertAdjustment = assertAdjustment(cl.getDeclaredFields());
      
      cnt = cl.getDeclaredFields().length
          - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE)
          - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED)
          - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC)
          - assertAdjustment;
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

      String[] names = {"addNew", "addInventory", "findBooksByAuthor",
                        "findBooksByTitle", "findCDsByArtist",
                        "findCDsByTitle", "findBookOnTapeByReader" };

      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
      pass &= test(cnt == names.length, test++);
      pass &= test(verifyNames(cl.getDeclaredMethods(), Modifier.PUBLIC, names), test++);
      
      cnt = cl.getFields().length;
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      pass &= test(cnt == 1, test++);
      
      // Count and test number of of PACKAGE fields
      int assertAdjustment = assertAdjustment(cl.getDeclaredFields());
      
      cnt = cl.getDeclaredFields().length
          - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE)
          - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED)
          - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC)
          - assertAdjustment;
      pass &= test(cnt == 0, test++);
      
      return pass;
   }

   /**
    * Tests the Book class and all of its super classes
    */
   private static boolean testBook()
   {
      Book b1 = new Book();
      Book b2 = new Book();

      String description1 = new String("xyz");
      String description2 = new String("xyz");

      int quantity = 11;
      double wholesalePrice = 8.50;
      double retailPrice = 16.99;

      String title1 = new String("Big Rock Candy Mountain");
      String publisher1 = new String("Simon & Schuster");
      String title2 = new String("Big Rock Candy Mountain");
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

      System.out.println("Book tests...");

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
   private static boolean testBookOnTape()
   {
      boolean success = true;

      BookOnTape b1 = new BookOnTape();
      BookOnTape b2 = new BookOnTape();

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

      Name name1 = new Name(new String("Nemoi"), new String("Leonard"), new String("Hmmmm"));
      Name name2 = new Name(new String("Nemoi"), new String("Leonard"), new String("Hmmmm"));

      int length = 120;
      int format1 = BookOnTape.CD;
      int format2 = BookOnTape.DVD;
      int format3 = BookOnTape.TAPE;

      b1.setReader(name1);
      b2.setReader(name2);

      b1.setLength(length);
      b2.setLength(length);

      b1.setFormat(format1);
      b2.setFormat(format1);

      System.out.println("BookOnTape tests...");

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

      if(!b1.getReader().equals(name2))
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

      b2.setReader(name2);
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
   private static boolean testCD()
   {
      boolean success = true;

      CD c1 = new CD();
      CD c2 = new CD();

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

      Name name1 = new Name(new String("Nemoi"), new String("Leonard"), new String("Hmmmm"));
      Name name2 = new Name(new String("Nemoi"), new String("Leonard"), new String("Hmmmm"));

      String title1 = new String(new String("Spock Sings the Blues"));
      String title2 = new String(new String("Spock Sings the Blues"));

      c1.setArtist(name1);
      c2.setArtist(name2);

      c1.setTitle(title1);
      c2.setTitle(title2);

      System.out.println("CD tests...");

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

      if(!c1.getArtist().equals(name1))
      {
         System.out.println("\tFAILED: test4() #5");
         success = false;
      }

      if(!c1.getTitle().equals(title1))
      {
         System.out.println("\tFAILED: test4() #6");
         success = false;
      }

        c2.setArtist(new Name( new String("a"), new String("b"), new String("c")));

      if(c1.equals(c2))
      {
         System.out.println("\tFAILED: test4() #8");
         success = false;
      }

      c2.setArtist(name2);
        c2.setTitle(new String("zzzz"));

      if(c1.equals(c2))
      {
         System.out.println("\tFAILED: test4() #9");
         success = false;
      }

      c2.setTitle(title2);

      if(!c1.equals(c2))
      {
         System.out.println("\tFAILED: test4() #10");
         success = false;
      }

      if(c1.getProductID() != 100006)
      {
         System.out.println("\tFAILED: test4() #11");
         success = false;
      }

      if(c2.getProductID() != 100007)
      {
         System.out.println("\tFAILED: test4() #12");
         success = false;
      }

      CD c3 = new CD(99);
      CD c4 = new CD(99);

      if(!c3.equals(c4))
      {
         System.out.println("\tFAILED: test4() #13");
         success = false;
      }

      if(c3.getProductID() != 99)
      {
         System.out.println("\tFAILED: test4() #14");
         success = false;
      }

      // Test added Spring 2004
      c3.setDescription(null);
      c3.setTitle(null);

      if(!c3.equals(c4))
      {
         System.out.println("\tFAILED: test4() #15");
         success = false;
      }

      // Test added Spring 2004
      c4.setDescription(null);
      c4.setTitle(null);

      if(!c3.equals(c4))
      {
         System.out.println("\tFAILED: test4() #16");
         success = false;
      }

      CD c5 = new CD();

      if(c5.getProductID() != 100008)
      {
         System.out.println("\tFAILED: test4() #17");
         success = false;
      }

      return success;
   }

   /**
    * Tests the Inventory class's addNew() and addInventory() methods
    */
   private static boolean testInventoryAdds()
   {
      boolean success = true;

      Inventory i = new Inventory();

      Book b1 = new Book(1000);
      Book b2 = new Book(1000);

      System.out.println("Inventory add-method tests...");

      if(!i.addNew(b1))
      {
         System.out.println("\tFAILED: test5() #1");
         success = false;
      }

      if(i.addNew(b1))
      {
         System.out.println("\tFAILED: test5() #2");
         success = false;
      }

      if(i.addNew(b2))
      {
         System.out.println("\tFAILED: test5() #3");
         success = false;
      }

        b2.setDescription(new String("Great Book!"));

      if(i.addNew(b2))
      {
         System.out.println("\tFAILED: test5() #4");
         success = false;
      }

      Book b3 = new Book(1003);
      b3.setPages(9);

      if(!i.addNew(b3))
      {
         System.out.println("\tFAILED: test5() #5");
         success = false;
      }

        String s3 = new String(new String("Great Book!"));
      b3.setDescription(s3);

      Book b4 = new Book(1004);
      b4.setPages(9);
        String s4 = new String(new String("Great Book!"));
      b4.setDescription(s4);

      if(i.addNew(b4))
      {
         System.out.println("\tFAILED: test5() #6");
         success = false;
      }

      b4.setDescription(new String("Really Great Book!"));

      if(!i.addNew(b4))
      {
         System.out.println("\tFAILED: test5() #7");
         success = false;
      }

      CD cd1 = new CD(1000);

      if(i.addNew(cd1))
      {
         System.out.println("\tFAILED: test5() #8");
         success = false;
      }

      BookOnTape bot1 = new BookOnTape(1003);

      if(i.addNew(bot1))
      {
         System.out.println("\tFAILED: test5() #9");
         success = false;
      }

      if(!i.addInventory(1000, 99))
      {
         System.out.println("\tFAILED: test5() #10");
         success = false;
      }

      if(b1.getQuantity() != 99)
      {
         System.out.println("\tFAILED: test5() #11");
         success = false;
      }

      if(i.addInventory(1000, -999))
      {
         System.out.println("\tFAILED: test5() #12");
         success = false;
      }

      if(b1.getQuantity() != 99)
      {
         System.out.println("\tFAILED: test5() #13");
         success = false;
      }

      if(i.addInventory(1111, 1))
      {
         System.out.println("\tFAILED: test5() #14");
         success = false;
      }

      return success;
   }

   /**
    * Tests the Inventory class's various find methods
    */
   private static boolean testInventoryFinds()
   {
      boolean success = true;
      Inventory i = new Inventory();

      System.out.println("Inventory find-method tests...");

      ArrayList<BookOnTape> botList = i.findBookOnTapeByReader(null, null, null);

      if(botList.size() != 0)
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

      botList = i.findBookOnTapeByReader(new String("ReaderSmith"),
                                         new String("Sue"),
                                         new String("S"));

      if(botList.size() != 1)
      {
         System.out.println("\tFAILED: test6() #2");
         success = false;
      }
      
      if(!botList.get(0).getReader().equals(name1))
      {
         System.out.println("\tFAILED: test6() #3");
         success = false;
      }

      botList = i.findBookOnTapeByReader(null, null, new String("J"));

      if(botList.size() != 3)
      {
         System.out.println("\tFAILED: test6() #4");
         success = false;
      }

      botList = i.findBookOnTapeByReader(new String("ReaderJones"), null, null);

      if(botList.size() != 2)
      {
         System.out.println("\tFAILED: test6() #5");
         success = false;
      }

      botList = i.findBookOnTapeByReader(null, new String("Sue"), null);

      if(botList.size() != 2)
      {
         System.out.println("\tFAILED: test6() #6");
         success = false;
      }

      ArrayList<CD> cdList;
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

      cdList = i.findCDsByArtist(new String("ReaderSmith"), new String("Sue"), new String("S"));
      
      if(cdList.size() != 1)
      {
         System.out.println("\tFAILED: test6() #7");
         success = false;
      }

      if(!(cdList.get(0) instanceof CD))
      {
         System.out.println("\tFAILED: test6() #8");
         success = false;
      }

      if(!cdList.get(0).getArtist().equals(name1))
      {
         System.out.println("\tFAILED: test6() #9");
         success = false;
      }

      cdList = i.findCDsByArtist(null, null, new String("J"));

      if(cdList.size() != 3)
      {
         System.out.println("\tFAILED: test6() #10");
         success = false;
      }

      cdList = i.findCDsByArtist(new String("ReaderJones"), null, null);

      if(cdList.size() != 2)
      {
         System.out.println("\tFAILED: test6() #11");
         success = false;
      }

      cdList = i.findCDsByArtist(null, new String("Sue"), null);

      if(cdList.size() != 2)
      {
         System.out.println("\tFAILED: test6() #12");
         success = false;
      }

      ArrayList<Book> bList;
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
      b.setTitle(new String("Electric Koolaid Acid Test"));
      i.addNew(b);

      b = new Book();
      b.setAuthor(name4);
      b.setTitle(new String("The Razor's Edge"));
      i.addNew(b);

      bList = i.findBooksByAuthor(new String("ReaderSmith"), new String("Sue"), new String("S"));

      if(bList.size() != 1)
      {
         System.out.println("\tFAILED: test6() #13");
         success = false;
      }

      if(!(bList.get(0) instanceof Book))
      {
         System.out.println("\tFAILED: test6() #14");
         success = false;
      }

      if(!bList.get(0).getAuthor().equals(name1))
      {
         System.out.println("\tFAILED: test6() #15");
         success = false;
      }

      bList = i.findBooksByAuthor(null, null, new String("J"));

      if(bList.size() != 3)
      {
         System.out.println("\tFAILED: test6() #16");
         success = false;
      }

      bList = i.findBooksByAuthor(new String("ReaderJones"), null, null);

      if(bList.size() != 2)
      {
         System.out.println("\tFAILED: test6() #17");
         success = false;
      }

      bList = i.findBooksByAuthor(null, new String("Sue"), null);

      if(bList.size() != 2)
      {
         System.out.println("\tFAILED: test6() #18");
         success = false;
      }

      cdList = i.findCDsByTitle(new String("Sketches of Spain"));

      if(cdList.size() != 1)
      {
         System.out.println("\tFAILED: test6() #19");
         success = false;
      }

      cdList = i.findCDsByTitle(new String("Blah"));

      if(cdList.size() != 0)
      {
         System.out.println("\tFAILED: test6() #20");
         success = false;
      }

      bList = i.findBooksByTitle(new String("War and Peace"));

      if(bList.size() != 1)
      {
         System.out.println("\tFAILED: test6() #21");
         success = false;
      }

      cdList = i.findCDsByTitle(new String("Blah"));

      if(cdList.size() != 0)
      {
         System.out.println("\tFAILED: test6() #22");
         success = false;
      }

      return success;
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
   
   private static int assertAdjustment(Field[] fields)
   {
      int adjustment = 0;
      
      for (Field f : fields)
      {
         int mods = f.getModifiers();
         
         if (Modifier.isStatic(mods)
          && Modifier.isFinal(mods)
          && f.getName().equals("$assertionsDisabled"))
         {
            adjustment++;
         }
      }
      
      return adjustment;
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
