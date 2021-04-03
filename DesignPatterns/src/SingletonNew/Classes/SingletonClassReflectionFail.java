package SingletonNew.Classes;

public class SingletonClassReflectionFail {

    private static SingletonClassReflectionFail sSoleInstance;

    private SingletonClassReflectionFail() {
    }  //private constructor.

    public static SingletonClassReflectionFail getInstance() {
        if (sSoleInstance == null) { //if there is no instance available... create new one
            sSoleInstance = new SingletonClassReflectionFail();
        }
        return sSoleInstance;
    }
}
