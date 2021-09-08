package practice.DSA.Graph.DisjointSets;


/* Quick union is more efficient than quick find because the worst case time complexity is O(N^2) in this case and depends on the elements. But for the
* quick find algorithm, the time complexity is O(N^2) in every case as for each union operation, it has to traverse the whole array.
* Quick union can further be optimized using union by rank where the root node with larger height is chosen as the root during union operation. */
public class QuickUnion {

    int[] root;

    QuickUnion(int size) {

        root = new int[size];

        for(int i = 0 ; i < size ; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {

        while(x != root[x]) {
            x = root[x];
        }
        return x;
    }

    /* Here union function's runtime depends on the find function which has worst case of O(N). So the overall complexity is <= O(N) */
    public void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
