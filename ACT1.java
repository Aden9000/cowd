import java.util.Scanner;
public class ACT1 {
   public static void main (String ... args){
      Scanner scan = new Scanner(System.in); 
      int nums, sum = 0;
      int product = 1; 
      System.out.println("Input 10 integer numbers:");
      for(int i = 0; i < 10; i++){
         System.out.println("Input number:");
         nums = scan.nextInt();
         sum += nums;
         if(sum <= 0){
            sum = 0;
         }
         if( nums <= 0){
            nums = 1;     
         }
         product *= nums;
      }
      System.out.println("Sum is : "+sum);
      System.out.println("Product is : "+product);
   }
}