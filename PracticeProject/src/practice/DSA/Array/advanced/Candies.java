package practice.DSA.Array.Advanced;

import java.util.Arrays;

/**
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 *
 * Example 1:
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 *
 *  Example 2:
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 */
public class Candies {

    public static void main(String[] args) {
        System.out.println(candy(new int[] {1, 0, 2}));
        System.out.println(candy(new int[] {1, 2, 2}));
    }

// O(n) space
// O(n) time
    public static int candy(int[] ratings) {

        int n = ratings.length;
        int[] left2right = new int[n];
        int[] right2left = new int[n];

        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);

        for(int i = 1; i < n; i++) {
            if(ratings[i - 1] < ratings[i]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }

        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
        }

        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }
        return sum;
    }
}