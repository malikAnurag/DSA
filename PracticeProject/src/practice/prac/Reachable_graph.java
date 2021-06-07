package practice.prac;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given an undirected graph and two distinct vertices 𝑢 and 𝑣, check if there is a path between 𝑢 and 𝑣.
 */
public class Reachable_graph {

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
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }

    private static boolean reach(ArrayList<Integer>[] adj, int x, int y) {

        boolean[] visited = new boolean[adj.length];

        return reachability(adj, x, y, visited);
    }

    private static boolean reachability(ArrayList<Integer>[] adj, int x, int y, boolean[] visited) {

        if(x == y)
            return true;

        visited[adj[x].get(0)] = true;

        for(int i = 0 ; i < adj[x].size() ; i++) {
            if(!visited[adj[x].get(i)]) {
                if(reachability(adj, i, y, visited))
                    return true;
            }
        }
        return false;
    }
}
