/**
 * A Triangle object that implements the Shape interface
 *
 * @author Tyler Holland
 * @version Program 2
 * @version CPE102-5
 * @version Winter 2009
 */

public class Triangle implements Shape
{
   //Instance variables
   private java.awt.Point a;
   private java.awt.Point b;
   private java.awt.Point c;
   private java.awt.Color color;
   private boolean filled;

   //Constructors
   public Triangle (java.awt.Point a, java.awt.Point b, java.awt.Point c, java.awt.Color color, boolean filled)
   {
      this.a = a;
      this.b = b;
      this.c = c;
      this.color = color;
      this.filled = filled;
   }

   //Methods
   public java.awt.Point getVertexA()
   {
      return a;
   }
   public void setVertexA(java.awt.Point point)
   {
      this.a = point;
   }
   public java.awt.Point getVertexB()
   {
      return b;
   }
   public void setVertexB(java.awt.Point point)
   {
      this.b = point;
   }
   public java.awt.Point getVertexC()
   {
      return c;
   }
   public void setVertexC(java.awt.Point point)
   {
      this.c = point;
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
      if(this.a.x != ((Triangle)other).a.x)
      {
         return false;
      }
      if(this.a.y != ((Triangle)other).a.y)
      {
         return false;
      }
      if(this.b.x != ((Triangle)other).b.x)
      {
         return false;
      }
      if(this.b.y != ((Triangle)other).b.y)
      {
         return false;
      }
      if(this.c.x != ((Triangle)other).c.x)
      {
         return false;
      }
      if(this.c.y != ((Triangle)other).c.y)
      {
         return false;
      }
      if(this.color != ((Triangle)other).color)
      {
         return false;
      }
      if(this.filled != ((Triangle)other).filled)
      {
         return false;
      }
      return true;
   }
   //Methods from Shape interface
   public double getArea()
   {
      double area;
      double sideA;
      double sideB;
      double sideC;
      double s;

      sideA = Math.sqrt(Math.pow((b.x - a.x), 2) + Math.pow((b.y - a.y), 2));
      sideB = Math.sqrt(Math.pow((c.x - b.x), 2) + Math.pow((c.y - b.y), 2));
      sideC = Math.sqrt(Math.pow((c.x - a.x), 2) + Math.pow((c.y - a.y), 2));
      //Heron's formula
      s = (sideA + sideB + sideC) / 2;
      area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));

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
      this.a.x = this.a.x + point.x;
      this.a.y = this.a.y + point.y;

      this.b.x = this.b.x + point.x;
      this.b.y = this.b.y + point.y;

      this.c.x = this.c.x + point.x;
      this.c.y = this.c.y + point.y;
   }

}