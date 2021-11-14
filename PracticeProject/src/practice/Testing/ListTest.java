package practice.Testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListTest {

    private static final List<Integer> finalList = Collections.unmodifiableList(Arrays.asList(1,2,3,4));

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
        List<Integer> list;

        Address(String streetName){
            this.streetName = streetName;
        }

        Address(List<Integer> list) {
            this.list = list;
        }

        void setStreetName(String streetName){
            this.streetName=streetName;
        }
    }
}
