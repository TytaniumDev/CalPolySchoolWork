/**
 * A CD Class that uses Product to store extra info about CDs.
 *
 * @author Tyler Holland
 * @version Program 4
 * @version CPE102-5
 * @version Winter 2009
 */

public class CD extends Product
{
   //Instance Variables
   private String title;
   private Name artist;
   
   //Constructors
   public CD()
   {
      super();
      this.title = null;
      this.artist = new Name();
   }

   public CD(int productID)
   {
      super(productID);
      this.title = null;
      this.artist = new Name();
   }
   
   //Methods
   public String getTitle()
   {
      return title;
   }
   public void setTitle(String title)
   {
      if(title == null)
      {
         this.title = title;
      }
      else
      {
         this.title = new String(title);
      }
   }
   public Name getArtist()
   {
      return artist;
   }
   public void setArtist(Name artist)
   {
      this.artist = artist;
   }
   public boolean equals(Object other)
   {
      if(!super.equals(other))
      {
         return false;
      }
      if(!(((CD)other).title == null || this.title.equals(((CD)other).title)))
      {
         return false;
      }
      if(!(((CD)other).artist.getFirst() == null || 
         this.artist.getFirst().equals(((CD)other).artist.getFirst())))
      {
         return false;
      }
      if(!(((CD)other).artist.getMiddle() == null ||
         this.artist.getMiddle().equals(((CD)other).artist.getMiddle())))
      {
         return false;
      }
      if(!(((CD)other).artist.getLast() == null ||
         this.artist.getLast().equals(((CD)other).artist.getLast())))
      {
         return false;
      }
   return true;
   }
}
