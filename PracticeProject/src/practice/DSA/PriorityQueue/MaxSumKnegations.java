package practice.DSA.PriorityQueue;

import java.util.PriorityQueue;

/**
 * Given an array of size n and a number k. We must modify array K number of times. Here modify array means in each operation we can replace any array element
 * arr[i] by -arr[i].
 * We need to perform this operation in such a way that after K operations, sum of array must be maximum?
 *
 * Examples:
 *
 * Input : arr[] = {-2, 0, 5, -1, 2}
 *         K = 4
 * Output: 10
 * // Replace (-2) by -(-2), array becomes {2, 0, 5, -1, 2}
 * // Replace (-1) by -(-1), array becomes {2, 0, 5, 1, 2}
 * // Replace (0) by -(0), array becomes {2, 0, 5, 1, 2}
 * // Replace (0) by -(0), array becomes {2, 0, 5, 1, 2}
 *
 * Input : arr[] = {9, 8, 8, 5}
 *         K = 3
 * Output: 20
 */
public class MaxSumKnegations {

    public static void main(String[] args) {
        System.out.println(getMaxSum(new int[]{-2, 0, 5, -1, 2}, 4));
        System.out.println(getMaxSum(new int[]{9, 8, 8, 5}, 3));
    }

    public static int getMaxSum(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : arr)
            pq.add(i);

        while (k > 0) {
            int temp = pq.poll();
            temp *= -1;

            pq.add(temp);
            k--;
        }
        int result = 0;
        for (int num : pq) {
            result += num;
        }
        return result;
    }
}
