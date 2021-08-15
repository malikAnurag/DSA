package practice.DSA.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
 * A leaf is a node with no children.
 *
 * Example 1:
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 *
 *  Example 2:
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 *
 *  Example 3:
 * Input: root = [1,2], targetSum = 0
 * Output: []
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class PathSum_II {

    static List<List<Integer>> result = new ArrayList();

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(7);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);

        System.out.println(pathSum(root, 22));

    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        findPaths(root, targetSum, 0, new ArrayList());
        return result;
    }

    static void findPaths(TreeNode root, int target, int current, List<Integer> al) {

        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null && root.key + current == target) {
            al.add(root.key);
            List<Integer> res = new ArrayList(al);
            result.add(res);
            return;
        }

        al.add(root.key);

        if(root.left != null) {
            findPaths(root.left, target, current + root.key, al);
            al.remove(al.size()-1);
        }

        if(root.right != null) {
            findPaths(root.right, target, current + root.key, al);
            al.remove(al.size()-1);
        }
    }
}
