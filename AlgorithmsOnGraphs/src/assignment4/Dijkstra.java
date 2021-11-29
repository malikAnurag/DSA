package assignment4;

import java.util.*;

/**
 * Given a directed graph with positive edge weights and with 𝑛 vertices and 𝑚 edges as well as two
 * vertices 𝑢 and 𝑣, compute the weight of a shortest path between 𝑢 and 𝑣 (that is, the minimum total
 * weight of a path from 𝑢 to 𝑣).
 */


public class Dijkstra {

    public static class Node implements Comparable<Node> {
        int dist;
        int index;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if (this.dist > o.dist) return 1;
            else if (this.dist < o.dist) return -1;
            else return 0;
        }
    }

    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {

        int[] dist = new int[adj.length];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[s] = 0;
        queue.add(new Node(s, dist[s]));

        while (!queue.isEmpty()) {

            Node u = queue.remove();
            int u_index = u.index;

            for(int v : adj[u_index]) {
                int v_index = adj[u_index].indexOf(v);
                if(dist[v] > dist[u_index] + cost[u_index].get(v_index)) {
                    dist[v] = dist[u_index] + cost[u_index].get(v_index);
                    queue.add(new Node(v, dist[v]));
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
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

/*
* 4 4
1 2 1
4 1 2
2 3 2
1 3 5
1 3

=> 3

* *
5 9
1 2 4
1 3 2
2 3 2
3 2 1
2 4 2
3 5 4
5 4 1
2 5 3
3 4 4
1 5
*
* => 6
*
*
*
* 3 3
1 2 7
1 3 5
2 3 2
3 2
* */