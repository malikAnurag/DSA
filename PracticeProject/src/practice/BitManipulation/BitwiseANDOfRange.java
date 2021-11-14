package practice.BitManipulation;

/**
 * Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.
 *
 * Example 1:
 * Input: left = 5, right = 7
 * Output: 4
 *
 * Example 2:
 * Input: left = 0, right = 0
 * Output: 0
 *
 * Example 3:
 * Input: left = 1, right = 2147483647
 * Output: 0
 *
 * Constraints:
 * 0 <= left <= right <= 231 - 1
 */
public class BitwiseANDOfRange {

    public static void main(String[] args) {
        System.out.println(getResult(5, 7));
        System.out.println(getResult(0, 0));
        System.out.println(getResult(1, 2147483647));
    }

    // Right shift until both the numbers have same bits because the initial bits are different starting from the right
    // So go until the point from where the bits are the same towards the left ... till 32
    // So basically first we do right shift to remove all the mismatches of 0s and 1s and take a count of these shifts
    // Finally, do a left shift by this count, of one of the numbers to get the common part and all 0s on the right side

    static int getResult(int left, int right) {

        int count = 0;

        while(left != right) {
            left >>= 1;
            right >>= 1;
            count++;
        }
        return left << count;
    }
}