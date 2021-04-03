package SingletonNew.Classes;

public class SingletonClassThreadSafe {

    // Use of volatile keyword to prevent another thread seeing the half-initialised
    // state of the object; with this all the writes happen before any read
    private static volatile SingletonClassThreadSafe sSoleInstance;

    //private constructor.
    private SingletonClassThreadSafe() {

        //Prevent form the reflection api.
        if (sSoleInstance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SingletonClassThreadSafe getInstance() {
        //Double check locking pattern
        if (sSoleInstance == null) { //Check for the first time
            synchronized (SingletonClassThreadSafe.class) {   //Check for the second time.
                //if there is no instance available... create new one
                if (sSoleInstance == null) {
                    sSoleInstance = new SingletonClassThreadSafe();
                }
            }
        }
        return sSoleInstance;
    }
}
