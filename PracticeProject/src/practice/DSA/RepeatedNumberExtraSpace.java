package practice.DSA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Find out the repeated elements (can use extra space)
 */
public class RepeatedNumberExtraSpace {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 3, 1};

        Set<Integer> hs = new HashSet<>();
        boolean flag;
        ArrayList<Integer> al = new ArrayList<>();

        for (int i : arr) {
            flag = hs.add(i);
            if (!flag)
                al.add(i);
        }

        System.out.println(al);
    }
}
