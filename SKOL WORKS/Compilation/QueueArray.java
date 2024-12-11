package Compilation;
import java.util.Scanner;
public class QueueArray {
    private Object [] items;
    private int count;

    public QueueArray(int size){
        items = new Object[size];
        count = 0;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == items.length;
    }

    public boolean enqueue(Object value){
        if (!isFull()){
            items[count++] = value;
            return true;
        }else{
            System.out.println("Queue is full...");
            return false;
        }
    }

    public boolean dequeue(){
        if (!isEmpty()){
            for(int i = 1; i < count; i++){
                items[i-1] = items[i];
            }
            items[count-1] = null;
            count--;
            System.out.println("Dequeue successful...");
            return true;
        }else{
            System.out.println("Queue is empty...");
            return false;
        }
    }

    public void display(){
        if(!isEmpty()){
            for(int i = 0; i < count; i++){
                System.out.print("["+items[i]+"]->");
            }
            System.out.println();
        }else{
            System.out.println("Queue is empty...");
        }
    }

    public static void queuearray(String ... args) {
        Scanner scan = new Scanner(System.in);
        try{
            System.out.print("Enter the size of the queue: ");
            QueueArray queue = new QueueArray(scan.nextInt());
            scan.nextLine();
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Enqueue.");
                System.out.println("2. Dequeue.");
                System.out.println("3. Display queue.");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");
                String choice = scan.nextLine();
                    switch (choice) {
                        case "1": 
                            try {
                                System.out.print("Enter a value to push: ");
                                String value = scan.nextLine();
                                queue.enqueue(value);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                scan.nextLine(); 
                            }
                            break;
                        case "2": 
                            queue.dequeue();
                            break;
                        case "3": 
                            queue.display();
                            break;
                        case "4":
                            System.out.println("Exiting program...");
                            return;
                        default:
                            System.out.println("Invalid choice...");
                            break;
                    }
                
            }
        }catch(Exception e){
            System.out.println("Invalid input. Please enter a valid size.");
            scan.nextLine(); 
        }
    }
}