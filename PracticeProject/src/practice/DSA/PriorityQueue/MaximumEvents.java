package practice.DSA.PriorityQueue;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.
 * <p>
 * You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.
 * <p>
 * Return the maximum number of events you can attend.
 * <p>
 * Example 1:
 * Input: events = [[1,2],[2,3],[3,4]]
 * Output: 3
 * Explanation: You can attend all the three events.
 * One way to attend them all is as shown.
 * Attend the first event on day 1.
 * Attend the second event on day 2.
 * Attend the third event on day 3.
 * <p>
 * Example 2:
 * Input: events= [[1,2],[2,3],[3,4],[1,2]]
 * Output: 4
 * <p>
 * Constraints:
 * 1 <= events.length <= 105
 * events[i].length == 2
 * 1 <= startDayi <= endDayi <= 105
 */
public class MaximumEvents {

    public static void main(String[] args) {

    }

    private static int getMaxEvents(int[][] events) {

        int lastDay = 0, i = 0, count = 0, day = 1, n = events.length;
        Arrays.sort(events, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] event : events) {
            lastDay = Math.max(lastDay, event[1]);
        }

        while(day <= lastDay) {

            while(i < n && events[i][0] == day) {
                pq.add(events[i][1]);
                i++;
            }

            while(!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if(!pq.isEmpty()) {
                count++;
                pq.poll();
            }
            day++;
        }
        return count;
    }

}
