package practice.DSA.Array.advanced.Subarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
 *
 * The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element
 * and skipping the third element is invalid.
 *
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 * Find and return the required subarray.
 *
 * NOTE:
 * If there is a tie, then compare with segment's length and return segment which has maximum length.
 * If there is still a tie, then return the segment with minimum starting index.
 *
 * Input 1:
 *  A = [1, 2, 5, -7, 2, 3]
 *
 * Input 2:
 *  A = [10, -1, 2, 3, -4, 100]
 *
 * Example Output
 *
 *  Output 1:
 *  [1, 2, 5]
 *
 *  Output 2:
 *  [100]
 */
public class MaxNonNegativeSubArray {
    public static void main(String[] args) {

        int[] A = new int[]{1, 2, 5, -7, 2, 3};
        int[] result = maxSet(A);
        System.out.printf(Arrays.toString(result));

        int[] B = new int[]{10, -1, 2, 3, -4, 100};
        result = maxSet(B);
        System.out.println("\n"+ Arrays.toString(result));
    }

    public static int[] maxSet(int[] A) {

        List<Integer> maxArray = new ArrayList<>();
        List<Integer> newArray = new ArrayList<>();
        long sum = Integer.MIN_VALUE;
        long curr = 0;

        for (int i : A) {

            if (i >= 0) {
                curr += i;
                newArray.add(i);
            }
            else {
                newArray = new ArrayList<>();
                curr = 0;
            }

            if (curr > sum || (curr == sum && newArray.size() > maxArray.size())) {
                maxArray = newArray;
                sum = curr;
            }
        }
        return maxArray.stream().mapToInt(i -> i).toArray();
    }
}
