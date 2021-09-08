package practice.DSDesign;

/**
 * Given an integer array nums, handle multiple queries of the following type:
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 *
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right
 * inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 *
 * Example 1:
 * Input
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * Output
 * [null, 1, -1, -3]
 *
 * Explanation
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
 * numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
 * numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 *
 * Constraints:
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= left <= right < nums.length
 * At most 104 calls will be made to sumRange.
 * // TODO: check segment trees
 */

/*
* Time complexity : O(n)
* */
public class RangeSumQuery {

    public static void main(String[] args) {
        RangeSumQuery obj = new RangeSumQuery(new int[]{-2, 0, 3, -5, 2, -1});
        int res1 = obj.sumRange(0, 2);
        int res2 = obj.sumRange(2, 5);
        int res3 = obj.sumRange(0, 5);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

    int[] prefixSum;

    public RangeSumQuery(int[] nums) {

        prefixSum = new int[nums.length + 1];

        for(int i = 0 ; i < nums.length ; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        for(int i : prefixSum) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
