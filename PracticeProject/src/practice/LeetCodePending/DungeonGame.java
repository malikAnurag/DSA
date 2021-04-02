package practice.LeetCodePending;

import java.util.Arrays;

/**
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
 * The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned
 * in the top-left room and must fight his way through the dungeon to rescue the princess.
 *
 * The knight has an initial health point represented by a positive integer. If at any point his health point
 * drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering
 * these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health
 * (positive integers).
 *
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or
 * downward in each step.
 *
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 *
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows
 * the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 *
 *
 -2 (K)	    -3	    3
 -5	        -10	    1
 10	        30	   -5 (P)

 Note:

 The knight's health has no upper bound.
 Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class DungeonGame {

    public static void main(String[] args) {

        int[][] dungeon = new int[][]{  {-2, -3, 3},
                                        {-5, -10, 1},
                                        {10, 30, -5}    };

        System.out.println(calculateMinimumHP(dungeon));

    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length + 1][dungeon[0].length + 1];
        for (int i = 0; i < dungeon.length + 1; i++) Arrays.fill(dp[i], -1);

        return mhr(dungeon, 0, 0, dp);
    }

    private static int mhr(int[][] arr, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) return dp[i][j];
        if (i == arr.length - 1 && j == arr[0].length - 1) return arr[i][j] > 0 ? 1 : Math.abs(arr[i][j]) + 1;
        if (i == arr.length || j == arr[0].length) return Integer.MAX_VALUE;

        return dp[i][j] = Math.max(1, Math.min(mhr(arr, i + 1, j, dp), mhr(arr, i, j + 1, dp)) - arr[i][j]);
    }


}
