/**
 * Applet for viewing Drawable Shape objects from Program 2.
 
 * @author Kurt Mammen
 * @version Lab 5
 */
import java.applet.Applet;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;

public class CanvasViewer extends Applet
{
   // DON'T change this type - make your Canvas Drawable by implementing
   // the interface as specified in the assignment.
   private Drawable canvas;
   
   public CanvasViewer(Canvas canvas)
   {
      // DON'T change this.canvas's type - make your Canvas Drawable by 
      // implementing the interface as specified in the assignment.
      this.canvas = canvas;
   }
   
   public void paint(Graphics g)
   {
      canvas.draw(g);
   }
   
   public static void main(String[] args)
   {
      Canvas canvas = new Canvas();
      
      // TODO - YOU MUST ADD CODE HERE!
      //
      // After you extend the Drawable interface in the Shape interface you
      // and implement the draw method in the necessary classes you must modify
      // this method to construct at least two object of each shape type, Circle
      // Rectangle, Triangle, and ConvexPolygon, onefilled and the other not
      // filled.  Use different colors and sizes and, if you are up to it, be
      // creative and draw some kind of picture.  Note that the dimensions are
      // in pixels so size accordingly.
      //
      // Here are some samples to get you started.  If you have done everything
      // correctly this should compile, run and draw a couple of circles on your
      // screen - it may take a few seconds to display so be patient.  Once this
      // works create your own shapes and demo to your instructor.
      // 
      //Circles
      canvas.add(new Circle(70, new Point(250, 250), Color.cyan, true));     
      canvas.add(new Circle(20, new Point(250, 400), Color.black, false));
      
      //Rectangles
      canvas.add(new Rectangle(50, 75, new Point(100,100), Color.blue, true));
      canvas.add(new Rectangle(75, 50, new Point(200,150), Color.magenta, false));
      
      //ConvexPolygons
      Point one = new Point(10, 20);
      Point two = new Point(100, 50);
      Point three = new Point(60, 230);
      Point four = new Point(70, 100);
      Point five = new Point(200, 75);
      Point six = new Point(210, 100);
      Point seven = new Point(250, 115);
      Point eight = new Point(150, 120);
      
      Point[] first = new Point[4];
      Point[] second = new Point[4]; 

      first[0] = new Point(one);
      first[1] = new Point(two);
      first[2] = new Point(three);
      first[3] = new Point(four);
      
      second[0] = new Point(five);
      second[1] = new Point(six);
      second[2] = new Point(seven);
      second[3] = new Point(eight);
      
      canvas.add(new ConvexPolygon(first, Color.yellow, true));
      canvas.add(new ConvexPolygon(second, Color.orange, false));
      
      //Triangles
      canvas.add(new Triangle(new Point(230,230), new Point(240,240), new Point(220,240), 
            Color.pink, false));
      canvas.add(new Triangle(new Point(440,140), new Point(490,140), new Point(430,100),
            Color.green, true));
 
      // Create an application frame setting its size and closing behavior
      JFrame frame = new JFrame("Canvas Viewer (tm)");
      frame.setSize(500, 500);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Create a applet - specifically a WorkSpaceViewer 
      Applet applet = new CanvasViewer(canvas);
      
      // Add the applet to the application frame
      frame.add(applet);
      
      // Display the application frame
      frame.setVisible(true);
   }
}