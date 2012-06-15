//Written by Tyler Holland (tyhollan)
import java.util.Random;

public class RandomText
{
   String text;
   public RandomText(int size)
   {
      Random rando = new Random();
      char temp[] = new char[size];
      for(int i = 0; i < size; i ++)
      {
         switch(rando.nextInt(4))
         {
            case 0:
               temp[i] = 'A';
               break;
            case 1:
               temp[i] = 'T';
               break;
            case 2:
               temp[i] = 'C';
               break;
            case 3:
               temp[i] = 'G';
               break;
            default:
               temp[i] = 'A';
         }
      }
      text = new String(temp);
   }
}
