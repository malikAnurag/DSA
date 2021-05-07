package practice.DSA.Array.advanced;

/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 *  Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 */
public class JumpingGameArray {

    public static void main(String[] args) {
        System.out.println("Minimum number of jumps : " + getJumps(new int[]{2, 3, 1, 1, 4}));
        System.out.println("Minimum number of jumps : " + getJumps(new int[]{2, 3, 0, 1, 4}));
    }

    public static int getJumps(int[] arr) {

        if (arr.length <= 1 || arr[0] == 0)
            return 0;

        int jumps = 1;
        int maxReach = arr[0];
        int steps = arr[0];

        for(int i = 1 ; i < arr.length ; i++) {

            if(i == arr.length-1)
                return jumps;

            if(maxReach < i + arr[i]) {
                maxReach = i + arr[i];
            }

            steps--;

            if(steps == 0) {
                jumps++;
                steps = maxReach - i;
            }
        }
        return jumps;
    }
}
