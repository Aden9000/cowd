import java.util.Scanner;
public class ACT2 {
   public static void main (String ... args){
      Scanner scan = new Scanner(System.in);
      int[] Even = new int [10];
      int[] Odd = new int [10];
      int[] nums = new int [10];
      int x = 0;
      int y = 0;
      for(int i = 0; i < nums.length; i++){
         System.out.print("Input number: ");
         nums[i] = scan.nextInt();
         if(nums[i] % 2 == 0)
            Even[x++]= nums[i];
         else
            Odd[y++]= nums[i];
      }
      System.out.print("Even\t\t\t\tOdd");
      for(int i = 0; i < nums.length; i++){
         if (i < x)
            System.out.print("\n"+Even[i]);
         if (i < y)
            System.out.print("\t\t\t\t\t"+Odd[i]);
         else
            System.out.println();
      }
   }
}
