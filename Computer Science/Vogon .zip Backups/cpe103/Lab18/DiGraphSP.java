
public class DiGraphSP
{
   private int adjTable[][];
   
   public DiGraphSP(int N)
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
   
   private class PathInfo
   {
      public int distance;
      public int lastVertex;
      public PathInfo()
      {
         distance = -1;
         lastVertex = -1;
      }
   }
   
   private PathInfo[] shortestPaths(int vertex)
   {
      PathInfo[] array = new PathInfo[adjTable.length];
      for(int i = 0; i < array.length; i++)
      {
         array[i] = new PathInfo();
      }
      array[vertex].distance = 0;
      array[vertex].lastVertex = -1;
   
      LQueue<Integer> queue = new LQueue<Integer>();
      queue.enqueue(vertex);
      int v;
      while(!queue.isEmpty())
      {
         v = queue.dequeue();
         for(int x = 0; x < adjTable.length ; x++)
         {
            if(adjTable[v][x] == 1)
            {
               if(array[x].distance == -1)
               {
                    array[x].distance = array[v].distance+1;
                    array[x].lastVertex = v;
                    queue.enqueue(x);
               } 
            }
         }
      }
      return array;
   }
   
   public boolean isTherePath(int vertex1, int vertex2)
   {
      PathInfo[] array = shortestPaths(vertex1);
      if(array[vertex2].distance > -1)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   public int lengthOfPath(int vertex1, int vertex2)
   {
      PathInfo[] array = shortestPaths(vertex1);
      return array[vertex2].distance;
   }
   
   public void printPath(int from, int to)
   {
      PathInfo[] array = shortestPaths(from);
      printPath(array, from, to);
      System.out.println();
   }
   private void printPath(PathInfo[] arr, int from, int to)
   {
      if(from == to)
      {
         System.out.print(from);
      }
      else
      {
         printPath(arr, from, arr[to].lastVertex);
         System.out.print(" to " + to);
      }
   }
}
