package practice.DP.JumpGames;

import java.util.*;

/**
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 * In one step you can jump from index i to index:
 *
 * i + 1 where: i + 1 < arr.length.
 * i - 1 where: i - 1 >= 0.
 * j where: arr[i] == arr[j] and i != j.
 *
 * Return the minimum number of steps to reach the last index of the array.
 * Notice that you can not jump outside of the array at any time.
 *
 * Example 1:
 * Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
 * Output: 3
 * Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
 *
 * Example 2:
 * Input: arr = [7]
 * Output: 0
 * Explanation: Start index is the last index. You do not need to jump.
 *
 * Example 3:
 * Input: arr = [7,6,9,6,9,6,9,7]
 * Output: 1
 * Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 *
 * Constraints:
 * 1 <= arr.length <= 5 * 104
 * -108 <= arr[i] <= 108
 */
public class JumpGame4 {

    public static void main(String[] args) {
        System.out.println(getJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
        System.out.println(getJumps(new int[]{7}));
        System.out.println(getJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7}));
    }

    static int getJumps(int[] arr) {

        if(arr == null || arr.length <= 1) {
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        int jumps = 0;
        q.add(0);

        for(int i = 0 ; i < arr.length ; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {

                int node = q.poll();

                if(node == arr.length - 1) {
                    return jumps;
                }

                if(node < 0 || node >= arr.length || visited[node])
                    continue;

                if(node - 1 > 0 && !visited[node - 1]) {
                    q.offer(node - 1);
                }

                if(node + 1 < arr.length && !visited[node + 1]) {
                    q.offer(node + 1);
                }

                if(graph.containsKey(arr[node])) {
                    for(int idx : graph.get(arr[node])) {
                        if(idx >= 0 && idx < arr.length && !visited[idx]) {
                            q.offer(idx);
                        }
                    }
                    graph.get(arr[node]).clear();
                }
                visited[node] = true;
            }
            jumps++;
        }
        return -1;
    }
}