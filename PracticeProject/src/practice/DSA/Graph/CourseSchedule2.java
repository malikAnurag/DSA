package practice.DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is
 * expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to
 * finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses,
 * return an empty array.
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 *              course 0. So the correct course order is [0,1] .
 * Example 2:
 *
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 *              courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 *              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is
 * represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseSchedule2 {

    static List<Integer>[] adj;
    static boolean[] visited;
    static boolean[] marked;
    static int index = 0 ;
    static int[] result;

    public static void main(String[] args) {

        Arrays.stream(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})).forEach(System.out::println);
    }

    public static int[] findOrder(int courses, int[][] prerequisites) {

        visited = new boolean[courses];
        marked = new boolean[courses];
        adj = new ArrayList[courses];
        result = new int[courses];

        for (int i = 0; i < courses; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for (int i = 0; i < courses; i++) {

            if (!visited[i]) {
                if (isCyclic(i)) {
                    return new int[0];
                }
            }
        }
        return result;
    }

    public static boolean isCyclic(int u) {

        visited[u] = true;

        for(int j : adj[u]) {
            if(!visited[j]) {
                if(isCyclic(j)) {
                    return true;
                }
            }
            else if(!marked[j])
                return true;
        }
        marked[u] = true;
        result[index++] = u;
        return false;
    }
}
