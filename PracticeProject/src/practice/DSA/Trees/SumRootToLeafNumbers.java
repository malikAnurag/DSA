package practice.DSA.Trees;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 */
public class SumRootToLeafNumbers {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int sum = findSum(root, 0);
        System.out.println("Sum of numbers from root to leaf of tree is : " + sum);


//				 1
//				/ \
//		       2   3
//			  / \
//		     4   5
    }

    public static int findSum(TreeNode root, int val) {

        if(root == null)
            return 0;

        val = 10 * val + root.key;

        if(root.left == null && root.right == null)
            return val;

        return findSum(root.left, val) + findSum(root.right, val);
    }
}
