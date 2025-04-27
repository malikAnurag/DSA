package practice.DP.Knapsack.zero_one;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array arr[] of size n, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
 * If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2))
 * should be minimum.
 * <p>
 * Example:
 * Input: arr = [1, 6, 11, 5]
 * Output: 1
 * Explanation: S1 = [1, 5, 6], sum = 12,  S2 = [11], sum = 11,  Absolute Difference (12 – 11) = 1
 * <p>
 * Input: arr = [1, 5, 11, 5]
 * Output: 0
 * Explanation: S1 = [1, 5, 5], sum = 11, S2 = [11], sum = 11, Absolute Difference (11 – 11) = 0
 */
public class PartitionSetIntoMinDifferenceSubsets {

    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{1, 6, 11, 5}));
        System.out.println(minimumDifference(new int[]{1, 5, 11, 5}));
        System.out.println(minimumDifference(new int[]{11, 99, 101, 4}));
    }

    public static int minimumDifference(int[] nums) {

        int range = 0;
        int n = nums.length;
        List<Integer> al = new ArrayList<>();

        for (int i : nums) {
            range += i;
        }

        boolean[][] subset = subsetSum(nums, range);

        // Difference : S2 - S1 => Range - S1 - S1 => Range - 2*S1
        // Use the last row of the matrix to see which all sums are possible with the array elements
        // Loop only till range/2 because we want S1 to be smaller than S2
        for (int i = 0; i <= range / 2; i++) {
            if (subset[n][i]) {
                al.add(i);
            }
        }

        int min = Integer.MAX_VALUE;

        for (int sum : al) {
            if (range - (2 * sum) < min) {
                min = range - (2 * sum);
            }
        }
        return min;
    }


    private static boolean[][] subsetSum(int[] arr, int sum) {

        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp;
    }
}
