
import java.util.Scanner;
public class QueueArray{
   private Object[] items;
   private int count;
   public QueueArray(int size){
      items = new Object[size];
      count = 0;
   }
   public boolean isEmpty(){
      if(count == 0)
         return true;
      else
         return false;
   }
   public boolean isFull(){
      return count == items.length;
   }
   public boolean enqueue(Object val){
      if(!isFull()){
         items[count++] = val;
         return true;
      }
      return false;
   }
   public boolean dequeue(){
      if(!isEmpty()){
         for(int i = 1; i < count; i++){
            items[i-1] = items[i];
         }
         items[count-1] = null;
         count--;
         return true;
      }
      return false;
   }
   public void display(){
      if(!isEmpty()){
         for(int i=0; i<count; i++){
            System.out.println("["+items[i]+"]");
         }
         System.out.println();
      }else
         System.out.println("Queue is empty.");
   }
   public static void main(String ... args){
      Scanner scan = new Scanner(System.in);
      boolean c = true;
      QueueArray qa = new QueueArray(4);
      while(c == true){
         System.out.println("\n[1] Enqueue.\n[2] Dequeue.\n[3] Display Queue.\n[4]Exit.");
         int choice = scan.nextInt();
         scan.nextLine();
         switch(choice){
            case 1 :
               System.out.println("Enqueue: ");
               qa.enqueue(scan.nextLine());
               break;
            case 2 :
               qa.dequeue();
               break;
            case 3 :
               qa.display();
               break;
            case 4 :
               c = false;
               break;
         }
      }
   }
}