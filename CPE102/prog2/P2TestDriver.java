import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.lang.reflect.*;

public class P2TestDriver
{
   private static final String RESULTS_FOR = "Results for Program 2";

   public static void main(String[] args)
   {
      boolean pass = true;
      
      printHeader(args);
      
      // Architecture tests...
      //
      pass &= testCircleArch();
      pass &= testRectangleArch();
      pass &= testTriangleArch();
      pass &= testConvexPolygonArch();
      pass &= testCanvasArch();
      
      // Unit Tests...
      //
      try
      {
         pass &= testCircle();
      }
      catch (Exception e)
      {
         pass &= false;
         System.out.println("FAILED, runtime exception testing Circle");
         e.printStackTrace();
      }
      
      try
      {
         pass &= testRectangle();
      }
      catch (Exception e)
      {
         pass &= false;
         System.out.println("FAILED, runtime exception testing Rectangle");
         e.printStackTrace();
      }

      try
      {
         pass &= testTriangle();
      }
      catch (Exception e)
      {
         pass &= false;
         System.out.println("FAILED, runtime exception testing Triangle");
         e.printStackTrace();
      }
      
      try
      {
         pass &= testConvexPolygon();
      }
      catch (Exception e)
      {
         pass &= false;
         System.out.println("FAILED, runtime exception testing ConvexPolygon");
         e.printStackTrace();
      }
      
      try
      {
         pass &= testCanvas();
      }
      catch (Exception e)
      {
         pass &= false;
         System.out.println("FAILED, runtime error testing Canvas");
         e.printStackTrace();
      }
      
      printResults(pass);
      
      // Added for to support robust script checking
      if (!pass)
      {
         System.exit(-1);
      }
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
      pass &= test((temp = cl.getInterfaces()).length == 1, test++);
      pass &= test(temp[0].getName().equals("Shape"), test++);
      pass &= test(verifyEqualsMethodSignature(cl), test++);
            
      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
      pass &= test(cnt == 10, test++);
      
      cnt = cl.getFields().length;
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      pass &= test(cnt == 4, test++);
      
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
      pass &= test((temp = cl.getInterfaces()).length == 1, test++);
      pass &= test(temp[0].getName().equals("Shape"), test++);
      pass &= test(verifyEqualsMethodSignature(cl), test++);
      
      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
      pass &= test(cnt == 12, test++);
      
      cnt = cl.getFields().length;
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      pass &= test(cnt == 5, test++);
      
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
      pass &= test((temp = cl.getInterfaces()).length == 1, test++);
      pass &= test(temp[0].getName().equals("Shape"), test++);
      pass &= test(verifyEqualsMethodSignature(cl), test++);
      
      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
      pass &= test(cnt == 13, test++);
      
      cnt = cl.getFields().length;
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      pass &= test(cnt == 0, test++);
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      pass &= test(cnt == 5, test++);
      
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
      vertices[0] = new Point(a);
      vertices[1] = new Point(b);
      vertices[2] = new Point(c);
      vertices[3] = new Point(d);
      vertices[4] = new Point(e);
   
      poly = new ConvexPolygon(vertices, Color.cyan, false);
      
      cl = poly.getClass();

      pass &= test(cl.getConstructors().length == 1, test++);     
      pass &= test((temp = cl.getInterfaces()).length == 1, test++);
      pass &= test(temp[0].getName().equals("Shape"), test++);
      pass &= test(verifyEqualsMethodSignature(cl), test++);
      
      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
      pass &= test(cnt == 9, test++);
      
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
      
      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
      pass &= test(cnt == 10, test++);
      
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
   
      circle = new Circle(5.6789, new Point(-99, 66), Color.cyan, false);
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
      
      circle.move(new Point(-5, -7));     
      pass &= test(circle.getPosition().equals(new Point(-104, 59)), test++);

      Circle circle2 = new Circle(4.321, new Point(-104, 59), Color.black, true);
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
      
      System.out.println("Rectangle tests...");
   
      rect = new Rectangle(4.3, 5.6, new Point(-99, 66), Color.cyan, false);
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
      
      rect.move(new Point(-5, -7));
      pass &= test(rect.getPosition().equals(new Point(-104, 59)), test++);

      Rectangle rect2 = new Rectangle(4.321, 89.21, new Point(-104, 59), Color.black, true);
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
   
   private static boolean testTriangle()
   {
      boolean pass = true;
      int test = 1;
      Triangle tri;
      Point a = new Point(4, 0);
      Point b = new Point(-2, -1);
      Point c = new Point(1, 4);
      
      System.out.println("Triangle tests...");
   
      tri = new Triangle(a, b, c, Color.cyan, false);
      pass &= test(approx(tri.getArea(), 13.5, 0.000001), test++);
      pass &= test(tri.getColor().equals(Color.cyan), test++);

      tri.setColor(Color.black);
      pass &= test(tri.getColor().equals(Color.black), test++);
      pass &= test(!tri.getFilled(), test++);
      
      tri.setFilled(true);
      pass &= test(tri.getFilled(), test++);
      pass &= test(tri.getVertexA().equals(new Point(4, 0)), test++);
      pass &= test(tri.getVertexB().equals(new Point(-2, -1)), test++);
      pass &= test(tri.getVertexC().equals(new Point(1, 4)), test++);
      
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
      
      Triangle tri2 = new Triangle(a, b, c, Color.black, true);
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
      vertices[0] = new Point(a);
      vertices[1] = new Point(b);
      vertices[2] = new Point(c);
      vertices[3] = new Point(d);
      vertices[4] = new Point(e);
      
      System.out.println("ConvexPolygon tests...");
   
      poly = new ConvexPolygon(deepCopy(vertices), Color.cyan, false);
    
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
      pass &= test(poly.getVertex(4).equals(e), test++);

      poly.setVertex(0, new Point(8, 9));

      pass &= test(poly.getVertex(0).equals(new Point(8, 9)), test++);

      poly.setVertex(1, new Point(1, 11));

      pass &= test(poly.getVertex(1).equals(new Point(1, 11)), test++);
      
      poly.setVertex(2, new Point(-2, -3));

      pass &= test(poly.getVertex(2).equals(new Point(-2, -3)), test++);

      poly.setVertex(3, new Point(3, -4));

      pass &= test(poly.getVertex(3).equals(new Point(3, -4)), test++);

      poly.setVertex(4, new Point(13, 2));

      pass &= test(poly.getVertex(4).equals(new Point(13, 2)), test++);

      poly.move(new Point(-1, -2));

      pass &= test(poly.getVertex(0).equals(new Point(7, 7)), test++);
      pass &= test(poly.getVertex(1).equals(new Point(0, 9)), test++);      
      pass &= test(poly.getVertex(2).equals(new Point(-3, -5)), test++);
      pass &= test(poly.getVertex(3).equals(new Point(2, -6)), test++);
      pass &= test(poly.getVertex(4).equals(new Point(12, 0)), test++);

      ConvexPolygon poly2 = new ConvexPolygon(deepCopy(vertices), Color.black, false);
      
      pass &= test(!poly.equals(poly2), test++);
      
      poly2.setFilled(true);
      pass &= test(poly.equals(poly2), test++);
      
      ConvexPolygon poly3 = new ConvexPolygon(deepCopy(vertices), Color.black, false);
      poly3.setFilled(true);
      poly3.setVertex(0, new Point(7, 8));
 
      pass &= test(!poly2.equals(poly3), test++); 
     
      poly3 = new ConvexPolygon(deepCopy(vertices), Color.black, false);
      poly3.setVertex(1, new Point(1, 9));
      
      pass &= test(!poly2.equals(poly3), test++);

      poly3 = new ConvexPolygon(deepCopy(vertices), Color.black, false);
      poly3.setVertex(4, new Point(13, 1));
      
      pass &= test(!poly2.equals(poly3), test++);

      poly3 = new ConvexPolygon(deepCopy(vertices), Color.red, false);
      
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
      Triangle[] tris = new Triangle[3];
      ConvexPolygon[] polys = new ConvexPolygon[3];
      ArrayList<Circle> circleList;
      ArrayList<Rectangle> rectList;
      ArrayList<Triangle> triList;
      ArrayList<ConvexPolygon> polyList;
      ArrayList<Shape> shapeList;
      
      circles[0] = new Circle(1.1, new Point(1, 2), Color.cyan, false);
      circles[1] = new Circle(2.2, new Point(2, 3), Color.red, false);   
      circles[2] = new Circle(3.3, new Point(3, 4), Color.black, false);
      
      rects[0] = new Rectangle(1.1, 1.11, new Point(1, 2), Color.cyan, false);
      rects[1] = new Rectangle(2.2, 2.22, new Point(2, 3), Color.red, false);
      rects[2] = new Rectangle(3.3, 3.33, new Point(3, 4), Color.black, false);
      
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
      
      System.out.println("Canvas tests...");
      
      // Test an empty Canvas...
      pass &= test(canvas.size() == 0, test++);
      pass &= test(canvas.getCircles().size() == 0, test++);
      pass &= test(canvas.getRectangles().size() == 0, test++);
      pass &= test(canvas.getTriangles().size() == 0, test++);
      pass &= test(canvas.getConvexPolygons().size() == 0, test++);
      pass &= test(canvas.getShapesByColor(Color.cyan).size() == 0, test++);
      pass &= test(canvas.getAreaOfAllShapes() == 0, test++);
      
      // Add a shape and test a Canvas with one shape in it...
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
      
      // Remove a shape and test an empty Canvas...
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
      
      pass &= test(canvas.size() == 4, test++);
      pass &= test(canvas.getCircles().size() == 1, test++);
      pass &= test(canvas.getRectangles().size() == 1, test++);
      pass &= test(canvas.getTriangles().size() == 1, test++);
      pass &= test(canvas.getConvexPolygons().size() == 1, test++);
      pass &= test(canvas.getShapesByColor(Color.black).size() == 0, test++);
      pass &= test(canvas.getShapesByColor(Color.cyan).size() == 4, test++);
      pass &= test(canvas.getCircles().get(0).equals(circles[0]), test++);
      pass &= test(canvas.getRectangles().get(0).equals(rects[0]), test++);
      pass &= test(canvas.getTriangles().get(0).equals(tris[0]), test++);
      pass &= test(canvas.getConvexPolygons().get(0).equals(polys[0]), test++);
      
      area = circles[0].getArea();
      area += rects[0].getArea();
      area += tris[0].getArea();
      area += polys[0].getArea();
      
      pass &= test(approx(canvas.getAreaOfAllShapes(), area, 0.000001), test++);

      // Remove a shape and test again...
      canvas.remove(2);
      
      pass &= test(canvas.size() == 3, test++);
      pass &= test(canvas.getCircles().size() == 1, test++);
      pass &= test(canvas.getRectangles().size() == 1, test++);
      pass &= test(canvas.getTriangles().size() == 0, test++);
      pass &= test(canvas.getConvexPolygons().size() == 1, test++);
      pass &= test(canvas.getShapesByColor(Color.black).size() == 0, test++);
      pass &= test(canvas.getShapesByColor(Color.cyan).size() == 3, test++);
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
    
      pass &= test(canvas.size() == 12, test++);
      pass &= test(canvas.getCircles().size() == 3, test++);
      pass &= test(canvas.getRectangles().size() == 3, test++);
      pass &= test(canvas.getTriangles().size() == 3, test++);
      pass &= test(canvas.getConvexPolygons().size() == 3, test++);
      pass &= test(canvas.getShapesByColor(Color.black).size() == 4, test++);
      pass &= test(canvas.getShapesByColor(Color.cyan).size() == 4, test++);
      pass &= test(canvas.getShapesByColor(Color.white).size() == 0, test++);
      pass &= test(canvas.get(8).equals(circles[2]), test++);
      pass &= test(canvas.get(9).equals(rects[2]), test++);
      pass &= test(canvas.get(10).equals(tris[2]), test++);
      pass &= test(canvas.get(11).equals(polys[2]), test++);
      pass &= test(approx(canvas.getAreaOfAllShapes(), area, 0.000001), test++);

      // Remove a couple of shapes and test again...
      pass &= test(canvas.remove(0).equals(circles[0]), test++);
      pass &= test(canvas.remove(10).equals(polys[2]), test++);
      pass &= test(canvas.remove(7).equals(circles[2]), test++);
      
      pass &= test(canvas.size() == 9, test++);
      pass &= test(canvas.getCircles().size() == 1, test++);
      pass &= test(canvas.getRectangles().size() == 3, test++);
      pass &= test(canvas.getTriangles().size() == 3, test++);
      pass &= test(canvas.getConvexPolygons().size() == 2, test++);
      pass &= test(canvas.getShapesByColor(Color.black).size() == 2, test++);
      pass &= test(canvas.getShapesByColor(Color.cyan).size() == 3, test++);
      pass &= test(canvas.getShapesByColor(Color.white).size() == 0, test++);
      
      area -= circles[0].getArea();
      area -= polys[2].getArea();
      area -= circles[2].getArea();
      
      pass &= test(approx(canvas.getAreaOfAllShapes(), area, 0.000001), test++);
                          
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
   
   private static Point[] deepCopy(Point[] a)
   {
      int i = 0;
      Point[] ret = new Point[a.length];
      
      for(Point p : a)
      {
         if (p == null)
         {
            ret[i++] = null;
         }
         else
         {
            ret[i++] = new Point(p);
         }
      }
      
      return ret;
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