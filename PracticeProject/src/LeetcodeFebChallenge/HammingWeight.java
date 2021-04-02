package LeetcodeFebChallenge;

/**
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has
 * (also known as the Hamming weight).
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be
 * given as a signed integer type. It should not affect your implementation, as the integer's internal binary
 * representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3
 * above, the input represents the signed integer. -3.
 * Follow up: If this function is called many times, how would you optimize it?
 */
public class HammingWeight {

    public static void main(String[] args) {

        System.out.println(getHammingWeight(00000000000000000000000000001011));
        System.out.println(getHammingWeight(00000000000000000000000010000000));
    }

    public static int getHammingWeight(int n) {

        int count = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) > 0) count++;

            mask = mask << 1;
        }
        return count;
    }
}
