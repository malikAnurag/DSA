package practice.DSA;

/**
 * Find number of trailing zeroes in a fectorial.
 */
public class TrailingZeroesInFectorial {

    public static void main(String[] args) {
        System.out.println(getTrailingZeroes(10));
    }

    public static int getTrailingZeroes(int A) {

        int result = 0;

        for (int i = 5; A / i > 0; i *= 5) {
            result += A / i;
        }

        return result;
    }
}
