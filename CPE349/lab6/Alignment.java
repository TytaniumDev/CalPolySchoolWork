/* Written by Tyler Holland and Spencer Ellsworth */
public class Alignment
{
   public int d[][];
   public int finalx, finaly;
   String gx, gy;
   public int cost[][];
   public String scost;
   
   public int findAlignment(String x, String y)
   {
      gx = x;
      gy = y;
      int n; // length of x
      int m; // length of y
      int i; // iterates through x
      int j; // iterates through y
      
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
        // Examine y
        for (j = 1; j <= m; j++) 
        {
           // Minimum of surrounding cells
           // d[i-1][j-1] = substitute
           // d[i-1][j] = insert
           // d[i][j-1] = delete
           d[i][j] = Minimum (d[i-1][j]+ Match(x.charAt(i-1),'_'),
                              d[i][j-1]+ Match('_',y.charAt(j-1)),
                              d[i-1][j-1] + Match(x.charAt(i-1),y.charAt(j-1)));
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
         /*else
         {
            System.out.println("ERROR");
         }*/
      }
      if(j > 0)
      {
         while(j > 0)
         {
            yaln = gy.charAt(j-1) + yaln;
            xaln = '_' + xaln;
            j--;
         }
      }
      else if(i > 0)
      {
         while(i > 0)
         {
            yaln = '_' + yaln;
            xaln = gx.charAt(i-1) + xaln;
            i--;
         }
      }
      System.out.println(xaln);
      System.out.println(yaln);
   }
   
   public void setMatchingCost(String chars, int[][] ints)
   {
      cost = ints;
      scost = chars;
   }
   
   private int Match(char x, char y)
   {
      int i,j;
      i = scost.indexOf(x);
      j = scost.indexOf(y);
      return cost[i][j];
   }
}
