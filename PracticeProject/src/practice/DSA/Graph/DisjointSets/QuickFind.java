package practice.DSA.Graph.DisjointSets;

public class QuickFind {

    int[] root;

    QuickFind(int size) {

        root = new int[size];

        for(int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    // Instead of storing parent node, we store the root node for each vertex, that's why we don't have to iterate in quick find
    public int find(int x) {
        return root[x];
    }

    /* Here it has to go through the entire root array everytime */
    public void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {
            for(int i = 0; i < root.length; i++) {
                if(root[i] == rootY) {
                    root[i] = rootX;
                }
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
