package practice.DSA.Trees;

/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values
 * along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 * Example 1:
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 *
 *  Example 2:
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 *
 *  Example 3:
 * Input: root = [1,2], targetSum = 0
 * Output: false
 */
public class PathSum {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(checkPathSum(root, 22));
    }

    static boolean checkPathSum(TreeNode root, int target) {
        return checkSum(root, 0, target);
    }

    static boolean checkSum(TreeNode root, int current, int target) {

        if(root == null)
            return false;

        if(root.left == null && root.right == null && root.key + current == target) {
            return true;
        }
        return checkSum(root.left, current + root.key, target) || checkSum(root.right, current + root.key, target);
    }
}