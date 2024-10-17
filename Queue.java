

package javaapplication34;

import java.util.LinkedList;
import java.util.Queue;

public class JavaApplication34 {

    
    public static void main(String[] args) {
         // Creating a queue using a LinkedList
        Queue<Integer> queue = new LinkedList<>();
        // Adding elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);
        // Accessing and removing elements from the queue (FIFO)
        int firstElement = queue.poll(); // Removes and returns "Apple"
        int secondElement = queue.poll(); // Removes and returns "Banana"
        // Printing the remaining elements in the queue
        System.out.println("Remaining elements in the queue: " + queue);
        // Adding more elements to the queue
        queue.add(4);
        queue.add(5);
        // Accessing and removing elements from the queue (FIFO)
        int thirdElement = queue.poll(); // Removes and returns "Cherry"
        // Printing the remaining elements in the queue
        System.out.println("Remaining elements in the queue: " + queue);
    }
}
    
    

