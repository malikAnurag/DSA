package practice.Threads;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ForkJoinTask extends RecursiveAction {

    List<Long> data;
    public static Long total = 0L;
    public static int THRESHOLD_VALUE = 5;

    public ForkJoinTask(List<Long> data) {
        this.data = data;
    }

    @Override
    protected void compute() {

        if(data.size() <= THRESHOLD_VALUE) {
            long sum = computeDirectly();
            total += sum;
            System.out.println("Calculating the sum of " + data.toString() + " as : " + sum);
        }
        else {
            int mid = data.size()/2;
            ForkJoinTask firstTask = new ForkJoinTask(data.subList(0, mid));
            ForkJoinTask secondTask = new ForkJoinTask(data.subList(mid, data.size()));

            firstTask.fork(); // queuing the first task ; forking it; asynchronous
            secondTask.compute(); // compute the second task ; highest priority ; synchronously
            firstTask.join(); // waiting for the first task to finish
        }
    }

    private long computeDirectly() {
        long sum = 0;
        for(long l : data) {
            sum += l;
        }
        return sum;
    }


    public static void main(String[] args) {

        List<Long> data = LongStream.rangeClosed(0, 5000).boxed().collect(Collectors.toList());

        ForkJoinTask task = new ForkJoinTask(data);

        ForkJoinPool pool = new ForkJoinPool();

        System.out.println("Parallelism is :: " + pool.getParallelism());

        pool.invoke(task);

        System.out.println("Total sum calculated is : " + total + ", and original sum is: " + LongStream.rangeClosed(0, 5000).sum());

    }

}


