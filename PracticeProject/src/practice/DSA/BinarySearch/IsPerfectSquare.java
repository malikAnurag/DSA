package practice.DSA.BinarySearch;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 */
public class IsPerfectSquare {

    public static void main(String[] args) {
        System.out.println(checkPerfectSquare(16));
        System.out.println(checkPerfectSquare(150));
        System.out.println(checkPerfectSquare(90000));
    }

    public static boolean checkPerfectSquare(int num) {

        if(num == 0)
            return true;

        if(num < 0)
            return false;

        long left = 1;
        long right = Integer.MAX_VALUE;

        while(left <= right) {

            long mid = (left + right) / 2;
            long midSqr = mid * mid;

            if(midSqr == num) {
                return true;
            }

            if(midSqr > num) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }
}
