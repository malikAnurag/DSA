package practice.Recursion;

import java.util.Scanner;

/**
 * Find out the minimum number of pieces, i, to split this string such that each of the i pieces is a hexadecimal representation
 * of a perfect square.
 */

public class PerfectSquare {

    private static final Integer HEXADECIMAL = 16;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String S = scan.nextLine();

        int splits = getMin(S, 0);

        System.out.println(splits);

    }


    public static int getMin(String S, int index) {

        int result = getNumberofSplits(S, index);

        if (result <= S.length() && result > 0)
            return result;
        else
            return -1;

    }

    private static int getNumberofSplits(String S, int index) {

        if (index == S.length())
            return 0;

        int num = 0;
        int result = Integer.MAX_VALUE;
        for (int i = index; i < S.length(); i++) {
            num = num * 16 + Integer.parseInt(String.valueOf(S.charAt(i)), HEXADECIMAL);
            if (checkPerfectSquare(num)) {
                result = Math.min(result, 1 + getNumberofSplits(S, i + 1));
                System.out.println("Result: "+result+", num: "+num);
            }
        }
        return result;
    }

    private static boolean checkPerfectSquare(int x) {
        double sq = Math.sqrt(x);
        return ((sq - Math.floor(sq)) == 0);
    }
}

/* Test Cases :
896bb1 -> 1
1a919 -> 3
00002 -> -1
 */