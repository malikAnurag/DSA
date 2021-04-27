package practice.DSA.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
* First missing integer from numbers 1 to n!!
 * * */

public class FirstMissingInt {

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println("Missing integer: " + findFirst(A));
    }


    public static int findFirst(int[] arr) {

        Map<Integer, Integer> hm = new TreeMap();

        for(int i : arr) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        int index = 1, result = 0;
        boolean isMissing = false;

        System.out.println("Keyset ::" + hm.keySet());

        for(int j : hm.keySet()) {
            if(index != j) {
                isMissing = true;
                result = index;
                break;
            }
            index++;
        }
        if(isMissing)
            return result;
        else
            return index;
    }
}
