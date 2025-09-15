package practice.DSA.Array.advanced.SlidingWindow;

import java.util.*;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the
 * very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p>
 * Return the max sliding window.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * <p>
 * Example 3:
 * Input: nums = [1,-1], k = 1
 * Output: [1,-1]
 * <p>
 * Example 4:
 * Input: nums = [9,11], k = 2
 * Output: [11]
 * <p>
 * Example 5:
 * Input: nums = [4,-2], k = 2
 * Output: [4]
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{9, 11}, 2)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{4, -2}, 2)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<Integer>();
        List<Integer> al = new ArrayList<>();

        for (int i = 0; i < k; i++) {

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        al.add(nums[dq.peekFirst()]);

        for (int i = k; i < nums.length; i++) {

            if (!dq.isEmpty() && i - dq.peekFirst() == k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
            al.add(nums[dq.peekFirst()]);
        }
        return al.stream().mapToInt(i -> i).toArray();
    }
}
