/**
 * A Convex Polygon object that extends AbstractShape
 *
 * @author Tyler Holland
 * @version Program 3
 * @version CPE102-5
 * @version Winter 2009
 */
import java.awt.*;

public class ConvexPolygon extends AbstractShape
{
   //Instance variables
   private Point[] vertices;

   //Constructors
   public ConvexPolygon(Point[] vertices, Color color, boolean filled)
   {
      super(filled, color);
      this.vertices = new Point[vertices.length];
      //Fill the new vertices Point
      for(int i = 0; i < vertices.length; i++)
      {
         this.vertices[i] = new Point(vertices[i]);
      }
   }

   //Methods
   public Point getVertex(int index)
   {
      return new Point(vertices[index]);
   }
   public void setVertex(int index, Point vertex)
   {
      this.vertices[index] = new Point(vertex);
   }
   public boolean equals(Object other)
   {
      if(!super.equals(other))
      {
         return false;
      }
      //Special vertices array checking
      for(int i = 0; i < this.vertices.length; i++)
      {
         if(this.vertices[i].x != ((ConvexPolygon)other).vertices[i].x)
         {
            return false;
         }
         if(this.vertices[i].y != ((ConvexPolygon)other).vertices[i].y)
         {
            return false;
         }
      }
      return true;
   }

   //Methods from Shape interface
   public double getArea()
   {
      double area;
      double first = 0; //First sum in formula
      double second = 0; //Second sum in formula
      //First Calculation
      for(int i = 0; i < vertices.length; i++)
      {
         if(i == vertices.length - 1)
         {
            first = first + (vertices[i].x * vertices[0].y);
         }
         else 
         {
            first = first + (vertices[i].x * vertices[i+1].y);
         }
      }
      //Second Calculation
      for(int i = 0; i < vertices.length; i++)
      {
         if(i == vertices.length - 1)
         {
            second = second + (vertices[i].y * vertices[0].x);
         }
         else 
         {
            second = second + (vertices[i].y * vertices[i+1].x);
         }
      }

      area = (first - second) / 2;

      return area;
   }
   public void move(Point point)
   {
      for(int i = 0; i < this.vertices.length; i++)
      {
         this.vertices[i].x = this.vertices[i].x + point.x;
         this.vertices[i].y = this.vertices[i].y + point.y;
      }
   }
}