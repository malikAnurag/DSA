package SingletonNew.Testers;

import SingletonNew.Classes.SingletonClass;

public class SingletonTesterThreadFail {

    public static void main(String[] args) {
        //Thread 1
        Thread t1 = new Thread(() -> {
            SingletonClass instance1 = SingletonClass.getInstance();
            System.out.println("Instance 1 hash:" + instance1.hashCode());
        });

        //Thread 2
        Thread t2 = new Thread(() -> {
            SingletonClass instance2 = SingletonClass.getInstance();
            System.out.println("Instance 2 hash:" + instance2.hashCode());
        });

        //start both the threads
        t1.start();
        t2.start();
    }
}
