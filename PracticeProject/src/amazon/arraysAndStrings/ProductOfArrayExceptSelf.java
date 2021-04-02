package amazon.arraysAndStrings;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the
 * product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array
 * (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for
 * the purpose of space complexity analysis.)
 */

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        for (int i : getProductArray(new int[]{1, 2, 3, 4}))
            System.out.print(i + " ");
    }

    public static int[] getProductArray(int[] arr) {

        int[] result = new int[arr.length];
        int prod = arr[0];
        result[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            result[i] = prod;
            prod *= arr[i];
        }

        prod = 1;

        for (int j = arr.length - 1; j >= 0; j--) {
            result[j] *= prod;
            prod *= arr[j];
        }
        return result;
    }
}
