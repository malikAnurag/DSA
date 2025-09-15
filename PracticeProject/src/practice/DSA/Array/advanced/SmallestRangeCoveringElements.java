package practice.DSA.Array.advanced;

import java.util.*;

/**
 * You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.
 * <p>
 * We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.
 * <p>
 * Example 1:
 * Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
 * Output: [20,24]
 * Explanation:
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 * <p>
 * Example 2:
 * Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
 * Output: [1,1]
 * <p>
 * Constraints:
 * nums.length == k
 * 1 <= k <= 3500
 * 1 <= nums[i].length <= 50
 * -105 <= nums[i][j] <= 105
 * nums[i] is sorted in non-decreasing order.
 */
public class SmallestRangeCoveringElements {

    public int[] smallestRange(List<List<Integer>> nums) {

        List<int[]> merged = new ArrayList<>();
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                merged.add(new int[]{num, i});
            }
        }

        Collections.sort(merged, (a, b) -> a[0] - b[0]);
        int left = 0, rangeStart = 0, rangeEnd = Integer.MAX_VALUE, count = 0;

        for (int right = 0; right < merged.size(); right++) {

            int[] arr = merged.get(right);
            int idx = arr[1];

            hm.put(idx, hm.getOrDefault(idx, 0) + 1);

            if (hm.get(idx) == 1)
                count++;

            while (count == nums.size()) {

                int currRange = merged.get(right)[0] - merged.get(left)[0];

                if (currRange < rangeEnd - rangeStart) {
                    rangeStart = merged.get(left)[0];
                    rangeEnd = merged.get(right)[0];
                }

                int leftIdx = merged.get(left)[1];

                hm.put(leftIdx, hm.get(leftIdx) - 1);

                if (hm.get(leftIdx) == 0) {
                    count--;
                }
                left++;
            }
        }
        return new int[]{rangeStart, rangeEnd};
    }
}
