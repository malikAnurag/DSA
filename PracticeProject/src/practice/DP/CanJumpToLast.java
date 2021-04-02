package practice.DP;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 */

public class CanJumpToLast {

    public static void main(String[] args) {

        int[] arr = {3, 2, 1, 0, 4};
		System.out.println(canJump(arr));

        int[] arr1 = {2,3,1,1,4};
		System.out.println(canJump(arr1));
    }

    public static boolean canJump(int[] A) {

        if (A[0] == 0 && A.length == 1)
            return true;

        int presum = A[0];
        int i = 0;

        while (presum >= i) {
            presum = Math.max(presum, A[i] + i);
            if (presum >= A.length - 1)
                return true;
            i++;
        }
        return false;
    }
}
