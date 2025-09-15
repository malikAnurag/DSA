package practice.DSA.Array.advanced.SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> al = new ArrayList<>();

        for (int i = 0; i < k; i++) {

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        al.add(nums[dq.peekFirst()]);

        for (int i = k; i < nums.length; i++) {

            if (dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            al.add(nums[dq.peekFirst()]);
        }

        return al.stream().mapToInt(i -> i).toArray();
    }
}
