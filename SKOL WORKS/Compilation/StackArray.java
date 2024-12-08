package Compilation;
import java.util.Scanner;
public class StackArray {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackArray(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
        } else {
            stackArray[++top] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        } else {
            System.out.println("Popped successfully.");
            return stackArray[top--];
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void stackarray(String... args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Enter the size of the stack: ");
            StackArray stack = new StackArray(scan.nextInt());
        
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
                                int value = scan.nextInt();
                                stack.push(value);
                            } catch (Exception e) {
                                System.out.println("Invalid input. Please enter an integer.");
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
                    }
                
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid size.");
            scan.nextLine(); 
        }    
    }
}
