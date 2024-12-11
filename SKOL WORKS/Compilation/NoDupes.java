package Compilation;
import java.util.*;

public class NoDupes
{
   public static void NoDuplicates(String ... args)
   {
      Scanner input = new Scanner(System.in);
      int[] num = new int[10];
      String result = "";
      int x;
      int count;
      int arr_count = 0;
      
      System.out.println("Enter 10 numbers:");
      for(count = 0; count < 10; count = count + 1)
      {
         x = input.nextInt();
         if(!isExisting(x, arr_count, num))
         {
            num[arr_count++] = x;
            result += x + "\n";
         }
      }
      
      System.out.println("\nDuplicates removed: \n"+result);
   }
   
   public static boolean isExisting(int x, int arr_count, int[] arr)
   {
      for(int i=0; i<arr_count; i++)
      {
         if(x == arr[i])
            return true;
      }
      
      return false;
   
   }
   
}


