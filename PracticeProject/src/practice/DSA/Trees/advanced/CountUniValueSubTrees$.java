package practice.DSA.Trees.advanced;

import practice.DSA.Trees.TreeNode;

/**
 * Given the root of a binary tree, return the number of uni-value subtrees.
 * A uni-value subtree means all nodes of the subtree have the same value.
 *
 * Example 1:
 * Input: root = [5,1,5,5,5,null,5]
 * Output: 4
 *
 *  Example 2:
 * Input: root = []
 * Output: 0
 *
 *  Example 3:
 * Input: root = [5,5,5,5,5,null,5]
 * Output: 6
 *
 * Constraints:
 * The numbrt of the node in the tree will be in the range [0, 1000].
 * -1000 <= Node.val <= 1000
 */
public class CountUniValueSubTrees$ {

    static int count = 0;

    public static void main(String[] args) {

    }

    public static int countUnivalueSubtrees(TreeNode root) {
        helper(root);
        return count;
    }

    static boolean helper(TreeNode root) {

        if(root == null)
            return true;

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if(left && right) {

            if(root.right != null && root.right.key != root.key)
                return false;

            if(root.left != null && root.left.key != root.key)
                return false;

            count++;
            return true;
        }
        return false;
    }
}
