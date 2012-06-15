/**
 * A Canvas object to control the Shapes
 *
 * @author Tyler Holland
 * @version Program 3
 * @version CPE102-5
 * @version Winter 2009
 */
import java.util.ArrayList;

public class Canvas
{
   //Instance variables
   private ArrayList<AbstractShape> array = new ArrayList<AbstractShape>();

   //Constructors
   public Canvas()
   {
   }
   
   //Methods
   /**
    * Adds a shape to the canvas.
    * 
    * @param shape The shape to be added to the canvas.
    */
   public void add(AbstractShape shape)
   {
      this.array.add(shape);
   }

   /**
    * Removes a shape to the canvas.
    * 
    * @param index The index of the shape to be removed from the canvas.
    */
   public AbstractShape remove(int index)
   {
      return this.array.remove(index);
   }

   /**
    * Returns the shape at the specified index.
    * 
    * @param index The index of the shape that is wanted.
    * 
    * @return An AbstractShape representing the shape at the given index.
    */
   public AbstractShape get(int index)
   {
      return this.array.get(index);
   }

   /**
    * Gives the size of the canvas.
    * 
    * @return Returns an int with the size of the current canvas array.
    */
   public int size()
   {
      return this.array.size();
   }

   /**
    * Gives a list of all of the circles on the canvas.
    *
    * @return Returns an ArrayList<Circle> with all of the circles in it, in the order
    * that they appeared on the canvas.
    */
   public ArrayList<Circle> getCircles()
   {
      ArrayList<Circle> result = new ArrayList<Circle>();

      for(int i = 0; i < array.size(); i++)
      {
         if(array.get(i) instanceof Circle)
         {
            result.add((Circle)array.get(i));
         }
      }

      return result;
   }

   /**
    * Gives a list of all of the rectangles on the canvas.
    *
    * @return Returns an ArrayList<Rectangle> with all of the rectangles in it, in the order
    * that they appeared on the canvas.
    */
   public ArrayList<Rectangle> getRectangles()
   {
      ArrayList<Rectangle> result = new ArrayList<Rectangle>();

      for(int i = 0; i < array.size(); i++)
      {
         if(array.get(i) instanceof Rectangle && !(array.get(i) instanceof Square))
         {
            result.add((Rectangle)array.get(i));
         }
      }

      return result;
   }

   /**
    * Gives a list of all of the triangles on the canvas.
    *
    * @return Returns an ArrayList<Triangle> with all of the triangles in it, in the order
    * that they appeared on the canvas.
    */
   public ArrayList<Triangle> getTriangles()
   {
      ArrayList<Triangle> result = new ArrayList<Triangle>();

      for(int i = 0; i < array.size(); i++)
      {
         if(array.get(i) instanceof Triangle)
         {
            result.add((Triangle)array.get(i));
         }
      }

      return result;
   }

   /**
    * Gives a list of all of the convex polygons on the canvas.
    *
    * @return Returns an ArrayList<ConvexPolygon> with all of the convex polygons in it,
    *  in the order that they appeared on the canvas.
    */
   public ArrayList<ConvexPolygon> getConvexPolygons()
   {
      ArrayList<ConvexPolygon> result = new ArrayList<ConvexPolygon>();

      for(int i = 0; i < array.size(); i++)
      {
         if(array.get(i) instanceof ConvexPolygon && !(array.get(i) instanceof Triangle))
         {
            result.add((ConvexPolygon)array.get(i));
         }
      }

      return result;
   }

   /**
    * Gives a list of all of the shapes with a specified color on the canvas.
    *
    * @param color The color to be searched for. 
    *
    * @return Returns an ArrayList<AbstractShape> with all of the shapes that match 
    * the specified color.
    */
   public ArrayList<AbstractShape> getShapesByColor(java.awt.Color color)
   {
      ArrayList<AbstractShape> result = new ArrayList<AbstractShape>();
      AbstractShape temp;

      for(int i = 0; i < array.size(); i++)
      {
         temp = array.get(i);
         if(temp.getColor() == color)
         {
            result.add(array.get(i));
         }
      }

      return result;
   }

   /**
    * Gives a sum of all of the areas of the shapes on canvas.
    *
    * @return Returns a double with the sum of all of the areas of the shapes.
    */
   public double getAreaOfAllShapes()
   {
      double result = 0;
      AbstractShape temp;

      for(int i = 0; i < array.size(); i++)
      {
         temp = array.get(i);
         result = result + temp.getArea();
      }

      return result;
   }
}