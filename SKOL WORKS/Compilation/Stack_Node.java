package Compilation;

import java.util.Scanner;

class StackNode 
{
   String data;
   StackNode tail;
   
   public StackNode(String data)
   {
      this.data = data;
      tail = null;
   }   
}

public class Stack_Node
{
   private StackNode top;
   private int count;
   
   public Stack_Node()
   {
      top = null;
      count = 0;
   }
   
   private boolean isEmpty()
   {
      //return top == null;
      return count == 0;
   }
   
   public boolean push(String data)
   {
      StackNode node = new StackNode(data);
      node.tail = top;
      top = node;
      count++;
      return true;
   }
   
   public boolean pop()
   {
      if(!isEmpty())
      {
         top = top.tail;
         count--;
         return true;
      }
      return false;
   }
   
   public String peek()
   {
      if(!isEmpty())
      {
         return top.data;
      }
      return null;
   }
   
   public int getcount()
   {
      return count;
   }
   
   public void display()
   {
      if(!isEmpty())
      {
         StackNode temporary = top;
         while(temporary != null)
         {
            System.out.println(temporary.data);
            temporary = temporary.tail;
         }
         System.out.println();
      }
      else 
      {
         System.out.println("Stack is empty....");
      }
   }
   
   
   public static void stacknode(String ... args){
            Scanner scan = new Scanner(System.in);
            Stack_Node stack = new Stack_Node();
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Push");
                System.out.println("2. Pop");
                System.out.println("3. Peek");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");
                    String choice = scan.nextLine();
                    switch (choice) {
                        case "1": 
                            try {
                                System.out.print("Enter a value to push: ");
                                String value = scan.nextLine();
                                stack.push(value);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                scan.nextLine(); 
                            }
                            break;
                        case "2": 
                            stack.pop();
                            break;
                        case "3": 
                            System.out.println("["+stack.peek()+"]");
                            break;
                        case "4":
                            System.out.println("Exiting program...");
                            return;
                        default:
                            System.out.println("Invalid choice...");
                            break;
                    }
                
            }
            
   }
   
}
