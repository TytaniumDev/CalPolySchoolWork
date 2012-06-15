
public class SortTester
{
   public static void main(String[] args)
   {
      Integer[] array = new Integer[30];
      for(int i = 0; i < array.length; i++)
      {
         array[i] = 40 - i;
      }
      array[10] = 50;
      array[20] = 0;
      
      Integer[] selection = new Integer[30];
      Integer[] bubble = new Integer[30];
      Integer[] insertion = new Integer[30];
      Integer[] merge = new Integer[30];
      Integer[] quick = new Integer[30];
      
      for(int i = 0; i < array.length; i++)
      {
         selection[i] = array[i];
         bubble[i] = array[i];
         insertion[i] = array[i];
         merge[i] = array[i];
         quick[i] = array[i];
      }
      
      Sorts.selectionSort(selection, selection.length);
      Sorts.bubbleSort(bubble, 30);
      Sorts.insertionSort(insertion, 30);
      Sorts.mergeSort(merge, 30);
      Sorts.quickSort(quick, 30);
      
      System.out.print("Selection: ");
      for(int i = 0; i < 30; i++)
      {
         System.out.print("" + selection[i] + " ");
      }
      System.out.println();
      
      System.out.print("Insertion: ");
      for(int i = 0; i < 30; i++)
      {
         System.out.print("" + insertion[i] + " ");
      }
      System.out.println();
      
      System.out.print("Bubble: ");
      for(int i = 0; i < 30; i++)
      {
         System.out.print("" + bubble[i] + " ");
      }
      System.out.println();
      
      System.out.print("Merge: ");
      for(int i = 0; i < 30; i++)
      {
         System.out.print("" + merge[i] + " ");
      }
      System.out.println();
      
      System.out.print("Quick: ");
      for(int i = 0; i < 30; i++)
      {
         System.out.print("" + quick[i] + " ");
      }
      System.out.println();
   }
}
