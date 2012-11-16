/**
 * A class to help sort an Inventory, ascending alphabetically.
 *
 * @author Tyler Holland
 * @version Program 6
 * @version CPE102-5
 * @version Winter 2009
 */
import java.util.Comparator;

public class InventorySortA implements Comparator<Product>
{
   public int compare(Product a, Product b)
   {
      if(!(a.getClass().getName().equals(b.getClass().getName())))
      {
         if(a.getClass().getName().equals("Book"))
         {
            return -1;
         }
         else if(b.getClass().getName().equals("Book"))
         {
            return 1;
         }
         else if(a.getClass().getName().equals("BookOnTape"))
         {
            return -1;
         }
         else if(b.getClass().getName().equals("BookOnTape"))
         {
            return 1;
         }
      }
      else
      {
         if(a.getClass().getName().equals("Book"))
         {
            if(((AbstractBook)a).getAuthor().getLast().compareTo
                  (((AbstractBook)b).getAuthor().getLast()) > 0)
            {
               return 1;
            }
            else if(((AbstractBook)a).getAuthor().getLast().compareTo
                  (((AbstractBook)b).getAuthor().getLast()) < 0)
            {
               return -1;
            }
            else if(((AbstractBook)a).getAuthor().getLast().compareTo
                  (((AbstractBook)b).getAuthor().getLast()) == 0)
            {
               if(((AbstractBook)a).getAuthor().getFirst().compareTo
                     (((AbstractBook)b).getAuthor().getFirst()) > 0)
               {
                  return 1;
               }
               else if(((AbstractBook)a).getAuthor().getFirst().compareTo
                     (((AbstractBook)b).getAuthor().getFirst()) < 0)
               {
                  return -1;
               }
               else if(((AbstractBook)a).getAuthor().getFirst().compareTo
                     (((AbstractBook)b).getAuthor().getFirst()) == 0)
               {
                  if(((AbstractBook)a).getAuthor().getMiddle().compareTo
                        (((AbstractBook)b).getAuthor().getMiddle()) > 0)
                  {
                     return 1;
                  }
                  else if(((AbstractBook)a).getAuthor().getMiddle().compareTo
                        (((AbstractBook)b).getAuthor().getMiddle()) < 0)
                  {
                     return -1;
                  }
                  else if(((AbstractBook)a).getAuthor().getMiddle().compareTo
                        (((AbstractBook)b).getAuthor().getMiddle()) == 0)
                  {
                     return 0;
                  }
               }
            }
         }
         if(a.getClass().getName().equals("BookOnTape"))
         {
            if(((BookOnTape)a).getReader().getLast().compareTo
                  (((BookOnTape)b).getReader().getLast()) > 0)
            {
               return 1;
            }
            else if(((BookOnTape)a).getReader().getLast().compareTo
                  (((BookOnTape)b).getReader().getLast()) < 0)
            {
               return -1;
            }
            else if(((BookOnTape)a).getReader().getLast().compareTo
                  (((BookOnTape)b).getReader().getLast()) == 0)
            {
               if(((BookOnTape)a).getReader().getFirst().compareTo
                     (((BookOnTape)b).getReader().getFirst()) > 0)
               {
                  return 1;
               }
               else if(((BookOnTape)a).getReader().getFirst().compareTo
                     (((BookOnTape)b).getReader().getFirst()) < 0)
               {
                  return -1;
               }
               else if(((BookOnTape)a).getReader().getFirst().compareTo
                     (((BookOnTape)b).getReader().getFirst()) == 0)
               {
                  if(((BookOnTape)a).getReader().getMiddle().compareTo
                        (((BookOnTape)b).getReader().getMiddle()) > 0)
                  {
                     return 1;
                  }
                  else if(((BookOnTape)a).getReader().getMiddle().compareTo
                        (((BookOnTape)b).getReader().getMiddle()) < 0)
                  {
                     return -1;
                  }
                  else if(((BookOnTape)a).getReader().getMiddle().compareTo
                        (((BookOnTape)b).getReader().getMiddle()) == 0)
                  {
                     return 0;
                  }
               }
            }
         }
         if(a.getClass().getName().equals("CD"))
         {
            if(((CD)a).getArtist().getLast().compareTo
                  (((CD)b).getArtist().getLast()) > 0)
            {
               return 1;
            }
            else if(((CD)a).getArtist().getLast().compareTo
                  (((CD)b).getArtist().getLast()) < 0)
            {
               return -1;
            }
            else if(((CD)a).getArtist().getLast().compareTo
                  (((CD)b).getArtist().getLast()) == 0)
            {
               if(((CD)a).getArtist().getFirst().compareTo
                     (((CD)b).getArtist().getFirst()) > 0)
               {
                  return 1;
               }
               else if(((CD)a).getArtist().getFirst().compareTo
                     (((CD)b).getArtist().getFirst()) < 0)
               {
                  return -1;
               }
               else if(((CD)a).getArtist().getFirst().compareTo
                     (((CD)b).getArtist().getFirst()) == 0)
               {
                  if(((CD)a).getArtist().getMiddle().compareTo
                        (((CD)b).getArtist().getMiddle()) > 0)
                  {
                     return 1;
                  }
                  else if(((CD)a).getArtist().getMiddle().compareTo
                        (((CD)b).getArtist().getMiddle()) < 0)
                  {
                     return -1;
                  }
                  else if(((CD)a).getArtist().getMiddle().compareTo
                        (((CD)b).getArtist().getMiddle()) == 0)
                  {
                     return 0;
                  }
               }
            }
         }
      }
      return 9000;
   }
}
