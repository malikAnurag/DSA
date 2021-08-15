package practice.DSA.RecursionAndBacktracking;

import java.util.Scanner;

public class PerfectSquareHexaDecimalSplits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        System.out.println(getMin(S,0));
    }
    public static int getMin(String S, int index) {
        int min = getNumberOfSplits(S,index);
        if(min > 0 && min < S.length())
            return min;
        else
            return -1;
    }
    public static int getNumberOfSplits(String S, int index) {
        if(index ==  S.length())
            return 0;
        int result = Integer.MAX_VALUE;
        int num = 0 ;

        for(int i = index ; i < S.length() ; i++) {
            num = 16 * num + Integer.parseInt(String.valueOf(S.charAt(i)), 16);
            if(checkPerfectSquare(num)) {
                result = Math.min(result , 1 + getNumberOfSplits(S, i+1));
            }
        }
        return result;
    }

    public static boolean checkPerfectSquare(int n) {
        double ps = Math.sqrt(n);
        return (ps - Math.floor(ps) == 0);
    }
}