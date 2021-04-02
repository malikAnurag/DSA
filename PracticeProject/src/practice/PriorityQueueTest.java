package practice;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> pQueue =
                new PriorityQueue<Integer>(Collections.reverseOrder());

        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(400);

        // Printing the most priority element
        System.out.println("Head value using peek function:" + pQueue.poll());

        // Printing all elements
        System.out.println("The queue elements:");
        Iterator itr = pQueue.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
    }
}
