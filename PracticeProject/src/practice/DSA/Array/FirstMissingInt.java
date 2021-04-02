package practice.DSA.Array;

import java.util.HashMap;

/**
* First missing integer from numbers 1 to n!!
 * * */

public class FirstMissingInt {

    public static void main(String[] args) {

        int[] A = new int[]{1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println("Missing integer: " + findFirst(A));
    }


    public static int findFirst(int[] arr) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i : arr) {
            if (!hm.containsKey(i)) {
                hm.put(i, 1);
            } else {
                hm.put(i, hm.get(i) + 1);
            }
        }

        int index = 1, result = 0;
        boolean isMissing = false;

        for (int j : hm.keySet()) {
            if (index != j) {
                isMissing = true;
                result = index;
                break;
            }
            index++;
        }
        if (isMissing)
            return result;
        else
            return index;

    }
}
