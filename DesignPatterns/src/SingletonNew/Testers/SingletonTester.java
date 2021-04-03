package SingletonNew.Testers;

import SingletonNew.Classes.SingletonClass;
import SingletonNew.Classes.SingletonClassReflectionFail;

public class SingletonTester {

    public static void main(String[] args) {
        //Instance 1
        SingletonClass instance1 = SingletonClass.getInstance();

        //Instance 2
        SingletonClass instance2 = SingletonClass.getInstance();

        //now lets check the hash key.
        System.out.println("Instance 1 hash:" + instance1.hashCode());
        System.out.println("Instance 2 hash:" + instance2.hashCode());
    }
}
