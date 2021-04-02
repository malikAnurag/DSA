package practice.Threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Callables1 {

    public static int[] arr = IntStream.rangeClosed(0, 5000).toArray();
    public static int total = IntStream.rangeClosed(0, 5000).sum();

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable<Integer> callable1 = () -> {

            int sum = 0;

            for(int i = 0 ; i < arr.length/2 ; i++) {
                sum += arr[i];
            }
            return sum;
        };

        Callable<Integer> callable2 = () -> {

            int sum = 0 ;

            for(int i = arr.length/2; i < arr.length ; i++) {
                sum += arr[i];
            }
            return sum;
        };

        List<Callable<Integer>> callables = Arrays.asList(callable1, callable2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Future<Integer>> futures = executorService.invokeAll(callables);

        int res = 0;

        for(Future<Integer> future : futures) {
            res += future.get();
            System.out.println("Adding sum :: "+ future.get() + " to the total value");
        }
        executorService.shutdown();

        System.out.println("Calculated sum :: " + res);
        System.out.println("Original sum :: " + total);
    }
}
