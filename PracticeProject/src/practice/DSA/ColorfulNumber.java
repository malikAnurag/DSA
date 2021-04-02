package practice.DSA;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Given an integer N, the task is to check if the product of every consecutive set of digits is distinct or not.
 */

public class ColorfulNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = colorful(scan.nextInt());
        System.out.println(num);
    }

    public static int colorful(int A) {

        String S = String.valueOf(A);
        int flag = 1;
        Set<Integer> hs = new HashSet<>();

        for (int i = 0; i <= S.length(); i++) {
            int prod = 1;
            for (int j = i; j < S.length(); j++) {
                prod *= S.charAt(j);
                if (hs.contains(prod)) {
                    flag = 0;
                    break;
                } else {
                    hs.add(prod);
                }
            }
        }
        return flag;
    }
}

