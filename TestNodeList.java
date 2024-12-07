
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
public class TestNodeList{
   public static void main (String ... args){
      NodeList list = new NodeList();
      list.add(new Node(1));
      list.add(new Node(2));
      list.add(new Node(3));
      list.add(new Node(4));
      list.display();
      list.delete(2);
      list.display();
      list.delete(1);
      list.display();
      list.delete(1);
      list.display();
      list.delete(0);
      list.display();
      list.delete(0);
   }
}
