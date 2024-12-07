
import java.util.Scanner;
class Node
{
   Object value;
   Node next;
   public Node(Object value)
   {
      this.value = value;
      this.next = null;
   }
}
public class QueueNode
{
   Node first;
   Node last;
   int count;
   public QueueNode()
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
      Node newNode = new Node(value);
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
         return result += "last = [" + last.value + "]\n";
      else
         return result = "Queue is empty...";
   }
//toString
   public String toString()
   {
      String result = "";
      if(!isEmpty())
      {
         Node temporary = first;
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
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      QueueNode qn = new QueueNode();
      boolean condition = true;
      while(condition){
         System.out.println("\nMenu:\n1. Enqueue\n2. Dequeue\n3. Get first item\n4.Get last item\n5. Display queue\n6. Exit\nChoose: ");
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
