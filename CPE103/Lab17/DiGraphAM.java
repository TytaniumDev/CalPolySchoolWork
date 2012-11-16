
public class DiGraphAM
{
   private int adjTable[][];
   
   public DiGraphAM(int N)
   {
      adjTable = new int[N][N];
   }
   
   public void addEdge(int first, int second)
   {
      adjTable[first][second] = 1;
   }
   
   public void deleteEdge(int first, int second)
   {
      adjTable[first][second] = 0;
   }
   
   public int edgeCount()
   {
      int count = 0;
      for(int i = 0; i < adjTable.length; i++)
      {
         for(int j = 0; j < adjTable.length; j++)
         {
            if(adjTable[i][j] == 1)
            {
               count++;
            }
         }
      }
      return count;
   }
   
   public int vertexCount()
   {
      return adjTable.length;
   }
   
   public void print()
   {
      for(int i = 0; i < adjTable.length; i++)
      {
         System.out.print("" + i + " is connected to: ");
         for(int j = 0; j < adjTable.length; j++)
         {
            if(adjTable[i][j] == 1)
            {
               System.out.print("" + j + " ");  
            }
         }
         System.out.println();
      }
   }
   
   private int[] indegrees()
   {
      int[] temp = new int[adjTable.length];
      for(int i = 0; i < adjTable.length; i++)
      {
         for(int j = 0; j < adjTable.length; j++)
         {
            if(adjTable[i][j] == 1)
            {
               temp[j]++;
            }
         }
      }
      return temp;
   }
   
   public int[] topSort()
   {
      int[] temp = indegrees();
      int[] answer = new int[adjTable.length];
      LQueue<Integer> vertices = new LQueue<Integer>();
      int counter = 0;
      
      for(int i = 0; i < adjTable.length; i++)
      {
         if(temp[i] == 0)
         {
            vertices.enqueue(i);
         }
      }
      
      while(!vertices.isEmpty())
      {
         int v = vertices.dequeue();
         answer[counter] = v;
         counter++;
         for(int i = 0; i < adjTable.length; i++)
         {
            if(adjTable[v][i] == 1)
            {
               temp[i]--;
               if(temp[i] == 0)
               {
                  vertices.enqueue(i);
               }
            }
         }
      }
      
      if(counter != adjTable.length)
      {
         throw new RuntimeException();
      }
      return answer;
   }
}
