package practice.DSA.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 *
 * Example 1:
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 *
 *  Example 2:
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 * Constraints:
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 */
public class MeetingRoomsII {

    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}})); // Output: 2
        System.out.println(minMeetingRooms(new int[][]{{7,10},{2,4}})); // Output: 1
    }

    public static int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] interval : intervals) {

            int startTime = interval[0];
            int endTime = interval[1];

            if(!pq.isEmpty() && pq.peek() <= startTime) {
                pq.poll();
            }

            pq.offer(endTime);
        }
        return pq.size();
    }
}
