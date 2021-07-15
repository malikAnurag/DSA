package practice.DSA.Trees.BST;

import practice.DSA.Trees.TreeNode;

/**
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original
 * key plus sum of all keys greater than the original key in BST.
 *
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Note: This question is the same as 538: https://leetcode.com/problems/convert-bst-to-greater-tree/
 *
 * //TODO : gst.png
 *
 * Example 1:
 * Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 *  Example 2:
 * Input: root = [0,null,1]
 * Output: [1,null,1]
 *
 *  Example 3:
 * Input: root = [1,0,2]
 * Output: [3,3,2]
 *
 *  Example 4:
 * Input: root = [3,2,4,1]
 * Output: [7,9,4,10]
 */
public class BinarySearchTreeToGreaterSumTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        getGST(root, 0);

        System.out.println(root);
    }

    public static int getGST(TreeNode root, int val) {

        if(root == null)
            return val;

        root.key = root.key + getGST(root.right, val);
        return getGST(root.left, root.key);
    }
}
