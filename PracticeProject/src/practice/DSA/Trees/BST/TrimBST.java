package practice.DSA.Trees.BST;

import practice.DSA.Trees.TreeNode;

/**
 * Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all
 * its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will
 * remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.
 *
 * Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.
 *
 * Example 1:
 *
 * Input: root = [1,0,2], low = 1, high = 2
 * Output: [1,null,2]
 *
 *  Example 2:
 *
 * Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
 * Output: [3,2,null,1]
 *
 *  Example 3:
 *
 * Input: root = [1], low = 1, high = 2
 * Output: [1]
 *
 * Example 4:
 *
 * Input: root = [1,null,2], low = 1, high = 3
 * Output: [1,null,2]
 *
 * Example 5:
 *
 * Input: root = [1,null,2], low = 2, high = 4
 * Output: [2]
 */
public class TrimBST {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);

        root = trimBST(root, 1, 2);

        System.out.println(root.toString());
    }

    public static TreeNode trimBST(TreeNode root, int low, int high) {

        if(root == null)
            return null;

        root.left = trimBST(root.left , low , high);
        root.right = trimBST(root.right, low, high);

        if(root.key < low) {
            return root.right;
        }

        if(root.key > high) {
            return root.left;
        }

        return root;
    }
}
