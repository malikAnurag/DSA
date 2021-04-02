package practice;

public class SingletonClass {

    private static volatile SingletonClass singletonObj;

    private SingletonClass() {};


    public SingletonClass getInstance() {
        if(singletonObj == null) {
            synchronized (SingletonClass.class) {
                if(singletonObj == null) {
                    singletonObj = new SingletonClass();
                }
            }
        }
        return singletonObj;
    }
}
