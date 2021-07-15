package practice.DSA.BinarySearch.advanced;

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

// Time complexity : O(log(N−k)+k)
// Space complexity: O(1)
public class FindKClosestElements {

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
        System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, -1));
    }

    /*
    First of all, what is the biggest index the left bound could be? If there needs to be k elements, then the left bound's upper limit is arr.length - k,
    because if it were any further to the right, you would run out of elements to include in the final answer.

    Let's consider two indices at each binary search operation, the usual mid, and some index mid + k.
    The relationship between these indices is significant because only ONE of them could possibly be in a final answer.
    For example, if mid = 2, and k = 3, then arr[2] and arr[5] could not possibly both be in the answer, since that would require
    taking 4 elements [arr[2], arr[3], arr[4], arr[5]].

    This leads us to the question: how do we move our pointers left and right?
    If the element at arr[mid] is closer to x than arr[mid + k], then that means arr[mid + k], as well as every element to the right of it can never be
    in the answer.
    This means we should move our right pointer to avoid considering them. The logic is the same vice-versa - if arr[mid + k] is closer to x,
    then move the left pointer.
     */
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0, right = arr.length - k;

        while(left < right) {

            int mid = (left + right) / 2;

            if(x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        List<Integer> al = new ArrayList();

        for(int i = left; i < left + k; i++) {
            al.add(arr[i]);
        }
        return al;
    }
}
