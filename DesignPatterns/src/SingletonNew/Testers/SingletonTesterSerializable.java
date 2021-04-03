package SingletonNew.Testers;

import SingletonNew.Classes.SingletonClassSerializableFinal;

import java.io.*;

public class SingletonTesterSerializable {

    public static void main(String[] args) {

        try {
            SingletonClassSerializableFinal instance1 = SingletonClassSerializableFinal.getInstance();
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
            out.writeObject(instance1);
            out.close();

            //deserialize from file to object
            ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
            SingletonClassSerializableFinal instance2 = (SingletonClassSerializableFinal) in.readObject();
            in.close();

            System.out.println("instance1 hashCode=" + instance1.hashCode());
            System.out.println("instance2 hashCode=" + instance2.hashCode());

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
