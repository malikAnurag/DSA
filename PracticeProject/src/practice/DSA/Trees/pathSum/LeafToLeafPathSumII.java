package practice.DSA.Trees.pathSum;

// Given a binary tree, find the maximum path sum from any two "alive nodes" within the tree. We can assume a node is an alive node if and only if it is a leaf node, indicated by an asterisk below.

// Example 1

// Input

//              5
//            /    \
//          2       0
//         /       /  \
//       *25      *14  *15
// Output:

// 47 = 25 + 2 + 5 + 15

// Example 2

// Input

//              5
//            /    \
//          2       0
//         /  \     / \
//       *100 *50  *4 *15
// Output:

// 152 = 100 + 2 + 50


import practice.DSA.Trees.TreeNode;

public class LeafToLeafPathSumII {

    public static void main(String[] args) {

        // Input

        //              -5
        //            /    \
        //          -2       0
        //         /        /  \
        //       *-25      *-14  *-15
        // Output:

        // -29

        // Input

        //              5
        //            /    \
        //          2       0
        //         /  \     / \
        //       *100 *50  *4 *15


        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(25);

        root.right = new TreeNode(0);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(15);

        System.out.println("Maximum : " + maxPathSum(root));

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(100);
        root1.left.right = new TreeNode(50);

        root1.right = new TreeNode(0);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(15);

        System.out.println("Maximum : " + maxPathSum(root1));
    }

    static class Result {
        int maxSum = Integer.MIN_VALUE;
    }

    public static int maxPathSum(TreeNode root) {
        Result res = new Result();
        maxLeafToLeafPath(root, res);
        return res.maxSum;
    }

    private static int maxLeafToLeafPath(TreeNode node, Result res) {

        if (node == null)
            return 0;

        // If it's a leaf node, return its value
        if (node.left == null && node.right == null)
            return node.key;

        // Recursively get sums from left and right subtrees
        int leftSum = maxLeafToLeafPath(node.left, res);
        int rightSum = maxLeafToLeafPath(node.right, res);

        // If both children exist, check if current node gives a better path
        if (node.left != null && node.right != null) {
            int totalSum = leftSum + rightSum + node.key;
            res.maxSum = Math.max(res.maxSum, totalSum);
            return Math.max(leftSum, rightSum) + node.key;
        }

        // If one child is missing, return the sum including the existing child
        return (node.left == null ? rightSum : leftSum) + node.key;
    }
}