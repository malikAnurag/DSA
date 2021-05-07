package practice.DSA.Array.advanced;

import java.util.Arrays;
/**
 * Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 to n and obeys the following requirement:
 * Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
 *
 * If there are multiple answers, print any of them.
 *
 * Example 1:
 * Input: n = 3, k = 1
 * Output: [1, 2, 3]
 * Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.
 *
 * Example 2:
 * Input: n = 3, k = 2
 * Output: [1, 3, 2]
 * Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.
 */
public class BeautifulArrangement2 {
    // n = total different positive integers
    // k = distinct differences in the new list

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArray(3, 1)));
        System.out.println(Arrays.toString(constructArray(3, 2)));
    }

    public static int[] constructArray(int n, int k) {

        int counter = 0;
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        for(int i = 0; i < k; i++) {
            rotate(arr, counter++);
        }
        return arr;
    }

    public static void rotate(int[] arr, int start) {

        int left = start, right = arr.length - 1;

        while(left <= right) {
            int t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;

            left++;
            right--;
        }
    }
}