package SingletonNew.Classes;

public class SingletonClassReflectionSafe {

    private static SingletonClassReflectionSafe sSoleInstance;

    //private constructor.
    private SingletonClassReflectionSafe() {

        //Prevent form the reflection api.
        if (sSoleInstance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SingletonClassReflectionSafe getInstance() {
        if (sSoleInstance == null) { //if there is no instance available... create new one
            sSoleInstance = new SingletonClassReflectionSafe();
        }
        return sSoleInstance;
    }
}