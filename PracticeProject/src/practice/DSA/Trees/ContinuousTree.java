package practice.DSA.Trees;

/**
 * A tree is a Continuous tree if in each root to leaf path, the absolute difference between keys of two adjacent is 1.
 * We are given a binary tree, we need to check if the tree is continuous or not.
 * Examples:
 *
 *
 * Input :              3
 *                     / \
 *                    2   4
 *                   / \   \
 *                  1   3   5
 * Output: "Yes"
 *
 * Input :              7
 *                     / \
 *                    5   8
 *                   / \   \
 *                  6   4   10
 * Output: "No"
 */
public class ContinuousTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(isContinuousTree(root) ? "Yes" : "No");

        root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(8);
        root.right.right = new TreeNode(10);

        System.out.println(isContinuousTree(root) ? "Yes" : "No");
    }

    public static boolean isContinuousTree(TreeNode root) {

        if(root == null)
            return true;

        if(root.left == null && root.right == null)
            return true;

        if(root.left == null) {
            return Math.abs(root.key - root.right.key) == 1 && isContinuousTree(root.right);
        }

        if(root.right == null) {
            return Math.abs(root.key - root.left.key) == 1 && isContinuousTree(root.left);
        }

        return Math.abs(root.key - root.left.key) == 1 &&
                Math.abs(root.key - root.right.key) == 1 &&
                isContinuousTree(root.left) &&
                isContinuousTree(root.right);
    }
}
