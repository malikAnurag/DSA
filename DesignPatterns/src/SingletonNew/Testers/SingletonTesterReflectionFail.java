package SingletonNew.Testers;

import SingletonNew.Classes.SingletonClassReflectionFail;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTesterReflectionFail {

    public static void main(String[] args) {
        //Create the 1st instance
        SingletonClassReflectionFail instance1 = SingletonClassReflectionFail.getInstance();

        //Create 2nd instance using Java Reflection API.
        SingletonClassReflectionFail instance2 = null;
        try {
            Class<SingletonClassReflectionFail> clazz = SingletonClassReflectionFail.class;
            Constructor<SingletonClassReflectionFail> constructor = clazz.getDeclaredConstructor();
            // Changing the constructor visibility to public at run-time
            constructor.setAccessible(true);
            instance2 = constructor.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException |
                InstantiationException e) {
            e.printStackTrace();
        }

        //now lets check the hash key.
        System.out.println("Instance 1 hash:" + instance1.hashCode());
        System.out.println("Instance 2 hash:" + instance2.hashCode());
    }
}