package practice.Threads.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {

    public static void main(String[] args) throws InterruptedException {

        IntConsumer printNumber = number -> System.out.print(number + " ");

        Runnable fizz = () -> System.out.print("Fizz ");
        Runnable buzz = () -> System.out.print("Buzz ");
        Runnable fizzBuzzRunnable = () -> System.out.print("fizzBuzz ");

        FizzBuzz fizzBuzz = new FizzBuzz(25);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Runnable runnable1 = () -> {
            try {
                fizzBuzz.printFizz(fizz);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable runnable2 = () -> {
            try {
                fizzBuzz.printBuzz(buzz);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable runnable3 = () -> {
            try {
                fizzBuzz.printFizzBuzz(fizzBuzzRunnable);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable runnable4 = () -> {
            try {
                fizzBuzz.printNumber(printNumber);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        executorService.submit(runnable1);
        executorService.submit(runnable2);
        executorService.submit(runnable3);
        executorService.submit(runnable4);
    }

    Semaphore numberSemaphore;
    Semaphore fizzSemaphore;
    Semaphore buzzSemaphore;
    Semaphore fizzbuzzSemaphore;
    int n;

    public FizzBuzz(int n) {
        numberSemaphore = new Semaphore(1);
        fizzSemaphore = new Semaphore(0);
        buzzSemaphore = new Semaphore(0);
        fizzbuzzSemaphore = new Semaphore(0);
        this.n = n;
    }

    private void printNumber(IntConsumer printNumber) throws InterruptedException {

        for(int i = 1 ; i <= n ; i++) {

            numberSemaphore.acquire();

            if(i % 3 == 0 && i % 5 != 0) {
                fizzSemaphore.release();
            } else if(i % 3 != 0 && i % 5 == 0) {
                buzzSemaphore.release();
            } else if(i % 3 == 0 && i % 5 == 0) {
                fizzbuzzSemaphore.release();
            } else {
                printNumber.accept(i);
                numberSemaphore.release();
            }
        }
    }

    private void printFizz(Runnable printFizz) throws InterruptedException {
        for(int i = 1 ; i <= n ; i++) {
            fizzSemaphore.acquire();
            printFizz.run();
            numberSemaphore.release();
        }
    }

    private void printBuzz(Runnable printBuzz) throws InterruptedException {
        for(int i = 1 ; i <= n ; i++) {
            buzzSemaphore.acquire();
            printBuzz.run();
            numberSemaphore.release();
        }
    }

    private void printFizzBuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i = 1 ; i <= n ; i++) {
            fizzbuzzSemaphore.acquire();
            printFizzBuzz.run();
            numberSemaphore.release();
        }
    }
}
