package practice.Math;

import java.util.*;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear
 * exactly twice. Find the two elements that appear only once.
 *
 * Example:
 *
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 */
public class SingleNumber3 {

    public static void main(String[] args) {
        Arrays.stream(singleNumber(new int[]{1, 2, 1, 3, 2, 5})).forEach(System.out::println);
    }

    public static int[] singleNumber(int[] nums) {

        int[] result = new int[2];

        Set<Integer> hs = new HashSet();
        Map<Integer, Boolean> hm = new HashMap();

        for (int i : nums) {
            hm.put(i, hs.add(i));
        }
        int counter = 0;

        for (Map.Entry<Integer, Boolean> entry : hm.entrySet()) {
            if (entry.getValue()) {
                result[counter++] = entry.getKey();
            }
        }
        return result;
    }
}
