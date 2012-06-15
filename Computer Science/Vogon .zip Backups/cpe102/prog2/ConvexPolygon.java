/**
 * A Convex Polygon object that implements the Shape interface
 *
 * @author Tyler Holland
 * @version Program 2
 * @version CPE102-5
 * @version Winter 2009
 */

public class ConvexPolygon implements Shape
{
   //Instance variables
   private java.awt.Point[] vertices;
   private java.awt.Color color;
   private boolean filled;

   //Constructors
   public ConvexPolygon(java.awt.Point[] vertices, java.awt.Color color, boolean filled)
   {
      this.vertices = vertices;
      this.color = color;
      this.filled = filled;
   }

   //Methods
   public java.awt.Point getVertex(int index)
   {
      return vertices[index];
   }
   public void setVertex(int index, java.awt.Point vertex)
   {
      this.vertices[index] = vertex;
   }
   public boolean equals(Object other)
   {
      if(other == null)
      {
         return false;
      }
      if(this.getClass() != other.getClass())
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
      if(this.color != ((ConvexPolygon)other).color)
      {
         return false;
      }
      if(this.filled != ((ConvexPolygon)other).filled)
      {
         return false;
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
      for(int i = 0; i < this.vertices.length; i++)
      {
         this.vertices[i].x = this.vertices[i].x + point.x;
         this.vertices[i].y = this.vertices[i].y + point.y;
      }
   }
}