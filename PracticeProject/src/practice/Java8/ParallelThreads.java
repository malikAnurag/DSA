package practice.Java8;

public class ParallelThreads {

    public static void main(String[] args) {
        ParallelTask1 task1 = new ParallelTask1();
        ParallelTask2 task2 = new ParallelTask2();
        task1.start();
        task2.start();
    }
}

class ParallelTask1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println(Thread.currentThread().getName() + " is printing : " + i);
    }
}

class ParallelTask2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println(Thread.currentThread().getName() + " is printing : " + i);
    }
}
