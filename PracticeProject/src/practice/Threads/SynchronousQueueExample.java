package practice.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueExample {

    public static void main(String[] args) {

        String[] names = {"Anurag", "Dipika", "Aveer", "Malik", "Tambawala"};

        SynchronousQueue<String> queue = new SynchronousQueue<>();

        Runnable producer = () -> {
            try {
                for (String name : names) {
                    queue.put(name);
                    System.out.println("Inserting " + name + " in the queue");
                    TimeUnit.MILLISECONDS.sleep(2000);
                }
            }catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        };

        Runnable consumer = () -> {
            try {
                while (true) {
                    System.out.println("Consuming the name ::" + queue.take());
                    TimeUnit.MILLISECONDS.sleep(10000);
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(producer);
        executorService.submit(consumer);
        executorService.shutdown();
    }
}
