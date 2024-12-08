package Compilation;

import java.util.Scanner;

class Node{
    int data;
    Node next;
    public Node(int data){
       this.data = data;
       this.next = null;
    }
 }
 class NodeList{
    Node last;
    int counter;
    public NodeList(){
       this.last = null;
       this.counter = 0;
    }
    public boolean isEmpty(){
       return last == null;
    }
    public boolean add(Node item){
       if (isEmpty()){
          last = item;
       }else{
          Node temp = last;
          while(temp.next != null){
             temp = temp.next;
          }
          temp.next = item;
       }
       counter++;
       return true;
    }
    public boolean delete(int location){
       if (isEmpty() || location < 0 || location >= counter){
          System.out.println("Location out of bounds");
          return false;
       }
       if (location == 0) {
          last = last.next;
       } else {
          Node temp = last;
          for(int i = 0; i < location - 1; i++){
             temp = temp.next;
          }
          temp.next = temp.next.next;
       }
       counter--;
       return true;
    }
    public void display(){
       if(isEmpty()){
          System.out.println("List is empty");
          return;
       }
       Node temp = last;
       int index = 0;
       while(temp != null){
          System.out.print("Node "+ temp.data +" at index "+ index+"\n");
          temp = temp.next;
          index++;
       }
       System.out.println();
    }
 }
 public class Node_List{
    public static void nodelist (String ... args){
       NodeList list = new NodeList();
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("[1] Add a Node");
            System.out.println("[2] Display the List");
            System.out.println("[3] Delete a Node");
            System.out.println("[4] Exit");
            String choice = scan.nextLine();

            switch (choice) {
                case "1": 
                  try{
                    System.out.print("Enter the value for the new node: ");
                    int value = scan.nextInt();
                    list.add(new Node(value));
                    System.out.println("Node with value " + value + " added.");
                  }catch (Exception e) {
                     System.out.println("Invalid input. Please enter a valid integer.");
                     scan.nextLine(); 
                 }
                    break;

                case "2": 
                    System.out.println("Displaying the list:");
                    list.display();
                    break;

                case "3": 
                    System.out.print("Enter the index of the node to delete: ");
                    int index = scan.nextInt();
                    try {
                        list.delete(index);
                        System.out.println("Node at index " + index + " deleted.");
                        
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        break;
                    }
                    break;

                case "4": 
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
 }
