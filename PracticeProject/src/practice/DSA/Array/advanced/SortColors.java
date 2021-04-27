package practice.DSA.Array.advanced;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and
 * followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(sortColors(new int[]{2,0,2,1,1,0})));
    }

    public static int[] sortColors(int[] arr) {

        int low = 0 ;
        int mid = 0;
        int high = arr.length - 1;

        while(mid <= high) { // 2 0 2 1 1 0

            if(arr[mid] == 0) {
                swap(arr, low++, mid++);
            }
            else if(arr[mid] == 1) {
                mid++;
            }
            else {
                swap(arr, mid, high--);
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}