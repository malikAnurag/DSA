package practice.DSA.Graph.DisjointSets;

/*
After finding the root node, we can update the parent node of all traversed elements to their root node.
When we search for the root node of the same element again, we only need to traverse two elements to find its root node, which is highly efficient.

Time Complexities:
                  Find - O(log N), Union - O(log N),  Connected - O(log N)
* */
public class PathCompression {

    int[] root;

    public PathCompression(int size) {

        root = new int[size];

        for(int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {

        if(x == root[x])
            return x;

        return root[x] = find(root[x]);
    }

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