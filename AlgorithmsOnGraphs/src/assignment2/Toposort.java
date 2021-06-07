package assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Compute a topological ordering of a given directed acyclic graph (DAG) with 𝑛 vertices and 𝑚 edges.
 * */
public class Toposort {

    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {

        int used[] = new int[adj.length];
        ArrayList<Integer> order = new ArrayList<>();

        for (int i = 0; i < adj.length; i++) {
            if (used[i] == 0)
                dfs(adj, used, order, i);
        }
        return order;
    }

    private static void dfs(ArrayList<Integer>[] adj, int[] used, ArrayList<Integer> order, int s) {

        used[s] = 1;

        for (int i = 0; i < adj[s].size(); i++) {
            if (used[adj[s].get(i)] == 0)
                dfs(adj, used, order, adj[s].get(i));
        }
        order.add(0, s);
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
        System.out.println("ADJ: ");
        Arrays.stream(adj).forEach(list -> System.out.println(list.toString()));

        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}

/*
5 7
2 1
3 2
3 1
4 3
4 1
5 2
5 3
* */