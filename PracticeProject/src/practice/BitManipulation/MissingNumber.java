package practice.BitManipulation;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 *
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 *
 * Example 1:
 * Input: nums = [3,0,1]
 * Output: 2
 *
 * Example 2:
 * Input: nums = [0,1]
 * Output: 2
 *
 *  Example 3:
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 *
 *  Example 4:
 * Input: nums = [0]
 * Output: 1
 */
public class MissingNumber {

    public static void main(String[] args) {

        int[] arr1 = {3, 0, 1};
        int[] arr2 = {0, 1};
        int[] arr3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int[] arr4 = {0};
        System.out.println(getMissingNumber(arr1));
        System.out.println(getMissingNumber(arr2));
        System.out.println(getMissingNumber(arr3));
        System.out.println(getMissingNumber(arr4));
    }


    public static int getMissingNumber(int[] arr) {

        int k1 = 0, k2 = 0;

        for (int i = 0; i <= arr.length; i++) {
            k1 ^= i;
        }

        for (int i : arr) {
            k2 ^= i;
        }
        return k1 ^ k2;
    }
}
