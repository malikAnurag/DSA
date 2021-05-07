package practice.Math;

/**
 * Given an integer, write a function to determine if it is a power of two: n == 2^x
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 *
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(checkIfPowerOfTwo(1));
        System.out.println(checkIfPowerOfTwo(16));
        System.out.println(checkIfPowerOfTwo(-2147483648));
    }

    public static boolean checkIfPowerOfTwo(int n) {

        return (Math.log10(n)/Math.log10(2)) % 1 == 0;

//        boolean isPow = true;
//
//        if(n == 0 || n < 0)
//            return false;
//
//        while(n > 0) {
//
//            if(n == 1)
//                break;
//
//            if(n % 2 != 0) {
//                isPow = false;
//                break;
//            }
//
//            n /= 2;
//        }
//        return isPow;
    }
}
