package practice.DSA.Trees.Traversals;

import practice.DSA.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left
 * for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class SpiralLevelOrder1 {

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
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        boolean flag = true;
        int h = height(root);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= h; i++) {
            List<Integer> al = new ArrayList<>();
            spiralOrder(al, i, flag, root);
            result.add(al);
            flag = !flag;
        }
        System.out.println("Spiral Order Lists: " + result.toString());
    }


    public static void spiralOrder(List<Integer> al, int level, boolean flag, TreeNode root) {

        if (root == null)
            return;

        if (level == 1) {
            al.add(root.key);
            return;
        } else if (level > 1) {
            if (flag) {
                spiralOrder(al, level - 1, true, root.left);
                spiralOrder(al, level - 1, true, root.right);
            } else {
                spiralOrder(al, level - 1, false, root.right);
                spiralOrder(al, level - 1, false, root.left);
            }
        }
    }


    public static int height(TreeNode node) {

        if (node == null)
            return 0;

        int l = height(node.left);
        int r = height(node.right);

        return l > r ? l + 1 : r + 1;
    }
}
