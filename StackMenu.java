//Aldrin Meller T. Basalo
import java.util.Scanner;
public class StackMenu{

   public static void main(String ... args){
      Scanner scan = new Scanner(System.in);
      String choice;
      String item;
      int size;
      System.out.println("Enter size: ");
      size = scan.nextInt();
      scan.nextLine();
      StackArray stack = new StackArray(size);
      do{
         System.out.println("\n--Stack Array Menu--\n1.] Push an item\n2.] Pop an item\n3.] Peek\n4.] Display Stack\nx.] Exit Program");
         System.out.println("Select a choice: ");
         choice = scan.nextLine().toUpperCase();
         switch(choice){
         case "1":
            System.out.println("Input item to Push: ");
            item = scan.nextLine();
            stack.push(item);
            break;
         case "2":
            stack.pop();
            break;
         case "3":
            System.out.println("Item peeked: "+stack.peek());
            break;
         case "4":
            stack.display();
            break;
         case "X":
            System.out.println("Program Ended...");
            break;
         default:
            System.out.println("Invalid Input");
            break;
         }
      }while(!choice.equals("X"));
   }
}