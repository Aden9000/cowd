package Compilation;
import java.util.*;
public class Menu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean condition = true;
        
        while(condition){
            System.out.println("\nChoose an operation: \n[1] No Duplicate Integer.\n[2] Largest Integer.\n[3] Sum and Product.\n[4] Even and Odd Integers.\n[5] Infix to Postfix.\n[6] Node List.\n[7] Stack Array.\n[8] Stack Node.\n[9] Queue Array.\n[10] Queue Node.\n[11] Exit.");
            String choice = scan.nextLine();
            switch(choice){
                case "1" :
                    try {
                        NoDupes.NoDuplicates();
                    } catch (java.util.InputMismatchException e) {
                            System.out.println("Error: Please enter a valid integer.");
                    }
                    break;
                case "2" :
                    try{
                        Largest.largest();
                    }catch (java.util.InputMismatchException e) {
                        System.out.println("Error: Please enter a valid integer.");
                    }
                    break;
                case "3":
                    try{
                        SumandPRod.sumandprod();
                    }catch (java.util.InputMismatchException e) {
                        System.out.println("Error: Please enter a valid integer.");
                    }
                    break;
                case "4":
                    try{
                        EvenandOdd.evenandodd();
                    }catch (java.util.InputMismatchException e) {
                        System.out.println("Error: Please enter a valid integer.");
                    }
                    break;
                case "5":
                    try{
                        InfixtoPostfix.infixtopostfix();
                    }catch (Exception e) {
                        System.out.println("Error: Please enter a valid infix expression.");
                    }
                    break;
                case "6":
                    try{
                        Node_List.nodelist();
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "7":
                    try{
                        StackArray.stackarray();
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "8":
                    try{
                        Stack_Node.stacknode();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "9":
                    try{
                        QueueArray.queuearray();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "10":
                    try{
                        Queue_Node.queuenode();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "11":
                    System.out.println("Menu Exited...");
                    condition = false;
                    break;
                default :
                    System.out.println("Invalid choice...");
                    break;
            }
        }
    }
}
