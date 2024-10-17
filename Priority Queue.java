

package javaapplication35;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class JavaApplication35 {

   
    public static void main(String[] args) {
       Queue<Integer> my = new PriorityQueue<>(Collections.reverseOrder());
       
       my.offer(3);
        my.offer(1);
         my.offer(5);
          my.offer(2);
           my.offer(4);
           
           while(!my.isEmpty()){
            System.out.println(my.poll());
        }
            System.out.println("After polling" + my);

   
    }
    
}
