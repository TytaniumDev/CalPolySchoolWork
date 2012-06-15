/**
 * A circle object that extends AbstractShape
 *
 * @author Tyler Holland
 * @version Program 3
 * @version CPE102-5
 * @version Winter 2009
 */
import java.awt.*;

public class Circle extends AbstractShape
{
   //Instance variables
   private double radius;
   private Point position = new Point(); //X+Y of the center point of the circle

   //Constructors
   public Circle(double radius, Point position, Color color, boolean filled)
   {   
      super(filled, color);
      this.radius = radius;
      this.position.x = position.x;
      this.position.y = position.y;
   }
   
   //Methods
   public double getRadius()
   {
      return radius;
   }

   public void setRadius(double radius)
   {
      this.radius = radius;
   }

   public Point getPosition()
   {
      return new Point(position);
   }

   public boolean equals(Object other)
   {
      if(!super.equals(other))
      {
         return false;
      }
      if(this.radius != ((Circle)other).radius)
      {
         return false;
      }
      if(this.position.x != ((Circle)other).position.x)
      {
         return false;
      }
      if(this.position.y != ((Circle)other).position.y)
      {
         return false;
      }
      return true;
   }
   //Methods from Shape interface
   public double getArea()
   {
      double area;

      area = radius * radius * Math.PI;

      return area;
   }

   public void move(Point point)
   {
      this.position.x = this.position.x + point.x;
      this.position.y = this.position.y + point.y;
   }
}