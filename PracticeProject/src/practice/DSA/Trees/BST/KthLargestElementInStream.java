package practice.DSA.Trees.BST;

import practice.DSA.Trees.TreeNode;

/**
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Implement KthLargest class:
 *
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 * int add(int val) Returns the element representing the kth largest element in the stream.
 *
 *
 * Example 1:
 * Input
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * Output
 * [null, 4, 5, 5, 8, 8]
 *
 * Explanation
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *
 * Constraints:
 * 1 <= k <= 104
 * 0 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * -104 <= val <= 104
 * At most 104 calls will be made to add.
 * It is guaranteed that there will be at least k elements in the array when you search for the kth element.
 */
public class KthLargestElementInStream {

    private TreeNode BST;
    private int k_count;

    public KthLargestElementInStream(int[] arr, int k) {
        BST = null;

        for(int i = 0; i < arr.length; i++) {
            BST = insertNode(BST, arr[i]);
        }
        k_count = k;
    }

    private TreeNode insertNode(TreeNode root, int num) {

        if(root == null) {
            return new TreeNode(num, 1);
        }
        if(root.key > num) {
            root.left = insertNode(root.left, num);
        }
        else {
            root.right = insertNode(root.right, num);
        }
        root.count++;
        return root;
    }

    public int add(int val) {
        BST = insertNode(BST, val);
        return searchKth(BST, k_count);
    }

    private int searchKth(TreeNode root, int k) {

        int m = root.right != null ? root.right.count : 0;

        if(k == m + 1) {
            return root.key;
        }
        if(k <= m) {
            return searchKth(root.right, k);
        }
        else {
            return searchKth(root.left, k - m - 1); // Number of nodes in the left sub-tree = Nodes other than the root and the right sub-tree = k - (m + 1)
        }
    }
}
