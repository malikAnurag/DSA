package practice.DSA.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * You are given two integers n and k and two integer arrays speed and efficiency both of length n. There are n engineers numbered from 1 to n.
 * speed[i] and efficiency[i] represent the speed and efficiency of the ith engineer respectively.
 *
 * Choose at most k different engineers out of the n engineers to form a team with the maximum performance.
 *
 * The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.
 *
 * Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 109 + 7.
 *
 * Example 1:
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
 * Output: 60
 * Explanation:
 * We have the maximum performance of the team by selecting engineer 2 (with speed=10 and efficiency=4) and engineer 5 (with speed=5 and efficiency=7). That is, performance = (10 + 5) * min(4, 7) = 60.
 *
 *  Example 2:
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
 * Output: 68
 * Explanation:
 * This is the same example as the first but k = 3. We can select engineer 1, engineer 2 and engineer 5 to get the maximum performance of the team. That is, performance = (2 + 10 + 5) * min(5, 4, 7) = 68.
 *
 *  Example 3:
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
 * Output: 72
 *
 * Constraints:
 * 1 <= <= k <= n <= 105
 * speed.length == n
 * efficiency.length == n
 * 1 <= speed[i] <= 105
 * 1 <= efficiency[i] <= 108
 */
public class MaximumPerformanceOfATeam {

    public static void main(String[] args) {
        System.out.println(getMaxPerformance(6, new int[] {2,10,3,1,5,8}, new int[] {5,4,3,9,7,2}, 2));
        System.out.println(getMaxPerformance(6, new int[] {2,10,3,1,5,8}, new int[] {5,4,3,9,7,2}, 3));
        System.out.println(getMaxPerformance(6, new int[] {2,10,3,1,5,8}, new int[] {5,4,3,9,7,2}, 4));
    }

    /*
        * Performance = sum(speed) * min(efficiency). Idea is simple: try every efficiency value from highest to lowest and at the same time maintain an
            as-large-as-possible speed group, keep adding speed to total speed, if size of engineers group exceeds K, lay off the engineer with lowest speed.

        * Sort efficiency with descending order. Because, afterwards, when we iterate whole engineers, every round, when calculating the current performance,
            minimum efficiency is the efficiency of the new incoming engineer.

        * Maintain a pq to track of the minimum speed in the group. If size of group is == K, kick the engineer with minimum speed out (since efficiency
            is fixed by new coming engineer, the only thing matters now is sum of speed). Calculate/Update performance.
    * */

    public static int getMaxPerformance(int n, int[] speed, int[] efficiency, int k) {

        int mod = (int) (1e9 + 7);
        long result = Long.MIN_VALUE, totalSpeed = 0;

        int[][] engineers = new int[n][2];

        for(int i = 0 ; i < n ; i++) {
            engineers[i] = new int[] {efficiency[i], speed[i]};
        }

        Arrays.sort(engineers, (a,b) -> b[0] - a[0]); // sorting engineers with decreasing order of their efficiency

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a,b) -> a-b);

        for(int[] engineer : engineers) {

            if(pq.size() == k) {
                totalSpeed -= pq.poll();
            }

            totalSpeed += engineer[1];
            pq.add(engineer[1]);

            result = Math.max(result, totalSpeed * engineer[0]);
        }
        return (int)(result % mod);
    }
}
