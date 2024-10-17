

package javaapplication32;
import java.util.LinkedList;

public class JavaApplication32 {

   
    public static void main(String[] args) {
         
        LinkedList<Integer> numbers = new LinkedList<>();
// insertion
                                                                                                                                                                                                                                                                 
        numbers.addFirst(6);
          numbers.addLast(8);
        numbers.add(1);
          numbers.add(2, 5);
        System.out.println("Linked List Original: " + numbers);
        System.out.println(numbers.size());
//  Seraching  
       
        boolean containslion = numbers.contains(5);
        System.out.println(containslion);
        
    }
}
    
    

