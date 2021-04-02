package practice.DSA.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 * Each person may dislike some other people, and they should not go into the same group.
 * <p>
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 * Return true if and only if it is possible to split everyone into two groups in this way.
 */

//TODO: https://www.youtube.com/watch?v=wciOFao3IFU&feature=emb_logo

public class PossibleBipartition {

    public static void main(String[] args) {

        int N = 4;
        int[][] dislikes = new int[][]{{1,2},{1,3},{2,4}};

        System.out.println("Is partition possible? : " + isBipartitionPossible(N, dislikes));
    }

    public static boolean isBipartitionPossible(int N, int[][] dislikes) {

        List<List<Integer>> graph = new ArrayList<>(N + 1);
        int[] group = new int[N + 1];

        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < dislikes.length; i++) {
            graph.get(dislikes[i][0]).add(dislikes[i][1]);
            graph.get(dislikes[i][1]).add(dislikes[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i <= N; i++) {
            if (group[i] == 0) {

                group[i] = 1;
                queue.add(i);

                while (!queue.isEmpty()) {

                    int u = queue.poll();

                    for (int j : graph.get(u)) {

                        if (group[j] == 0) {
                            if (group[u] == 0)
                                group[j] = 1;
                            else
                                group[j] = 2;
                        } else if (group[u] == group[j])
                            return false;
                    }
                }
            }
        }
        return true;
    }
}
