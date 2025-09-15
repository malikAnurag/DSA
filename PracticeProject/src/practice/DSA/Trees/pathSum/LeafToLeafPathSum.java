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

public class LeafToLeafPathSum {

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


        TreeNode root = new TreeNode(-5);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(-25);

        root.right = new TreeNode(0);
        root.right.left = new TreeNode(-14);
        root.right.right = new TreeNode(-15);

        System.out.println("Maximum : " + findMax(root));

        max = Integer.MIN_VALUE;

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(100);
        root1.left.right = new TreeNode(50);

        root1.right = new TreeNode(0);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(15);

        System.out.println("Maximum : " + findMax(root1));
    }

    static int max = Integer.MIN_VALUE;

    public static int findMax(TreeNode root) {
        solve(root);
        return max;
    }

    public static int solve(TreeNode root) {

        if(root == null)
            return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        int possible_sum = root.key + left + right;

        max = Math.max(max, possible_sum);

        return Math.max(left, right) + root.key;
    }
}