package practice.DSA.Trees;

/**
 * Given a binary tree, find out if the tree can be folded or not.
 * A tree can be folded if left and right subtrees of the tree are structure wise mirror image of each other.
 * An empty tree is considered as foldable.
 *
 * Consider the below trees:
 * (c) and (d) cannot be folded.
 *
 * (a) and (b) can be folded.
 *
 *
 * (a)
 *        10
 *      /    \
 *     7      15
 *      \    /
 *       9  11
 *
 * (b)
 *         10
 *        /  \
 *       7    15
 *      /      \
 *     9       11
 *
 * (c)
 *         10
 *        /  \
 *       7   15
 *      /    /
 *     5   11
 *
 * (d)
 *
 *          10
 *        /   \
 *       7     15
 *     /  \    /
 *    9   10  12
 */
public class FoldableBinaryTrees {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10); // (c) Tree
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(5);

        root.right = new TreeNode(15);
        root.right.left = new TreeNode(11);

        System.out.println(isFoldable(root, root) ? "Yes" : "No");

        root = new TreeNode(10); // (b) Tree
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(9);

        root.right = new TreeNode(15);
        root.right.right = new TreeNode(11);

        System.out.println(isFoldable(root, root) ? "Yes" : "No");
    }

    public static boolean isFoldable(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null)
            return true;

        if(root1 == null || root2 == null)
            return false;

        return isFoldable(root1.left, root2.right) && isFoldable(root1.right, root2.left);
    }
}
