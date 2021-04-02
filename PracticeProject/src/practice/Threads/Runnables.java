package practice.Threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Runnables {

    public static int[] arr = IntStream.rangeClosed(0, 5000).toArray();
    public static int total = IntStream.rangeClosed(0, 5000).sum();
    public static int sum = 0;


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Runnable runnable1 = () -> {
            for(int i = 0 ; i < arr.length/2 ; i++) {
                sum += arr[i];
            }
        };

        Runnable runnable2 = () -> {
            for(int i = arr.length/2; i < arr.length ; i++) {
                sum += arr[i];
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(runnable1);
        executorService.submit(runnable2);

        // We can not use runnable for this case as we need both the computed sums at this point and while using runnables, we can't
        // make sure that the task is finished at this point.
        // If we use callable, we can make use of get() method which is blocking and give us the correct computed result at this point.
        // Also, here we have to make use of callables as they return a future object whose get method can be used!
        int res = sum;

        System.out.println("Calculated sum :: " + res);
        System.out.println("Original sum :: " + total);
    }
}

