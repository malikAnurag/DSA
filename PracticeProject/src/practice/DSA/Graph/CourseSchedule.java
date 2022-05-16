package practice.DSA.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 */

//TODO: https://www.youtube.com/watch?v=CL4NZAoOdpM

public class CourseSchedule {

    public static void main(String[] args) {

        System.out.println(isPossibleToFinish(2, new int[][]{{1,0}}));
        System.out.println(isPossibleToFinish(2, new int[][]{{1,0},{0,1}}));
    }

    public static boolean isPossibleToFinish(int courses, int[][] preRequisites) {

        boolean[] visited = new boolean[courses];
        boolean[] marked = new boolean[courses];
        List<Integer>[] adj = new ArrayList[courses];

        for(int i  = 0 ; i < courses ; i++)
            adj[i] = new ArrayList<>();


        for (int[] preRequisite : preRequisites) {
            adj[preRequisite[0]].add(preRequisite[1]);
        }

        for(int i  = 0 ; i < courses ; i++) {

            if(!visited[i]) {
                if(isCyclic(adj, visited, marked, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isCyclic(List<Integer>[] adj, boolean[] visited, boolean[] marked, int u) {

        visited[u] = true;

        for(int j : adj[u]) {
            if(!visited[j]) {
                if(isCyclic(adj, visited, marked, j)) {
                    return true;
                }
            }
            else if(!marked[j])
                return true;
        }
        marked[u] = true;
        return false;
    }
}
