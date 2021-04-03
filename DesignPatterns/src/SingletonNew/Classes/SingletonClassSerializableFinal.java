package SingletonNew.Classes;

import java.io.Serializable;

public class SingletonClassSerializableFinal implements Serializable {

    private static final long serialVersionUID = 2781492138465062318L;

    private static volatile SingletonClassSerializableFinal sSoleInstance;

    //private constructor.
    private SingletonClassSerializableFinal() {
        //Reflection api safety
        if (sSoleInstance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SingletonClassSerializableFinal getInstance() {
        if (sSoleInstance == null) {
            // Thread safety
            synchronized (SingletonClassSerializableFinal.class) {
                if (sSoleInstance == null) {
                    sSoleInstance = new SingletonClassSerializableFinal();
                }
            }
        }
        return sSoleInstance;
    }

    //Serialization safety
    protected Object readResolve() {
        return getInstance();
    }
}
