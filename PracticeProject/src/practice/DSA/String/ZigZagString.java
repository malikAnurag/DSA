package practice.DSA.String;

import java.util.Arrays;

public class ZigZagString {

    public static void main(String[] args) {
        String x = "ABCDEFGHIJKLMNOPQRS";
        System.out.println(convert(x, 6));
    }

    public static String convert(String A, int B) {

        if (B == 1)
            return A;

        String[] arr = new String[B];
        Arrays.fill(arr, "");

        char[] x = A.toCharArray();
        int j = 0;
        boolean down = true;

        for (int i = 0; i < x.length; i++) {

            arr[j] += x[i];

            if (j == B - 1)
                down = false;
            if (j == 0)
                down = true;

            if (down)
                j++;
            else
                j--;
        }

        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            System.out.println(s);
            result.append(s);
        }
        return result.toString();
    }
}
