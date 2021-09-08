package practice.DSA.Trees.SegmentTrees;
/**
 * Given an integer array nums, handle multiple queries of the following types:
 *
 * Update the value of an element in nums.
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 *
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * void update(int index, int val) Updates the value of nums[index] to be val.
 * int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive
 * (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 *
 *
 * Example 1:
 *
 * Input
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * Output
 * [null, 9, null, 8]
 *
 * Explanation
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
 * numArray.update(1, 2);   // nums = [1, 2, 5]
 * numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 *
 * Constraints:
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * 0 <= index < nums.length
 * -100 <= val <= 100
 * 0 <= left <= right < nums.length
 * At most 3 * 104 calls will be made to update and sumRange.
 */
public class RangeQuerySum {

    public static void main(String[] args) {

        NumArray obj = new NumArray(new int[] {1, 3, 5});
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2));
    }
}

class NumArray {

    class SegmentTreeNode {

        private int start, end;
        private SegmentTreeNode left, right;
        private int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    // TC : O(n)
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {

        if(start > end) {
            return null;
        } else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);

            if(start == end) {
                ret.sum = nums[start]; // leaf nodes
            } else {
                int mid = start + (end - start) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }

    // TC : O(logn)
    void update(int i, int val) {
        updateHelper(root, i, val);
    }

    void updateHelper(SegmentTreeNode root, int pos, int val) {

        // found leaf node to be updated
        if(root.start == root.end) {
            root.sum = val;
        } else {
            // parent nodes across the path
            int mid = root.start + (root.end - root.start) / 2;

            if(pos <= mid) {
                updateHelper(root.left, pos, val);
            } else {
                updateHelper(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRangeHelper(root, i, j);
    }

    // TC : O(logn)
    public int sumRangeHelper(SegmentTreeNode root, int start, int end) {

        // if you found out the node that matches your search return its value
        if(root.start == start && root.end == end) {
            return root.sum;
        } else {

            int mid = root.start + (root.end - root.start) / 2; // overflow conditions

            if(end <= mid) {
                // move left
                return sumRangeHelper(root.left, start, end);
            } else if(start >= mid + 1) {
                // move right
                return sumRangeHelper(root.right, start, end);
            } else {
                // consider both nodes
                return sumRangeHelper(root.left, start, mid) + sumRangeHelper(root.right, mid + 1, end);
            }
        }
    }
}