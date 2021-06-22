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

    int[] segmentTree;
    int[] nums;
    int n;

    public NumArray(int[] arr) {

        n = arr.length;
        nums = arr;

        int heightOfTree = (int) Math.ceil(Math.log(n) / Math.log(2));

        int maxSize = 2 * (int) Math.pow(2, heightOfTree) - 1;

        segmentTree = new int[maxSize];

        constructUtil(0, n - 1, 0);
    }

    int constructUtil(int startIndex, int endIndex, int currentIndex) {

        if(startIndex == endIndex) {
            segmentTree[currentIndex] = nums[startIndex];
            return nums[startIndex];
        }

        int mid = getMid(startIndex, endIndex);

        segmentTree[currentIndex] = constructUtil(startIndex, mid, 2 * currentIndex + 1) +
                                    constructUtil(mid + 1, endIndex, 2 * currentIndex + 2);

        return segmentTree[currentIndex];
    }

    public void update(int indexToUpdate, int val) {

        int diff = val - nums[indexToUpdate];

        nums[indexToUpdate] = val;

        updateValueUtil(0, n - 1, indexToUpdate, diff, 0);
    }

    void updateValueUtil(int startIndex, int endIndex, int indexToUpdate, int diff, int currentIndex) {

        if(indexToUpdate < startIndex || indexToUpdate > endIndex) {
            return;
        }

        segmentTree[currentIndex] = segmentTree[currentIndex] + diff;

        if(startIndex != endIndex) {
            int mid = getMid(startIndex, endIndex);
            updateValueUtil(startIndex, mid, indexToUpdate, diff, 2 * currentIndex + 1);
            updateValueUtil(mid + 1, endIndex, indexToUpdate, diff, 2 * currentIndex + 2);
        }
    }

    public int sumRange(int left, int right) {

        if(left < 0 || right >= n || left > right) {
            return -1;
        }
        return getSumUtil(0, n - 1, left, right, 0);
    }

    int getSumUtil(int startIndex, int endIndex, int left, int right, int currentIndex) {

        // If segment of this node is a part of given range, then return the sum of the segment
        if(left <= startIndex && right >= endIndex) {
            return segmentTree[currentIndex];
        }

        // If segment of this node is outside the given range
        if(endIndex < left || startIndex > right) {
            return 0;
        }

        int mid = getMid(startIndex, endIndex);

        return getSumUtil(startIndex, mid, left, right, 2 * currentIndex + 1) +
               getSumUtil(mid + 1, endIndex, left, right, 2 * currentIndex + 2);
    }

    int getMid(int left, int right) {
        return left + (right - left) / 2;
    }
}