package assignment3;

import java.util.*;

/**
 * Given an undirected graph with 𝑛 vertices and 𝑚 edges and two vertices 𝑢 and 𝑣, compute the length
 * of a shortest path between 𝑢 and 𝑣 (that is, the minimum number of edges in a path from 𝑢 to 𝑣).
 */

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {

        if(s == t)
            return 0;

        int[] dist = new int[adj.length];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[s] = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);

        while(!queue.isEmpty()){

            int u = queue.poll();

            for(int v : adj[u]){
                if(dist[v] == Integer.MAX_VALUE){
                    dist[v] = 1 + dist[u];
                    queue.add(v);
                }
            }
        }
        if(dist[t] != Integer.MAX_VALUE)
            return dist[t];
        else
            return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
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
        System.out.println(distance(adj, x, y));
    }
}

/**
 * 4 4
 * 1 2
 * 4 1
 * 2 3
 * 3 1
 * 2 4
 *
 * 2
 * */

//5 4
//5 2
//1 3
//3 4
//1 4
//3 5

//-1