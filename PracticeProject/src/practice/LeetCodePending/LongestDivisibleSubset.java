package practice.LeetCodePending;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in
 * this subset satisfies:
 *
 * Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 *
 * Example 2:
 *
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 */
public class LongestDivisibleSubset {

    public static void main(String[] args) {

        System.out.println(largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;

        if (n == 0)
            return new ArrayList();

        int[] count = new int[n];
        Arrays.fill(count, 1);
        Arrays.sort(nums);

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
        }

        int maxIndex = 0;
        List<Integer> al = new ArrayList<>();

        for (int i = 0; i < n; i++)
            maxIndex = count[i] > count[maxIndex] ? i : maxIndex;

        int temp = nums[maxIndex];
        int currentCount = count[maxIndex];

        for (int j = maxIndex; j >= 0; j--) {
            if (temp % nums[j] == 0 && currentCount == count[j]) {
                al.add(nums[j]);
                temp = nums[j];
                currentCount--;
            }
        }
        Collections.sort(al);
        return al;
    }
}
