package practice.BitManipulation;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, return the Hamming distance between them.
 *
 * Example 1:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 *
 * Example 2:
 * Input: x = 3, y = 1
 * Output: 1
 *
 * Constraints:
 * 0 <= x, y <= 231 - 1
 */
public class HammingDistanceBitwise {

    public static void main(String[] args) {
        System.out.println(getHammingDistance(1, 4));
        System.out.println(getHammingDistance(3, 1));
    }

    /* Here XOR operation would give 1 only at those bits which are different in both these numbers.
    * Here we adopt the right shift operation, where each bit would have its turn to be shifted to the rightmost position.
    * Once shifted, we then check if the rightmost bit is one, which we can use either the
    * modulo operation (i.e. i % 2) or the bit AND operation (i.e. i & 1). Both operations would mask out the rest of the bits other than the rightmost bit.
    * */
    static int getHammingDistance(int x, int y) {

        int xor = x ^ y;
        int ans = 0;

        while(xor != 0) {

            if( (xor & 1) == 1)
                ans++;

            xor = xor >> 1;
        }
        return ans;
    }
}
