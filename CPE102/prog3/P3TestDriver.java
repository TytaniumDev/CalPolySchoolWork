import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.lang.reflect.*;
import java.util.Arrays;

public class P3TestDriver
{
   private static final String RESULTS_FOR = "Results for Program 3";

   public static void main(String[] args) throws ClassNotFoundException
   {
      boolean pass = true;
      
      printHeader(args);
      
      // Architecture tests...
      pass &= testAbstractShapeArch();
      pass &= testCircleArch();
      pass &= testRectangleArch();
      pass &= testSquareArch();
      pass &= testTriangleArch();
      pass &= testConvexPolygonArch();
      pass &= testCanvasArch();
      
      // Unit Tests...
      pass &= testCircle();
      pass &= testRectangle();
      pass &= testSquare();
      pass &= testTriangle();
      pass &= testConvexPolygon();
      pass &= testCanvas();
      pass &= testCompareTo();
      
      printResults(pass);
      
      // Added for to support robust script checking
      if (!pass)
      {
         System.exit(-1);
      }
   }

   private static boolean testAbstractShapeArch() throws ClassNotFoundException
   {
      boolean pass = true;
      int test = 1;
      int cnt;
      Circle circle;
      Class cl;
      Class[] temp;
      
      System.out.println("AbstractShape architecture tests...");
      
      cl = Class.forName("AbstractShape");
      
      pass &= test(Modifier.isAbstract(cl.getModifiers()), test++);
      pass &= test(cl.getConstructors().length == 1, test++);
      
      temp = cl.getInterfaces();
      pass &= test(temp.length == 1, test++);
      pass &= test(temp[0].getName().equals("java.lang.Comparable"), test++);

      String[] names = {"equals", "getColor", "setColor", "getFilled",
                        "setFilled", "compareTo"};

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
      cnt = cl.getDeclaredFields().length
          - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE)
          - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED)
          - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC);
      pass &= test(cnt == 0, test++);
      
      return pass;
   }
   
   private static boolean testCircleArch()
   {
      boolean pass = true;
      int test = 1;
      int cnt;
      Circle circle;
      Class cl;
      Class[] temp;
      
      System.out.println("Circle architecture tests...");
      
      circle = new Circle(5.6789, new Point(-99, 66), Color.cyan, false);
      
      cl = circle.getClass();

      pass &= test(cl.getConstructors().length == 1, test++);
      pass &= test(circle instanceof AbstractShape, test++);
      
      String[] names = {"equals", "getRadius", "setRadius", "getPosition",
                        "move", "getArea"};

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
      cnt = cl.getDeclaredFields().length
          - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE)
          - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED)
          - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC);
      pass &= test(cnt == 0, test++);
    
      return pass;
   }

   private static boolean testRectangleArch()
   {
      boolean pass = true;
      int test = 1;
      int cnt;
      Rectangle rect;
      Class cl;
      Class[] temp;
      
      System.out.println("Rectangle architecture tests...");
      
      rect = new Rectangle(4.3, 5.6, new Point(-99, 66), Color.cyan, false);
      
      cl = rect.getClass();

      pass &= test(cl.getConstructors().length == 1, test++);     
      pass &= test(rect instanceof AbstractShape, test++);

      String[] names = {"equals", "getWidth", "setWidth", "getHeight",
                        "setHeight", "getPosition", "move", "getArea"};

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
      cnt = cl.getDeclaredFields().length
          - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE)
          - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED)
          - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC);
      pass &= test(cnt == 0, test++);

      return pass;
   }

   private static boolean testSquareArch()
   {
      boolean pass = true;
      int test = 1;
      int cnt;
      Square rect;
      Class cl;
      Class[] temp;
      
      System.out.println("Square architecture tests...");
      
      rect = new Square(5, new Point(-99, 66), Color.cyan, false);
      
      cl = rect.getClass();
      pass &= test(cl.getConstructors().length == 1, test++);
      
      pass &= test(rect instanceof AbstractShape, test++);
      pass &= test(rect instanceof Rectangle, test++);
      
      String[] names = {"setWidth","setHeight"};
      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
      pass &= test(cnt == names.length, test++);
      pass &= test(verifyNames(cl.getDeclaredMethods(), Modifier.PUBLIC, names), test++);
      
      cnt = cl.getFields().length;
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      pass &= test(cnt == 0, test++);
      
      // Count and test number of of PACKAGE fields
      cnt = cl.getDeclaredFields().length
          - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE)
          - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED)
          - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC);
      pass &= test(cnt == 0, test++);
         
      return pass;
   }
   
   private static boolean testTriangleArch()
   {
      boolean pass = true;
      int test = 1;
      int cnt;
      Triangle tri;
      Class cl;
      Class[] temp;
      
      System.out.println("Triangle architecture tests...");

      Point a = new Point(0, 0);
      Point b = new Point(3, 0);
      Point c = new Point(0, 4);      
      tri = new Triangle(a, b, c, Color.cyan, false);

      cl = tri.getClass();
      pass &= test(cl.getConstructors().length == 1, test++);
      
      pass &= test(tri instanceof AbstractShape, test++);
      
      // Handle two reasonable decisions the students might make about getArea method.
      // Added Fall 2008
      String[] namesSeparate = {"getVertexA", "getVertexB", "getVertexC",
                                "setVertexA", "setVertexB", "setVertexC", "getArea"};

      String[] namesShared = {"getVertexA", "getVertexB", "getVertexC",
                              "setVertexA", "setVertexB", "setVertexC"};

      String[] names = namesSeparate;                             
      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);
     
      if (cnt == namesShared.length)
      {
         names = namesShared;
      }
              
      pass &= test(cnt == names.length, test++);
      pass &= test(verifyNames(cl.getDeclaredMethods(), Modifier.PUBLIC, names), test++);
      
      cnt = cl.getFields().length;
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      pass &= test(cnt == 0, test++);
      
      // Count and test number of of PACKAGE fields
      cnt = cl.getDeclaredFields().length
          - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE)
          - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED)
          - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC);
      pass &= test(cnt == 0, test++);

      return pass;
   }

   private static boolean testConvexPolygonArch()
   {
      boolean pass = true;
      int test = 1;
      int cnt;
      ConvexPolygon poly;
      Class cl;
      Class[] temp;
      
      System.out.println("ConvexPolygon architecture tests...");

      Point a = new Point(7, 7);
      Point b = new Point(0, 9);
      Point c = new Point(-3, -5);
      Point d = new Point(2, -6);
      Point e = new Point(12, 0);
      Point[] vertices = new Point[5];
      vertices[0] = a;
      vertices[1] = b;
      vertices[2] = c;
      vertices[3] = d;
      vertices[4] = e;
   
      poly = new ConvexPolygon(vertices, Color.cyan, false);

      // Deep copy made?
      a.x = b.x = c.x = d.x = e.x = 0;
      a.y = b.y = c.y = d.y = e.y = 0;
      
      cl = poly.getClass();
      pass &= test(cl.getConstructors().length == 1, test++);
      
      pass &= test(poly instanceof AbstractShape, test++);
      
      String[] names = {"getVertex", "setVertex", "equals", "getArea", "move"};
      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
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
      cnt = cl.getDeclaredFields().length
          - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE)
          - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED)
          - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC);
      pass &= test(cnt == 0, test++);
         
      return pass;
   }
   
   private static boolean testCanvasArch()
   {
      boolean pass = true;
      int test = 1;
      int cnt;
      Canvas canvas;
      Class cl;
      Class[] temp;
      
      System.out.println("Canvas architecture tests...");

      canvas = new Canvas();
      
      cl = canvas.getClass();
      pass &= test(cl.getConstructors().length == 1, test++);
      
      String[] names = {"add", "remove", "get", "size", "getCircles",
                        "getRectangles", "getTriangles", "getConvexPolygons",
                        "getShapesByColor", "getAreaOfAllShapes"};
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
      cnt = cl.getDeclaredFields().length
          - countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE)
          - countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED)
          - countModifiers(cl.getDeclaredFields(), Modifier.PUBLIC);
      pass &= test(cnt == 0, test++);
         
      return pass;
   }

   private static boolean testCircle()
   {
      boolean pass = true;
      int test = 1;
      Circle circle;
      
      System.out.println("Circle tests...");
   
      Point pt = new Point(-99, 66);
      circle = new Circle(5.6789, pt, Color.cyan, false);
      
      // Deep copy made?
      pt.x = 0;
      pt.y = 0;
      
      pass &= test(approx(circle.getArea(), Math.PI*5.6789*5.6789, 0.000001), test++);
      pass &= test(circle.getColor().equals(Color.cyan), test++);

      circle.setColor(Color.black);
      
      pass &= test(circle.getColor().equals(Color.black), test++);
      pass &= test(!circle.getFilled(), test++);
      
      circle.setFilled(true);
      
      pass &= test(circle.getFilled(), test++);
      pass &= test(circle.getRadius() == 5.6789, test++);

      circle.setRadius(4.321);

      pass &= test(circle.getRadius() == 4.321, 7);
      pass &= test(approx(circle.getArea(), Math.PI*4.321*4.321, 0.000001), test++);
      pass &= test(circle.getPosition().equals(new Point(-99, 66)), test++);
      
      pt.x = -5;
      pt.y = -7;
      circle.move(pt);
      
      // Deep copy/move made?
      pt.x = 0;
      pt.y = 0;
     
      pass &= test(circle.getPosition().equals(new Point(-104, 59)), test++);
     
      // Deep get?
      pt = circle.getPosition();
      pt.x = pt.y = 0;
      pass &= test(circle.getPosition().equals(new Point(-104, 59)), test++);
      
      Circle circle2 = new Circle(4.321, new Point(-104, 59), Color.black, false);
      circle2.setFilled(true);

      pass &= test(circle.equals(circle2), test++);
      
      Circle circle3 = new Circle(4.3219, new Point(-104, 59), Color.black, false);

      pass &= test(!circle2.equals(circle3), test++);

      circle3 = new Circle(4.321, new Point(-104, 59), Color.red, false);

      pass &= test(!circle2.equals(circle3), test++);
 
      circle3 = new Circle(4.321, new Point(104, 59), Color.black, false);
     
      pass &= test(!circle2.equals(circle3), test++);                 
      pass &= test(!circle2.equals(null), test++);
      pass &= test(!circle2.equals(new String("Whatever")), test++);
      
      return pass;  
   }
   
   private static boolean testRectangle()
   {
      boolean pass = true;
      int test = 1;
      Rectangle rect;
      Point pt;
      
      System.out.println("Rectangle tests...");
   
      pt = new Point(-99, 66);
      rect = new Rectangle(4.3, 5.6, pt, Color.cyan, false);
      
      // Deep?
      pt.x = pt.y = 0;
      
      pass &= test(approx(rect.getArea(), 4.3 * 5.6, 0.000001), test++);
      pass &= test(rect.getColor().equals(Color.cyan), test++);
      
      rect.setColor(Color.black);
            
      pass &= test(rect.getColor().equals(Color.black), test++);
      pass &= test(!rect.getFilled(), test++);
      
      rect.setFilled(true);
      
      pass &= test(rect.getFilled(), test++);
      pass &= test(rect.getWidth() == 4.3, test++);
      pass &= test(rect.getHeight() == 5.6, test++);
      
      rect.setWidth(4.321);
      
      pass &= test(rect.getWidth() == 4.321, test++);
      
      rect.setHeight(89.21);
      
      pass &= test(rect.getHeight() == 89.21, test++);  
      pass &= test(approx(rect.getArea(), 4.321 * 89.21, 0.000001), test++);
      pass &= test(rect.getPosition().equals(new Point(-99, 66)), test++);
      
      pt = new Point(-5, -7);
      rect.move(pt);
      
      // Deep?
      pt.x = pt.y = 0;
      
      pt = rect.getPosition();
      pass &= test(pt.equals(new Point(-104, 59)), test++);
      
      // Deep?
      pt.x = pt.y = 0;
      pt = rect.getPosition();
      pass &= test(pt.equals(new Point(-104, 59)), test++);

      Rectangle rect2 = new Rectangle(4.321, 89.21, new Point(-104, 59), Color.black, false);
      rect2.setFilled(true);
      
      pass &= test(rect.equals(rect2), test++);

      Rectangle rect3 = new Rectangle(4.3219, 89.21, new Point(-104, 59), Color.black, false);
         
      pass &= test(!rect2.equals(rect3), test++);

      rect3 = new Rectangle(4.321, 89.219, new Point(-104, 59), Color.black, false);
      
      pass &= test(!rect2.equals(rect3), test++);   

      rect3 = new Rectangle(4.321, 89.21, new Point(-104, 59), Color.red, false);

      pass &= test(!rect2.equals(rect3), test++); 

      rect3 = new Rectangle(4.321, 89.21, new Point(104, 59), Color.black, false);

      pass &= test(!rect2.equals(rect3), test++);        
      pass &= test(!rect2.equals(null), test++);        
      pass &= test(!rect2.equals(new String("Whatever")), test++);        

      return pass;
   }
   
   private static boolean testSquare()
   {
      boolean pass = true;
      int test = 1;
      Square sq;
      
      System.out.println("Square tests...");
   
      sq = new Square(4.3, new Point(-99, 66), Color.cyan, false);
      
      pass &= test(approx(sq.getArea(), 4.3 * 4.3, 0.000001), test++);
      pass &= test(sq.getColor().equals(Color.cyan), test++);
      
      sq.setColor(Color.black);
            
      pass &= test(sq.getColor().equals(Color.black), test++);
      pass &= test(!sq.getFilled(), test++);
      
      sq.setFilled(true);
      
      pass &= test(sq.getFilled(), test++);
      pass &= test(sq.getWidth() == 4.3, test++);
      pass &= test(sq.getHeight() == 4.3, test++);
      
      sq.setWidth(4.321);
      
      pass &= test(sq.getWidth() == 4.321, test++);
      pass &= test(sq.getHeight() == 4.321, test++);
      
      sq.setHeight(89.21);
      
      pass &= test(sq.getHeight() == 89.21, test++);  
      pass &= test(sq.getWidth() == 89.21, test++);  
      pass &= test(approx(sq.getArea(), 89.21 * 89.21, 0.000001), test++);
      pass &= test(sq.getPosition().equals(new Point(-99, 66)), test++);
      
      sq.move(new Point(-5, -7));
      
      pass &= test(sq.getPosition().equals(new Point(-104, 59)), test++);

      Square sq2 = new Square(89.21, new Point(-104, 59),Color.black, true);
      
      pass &= test(sq.equals(sq2), test++);

      Square sq3 = new Square(89.21,new Point(-104, 59), Color.black, false);
         
      pass &= test(!sq2.equals(sq3), test++);

      sq3 = new Square(89.219,new Point(-104, 59), Color.black, false);
      
      pass &= test(!sq2.equals(sq3), test++);   

      sq3 = new Square(89.21, new Point(-104, 59), Color.red, false);

      pass &= test(!sq2.equals(sq3), test++); 

      sq3 = new Square(89.21, new Point(104, 59), Color.black, false);

      pass &= test(!sq2.equals(sq3), test++);        
      pass &= test(!sq2.equals(null), test++);        
      pass &= test(!sq2.equals(new String("Whatever")), test++);        

      return pass;
   }
   
   private static boolean testTriangle()
   {
      boolean pass = true;
      int test = 1;
      Triangle tri;
      Point a = new Point(0, 0);
      Point b = new Point(3, 0);
      Point c = new Point(0, 4);
      
      System.out.println("Triangle tests...");
 
      tri = new Triangle(c, b, a, Color.cyan, false);
      pass &= test(approx(tri.getArea(), 6.0, 0.000001), test++);
       
      tri = new Triangle(a, b, c, Color.cyan, false);
    
      pass &= test(approx(tri.getArea(), 6.0, 0.000001), test++);
      pass &= test(tri.getColor().equals(Color.cyan), test++);
   
      pass &= test(approx(tri.getArea(), 6.0, 0.000001), test++);

      tri.setColor(Color.black);

      pass &= test(tri.getColor().equals(Color.black), test++);
      pass &= test(!tri.getFilled(), test++);
      
      tri.setFilled(true);

      pass &= test(tri.getFilled(), test++);
      pass &= test(tri.getVertexA().equals(new Point(0, 0)), test++);
      pass &= test(tri.getVertexB().equals(new Point(3, 0)), test++);
      pass &= test(tri.getVertexC().equals(new Point(0, 4)), test++);
      
      a = new Point(7, -3);
      tri.setVertexA(a);
                  
      pass &= test(tri.getVertexA().equals(new Point(7, -3)), test++);
      
      b = new Point(13, 56);
      tri.setVertexB(b);
      
      pass &= test(tri.getVertexB().equals(new Point(13, 56)), test++);
      
      c = new Point(-3, 23);
      tri.setVertexC(c);
      
      pass &= test(tri.getVertexC().equals(new Point(-3, 23)), test++);
      pass &= test(approx(tri.getArea(), 373.0, 0.000001), test++);
      
      tri.move(new Point(-5, -7));

      pass &= test(tri.getVertexA().equals(new Point(2, -10)), test++);
      pass &= test(tri.getVertexB().equals(new Point(8, 49)), test++);
      pass &= test(tri.getVertexC().equals(new Point(-8, 16)), test++);
      
      a = new Point(2, -10);
      b = new Point(8, 49);
      c = new Point(-8, 16);
      
      Triangle tri2 = new Triangle(a, b, c, Color.black, false);
      tri2.setFilled(true);

      pass &= test(tri.equals(tri2), test++);

      Triangle tri3 = new Triangle(new Point(3, -9), b, c, Color.black, false);
      
      pass &= test(!tri2.equals(tri3), test++);      

      tri3 = new Triangle(a, new Point(7, 48), c, Color.black, false);
      
      pass &= test(!tri2.equals(tri3), test++);      

      tri3 = new Triangle(a, b, new Point(-7, 17), Color.black, false);
      
      pass &= test(!tri2.equals(tri3), test++);      

      tri3 = new Triangle(a, b, c, Color.red, false);
      
      pass &= test(!tri2.equals(tri3), test++);
      pass &= test(!tri2.equals(null), test++);      
      pass &= test(!tri2.equals(new String("Whatever")), test++);      

      return pass;  
   }
   
   private static boolean testConvexPolygon()
   {
      boolean pass = true;
      int test = 1;
      ConvexPolygon poly;
      Point a = new Point(7, 7);
      Point b = new Point(0, 9);
      Point c = new Point(-3, -5);
      Point d = new Point(2, -6);
      Point e = new Point(12, 0);
      Point[] vertices = new Point[5];
      Point ta, tb, tc, td, te;
      vertices[0] = ta = new Point(a);
      vertices[1] = tb = new Point(b);
      vertices[2] = tc = new Point(c);
      vertices[3] = td = new Point(d);
      vertices[4] = te = new Point(e);
         
      System.out.println("ConvexPolygon tests...");

      poly = new ConvexPolygon(vertices, Color.cyan, false);

      // Deep copy made?
      ta.x = tb.x = tc.x = td.x = te.x = 0;
      ta.y = tb.y = tc.y = td.y = te.y = 0;
       
      pass &= test(approx(poly.getArea(), 137.0, 0.000001), test++);
      pass &= test(poly.getColor().equals(Color.cyan), test++);
     
      poly.setColor(Color.black);

      pass &= test(poly.getColor().equals(Color.black), test++);
      pass &= test(!poly.getFilled(), test++);
     
      poly.setFilled(true);

      pass &= test(poly.getFilled(), test++);
      pass &= test(poly.getVertex(0).equals(a), test++);
      pass &= test(poly.getVertex(1).equals(b), test++);
      pass &= test(poly.getVertex(2).equals(c), test++);
      pass &= test(poly.getVertex(3).equals(d), test++);
      pass &= test(poly.getVertex(4).equals(e), test++); //Test 10

      Point pt = new Point(8, 9);
      poly.setVertex(0, pt);
      pt.x = pt.y = 0;
      pass &= test(poly.getVertex(0).equals(new Point(8, 9)), test++);

      pt = new Point(1, 11);
      poly.setVertex(1, pt);
      pt.x = pt.y = 0;
      pass &= test(poly.getVertex(1).equals(new Point(1, 11)), test++);
      
      pt = new Point(-2, -3);
      poly.setVertex(2, pt);
      pt.x = pt.y = 0;
      pass &= test(poly.getVertex(2).equals(new Point(-2, -3)), test++);

      pt = new Point(3, -4);
      poly.setVertex(3, pt);
      pt.x = pt.y = 0;
      pass &= test(poly.getVertex(3).equals(new Point(3, -4)), test++);

      pt = new Point(13, 2);
      poly.setVertex(4, pt);
      pt.x = pt.y = 0;
      pass &= test(poly.getVertex(4).equals(new Point(13, 2)), test++);

      pt = new Point(-1, -2);
      poly.move(pt);
      pt.x = pt.y = 0;
      pass &= test(poly.getVertex(0).equals(new Point(7, 7)), test++);
      pass &= test(poly.getVertex(1).equals(new Point(0, 9)), test++);      
      pass &= test(poly.getVertex(2).equals(new Point(-3, -5)), test++);
      pass &= test(poly.getVertex(3).equals(new Point(2, -6)), test++);
      pass &= test(poly.getVertex(4).equals(new Point(12, 0)), test++);

      // Deep?
      pt = poly.getVertex(2);
      pt.x = pt.y = 0;
      pass &= test(poly.getVertex(2).x == -3, test++);
      pass &= test(poly.getVertex(2).y == -5, test++);
  
      vertices[0] = poly.getVertex(0);
      vertices[1] = poly.getVertex(1);
      vertices[2] = poly.getVertex(2);
      vertices[3] = poly.getVertex(3);
      vertices[4] = poly.getVertex(4);
      
      ConvexPolygon poly2 = new ConvexPolygon(vertices, Color.black, false);
      
      pass &= test(!poly.equals(poly2), test++);
      
      poly2.setFilled(true);
      pass &= test(poly.equals(poly2), test++);
      
      ConvexPolygon poly3 = new ConvexPolygon(vertices, Color.black, false);
      poly3.setFilled(true);
      poly3.setVertex(0, new Point(7, 8));
 
      pass &= test(!poly2.equals(poly3), test++); 
     
      poly3 = new ConvexPolygon(vertices, Color.black, false);
      poly3.setVertex(1, new Point(1, 9));
      
      pass &= test(!poly2.equals(poly3), test++);

      poly3 = new ConvexPolygon(vertices, Color.black, false);
      poly3.setVertex(4, new Point(13, 1));
      
      pass &= test(!poly2.equals(poly3), test++);

      poly3 = new ConvexPolygon(vertices, Color.red, false);
      
      pass &= test(!poly2.equals(poly3), test++);    
      pass &= test(!poly2.equals(null), test++);   
      pass &= test(!poly2.equals(new String("Whatever")), test++);
      
      return pass;   
   }
   
   private static boolean testCanvas()
   {
      boolean pass = true;
      int test = 1;
      double area;
      Canvas canvas = new Canvas();
      Circle[] circles = new Circle[3];
      Rectangle[] rects = new Rectangle[3];
      Square[] squares = new Square[3];
      Triangle[] tris = new Triangle[3];
      ConvexPolygon[] polys = new ConvexPolygon[3];
      ArrayList<Circle> circleList;
      ArrayList<Rectangle> rectList;
      ArrayList<Triangle> triList;
      ArrayList<ConvexPolygon> polyList;
      ArrayList<AbstractShape> shapeList;
      ArrayList<Square> squareList;
      
      circles[0] = new Circle(1.1, new Point(1, 2), Color.cyan, false);
      circles[1] = new Circle(2.2, new Point(2, 3), Color.red, false);   
      circles[2] = new Circle(3.3, new Point(3, 4), Color.black, false);
      
      rects[0] = new Rectangle(1.1, 1.11, new Point(1, 2), Color.cyan, false);
      rects[1] = new Rectangle(2.2, 2.22, new Point(2, 3), Color.red, false);
      rects[2] = new Rectangle(3.3, 3.33, new Point(3, 4), Color.black, false);
      
      squares[0] = new Square(1.1, new Point(1, 2), Color.cyan, false);
      squares[1] = new Square(2.2, new Point(2, 3), Color.red, false);
      squares[2] = new Square(3.3, new Point(3, 4), Color.black, false);

      Point a = new Point(1, 1);
      Point b = new Point(0, 2);
      Point c = new Point(0, 0);
      
      Point aa = new Point( 2, 2);
      Point bb = new Point(1, 3);
      Point cc = new Point(1, 1);
      
      Point aaa = new Point(3, 3);
      Point bbb = new Point(2, 4);
      Point ccc = new Point(2, 2);

      tris[0] = new Triangle(a, b, c, Color.cyan, false);
      tris[1] = new Triangle(aa, bb, cc, Color.red, false);
      tris[2] = new Triangle(aaa, bbb, ccc, Color.black, false);
      
      Point[] aVertices = new Point[5];
      Point[] bVertices = new Point[5];
      Point[] cVertices = new Point[5];
      
      aVertices[0] = new Point(4, 0);
      aVertices[1] = new Point(2, 2);
      aVertices[2] = new Point(-2, -2);
      aVertices[3] = new Point(-4, 0);
      aVertices[4] = new Point(0, -2);

      bVertices[0] = new Point(4, 1);
      bVertices[1] = new Point(2, 3);
      bVertices[2] = new Point(-2, -1);
      bVertices[3] = new Point(-4, 1);
      bVertices[4] = new Point(0, -1);

      cVertices[0] = new Point(4, -1);
      cVertices[1] = new Point(2, 1);
      cVertices[2] = new Point(-2, -3);
      cVertices[3] = new Point(-4, -1);
      cVertices[4] = new Point(0, -3);
     
      polys[0] = new ConvexPolygon(aVertices, Color.cyan, false);
      polys[1] = new ConvexPolygon(bVertices, Color.red, false);
      polys[2] = new ConvexPolygon(cVertices, Color.black, false);
      
      System.out.println("WorkSpace tests...");
      
      // Test an empty WorkSpace...
      pass &= test(canvas.size() == 0, test++);
      pass &= test(canvas.getCircles().size() == 0, test++);
      pass &= test(canvas.getRectangles().size() == 0, test++);
      pass &= test(canvas.getTriangles().size() == 0, test++);
      pass &= test(canvas.getConvexPolygons().size() == 0, test++);
      pass &= test(canvas.getShapesByColor(Color.cyan).size() == 0, test++);
      pass &= test(canvas.getAreaOfAllShapes() == 0, test++);
      
      // Add a shape and test a WorkSpace with one shape in it...
      canvas.add(circles[0]);

      pass &= test(canvas.size() == 1, test++);
      pass &= test(canvas.getCircles().size() == 1, test++);
      pass &= test(canvas.getRectangles().size() == 0, test++);
      pass &= test(canvas.getTriangles().size() == 0, test++);
      pass &= test(canvas.getConvexPolygons().size() == 0, test++);
      pass &= test(canvas.getShapesByColor(Color.black).size() == 0, test++);
      pass &= test(canvas.getShapesByColor(Color.cyan).size() == 1, test++);
      pass &= test(canvas.getCircles().get(0).equals(circles[0]), test++);
      pass &= test(canvas.getShapesByColor(Color.cyan).get(0).equals(circles[0]), test++);
      pass &= test(canvas.get(0).equals(circles[0]), test++);
      pass &= test(approx(canvas.getAreaOfAllShapes(), circles[0].getArea(), 0.000001), test++);
      
      // Remove a shape and test an empty WorkSpace...
      pass &= test(canvas.remove(0).equals(circles[0]), test++);
      pass &= test(canvas.size() == 0, test++);
      pass &= test(canvas.getCircles().size() == 0, test++);
      pass &= test(canvas.getRectangles().size() == 0, test++);
      pass &= test(canvas.getTriangles().size() == 0, test++);
      pass &= test(canvas.getConvexPolygons().size() == 0, test++);
      pass &= test(canvas.getShapesByColor(Color.cyan).size() == 0, test++);
      pass &= test(canvas.getAreaOfAllShapes() == 0, test++);
      
      
      // Add one of each shape and test...
      canvas.add(circles[0]);
      canvas.add(rects[0]);
      canvas.add(tris[0]);
      canvas.add(polys[0]);
      canvas.add(squares[0]);
      
      pass &= test(canvas.size() == 5, test++);
      pass &= test(canvas.getCircles().size() == 1, test++);
      pass &= test(canvas.getRectangles().size() == 1, test++);
      pass &= test(canvas.getTriangles().size() == 1, test++);
      pass &= test(canvas.getConvexPolygons().size() == 1, test++);
      pass &= test(canvas.getShapesByColor(Color.black).size() == 0, test++);
      pass &= test(canvas.getShapesByColor(Color.cyan).size() == 5, test++);
      pass &= test(canvas.getCircles().get(0).equals(circles[0]), test++);
      pass &= test(canvas.getRectangles().get(0).equals(rects[0]), test++);
      pass &= test(canvas.getTriangles().get(0).equals(tris[0]), test++);
      pass &= test(canvas.getConvexPolygons().get(0).equals(polys[0]), test++);
      
      area = circles[0].getArea();
      area += rects[0].getArea();
      area += tris[0].getArea();
      area += polys[0].getArea();
      area += squares[0].getArea();
      
      pass &= test(approx(canvas.getAreaOfAllShapes(), area, 0.000001), test++);

      // Remove a shape and test again...
      canvas.remove(2);
      
      pass &= test(canvas.size() == 4, test++);
      pass &= test(canvas.getCircles().size() == 1, test++);
      pass &= test(canvas.getRectangles().size() == 1, test++);
      pass &= test(canvas.getTriangles().size() == 0, test++);
      pass &= test(canvas.getConvexPolygons().size() == 1, test++);
      pass &= test(canvas.getShapesByColor(Color.black).size() == 0, test++);
      pass &= test(canvas.getShapesByColor(Color.cyan).size() == 4, test++);
      pass &= test(canvas.getCircles().get(0).equals(circles[0]), test++);
      pass &= test(canvas.getRectangles().get(0).equals(rects[0]), test++);
      pass &= test(canvas.getConvexPolygons().get(0).equals(polys[0]), test++);
      
      area -= tris[0].getArea();

      pass &= test(approx(canvas.getAreaOfAllShapes(), area, 0.000001), test++);

      // Add more shapes and test again...
      canvas.add(tris[0]);
      area += tris[0].getArea();
            
      for(int i = 1; i < 3; i++)
      {
         canvas.add(circles[i]);
         canvas.add(rects[i]);
         canvas.add(tris[i]);
         canvas.add(polys[i]);
         
         area += circles[i].getArea();
         area += rects[i].getArea();
         area += tris[i].getArea();
         area += polys[i].getArea();
      }
      
      canvas.add(squares[1]);
      canvas.add(squares[2]);
      area += squares[1].getArea();
      area += squares[2].getArea();
    
      pass &= test(canvas.size() == 15, test++);
      pass &= test(canvas.getCircles().size() == 3, test++);
      pass &= test(canvas.getRectangles().size() == 3, test++);
      pass &= test(canvas.getTriangles().size() == 3, test++);
      pass &= test(canvas.getConvexPolygons().size() == 3, test++);
      pass &= test(canvas.getShapesByColor(Color.black).size() == 5, test++);
      pass &= test(canvas.getShapesByColor(Color.cyan).size() == 5, test++);
      pass &= test(canvas.getShapesByColor(Color.white).size() == 0, test++);
      pass &= test(canvas.get(9).equals(circles[2]), test++);
      pass &= test(canvas.get(10).equals(rects[2]), test++);
      pass &= test(canvas.get(11).equals(tris[2]), test++);
      pass &= test(canvas.get(12).equals(polys[2]), test++);
      pass &= test(approx(canvas.getAreaOfAllShapes(), area, 0.000001), test++);

      // Remove a couple of shapes and test again...
      pass &= test(canvas.remove(0).equals(circles[0]), test++);
      pass &= test(canvas.remove(11).equals(polys[2]), test++);
      pass &= test(canvas.remove(8).equals(circles[2]), test++);
      
      pass &= test(canvas.size() == 12, test++);
      pass &= test(canvas.getCircles().size() == 1, test++);
      pass &= test(canvas.getRectangles().size() == 3, test++);
      pass &= test(canvas.getTriangles().size() == 3, test++);
      pass &= test(canvas.getConvexPolygons().size() == 2, test++);
      pass &= test(canvas.getShapesByColor(Color.black).size() == 3, test++);
      pass &= test(canvas.getShapesByColor(Color.cyan).size() == 4, test++);
      pass &= test(canvas.getShapesByColor(Color.white).size() == 0, test++);
      
      area -= circles[0].getArea();
      area -= polys[2].getArea();
      area -= circles[2].getArea();
      
      pass &= test(approx(canvas.getAreaOfAllShapes(), area, 0.000001), test++);
                          
      return pass;     
   }
   
   private static boolean testCompareTo()
   {
      boolean pass = true;
      int test = 1;
      Circle[] circles = new Circle[2];
      Rectangle[] rects = new Rectangle[2];
      Triangle[] tris = new Triangle[2];
      ConvexPolygon[] polys = new ConvexPolygon[2];
      Square[] sqs = new Square[2];
      
      circles[0] = new Circle(1.1, new Point(1, 2), Color.cyan, false);
      circles[1] = new Circle(1.1, new Point(1, 2), Color.cyan, false);
      
      rects[0] = new Rectangle(1.1, 1.11, new Point(1, 2), Color.cyan, false);
      rects[1] = new Rectangle(1.1, 1.11, new Point(1, 2), Color.cyan, false);
      
      Point a = new Point(1, 1);
      Point b = new Point(0, 2);
      Point c = new Point(0, 0);
      
      tris[0] = new Triangle(a, b, c, Color.cyan, false);
      tris[1] = new Triangle(a, b, c, Color.cyan, false);
      
      Point[] aVertices = new Point[5];
      
      aVertices[0] = new Point(4, 0);
      aVertices[1] = new Point(2, 2);
      aVertices[2] = new Point(-2, -2);
      aVertices[3] = new Point(-4, 0);
      aVertices[4] = new Point(0, -2);

      polys[0] = new ConvexPolygon(aVertices, Color.cyan, false);
      polys[1] = new ConvexPolygon(aVertices, Color.cyan, false);
      
      sqs[0] = new Square(2, new Point (11, 33), Color.cyan, false);
      sqs[1] = new Square(2, new Point (11, 33), Color.cyan, false);
      
      System.out.println("Comparable.compareTo() tests...");
                              
      // Unit test message...
      //
      pass &= test(circles[0].compareTo(circles[1]) == 0, test++);
      pass &= test(rects[0].compareTo(rects[1]) == 0, test++);
      pass &= test(tris[0].compareTo(tris[1]) == 0, test++);
      pass &= test(polys[0].compareTo(polys[1]) == 0, test++);
      pass &= test(sqs[0].compareTo(sqs[1]) == 0, test++);

      pass &= test(circles[0].compareTo(polys[0]) < 0, test++);
      pass &= test(polys[0].compareTo(rects[0]) < 0, test++);
      pass &= test(rects[0].compareTo(sqs[0]) < 0, test++);
      pass &= test(sqs[0].compareTo(tris[0]) < 0, test++);
      
      pass &= test(tris[0].compareTo(sqs[0]) > 0, test++);
      pass &= test(sqs[0].compareTo(rects[0]) > 0, test++);
      pass &= test(rects[0].compareTo(polys[0]) > 0, test++);
      pass &= test(polys[0].compareTo(circles[0]) > 0, test++);
      
      // Make some bigger shapes...
      circles[1].setRadius(44.7);
      rects[1].setHeight(12.56);
      tris[1].setVertexA(new Point(5, 1));
      polys[1].setVertex(0, new Point(8, 0));
      sqs[1].setWidth(4);

      pass &= test(circles[0].compareTo(circles[1]) < 0, test++);
      pass &= test(rects[0].compareTo(rects[1]) < 0, test++);
      pass &= test(tris[0].compareTo(tris[1]) < 0, test++);
      pass &= test(polys[0].compareTo(polys[1]) < 0, test++);
      pass &= test(sqs[0].compareTo(sqs[1]) < 0, test++);

      pass &= test(circles[1].compareTo(circles[0]) > 0, test++);
      pass &= test(rects[1].compareTo(rects[0]) > 0, test++);
      pass &= test(tris[1].compareTo(tris[0]) > 0, test++);
      pass &= test(polys[1].compareTo(polys[0]) > 0, test++);
      pass &= test(sqs[1].compareTo(sqs[0]) > 0, test++);
        
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
      Arrays.sort(names);
      
      for (Method m : methods)
      {
         if (m.getModifiers() == modifier)
         {
            if (Arrays.binarySearch(names, m.getName()) < 0)
            {
               System.out.println(m.getName());
               return false;
            }
         }
      }
      
      return true;
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
