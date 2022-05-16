package practice.DSA.String;

/**
 * Let's say a positive integer is a super-palindrome if it is a palindrome, and it is also the square of a palindrome.
 *
 * Given two positive integers left and right represented as strings, return the number of super-palindromes
 * integers in the inclusive range [left, right].
 *
 * Example 1:
 *
 * Input: left = "4", right = "1000"
 * Output: 4
 * Explanation: 4, 9, 121, and 484 are superpalindromes.
 * Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
 * Example 2:
 *
 * Input: left = "1", right = "2"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= left.length, right.length <= 18
 * left and right consist of only digits.
 * left and right cannot have leading zeros.
 * left and right represent integers in the range [1, 1018].
 * left is less than or equal to right.
 */

public class SuperPalindromes {

    public static void main(String[] args) {

    }

    public static int superpalindromesInRange(String left, String right) {

        int count = 0;

        long l = Long.parseLong(left);
        long r = Long.parseLong(right);

        for(int i = 1; i <= 100000; i++) {

            StringBuilder sb = new StringBuilder();
            sb.append(Integer.valueOf(i));

            for(int j = sb.length() - 1; j >= 0; j--) {
                sb.append(sb.charAt(j));
            }

            long n = Long.parseLong(sb.toString());
            n *= n;

            if(n > r)
                break;
            else if(l <= n && isPalindrome(n))
                count++;
        }


        for(int i = 1; i <= 100000; i++) {

            StringBuilder sb = new StringBuilder();
            sb.append(Integer.valueOf(i));

            for(int j = sb.length() - 2; j >= 0; j--) {
                sb.append(sb.charAt(j));
            }

            long n = Long.parseLong(sb.toString());
            n *= n;

            if(n > r)
                break;
            else if(l <= n && isPalindrome(n))
                count++;
        }

        return count;
    }


    public static boolean isPalindrome(long n) {
        return n == reverse(n);
    }

    public static long reverse(long n) {

        long m = 0, k = 0;

        while(n > 0) {
            k = n % 10;
            m = 10 * m + k;
            n /= 10;
        }

        return m;
    }
}
