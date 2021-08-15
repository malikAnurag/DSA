package practice.Threads;

/**
 * Print even-odd numbers with 2 threads.
 */
public class EvenOddMultiThreading {

    public static void main(String[] args) {
        Printer print = new Printer();
        Thread t1 = new Thread(new TaskEvenOdd(print, 10, false), "Odd-Thread");
        Thread t2 = new Thread(new TaskEvenOdd(print, 10, true), "Even-Thread");
        t1.start();
        t2.start();
    }
}

class TaskEvenOdd implements Runnable {

    private int max;
    private Printer print;
    private boolean isEvenNumber;

    public TaskEvenOdd(Printer print, int max, boolean isEvenNumber) {
        this.print = print;
        this.max = max;
        this.isEvenNumber = isEvenNumber;
    }

    @Override
    public void run() {

        int number = isEvenNumber ? 2 : 1;

        while (number <= max) {

            if (isEvenNumber) {
                print.printEven(number);
            }
            else {
                print.printOdd(number);
            }
            number += 2;
        }
    }
}

class Printer {

    private volatile boolean skipOdd;

    synchronized void printEven(int number) {
        while (!skipOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        skipOdd = false;
        notify();
    }

    synchronized void printOdd(int number) {
        while (skipOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        skipOdd = true;
        notify();
    }
}