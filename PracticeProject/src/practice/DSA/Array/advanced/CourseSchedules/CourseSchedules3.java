package practice.DSA.Array.Advanced.CourseSchedules;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * There are n different online courses numbered from 1 to n. You are given an array courses where courses[i] = [durationi, lastDayi]
 * indicate that the ith course should be taken continuously for durationi days and must be finished before or on lastDayi.
 *
 * You will start on the 1st day and you cannot take two or more courses simultaneously.
 *
 * Return the maximum number of courses that you can take.
 *
 * Example 1:
 *
 * Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
 * Output: 3
 * Explanation:
 * There are totally 4 courses, but you can take 3 courses at most:
 * First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take the next course on the 101st day.
 * Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day.
 * Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day.
 * The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.
 *
 * Example 2:
 * Input: courses = [[1,2]]
 * Output: 1
 *
 * Example 3:
 * Input: courses = [[3,2],[4,3]]
 * Output: 0
 */
public class CourseSchedules3 {

    public static void main(String[] args) {
        System.out.println(scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
        System.out.println(scheduleCourse(new int[][]{{1, 2}}));
        System.out.println(scheduleCourse(new int[][]{{3, 2}, {4, 3}}));
    }

    public static int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;

        for(int[] course : courses) {
            //Check if we consider the current course
            if(course[0] <= course[1]) {
                // current course can be completed with the last day given
                if(course[0] + time <= course[1]) {
                    pq.offer(course[0]);
                    time += course[0];
                } else {
                    // check if we can swap
                    if(pq.peek() > course[0]) {
                        time -= pq.poll();
                        time += course[0];
                        pq.offer(course[0]);
                    }
                }
            }
        }
        return pq.size();
    }
}