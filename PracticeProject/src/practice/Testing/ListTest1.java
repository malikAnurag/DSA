package practice.Testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest1 {

    public static void main(String[] args) {


        Demo d1 = new Demo();
        d1.getL1().add(1);

        System.out.println(d1.getL1().get(0));

    }


    static class Demo {

         List<Integer> l1;

        public List<Integer> getL1() {
            return l1;
        }

        public void setL1(List<Integer> l1) {
            this.l1 = l1;
        }
    }
}
