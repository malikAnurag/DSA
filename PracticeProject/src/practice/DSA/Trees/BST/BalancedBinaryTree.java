package practice.DSA.Trees.BST;

import practice.DSA.Trees.TreeHeight;
import practice.DSA.Trees.TreeNode;
/**
 * Given a binary tree, determine if it is height-balanced.
 *
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 *  Example 2:
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 *  Example 3:
 * Input: root = []
 * Output: true
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -104 <= Node.val <= 104
 */
//TODO : A height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by NO MORE than 1.
public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);

        System.out.println(isBalanced(root));
    }

    static boolean isBalanced(TreeNode root) {

        if(root == null)
            return true;

        return Math.abs(TreeHeight.height(root.left) - TreeHeight.height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
}
