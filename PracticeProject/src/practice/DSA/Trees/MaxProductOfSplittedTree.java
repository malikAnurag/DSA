package practice.DSA.Trees;

/**
 * Given the root of a binary tree, split the binary tree into two subtrees by removing one
 * edge such that the product of the sums of the subtrees is maximized.
 * Return the maximum product of the sums of the two subtrees. Since the answer may be too
 * large, return it modulo 109 + 7.
 * Note that you need to maximize the answer before taking the mod and not after taking it.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,6]
 * Output: 110
 * Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10.
 * Their product is 110 (11*10)
 *
 * Example 2:
 * Input: root = [1,null,2,3,4,null,null,5,6]
 * Output: 90
 * Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.
 * Their product is 90 (15*6)
 */
public class MaxProductOfSplittedTree {

    static long total = 0, max = Long.MIN_VALUE;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        findMaxProduct(root);
        System.out.println(max);
    }

    static void findMaxProduct(TreeNode root) {

        if(root == null)
            return;

        findTotalSum(root);
        findMaxSum(root);
    }

    private static long findMaxSum(TreeNode root) {
        
        if(root == null)
            return 0;

        long left = findMaxSum(root.left);
        long right = findMaxSum(root.right);
        long sum = root.key + left + right;

        max = Math.max(max, sum * (total - sum));
        return sum;
    }

    private static void findTotalSum(TreeNode root) {

        if(root == null)
            return;

        findTotalSum(root.left);
        total += root.key;
        findTotalSum(root.right);
    }
}
