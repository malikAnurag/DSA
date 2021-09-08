package practice.DSA.Graph.DisjointSets;

/*
Quick union can further be optimized using union by rank where the root node with larger height is chosen as the root during union operation.
NOTE: This enhancement can only be done for the quick union algorithm and not for the quick find.

Time Complexities:
                  Find - O(log N), Union - O(log N),  Connected - O(log N)

N is the number of vertices in the graph
*/
public class UnionByRank {

    int[] root;
    int[] rank;

    public UnionByRank(int size) {

        root = new int[size];
        rank = new int[size];

        for(int i = 0 ; i < size ; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        while(x != root[x]) {
            x = root[x];
        }
        return x;
    }

    public void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {

            if(rank[rootX] > rank[rootY]) { // If rank of root x is larger, update the root of root y
                root[rootY] = rootX;
            }
            else if(rank[rootY] > rank[rootX]) { // If rank of root y is larger, update the root of root x
                root[rootX] = rootY;
            }
            else {                          // If the ranks are equal, update either and increment the rank of the root
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}