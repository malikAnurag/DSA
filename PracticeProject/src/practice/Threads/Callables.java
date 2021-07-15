package practice.Threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Callables {

    public static int[] array = IntStream.rangeClosed(0, 5000).toArray();
    public static int total = IntStream.rangeClosed(0, 5000).sum();

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable callable1 = () -> {
            int sum = 0;

            for(int i = 0 ; i < array.length/2 ; i++)
                sum += array[i];
            return sum;
        };

        Callable callable2 = () -> {
            int sum = 0 ;

            for(int i = array.length/2 ; i < array.length ; i++)
                sum += array[i];
            return sum;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Callable<Integer>> taskList = Arrays.asList(callable1, callable2);
        List<Future<Integer>> futures = executorService.invokeAll(taskList);
        int result = 0;

        for(Future<Integer> future : futures) {
            result += future.get();
            System.out.println("Calculating sum :" + result);
        }
        System.out.println("Final result : " + result);
        System.out.println("Total existing result : " + total);
    }
}