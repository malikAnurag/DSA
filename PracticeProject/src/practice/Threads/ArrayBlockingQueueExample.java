package practice.Threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueExample {

    public static void main(String[] args) {

        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);

        // This adds numbers in the blocking queue and gets blocked once the queue is full i.e. 5 elements are filled (capacity mentioned while initializing)
        // Resumes only when the count drops below the capacity in the queue and there's space in the queue for new elements to get added
        Runnable producer = () -> {
            int i = 1;
            while (true) {
                try {
                    blockingQueue.put(i);
                    System.out.println("Putting i : " + i++);
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // This removes the elements from the queue and makes space for the addition of new elements
        Runnable consumer = () -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10000);
                    int poll = blockingQueue.take();
                    System.out.println("Polled i : " + poll);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(producer);
        executorService.submit(consumer);

        executorService.shutdown();
    }
}
