package assignment2;

import java.util.ArrayList;
import java.util.Scanner;

/*
* Applications of Depth First Search:
*
* 1. Detecting cycle in a graph
* 2. Path Finding
* 3. Topological Sorting
* 4. Finding Strongly Connected Components of a graph
* */


/**
 *  Check whether a given directed graph with 𝑛 vertices and 𝑚 edges contains a cycle.
 * */

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj) {
        //write your code here
        int[] visited = new int[adj.length];
        int[] recStack = new int[adj.length];

        for (int i = 0; i < adj.length; i++) {
            if (visited[i] == 0) {
                if (dfs(adj, i, visited, recStack) == 1)
                    return 1;
            }
        }
        return 0;
    }

    public static int dfs(ArrayList<Integer>[] adj, int x, int[] visited, int[] recStack) {

        visited[x] = 1;
        recStack[x] = 1;

        for (int i = 0; i < adj[x].size(); i++) {
            if (visited[adj[x].get(i)] == 0 && dfs(adj, adj[x].get(i), visited, recStack) == 1)
                return 1;
            else if (recStack[adj[x].get(i)] == 1)
                return 1;
        }
        recStack[x] = 0;
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
    }
}

/*
*
4 4
1 2
4 1
2 3
3 1
* */

/*
5 7
1 2
2 3
1 3
3 4
1 4
2 5
3 5
* */