package practice.DSA.Trees.advanced;

import practice.DSA.Trees.TreeHeight;
import practice.DSA.Trees.TreeNode;

/**
 * Given a binary tree, write a function to get the maximum width of the given tree.
 * Width of a tree is maximum of widths of all levels.
 * Let us consider the below example tree.
 *
 *          1
 *         /  \
 *        2    3
 *      /  \     \
 *     4    5     8
 *               /  \
 *              6    7
 * For the above tree,
 * width of level 1 is 1,
 * width of level 2 is 2,
 * width of level 3 is 3
 * width of level 4 is 2.
 *
 * So the maximum width of the tree is 3.
 */
public class MaximumWidth {
    /*
		   1
         /   \
        3     2
       / \     \
      5   3     9
		 *
		 *
		 * */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(widthOfBinaryTree(root));
    }

    public static int widthOfBinaryTree(TreeNode root) {

        int[] count = new int[10];
        int h = TreeHeight.height(root);

        maxWidth(count, 0, root);

        return getMax(count, h);
    }

    public static void maxWidth(int[] count, int level, TreeNode root) {
        if (root != null) {
            count[level]++;
            maxWidth(count, level + 1, root.left);
            maxWidth(count, level + 1, root.right);
        }
    }

    public static int getMax(int[] count, int h) {

        int max = count[0];

        for (int i = 0; i < h; i++) {
            if (count[i] > max)
                max = count[i];
        }
        return max;
    }
}