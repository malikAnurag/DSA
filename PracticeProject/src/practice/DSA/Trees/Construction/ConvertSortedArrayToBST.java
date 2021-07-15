package practice.DSA.Trees.Construction;

import practice.DSA.Trees.TreeNode;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 * Example 1:
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
 *
 *  Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 */
// Time complexity: O(N) since we visit each node exactly once.
// Space complexity: O(N). O(N) to keep the output, and O(logN) for the recursion stack.
public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return insertNode(nums, 0, nums.length - 1);
    }

    TreeNode insertNode(int[] nums, int left, int right) {

        if(left > right)
            return null;

        int mid = (right+left)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = insertNode(nums, left, mid - 1);
        root.right = insertNode(nums, mid + 1, right);
        return root;
    }
}