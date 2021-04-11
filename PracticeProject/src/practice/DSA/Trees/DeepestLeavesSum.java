package practice.DSA.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 */
public class DeepestLeavesSum {

    private static List<Integer> al = new ArrayList();

      /*
	 * 	  1
        /    \
       2      2
      / \    / \
     4   5  5   4

	  	  1
        /    \
       2      2
      / \    / \
     4   5  5   6
	 *
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

        System.out.println(deepestLeavesSum(root));

        al = new ArrayList<>();

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(deepestLeavesSum(root));
    }


    public static int deepestLeavesSum(TreeNode root) {

        int height = height(root);

        helper(root, 1, height);

        int sum = 0;

        for(int i : al)
            sum += i;

        return sum;
    }

    public static void helper(TreeNode root, int level, int height) {

        if(level == height) {
            al.add(root.key);
            return;
        }

        if(root.left != null)
            helper(root.left, level + 1, height);

        if(root.right != null)
            helper(root.right, level + 1, height);
    }
    public static int height(TreeNode root) {

        if(root == null)
            return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return lh > rh ? lh + 1 : rh + 1;
    }
}
