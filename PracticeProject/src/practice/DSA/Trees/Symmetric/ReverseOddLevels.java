package practice.DSA.Trees.Symmetric;

import practice.DSA.Trees.TreeNode; /**
 * Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
 * <p>
 * For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
 * Return the root of the reversed tree.
 * <p>
 * A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.
 * <p>
 * The level of a node is the number of edges along the path between it and the root node.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [2,3,5,8,13,21,34]
 * Output: [2,5,3,8,13,21,34]
 * Explanation:
 * The tree has only one odd level.
 * The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.
 * Example 2:
 * <p>
 * <p>
 * Input: root = [7,13,11]
 * Output: [7,11,13]
 * Explanation:
 * The nodes at level 1 are 13, 11, which are reversed and become 11, 13.
 */
public class ReverseOddLevels {

    private static TreeNode reverseOddLevels(TreeNode root) {
        swap(root.left, root.right, 0);
        return root;
    }

    private static void swap(TreeNode left, TreeNode right, int level) {
        if(left == null || right == null)
            return;

        if(level % 2 == 0) {
            int t = left.key;
            left.key = right.key;
            right.key = t;
        }
        swap(left.left, right.right, level + 1);
        swap(left.right, right.left, level + 1);
    }

}