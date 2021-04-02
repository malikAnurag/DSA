package practice.DSA.Array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * We have a collection of stones, each stone has a positive integer weight.
 * Each turn, we choose the two heaviest stones and smash them together.
 * Suppose the stones have weights x and y with x <= y.
 *
 * The result of this smash is:
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * <p>
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 */
public class LastStoneWeight {
    public static void main(String[] args) {

        int[] arr = new int[]{2, 7, 4, 1, 8, 1}; // 1 1 2 4 7 8 , 1 1 1 2 4, 1 1 1 2, 1 1 1, 1
        int[] arr1 = new int[]{2, 2};
        System.out.println(lastStoneWeight(arr));
        System.out.println(lastStoneWeight(arr1));

    }

    public static int lastStoneWeight(int[] stones) {

        ArrayList<Integer> al = new ArrayList<>();
        for (int i : stones)
            al.add(i);

        while (al.size() > 1) {
            Collections.sort(al);
            int n = al.size();
            int highest = al.get(n - 1);
            int secondHighest = al.get(n - 2);

            al.remove(al.size() - 2);
            al.remove(al.size() - 1);

            if (highest != secondHighest) {
                al.add(highest - secondHighest);
            }
        }
        if (al.size() > 0)
            return al.get(0);
        else
            return 0;
    }
}
