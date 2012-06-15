/**
 * A Rectangle object that implements the Shape interface
 *
 * @author Tyler Holland
 * @version Program 2
 * @version CPE102-5
 * @version Winter 2009
 */

public class Rectangle implements Shape
{
   //Instance variables
   private double width;
   private double height;
   private java.awt.Point position;
   private java.awt.Color color;
   private boolean filled;

   //Constructors
   public Rectangle(double width, double height, java.awt.Point position, 
                    java.awt.Color color, boolean filled)
   {
      this.width = width;
      this.height = height;
      this.position = position;
      this.color = color;
      this.filled = filled;
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

   public java.awt.Point getPosition()
   {
      return position;
   }

   public boolean equals(Object other)
   {
      if (other == null)
      {
         return false;
      }
      if (this.getClass() != other.getClass())
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
      if(this.color != ((Rectangle)other).color)
      {
         return false;
      }
      if(this.filled != ((Rectangle)other).filled)
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

   public java.awt.Color getColor()
   {
      return color;
   }

   public void setColor(java.awt.Color color)
   {
      this.color = color;
   }

   public boolean getFilled()
   {
      if(filled)
      {
         return true;
      }
      else
      {
         return false;
      }
   }

   public void setFilled(boolean filled)
   {
      this.filled = filled;
   }

   public void move(java.awt.Point point)
   {
      this.position.x = this.position.x + point.x;
      this.position.y = this.position.y + point.y;
   }
}