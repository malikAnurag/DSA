package practice.DSA.TwoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * <p>
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 * <p>
 * Example 1:
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 * <p>
 * Example 2:
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * arr is sorted in ascending order.
 * -104 <= arr[i], x <= 104
 */
// TODO : Check binary search to reduce time complexity
// Time complexity: O(N)
// Space complexity: O(1)
public class FindKClosestElements {

    public static void main(String[] args) {
        System.out.println(findKClosest(new int[]{1,2,3,4,5}, 4, 3));
        System.out.println(findKClosest(new int[]{1,2,3,4,5}, 4, -1));
    }

    public static List<Integer> findKClosest(int[] arr, int k, int x) {

        int left = 0 , right = arr.length - 1;

        while(right - left + 1 > k) {

            if(x - arr[left] <= arr[right] - x) {
                right--;
            }
            else if(x - arr[left] > arr[right] - x) {
                left++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = left ; i <= right ; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
