import java.util.Scanner;


public class DiGraphSPTest
{
   public static void main(String[] args)
   {      
      Scanner scan = new Scanner(System.in);

      System.out.println("Choose one of the following operations");
      System.out.println(" -   add edge (enter the letter a)");
      System.out.println(" -   delete edge (enter the letter d)");
      System.out.println(" -   edge count (enter the letter e)");
      System.out.println(" -   vertex count (enter the letter v)");
      System.out.println(" -   print (enter the letter p)");
      System.out.println(" -   topological sort (enter the letter t)");
      System.out.println(" -   is there a path (enter the letter i)");
      System.out.println(" -   length of the path (enter the letter l)");
      System.out.println(" -   shortest path (enter the letter s)");
      System.out.println(" -   quit (enter the letter q)");
      
      System.out.println("Enter the size of the graph: ");
      DiGraphSP graph = new DiGraphSP(scan.nextInt());
      int tempInt1;
      int tempInt2;
      char choice;
      choice = 'g';
      int vertex1;
      int vertex2;
      while(choice != 'q')
      {
         System.out.println("Enter a choice: ");
         choice = scan.next().charAt(0);
         switch (choice)
         {
            case 'a':
               System.out.println("Enter an edge to add: ");
               tempInt1 = scan.nextInt();
               tempInt2 = scan.nextInt();
               graph.addEdge(tempInt1, tempInt2);
               System.out.println("Edge " + tempInt1 + " " + tempInt2 + " added");   
               
               scan.nextLine();
               break;
               
            case 'p':
               graph.print();
               
               break;
               
            case 'd':
               System.out.println("Enter an edge to delete: ");
               tempInt1 = scan.nextInt();
               tempInt2 = scan.nextInt();
               graph.deleteEdge(tempInt1, tempInt2);
               System.out.println("Edge " + tempInt1 + " " + tempInt2 + " deleted");   
               
               scan.nextLine();
               break;
               
            case 'e':
               System.out.println("Edge Count: " + graph.edgeCount());
               
               break;
               
            case 'v':
               System.out.println("Number of vertices: " + graph.vertexCount());
               
               break;
               
            case 't':
               try
               {
                  int[] temp = graph.topSort();
                  System.out.print("Topological Sort: ");
                  for(int i = 0; i < temp.length; i++)
                  {
                     System.out.print("" + temp[i] + " ");
                  }
                  System.out.println();
               }
               catch(RuntimeException e)
               {
                  System.out.println("Can't do topological sort - the graph is cyclic");
               }
               
               break;
               
            case 'i':
               System.out.println("Enter 2 vertices to find a path for: ");
               vertex1 = scan.nextInt();
               vertex2 = scan.nextInt();
               if(graph.isTherePath(vertex1, vertex2))
               {
                  System.out.println("There is a path from " + vertex1 + " to " + vertex2);
               }
               else
               {
                  System.out.println("There is no path from " + vertex1 + " to " + vertex2);
               }
               scan.nextLine();
               break;
               
            case 'l':
               System.out.println("Enter 2 vertices to find the length of the path for: ");
               vertex1 = scan.nextInt();
               vertex2 = scan.nextInt();
               
               System.out.println("The length of the path is: " + graph.lengthOfPath(vertex1, vertex2));
               scan.nextLine();
               break;
               
            case 's':
               System.out.println("Enter 2 vertices to find a path for: ");
               vertex1 = scan.nextInt();
               vertex2 = scan.nextInt();
               if(graph.isTherePath(vertex1, vertex2))
               {
                  graph.printPath(vertex1, vertex2);
               }
               else
               {
                  System.out.println("There is no path from " + vertex1 + " to " + vertex2);
               }
               scan.nextLine();
               break;
               
            case 'q':
               System.out.println("quitting");
               break;
               
            default:
               System.out.println("Invalid choice");
         }
      }
   }
}
