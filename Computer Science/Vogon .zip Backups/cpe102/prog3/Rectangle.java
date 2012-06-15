/**
 * A Rectangle object that extends AbstractShape
 *
 * @author Tyler Holland
 * @version Program 3
 * @version CPE102-5
 * @version Winter 2009
 */
import java.awt.*;

public class Rectangle extends AbstractShape
{
   //Instance variables
   private double width;
   private double height;
   private java.awt.Point position = new Point();

   //Constructors
   public Rectangle(double width, double height, java.awt.Point position, 
                    java.awt.Color color, boolean filled)
   {
      super(filled, color);
      this.width = width;
      this.height = height;
      this.position.x = position.x;
      this.position.y = position.y;
   }
   //Methods
   public double getWidth()
   {
      return width;
   }

   public void setWidth(double width)
   {
      this.width = width;
   }

   public double getHeight()
   {
      return height;
   }

   public void setHeight(double height)
   {
      this.height = height;
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
      if(this.width != ((Rectangle)other).width)
      {
         return false;
      }
      if(this.height != ((Rectangle)other).height)
      {
         return false;
      }
      if(this.position.x != ((Rectangle)other).position.x)
      {
         return false;
      }
      if(this.position.y != ((Rectangle)other).position.y)
      {
         return false;
      }
      return true;
   }

   //Methods from Shape interface
   public double getArea()
   {
      double area;

      area = width * height;

      return area;
   }

   public void move(Point point)
   {
      this.position.x = this.position.x + point.x;
      this.position.y = this.position.y + point.y;
   }
}