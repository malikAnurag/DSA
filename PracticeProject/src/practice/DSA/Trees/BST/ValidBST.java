package practice.DSA.Trees.BST;

import practice.DSA.Trees.TreeNode;

public class ValidBST {
 /*
	 * 	  1
        /    \
       2      2
      / \    / \
     4   5  5   4

	 *
	 * */


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    /* Returns true if the given tree is a BST and its values are >= min and <= max. */
    static boolean isBSTUtil(TreeNode root, int min, int max) {
        /* an empty tree is BST */
        if(root == null)
            return true;

        /* false if this root violates the min/max constraints */
        if(root.key < min || root.key > max)
            return false;

        /* otherwise check the subtrees recursively tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(root.left, min, root.key - 1) && isBSTUtil(root.right, root.key + 1, max));
    }
}
