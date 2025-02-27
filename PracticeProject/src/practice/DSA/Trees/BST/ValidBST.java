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

        System.out.println(isBSTUtil(root, null, null));
    }

    /* Returns true if the given tree is a BST and its values are >= min and <= max. */
    private static boolean isBSTUtil(TreeNode root, Integer min, Integer max) {

        if(root == null)
            return true;

        if((min != null && root.key <= min) || (max != null && root.key >= max))
            return false;

        return isBSTUtil(root.right, root.key, max) && isBSTUtil(root.left, min, root.key);
    }
}
