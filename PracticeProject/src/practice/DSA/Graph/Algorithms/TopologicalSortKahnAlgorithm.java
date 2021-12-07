package practice.DSA.Graph.Algorithms;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where
 * prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them.
 * If it is impossible to finish all courses, return an empty array.
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 *
 * Example 2:
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 *
 * Example 3:
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 */
public class TopologicalSortKahnAlgorithm {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getOrderingOfCourses(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(getOrderingOfCourses(4, new int[][]{{1, 0}, {2,0}, {3,1}, {3,2}})));
    }

    /*
    * Time Complexity: O(V + E)
    * Space Complexity: O(V + E)
    * */
    static int[] getOrderingOfCourses(int n, int[][] prerequisites) {

        int index = 0;
        int[] topo = new int[n];
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Creating representation of the graph
        for(int[] edge : prerequisites) {
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[1]).add(edge[0]);

            // Record in-degree of each vertex
            indegree[edge[0]]++;
        }

        // Add all vertices with 0 in-degree to the queue
        for(int i = 0; i < n ; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {

            int node = q.poll();
            topo[index++] = node;

            // Reduce the in-degree of each neighbor by 1
            if(graph.containsKey(node)) {
                for(int j : graph.get(node)) {
                    indegree[j]--;

                    if(indegree[j] == 0) {
                        q.add(j);
                    }
                }
            }
        }
        if(index == n)
            return topo;

        return new int[0];
    }
}