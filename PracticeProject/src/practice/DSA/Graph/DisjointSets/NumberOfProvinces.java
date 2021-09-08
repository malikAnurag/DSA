package practice.DSA.Graph.DisjointSets;

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c,
 * then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 * Example 1:
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 *
 * Example 2:
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 */
public class NumberOfProvinces {

    public static void main(String[] args) {
        System.out.println(findProvinces(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(findProvinces(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }

    static int findProvinces(int[][] isConnected) {

        if(isConnected == null || isConnected.length == 0)
            return 0;

        int size = isConnected.length;

        UnionFind uf = new UnionFind(size);

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
}

class UnionFind {

    int[] root;
    int[] rank;
    int count;

    UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        count = size;

        for(int i = 0 ; i < size ; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    int find(int x) {

        if(x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]); // Path compression
    }

    void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) { // Union by rank

            if(rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            }
            else if(rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            }
            else {
                root[rootX] = rootY;
                rank[rootY]++;
            }
            count--;
        }
    }

    int getCount() {
        return count;
    }
}
