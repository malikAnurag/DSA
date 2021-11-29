package assignment3;

import java.util.*;

/**
 * Given an undirected graph with 𝑛 vertices and 𝑚 edges, check whether it is bipartite.
 */
/*
    A graph is bipartite if its vertices can be colored with two colors
    (say, black and white) such that the endpoints of each edge have different colors
 */
public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {

        int[] color = new int[adj.length];
        Arrays.fill(color, -1);

        color[0] = 0;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()){

            int u = queue.poll();

            for(int v : adj[u]) {
                if(color[v] == -1) {
                    color[v] = 1 - color[u];
                    queue.add(v);
                }
                else if(color[v] == color[u])
                    return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(bipartite(adj));
    }
}

/**
 4 4
 1 2
 4 1
 2 3
 3 1

 0
 */

/**
 5 4
 5 2
 4 2
 3 4
 1 4

 1
 */
