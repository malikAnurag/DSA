package practice.DSA;

import java.util.HashSet;
import java.util.Scanner;

/**
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
 * (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * Return True if n is a happy number, and False if not.
 */

public class HappyNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(isHappy(scan.nextInt()));
    }

    public static boolean isHappy(int n) {
        boolean flag;
        HashSet<Integer> hs = new HashSet<>();

        while (true) {
            String S = String.valueOf(n);
            int result = 0;
            for (char c : S.toCharArray()) {
                result += Math.pow(Integer.valueOf(String.valueOf(c)), 2);
            }

            boolean flag2 = hs.add(result);
            if (flag2) {
                if (result != 1)
                    n = result;
                else {
                    flag = true;
                    break;
                }
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
