
package javaapplication33;

import java.util.Stack;
public class JavaApplication33 {

   
    public static void main(String[] args) {
       Stack<String> mystack = new Stack<>();
        
        // Push elements onto the stack
        mystack.push("Felix");
        mystack.push("benhard");
        mystack.push("Pogi");
         
        System.out.println("Stack: " + mystack);
        // Pop and display the top element
        String topElement = mystack.pop();
        System.out.println("Popped: " + topElement);
        
        // Peek at the top element without removing it
           String peekedElement = mystack.peek();
        System.out.println("Peeked: " + peekedElement);
        // Check if the stack is empty
        boolean isEmpty = mystack.isEmpty();
        System.out.println("Is Stack Empty? " + isEmpty);
        // Get the size of the stack
         int stackSize = mystack.size();
        System.out.println("Stack Size: " + stackSize);
    }
    
}
