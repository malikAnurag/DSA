package practice.Testing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenOddMultiThread {

    public static void main(String[] args) {

        Printer printer = new Printer();
        PrintEvenOddTask evenTask = new PrintEvenOddTask(printer, 10, true);
        PrintEvenOddTask oddTask = new PrintEvenOddTask(printer, 10, false);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(evenTask);
        executorService.submit(oddTask);
    }
}


class PrintEvenOddTask implements Runnable {

    private Printer printer;
    private int max;
    private boolean isEvenNumber;

    public PrintEvenOddTask(Printer printer, int max, boolean isEvenNumber) {
        this.printer = printer;
        this.max = max;
        this.isEvenNumber = isEvenNumber;
    }

    @Override
    public void run() {

        int number = isEvenNumber ? 2 : 1;

        while(number < max) {
            if(number % 2 == 0) {
                printer.printEven(number);
            }
            else {
                printer.printOdd(number);
            }
            number += 2;
        }
    }
}


class Printer {

    public static volatile boolean skipOdd;

    synchronized void printEven(int number) {
        while(skipOdd) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + number);
        skipOdd = true;
        notify();
    }

    synchronized void printOdd(int number) {

        while(!skipOdd) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + number);
        skipOdd = false;
        notify();
    }
}
