package practice.DSDesign;

import practice.DSA.Trees.TreeNode;


/*
 *   N - no of values
 *   K - no of predefined buckets [773]
 *
 *   Time Complexity : O ( Log ( N / K )) :
 *                               Even distribution : Avg size of each bucket = N/K
 *                               Worst case : Scan entire bucket, hence time complexity of O(N/K)
 *
 *   M - no of unique values inserted into hashSet
 *
 *   Space : O (K + M)
 *
 * */
public class MyHashSetBST {

    BSTBucket[] buckets;
    int range;

    public MyHashSetBST() {
        range = 773;
        buckets = new BSTBucket[range];
        for (int i = 0; i < range; i++) {
            buckets[i] = new BSTBucket();
        }
    }

    private int hash(int val) {
        return val % range;
    }

    public void add(int val) {
        int idx = hash(val);
        buckets[idx].add(val);
    }

    public void remove(int val) {
        int idx = hash(val);
        buckets[idx].remove(val);
    }

    public boolean contains(int val) {
        int idx = hash(val);
        return buckets[idx].contains(val);
    }

}

class BSTBucket {

    BSTtree tree;

    public BSTBucket() {
        tree = new BSTtree();
    }

    public void add(Integer val) {
        tree.root = tree.insert(tree.root, val);
    }

    public boolean contains(Integer val) {
        return tree.search(tree.root, val) != null;
    }

    public void remove(Integer val) {
        tree.root = tree.remove(tree.root, val);
    }
}

class BSTtree {

    TreeNode root = null;

    public TreeNode insert(TreeNode root, int key) {

        if (root == null)
            return new TreeNode(key);

        if (root.key > key) {
            root.left = insert(root.left, key);
        } else if (root.key == key) { // skip insertion if present already
            return root;
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public TreeNode search(TreeNode root, int key) {

        if (root == null)
            return null;

        if (root.key == key) {
            return root;
        } else if (root.key > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public TreeNode remove(TreeNode root, int key) {

        if (root == null)
            return null;

        if (root.key == key) {

            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right != null) {
                TreeNode successor = findSuccessorBst(root, key);
                root.key = successor.key;
                root.right = remove(root.right, key);
            } else {
                return root.left != null ? root.left : root.right;
            }
        } else if (root.key > key) {
            root.left = remove(root.left, key);
        } else {
            root.right = remove(root.right, key);
        }
        return root;
    }

    private TreeNode findSuccessorBst(TreeNode root, int key) {

        TreeNode successor = null;

        while (root != null) {
            if (root.key > key) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }
}

