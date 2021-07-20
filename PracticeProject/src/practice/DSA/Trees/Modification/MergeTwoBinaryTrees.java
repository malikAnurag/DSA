package practice.DSA.Trees.Modification;

import practice.DSA.Trees.TreeNode;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 *
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be
 * used as the node of new tree.
 *
 * Example 1:
 *
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 *
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 */
public class MergeTwoBinaryTrees {


    /*
	 * 	  1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9
	 *
	 *
	 * */

     /*
	 * 	  4
        /    \
       2      9
      / \      \
     3   5      7
	 *
	 *
	 * */

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        root1.right.left.right = new TreeNode(8);
        root1.right.right.right = new TreeNode(9);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.left.right = new TreeNode(5);
        root2.left.left = new TreeNode(3);

        root2.right = new TreeNode(9);
        root2.right.right = new TreeNode(7);

        System.out.println(mergeTrees(root1, root2).toString());
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return merge(t1, t2);
    }

    public static TreeNode merge(TreeNode node1, TreeNode node2) {

        if(node1 == null && node2 == null) {
            return null;
        }

        if(node1 != null && node2 != null) {

            TreeNode node = new TreeNode(node1.key + node2.key);
            node.left = merge(node1.left, node2.left);
            node.right = merge(node1.right, node2.right);
            return node;
        }

        if(node2 == null) {
            return node1;
        }
        else {
            return node2;
        }
    }
}
