package practice.DSA.Array2D;

import java.util.Arrays;

/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to
 * make the rest of the intervals non-overlapping.
 * <p>
 * Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.
 * <p>
 * Example 1:
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 * <p>
 * Example 2:
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
 * <p>
 * Example 3:
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        int count = 0, k = Integer.MIN_VALUE;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        for(int[] interval : intervals) {
            if(k <= interval[0]) {
                k = interval[1];
            } else {
                count++;
            }
        }
        return count;
    }
}
