package practice.DSA.Array.advanced.SlidingWindow;

/**
 * You are given a binary array nums.
 * You can do the following operation on the array any number of times (possibly zero):
 * Choose any 3 consecutive elements from the array and flip all of them.
 * Flipping an element means changing its value from 0 to 1, and from 1 to 0.
 * Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible, return -1.
 * <p>
 * Example 1:
 * Input: nums = [0,1,1,1,0,0]
 * Output: 3
 * <p>
 * Explanation:
 * We can do the following operations:
 * Choose the elements at indices 0, 1 and 2. The resulting array is nums = [1,0,0,1,0,0].
 * Choose the elements at indices 1, 2 and 3. The resulting array is nums = [1,1,1,0,0,0].
 * Choose the elements at indices 3, 4 and 5. The resulting array is nums = [1,1,1,1,1,1].
 * <p>
 * Example 2:
 * Input: nums = [0,1,1,1]
 * Output: -1
 * Explanation:
 * It is impossible to make all elements equal to 1.
 */
public class MinOpsToMakeBinaryElementsTo1 {

    public int minOperations(int[] nums) {

        int flips = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 2] == 0) {
                nums[i - 2] = 1 - nums[i - 2];
                nums[i - 1] = 1 - nums[i - 1];
                nums[i] = 1 - nums[i];
                flips++;
            }
        }

        int sum = 0;
        for (int n : nums)
            sum += n;

        return sum == nums.length ? flips : -1;
    }
}
