package practice.prac;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given an undirected graph with 𝑛 vertices and 𝑚 edges, compute the number of connected components in it.
 */
public class SCC_graph {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // vertices
        int m = scanner.nextInt(); // edges
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
        System.out.println(numberOfComponents(adj));
    }

    private static int numberOfComponents(ArrayList<Integer>[] adj) {

        boolean[] visited = new boolean[adj.length];
        int count = 0;

        for(int i = 0 ; i < adj.length ; i++) {
            if(!visited[adj[i].get(0)]) {
                explore(adj, i, visited);
                for(boolean b : visited)
                    System.out.print(b + ",");
                count++;
            }
        }
        return count;
    }

    static void explore(ArrayList<Integer>[] adj, int i, boolean[] visited) {

        visited[i] = true;

        for(int j = 0 ; j < adj[i].size() ; j++) {
            if(!visited[adj[i].get(j)]) {
                explore(adj, adj[i].get(j), visited);
            }
        }
    }
}
