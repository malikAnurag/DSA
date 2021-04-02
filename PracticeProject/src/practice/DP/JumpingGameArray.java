package practice.DP;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine minimum number of jumps required to reach the last index.
 */
public class JumpingGameArray {

    public static void main(String[] args) {

        int[] arr = {2, 3, 1, 1, 4};
        System.out.println("Minimum number of jumps : " + getJumps(arr));
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

            System.out.println("\nJumps: " + jumps);
            System.out.println("Steps: " + steps);
            System.out.println("MaxReach: "+ maxReach);
        }
        return jumps;
    }
}
