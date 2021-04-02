package practice.DSA.String;

import java.util.Scanner;

/**
 * Return the maximum length of substring that has at most 2 matching characters.
 */
public class SuperString {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println(getMaxLength(scan.nextLine()));
    }

    public static int getMaxLength(String S) {

        int[] count = new int[256];
        int len = 0;
        int l = 0;

        for (int r = 0; r < S.length(); r++) {

            ++count[S.charAt(r)];

            while (count[S.charAt(r)] > 2) {
                --count[S.charAt(l)];
                l++;
            }

            len = Math.max(len, r - l + 1);
        }
        return len;
    }
}
//aabccba