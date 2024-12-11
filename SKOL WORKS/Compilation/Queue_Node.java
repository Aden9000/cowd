package Compilation;
import java.util.Scanner;

class QueueNode
{
   Object value;
   QueueNode next;
   
   public QueueNode(Object value)
   {
      this.value = value;
      this.next = null;
   }
}

public class Queue_Node 
{
   QueueNode first;
   QueueNode last;
   int count;
   
   public Queue_Node()
   {
      first = null;
      last = null;
      count = 0;
   }
   
   public boolean isEmpty()
   {
      return first == null && last == null;
      //return count == 0;
   }
   
   public boolean enqueue(Object value)
   {
      QueueNode newNode = new QueueNode(value);
      if(isEmpty())
      {
         //first = last = newNode;
         first = newNode;
         last = newNode;
      }
      else 
      {
         last.next = newNode;
         last = newNode;
      }
      count++;
      return true;
   }
   
   public boolean dequeue()
   {
      if(!isEmpty())
      {
         if(first == last)
         {
            first = null;
            last = null;
         }
         else 
         {
            first = first.next;
         }
         count--;
         return true;
      }
      else
         return false;
   }
   
   public String getFirst()
   {
    String result = "";
      if(!isEmpty())
      return result += "first = [" + first.value + "]\n";      
      else
      return result = "Queue is empty...";
   }
   
   public String getLast()
   {
    String result = "";
      if(!isEmpty())
         return result += "last  = [" + last.value + "]\n";
      else
         return result = "Queue is empty...";
   }
   
   
   //toString
   public String toString()
   {
      String result = "";
      if(!isEmpty())
      {
         QueueNode temporary = first;
         while(temporary != null)
         {
            result += "[" + temporary.value + "]->";
            temporary = temporary.next;
         }
         result += "\n";
         return result;
      }
      
      
      else
         return result = "Queue is empty...";
   }
   
   
   
   public static void queuenode(String ... args)
   {
      Scanner scan = new Scanner(System.in);
      Queue_Node qn = new Queue_Node();
      boolean condition = true;
      
      
      while(condition){
         System.out.println("\nMenu:\n[1] Enqueue\n[2] Dequeue\n[3] Get first item\n[4] Get last item\n[5] Display queue\n[6] Exit\nChoose:  ");
         String choice = scan.nextLine();
         switch(choice){
            case "1":
                System.out.println("Input Item: ");
                Object value = scan.nextLine();
                qn.enqueue(value);
               break;
            case "2":
                qn.dequeue();
                System.out.println("Dequeue successful...");
                break;
            case "3":
                System.out.println(qn.getFirst());
                break;
            case "4":
                System.out.println(qn.getLast());
                break;
            case "5":
                System.out.println("Items: "+ qn);
                break;
            case "6":
               condition = false;
               System.out.println("Exiting...");
               break;
            default:
               System.out.println("Invalid choice...");
               break;
         }
      }   
   }
} 