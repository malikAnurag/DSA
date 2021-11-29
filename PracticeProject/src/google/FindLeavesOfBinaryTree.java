package google;

import practice.DSA.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 *
 * Collect all the leaf nodes.
 * Remove all the leaf nodes.
 * Repeat until the tree is empty.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5]
 * Output: [[4,5,3],[2],[1]]
 * Explanation:
 * [[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter the order
 * on which elements are returned.
 *
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 */
public class FindLeavesOfBinaryTree {

    static List<List<Integer>> al;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(findLeaves(root));
    }

    static List<List<Integer>> findLeaves(TreeNode root) {
        al = new ArrayList<>();
        findLeavesHelper(root);
        return al;
    }

    static int findLeavesHelper(TreeNode root) {

        if(root == null)
            return -1;

        int lh = findLeavesHelper(root.left);
        int rh = findLeavesHelper(root.right);

        int current = Math.max(lh, rh) + 1;

        if(al.size() == current) {
            al.add(new ArrayList<>());
        }
        al.get(current).add(root.key);
        return current;
    }
}