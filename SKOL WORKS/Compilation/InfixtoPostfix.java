package Compilation;
import java.util.*;

class Node2 {
    String data;
    Node2 next;

    public Node2(String data) {
        this.data = data;
        this.next = null;
    }
}

class NodeList2 {
    Node2 top;
    int count;

    public NodeList2() {
        this.top = null;
        this.count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean push(String data) {
        Node2 node = new Node2(data);
        node.next = top;
        top = node;
        count++;
        return true;
    }

    public String pop() {
        if (!isEmpty()) {
            String data = top.data;
            top = top.next;
            count--;
            return data;
        }
        return null;
    }

    public String peek() {
        if (!isEmpty()) {
            return top.data;
        }
        return null;
    }

    public int getCount() {
        return count;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        } else {
            Node2 temp = top;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
 
 
class InfixPostfix {
    private String infix;

    public InfixPostfix(String i) {
        infix = i;
    }

    private int getPrec(char o) {
        if (o == '*' || o == '/') return 2;
        if (o == '+' || o == '-') return 1;
        return -1;
    }

    public String convert() {
        NodeList2 s = new NodeList2();
        String result = "";
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isDigit(c)) {
                result += c;
            } else if (c == '(') {
                s.push(c + "");
            } else if (c == ')') {
                while (!s.isEmpty() && !s.peek().equals("(")) {
                    result += s.peek();                     s.pop();
                }
                s.pop();
            } else {
                while (!s.isEmpty() && (getPrec(c) <= getPrec(s.peek().charAt(0)))) {
                    result += s.peek(); 
                    s.pop();
                }
                s.push(c + "");
            }
        }
        while (!s.isEmpty()) {
            result += s.peek();
            s.pop();
        }
        return result;
    }

}


class Eval {
    private String postfix;
    
    public Eval(String p){
        postfix = p;
    }
    
    public double getResult(){
        NodeList2 s = new NodeList2();
        double ans = 0;
        for(int i=0; i < postfix.length(); i++){
            char ch = postfix.charAt(i);
            if(Character.isDigit(ch)){
                s.push(ch+"");
                
            } else{
                double val2 = Double.parseDouble(s.pop());
                double val1 = Double.parseDouble(s.pop());
                
                switch(ch){
                    case '*':
                            ans= val1*val2;
                            break;
                    case '/':
                            ans = val1/val2;
                            break;
                    case '+':
                            ans = val1+val2;
                            break;
                    case '-':
                            ans = val1-val2;
                            break;
                }
                s.push(ans+"");
                
            }
        }
        return Double.parseDouble(s.pop());
    }
    
  
}
public class InfixtoPostfix{
    public static void infixtopostfix(String... args) {
        Scanner scan = new Scanner(System.in);
        InfixPostfix ip;
        Eval e;
        boolean c = true;
        String postfix= "";
        System.out.println("Input Infix: ");
        String infix = scan.nextLine();
        while(c == true){
        System.out.println("\nPostfix Program:\n[1] Convert to Postfix.\n[2] Evaluate Postfix.\n[3] Exit.");
        String choice = scan.nextLine();
        
        switch(choice){
            case "1" :
                  ip = new InfixPostfix(infix);
                  System.out.println("Result: " + ip.convert());
                  postfix = ip.convert();
                  break;
            case "2" :
                  ip = new InfixPostfix(infix);
                  postfix = ip.convert();
                  e = new Eval(postfix);
                  System.out.println("Result : "+ e.getResult());
                  break; 
            case "3" :
                  c = false;
                  break; 
            default  :
                System.out.println("Invalid choice...");   
                break;
         }
      }
   }
}
