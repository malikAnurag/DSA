package practice.DSA.Array.advanced;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of integers arr of even length, return true if and only if it is possible to reorder it such that arr[2 * i + 1] = 2 * arr[2 * i]
 * for every 0 <= i < len(arr) / 2.
 *
 * Example 1:
 * Input: arr = [3,1,3,6]
 * Output: false
 *
 * Example 2:
 * Input: arr = [2,1,2,6]
 * Output: false
 *
 * Example 3:
 * Input: arr = [4,-2,2,-4]
 * Output: true
 * Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
 *
 * Example 4:
 * Input: arr = [1,2,4,16,8,4]
 * Output: false
 *
 * Constraints:
 * 0 <= arr.length <= 3 * 104
 * arr.length is even.
 * -105 <= arr[i] <= 105
 * TODO: https://www.youtube.com/watch?v=tbq0fnZ-IhM
 */
public class ArrayOfDoubledPairs {

    public static void main(String[] args) {
        System.out.println(checkArray(new int[] {3,1,3,6}));
        System.out.println(checkArray(new int[] {2,1,2,6}));
        System.out.println(checkArray(new int[] {4,-2,2,-4}));
        System.out.println(checkArray(new int[] {1,2,4,16,8,4}));
    }

    /* Utilizing the target elements on the basis of the current element */
    static boolean checkArray(int[] arr) {

        Map<Integer, Integer> treeMap = new TreeMap<>();

        for(int i : arr) {
            treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
        }

        for(int i : treeMap.keySet()) {

            if(treeMap.get(i) == 0)
                continue;

            if(i < 0 && i % 2 != 0) {
                return false;
            }

            int target = i > 0 ? 2 * i : i/2;

            if(treeMap.get(i) > treeMap.getOrDefault(target, 0)) {
                return false;
            }
            treeMap.put(target, treeMap.get(target) - treeMap.get(i));
        }
        return true;
    }
}