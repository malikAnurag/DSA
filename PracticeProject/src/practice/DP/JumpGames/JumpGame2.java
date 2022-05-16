package practice.DP.JumpGames;

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
public class JumpGame2 {

    public static void main(String[] args) {
        System.out.println("Minimum number of jumps : " + getJumps(new int[]{2, 3, 1, 1, 4}));
        System.out.println("Minimum number of jumps : " + getJumps(new int[]{2,0}));
    }

    public static int getJumps(int[] arr) {

        int jumps = 0, farthest = 0, currentJumpEnd = 0;

        for(int i = 0 ; i < arr.length - 1; i++) {

            farthest = Math.max(farthest, arr[i] + i);

            if(i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
            }
        }
        return jumps;
    }
}
