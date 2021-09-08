package practice.DSA.Trees.BST;

import practice.DSA.Trees.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is
 * equal to the given target.
 *
 * Example 1:
 * Input: root = [5,3,6,2,4,null,7], k = 9
 * Output: true
 *
 * Example 2:
 * Input: root = [5,3,6,2,4,null,7], k = 28
 * Output: false
 *
 * Example 3:
 * Input: root = [2,1,3], k = 4
 * Output: true
 *
 * Example 4:
 * Input: root = [2,1,3], k = 1
 * Output: false
 *
 * Example 5:
 * Input: root = [2,1,3], k = 3
 * Output: true
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -104 <= Node.val <= 104
 * root is guaranteed to be a valid binary search tree.
 * -105 <= k <= 105
 */
public class TwoSum_IV {

    static List<Integer> al = new ArrayList<>();

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(findTarget(root, 9));
    }

    public static boolean findTarget(TreeNode root, int target) {

        inorder(root);

        int left = 0 , right = al.size() - 1;

        while(left < right) {

            int sum = al.get(left) + al.get(right);

            if(sum == target) {
                return true;
            }
            else if(sum < target) {
                left++;
            }
            else {
                right--;
            }
        }
        return false;
    }

    static void inorder(TreeNode root) {

        if(root == null)
            return;

        inorder(root.left);
        al.add(root.key);
        inorder(root.right);
    }
}