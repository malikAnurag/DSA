package SingletonNew.Testers;

import SingletonNew.Classes.SingletonClass;
import SingletonNew.Classes.SingletonClassThreadSafe;

public class SingletonTesterThreadSafe {

    public static void main(String[] args) {
        //Thread 1
        Thread t1 = new Thread(() -> {
            SingletonClassThreadSafe instance1 = SingletonClassThreadSafe.getInstance();
            System.out.println("Instance 1 hash:" + instance1.hashCode());
        });

        //Thread 2
        Thread t2 = new Thread(() -> {
            SingletonClassThreadSafe instance2 = SingletonClassThreadSafe.getInstance();
            System.out.println("Instance 2 hash:" + instance2.hashCode());
        });

        //start both the threads
        t1.start();
        t2.start();
    }
}
