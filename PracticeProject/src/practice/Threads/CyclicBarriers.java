package practice.Threads;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Sum of 15000 numbers using cyclic barriers
 */
public class CyclicBarriers {

    public static int[] arr1 = IntStream.rangeClosed(0, 5000).toArray();
    public static int[] arr2 = IntStream.rangeClosed(5001, 10000).toArray();
    public static int[] arr3 = IntStream.rangeClosed(10001, 15000).toArray();

    public static int total = IntStream.rangeClosed(0, 15000).sum();

    public static CyclicBarrier barrier = new CyclicBarrier(3);
    // parties : number of calls required to the await method in order to cross the barrier

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException, ExecutionException {

        Callable<Integer> callable1 = () -> {
            int sum = 0;
            sum += calculateSum(0, arr1.length / 2, arr1);

            //Waits until all parties have invoked await on this barrier
            // code is blocked and the barrier increases the count by this method

            barrier.await();
            sum += calculateSum(0, arr2.length / 2, arr2);
            barrier.await();
            sum += calculateSum(0, arr3.length / 2, arr3);
            barrier.await();
            return sum;
        };

        Callable<Integer> callable2 = () -> {
            int sum = 0;
            sum += calculateSum(arr1.length / 2, arr1.length, arr1);
            barrier.await();
            sum += calculateSum(arr2.length / 2, arr2.length, arr2);
            barrier.await();
            sum += calculateSum(arr3.length / 2, arr3.length, arr3);
            barrier.await();
            return sum;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<Integer> sum1 = executorService.submit(callable1);
        Future<Integer> sum2 = executorService.submit(callable2);

        System.out.println("Calculating first sum");
        barrier.await();
        System.out.println("Calculated first sum");

        System.out.println("Calculating second sum");
        barrier.await();
        System.out.println("Calculated second sum");

        System.out.println("Calculating third sum");
        barrier.await();
        System.out.println("Calculated third sum");

        int sum = sum1.get() + sum2.get();

        System.out.println("\nCalcuted sum of three arrays :: " + sum);
        System.out.println("Actual sum of three arrays ::" + total);

        executorService.shutdown();
    }

    private static int calculateSum(int start, int end, int[] array) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}
