/**
 * AbstractShape abstract class for area, color, filling, and moving
 *
 * @author Tyler Holland
 * @version Program 3
 * @version CPE102-5
 * @version Winter 2009
 */
public abstract class AbstractShape implements Comparable<AbstractShape>
{
   //Instance Variables
   private boolean filled;
   private java.awt.Color color;

   //Constructor
   public AbstractShape(boolean filled, java.awt.Color color)
   {
      this.filled = filled;
      this.color = color;
   }

   //Methods

   /**
    * Calculates and returns the area of the object.
    *
    * @return Returns the area of the shape as a double.
    */
   public abstract double getArea();

   /**
    * Returns the java.awt.Color of the object.
    *
    * @return Returns the color of the object as a java.awt.Color.
    */
   public java.awt.Color getColor()
   {
      return color;
   }

   /**
    * Sets the java.awt.Color of the object.
    *
    * @param color The color the object is being set to.
    */
   public void setColor(java.awt.Color color)
   {
      this.color = color;
   }

   /**
    * Checks if the object is filled with color.
    *
    * @return Returns true if the object is filled with color, otherwise false.
    */
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

   /**
    * Sets the filled state of the object.
    *
    * @param filled The filled state of the object.
    */
   public void setFilled(boolean filled)
   {
      this.filled = filled;
   }

   /**
    * Moves the shape by the x and y amounts specified in the Point given.
    *
    * @param point Point the shape is to be moved to.
    */
   public abstract void move(java.awt.Point point);

   /**
    * Compares two AbstractShapes for ordering purposes.
    * Overrides the java.land.Comparable<T> interface's compareTo 
    * method to make it more specific to AbstractShapes.
    * 
    * @param shape The shape to be compared to.
    *
    * @return Returns -1 if the original object's class name is less than shape's, 
    * or if the original's area is less than shape's.
    * Returns 0 if the original object's class name is equal to shape's, 
    * or if the original's area is equal to shape's.
    * Returns 1 if the original object's class name is greater than shape's, 
    * or if the original's area is greater than shape's.
    * Notice: all returns are ints.
    */
   public int compareTo(AbstractShape shape)
   {
      if(this.getClass() == shape.getClass())
      {
         if(this.getArea() < shape.getArea())
         {
            return -1;
         }
         else if(this.getArea() == shape.getArea())
         {
            return 0;
         }
         else if(this.getArea() > shape.getArea())
         {
            return 1;
         }
      }
      else
      {
         String thisName = this.getClass().getName();
         String shapeName = shape.getClass().getName();
         int result;
         
         result = thisName.compareTo(shapeName);
         
         if(result < 0)
         {
            return -1;
         }
         else if(result == 0)
         {
            return 0;
         }
         else if(result > 0)
         {
            return 1;
         }
      }
      return 9001;
   }
   
   /**
    * Checks to see if two AbstractShapes are equal.
    * Overrides the default Java equals method in order to 
    * make it more specific for AbstractShapes.
    *
    * @param other The object to be compared to (normally an AbstractShape).
    */
   public boolean equals(Object other)
   {
      if (other == null)
      {
         return false;
      }
      if (this.getClass() == other.getClass())
      {
         if(this.filled != ((AbstractShape)other).filled)
         {
            return false;
         }
         if(this.color != ((AbstractShape)other).color)
         {
            return false;
         }
         return true;
      }
      return false;
   }
}