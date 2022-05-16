package practice.DSA.PriorityQueue;

import java.util.*;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
 * An integer a is closer to x than an integer b if:
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 *
 * Example 1:
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 *
 * Example 2:
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 *
 * Constraints:
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * arr is sorted in ascending order.
 * -104 <= arr[i], x <= 104
 */
// TODO : Check Two pointers/binary searach to reduce time and space complexity
// Time complexity: O(N*log(N) + k*log(k))
// Space complexity: O(N)
public class FindKClosestElements {

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>() {

            @Override
            public int compare(Integer a, Integer b) {

                int A = Math.abs(x - a);
                int B = Math.abs(x - b);

                if((A - B) != 0) {
                    return A - B;
                }
                else {
                    return a < b ? -1 : 1;
                }
            }
        });

        for(int i : arr) {
            pq.add(i);
        }

        List<Integer> result = new ArrayList();

        while(k > 0) {
            result.add(pq.remove());
            k--;
        }
        Collections.sort(result);
        return result;
    }
}
