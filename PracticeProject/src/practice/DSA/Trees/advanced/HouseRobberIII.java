package practice.DSA.Trees.advanced;

import practice.DSA.Trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree.
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 *
 * Example 1:
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 *
 * Example 2:
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 104
 */
public class HouseRobberIII {

    static Map<TreeNode, Integer> hm = new HashMap();

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println(rob(root));
    }

    static int rob(TreeNode root) {

        if(root == null)
            return 0;

        if(hm.containsKey(root))
            return hm.get(root);

        int leftRight = 0, leftLeft = 0;
        int rightLeft = 0, rightRight = 0;

        if(root.left != null) {
            leftRight = rob(root.left.right);
            leftLeft = rob(root.left.left);
        }
        if(root.right != null) {
            rightLeft = rob(root.right.left);
            rightRight = rob(root.right.right);
        }

        int left = rob(root.left);
        int right = rob(root.right);

        int withRoot = root.key + leftLeft + leftRight + rightLeft + rightRight;
        int withoutRoot = left + right;

        int ans = Math.max(withoutRoot, withRoot);
        hm.put(root, ans);
        return ans;
    }
}
