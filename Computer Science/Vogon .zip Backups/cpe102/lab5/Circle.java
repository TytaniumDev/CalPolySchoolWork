/**
 * A circle object that implements the Shape interface
 *
 * @author Tyler Holland
 * @version Lab 5
 * @version CPE102-5
 * @version Winter 2009
 */
import java.awt.*;

public class Circle implements Shape
{
   //Instance variables
   private double radius;
   private Point position; //X+Y of the center point of the circle
   private Color color;
   private boolean filled; //Filled with color or wire-frame

   //Constructors
   public Circle(double radius, Point position, Color color, boolean filled)
   {
      this.radius = radius;
      this.position = position;
      this.color = color;
      this.filled = filled;
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
      if(this.color != ((Circle)other).color)
      {
         return false;
      }
      if(this.filled != ((Circle)other).filled)
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

   public Color getColor()
   {
      return color;
   }

   public void setColor(Color color)
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

   public void move(Point point)
   {
      this.position.x = this.position.x + point.x;
      this.position.y = this.position.y + point.y;
   }
   
   //Graphic Method
   public void draw(java.awt.Graphics graphic)
   {
      graphic.setColor(color);    
      
      if(this.filled)
      {
         graphic.fillOval(position.x, position.y, (int)(radius * 2), (int)(radius * 2));
      }
      else
      {
         graphic.drawOval(position.x, position.y, (int)(radius * 2), (int)(radius * 2));
      }
   }
}