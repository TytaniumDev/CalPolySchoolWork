/**
 * A Triangle object that extends ConvexPolygon
 *
 * @author Tyler Holland
 * @version Program 3
 * @version CPE102-5
 * @version Winter 2009
 */
import java.awt.*;

public class Triangle extends ConvexPolygon
{
   //Constructors
   public Triangle (Point a, Point b, Point c, 
                    Color color, boolean filled)
   {
      super(new Point[] {a, b, c}, color, filled);
   }

   //Methods
   public Point getVertexA()
   {
      return super.getVertex(0);
   }
   public void setVertexA(Point point)
   {
      super.setVertex(0, point);
   }
   public Point getVertexB()
   {
      return super.getVertex(1);
   }
   public void setVertexB(Point point)
   {
      super.setVertex(1, point);
   }
   public Point getVertexC()
   {
      return super.getVertex(2);
   }
   public void setVertexC(Point point)
   {
      super.setVertex(2, point);
   }
   public double getArea()
   {
      double area;
      double sideA;
      double sideB;
      double sideC;
      double s;
      Point a = super.getVertex(0);
      Point b = super.getVertex(1);
      Point c = super.getVertex(2);

      sideA = Math.sqrt(Math.pow((b.x - a.x), 2) + Math.pow((b.y - a.y), 2));
      sideB = Math.sqrt(Math.pow((c.x - b.x), 2) + Math.pow((c.y - b.y), 2));
      sideC = Math.sqrt(Math.pow((c.x - a.x), 2) + Math.pow((c.y - a.y), 2));
      //Heron's formula
      s = (sideA + sideB + sideC) / 2;
      area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));

      return area;
   }
}