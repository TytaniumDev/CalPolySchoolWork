//Written by Tyler Holland (tyhollan)
import java.util.Random;

public class RandomText
{
   String text;
   public RandomText(int size)
   {
      int aval = (int) 'a';
      Random rando = new Random();
      char temp[] = new char[size];
      for(int i = 0; i < size; i ++)
      {
         temp[i] = (char)(rando.nextInt(26) + aval);
      }
      text = new String(temp);
   }
}
