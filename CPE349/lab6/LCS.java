/* Written by Tyler Holland and Spencer Ellsworth */
public class LCS
{
   public int[][] opt;
   public int M;
   public int N;
   public String ax;
   public String ay;
   
   public void findLCS(String x, String y)
   {
      ax = x;
      ay = y;
      M = x.length();
      N = y.length();
      
      opt = new int[M+1][N+1];
      
      //Compute length of LCS and all subproblems
      for(int i = M-1; i >= 0; i--)
      {
         for(int j = N-1; j >= 0; j--)
         {
            if(x.charAt(i) == y.charAt(j))
            {
               opt[i][j] = opt[i+1][j+1] + 1;
            }
            else
            {
               opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
            }
         }
      }
   }
   
   public String getLCS()
   {
      String ret = new String("");
      int M = ax.length();
      int N = ay.length();
      int i = 0, j = 0;
      while(i < M && j < N) {
          if (ax.charAt(i) == ay.charAt(j)) {
              ret+=(ax.charAt(i));
              i++;
              j++;
          }
          else if (opt[i+1][j] >= opt[i][j+1]) i++;
          else                                 j++;
      }
      return ret;
   }
}
