/* Written by Tyler Holland and Spencer Ellsworth */
public class EditDistance
{
   public int d[][];
   public int finalx, finaly;
   String gx, gy;
   public int findEditDistance(String x, String y)
   {
      gx = x;
      gy = y;
      int n; // length of x
      int m; // length of y
      int i; // iterates through x
      int j; // iterates through y
      char x_i; // i'th character of x
      char y_j; // j'th character of y
      int cost; // cost
      //Initialize stuff
      n = x.length ();
      m = y.length ();
      if (n == 0) 
      {
        return m;
      }
      if (m == 0) 
      {
        return n;
      }
      d = new int[n+1][m+1];
      // First row + column = 0
      for (i = 0; i <= n; i++) 
      {
        d[i][0] = i;
      }
      for (j = 0; j <= m; j++) 
      {
        d[0][j] = j;
      }
      // Examine x
      for (i = 1; i <= n; i++) 
      {
        x_i = x.charAt (i - 1);
        // Examine y
        for (j = 1; j <= m; j++) 
        {
           y_j = y.charAt (j - 1);
           // Equal, cost is 0, else 1
           if (x_i == y_j) 
           {
              cost = 0;
           }
           else 
           {
              cost = 1;
           }
           // Minimum of surrounding cells
           // d[i-1][j-1] = substitute
           // d[i-1][j] = insert
           // d[i][j-1] = delete
           d[i][j] = Minimum (d[i-1][j]+1, d[i][j-1]+1, d[i-1][j-1] + cost);
        }
      }
      // Distance is in here
      finalx = n;
      finaly = m;
      return d[n][m];
   }
   
   private int Minimum (int a, int b, int c) 
   {
      int mi;

        mi = a;
        if (b < mi)
        {
          mi = b;
        }
        if (c < mi) 
        {
          mi = c;
        }
        return mi;
   }
   
   public void getAlignment()
   {
      int i, j; //Coordinates
      int temp;
      i = finalx;
      j = finaly;
      String xaln, yaln; //Aligned strings
      xaln = new String("");
      yaln = new String("");
      temp = 0;
      
      while(i > 0 && j > 0)
      {
         temp = Minimum(d[i-1][j-1], d[i-1][j], d[i][j-1]);
         if(temp == d[i-1][j-1]) //Diagonal
         {
            xaln = gx.charAt(i-1) + xaln;
            yaln = gy.charAt(j-1) + yaln;
            i--;
            j--;
         }
         else if (temp == d[i][j-1])
         {
            xaln = '_' + xaln;
            yaln = gy.charAt(j-1) + yaln;
            j--;
         }
         else if (temp == d[i-1][j])
         {
            xaln = gx.charAt(i-1) + xaln;
            yaln = '_' + yaln;
            i--;
         }
         else
         {
            System.out.println("ERROR");
         }
      }
      if(j > 0)
      {
         while(j > 0)
         {
            yaln += gy.charAt(j-1);
            xaln += '_';
            j--;
         }
      }
      else if(i > 0)
      {
         while(i > 0)
         {
            yaln += '_';
            xaln += gx.charAt(i-1);
            i--;
         }
      }
      System.out.println(xaln);
      System.out.println(yaln);
   }
}
