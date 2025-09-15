package practice.Threads.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/*
* Semaphores are perfect for controlling the execution order of multiple threads
* By initializing them with appropriate permits, we can ensure that threads run in the desired sequence
* */
public class PrintOddEven {

    public static void main(String[] args) {

        PrintOddEven printOddEven = new PrintOddEven(10);
        IntConsumer consumer = number -> System.out.print(number + " ");

        Runnable runnable1 = () -> {
            try {
                printOddEven.printZero(consumer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable runnable2 = () -> {
            try {
                printOddEven.printEven(consumer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable runnable3 = () -> {
            try {
                printOddEven.printOdd(consumer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(runnable1);
        executorService.submit(runnable2);
        executorService.submit(runnable3);
        executorService.shutdown();
    }

    Semaphore zeroSemaphore;
    Semaphore evenSemaphore;
    Semaphore oddSemaphore;
    int n;

    public PrintOddEven(int n) {
        zeroSemaphore = new Semaphore(1);
        evenSemaphore = new Semaphore(0);
        oddSemaphore = new Semaphore(0);
        this.n = n;
    }

    private void printZero(IntConsumer printNumber) throws InterruptedException {

        boolean isOdd = true;

        for (int i = 0; i < n; i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0);
            if (isOdd) {
                oddSemaphore.release();
            } else {
                evenSemaphore.release();
            }
            isOdd = !isOdd;
        }
    }

    private void printEven(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }

    private void printOdd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }
}
