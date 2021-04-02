package practice.DSA.Trees;

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 */

class Pair {
    TreeNode parent;
    int level;

    Pair(TreeNode parent, int level) {
        this.level = level;
        this.parent = parent;
    }
}

public class Cousins {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);

        System.out.println(isCousins(root, 4, 5));
        System.out.println(isCousins(root, 2, 3));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {

        Pair pair1 = cousinsHelper(root, x, null, 0);
        Pair pair2 = cousinsHelper(root, y, null, 0);

        return pair1.parent != pair2.parent && pair1.level == pair2.level;
    }

    public static Pair cousinsHelper(TreeNode root, int val, TreeNode parent, int level) {

        if (root == null)
            return null;

        if (root.key == val) {
            return new Pair(parent, level);
        }

        Pair leftPair = cousinsHelper(root.left, val, root, level + 1);
        Pair rightPair = cousinsHelper(root.right, val, root, level + 1);

        // TODO : Why this step?
        return leftPair == null ? rightPair : leftPair;
    }
}
