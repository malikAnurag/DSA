package practice.prac;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Check whether a given directed graph with 𝑛 vertices and 𝑚 edges contains a cycle.
 * */
public class Cyclicity {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
    }

    private static boolean acyclic(ArrayList<Integer>[] adj) {

        boolean[] visited = new boolean[adj.length];
        int[] recStack = new int[adj.length];

        for(int i = 0 ; i < adj.length ; i++) {
            if(!visited[i]) {
                if(dfs(adj, i, visited, recStack))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(ArrayList<Integer>[] adj, int i, boolean[] visited, int[] recStack) {

        visited[i] = true;
        recStack[i] = 1;

        for(int k = 0 ; k < adj[i].size() ; k++) {
            if(!visited[adj[i].get(k)] && dfs(adj, adj[i].get(k), visited, recStack)) {
                return true;
            }
            else if(recStack[adj[i].get(k)] == 1)
                return true;
        }
        recStack[i] = 0;
        return false;
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