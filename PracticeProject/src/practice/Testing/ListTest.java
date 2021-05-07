package practice.Testing;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {

        List<Address> al = new ArrayList<>();

        Address address = new Address("RanjitPura");
        al.add(address);

        List<Address> al2 = new ArrayList<>();
        al2.add(address);

        al2.get(0).setStreetName("RaniBagh");

        System.out.println(al.get(0).streetName);
    }

    static class Address{
        String streetName;

        Address(String streetName){
            this.streetName = streetName;
        }

        void setStreetName(String streetName){
            this.streetName=streetName;
        }
    }
}
