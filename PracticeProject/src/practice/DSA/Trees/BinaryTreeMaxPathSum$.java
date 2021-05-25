package practice.DSA.Trees;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child
 * connections.
 * The path must contain at least one node and does not need to go through the root.
 */

class Res {
    public int val;
}

public class BinaryTreeMaxPathSum$ {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int sum = maxPathSum(root);
        System.out.println("Max Path sum of tree is : " + sum);


//                -10
//                / \
//               9   20
//                  /  \
//                 15   7

    }

    public static int maxPathSum(TreeNode root) {

        Res res = new Res();
        res.val = Integer.MIN_VALUE;

        findMaxSumUtil(root, res);

        return res.val;
    }

    public static int findMaxSumUtil(TreeNode root, Res res) {

        if (root == null)
            return 0;

        int l = findMaxSumUtil(root.left, res);
        int r = findMaxSumUtil(root.right, res);

        int maxSingle = Math.max(Math.max(l, r) + root.key, root.key);

        int maxTop = Math.max(root.key + l + r, maxSingle);

        res.val = Math.max(res.val, maxTop);
        return maxSingle;
    }
}