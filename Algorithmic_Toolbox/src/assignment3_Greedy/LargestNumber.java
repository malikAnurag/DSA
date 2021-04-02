package assignment3_Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }

    private static String largestNumber(String[] a) {

        ArrayList<String> al = new ArrayList<>();

        for (String s : a)
            al.add(s);

        Collections.sort(al, new Comparator<String>() {

            @Override
            public int compare(String X, String Y) {

                String XY = X + Y;
                String YX = Y + X;

                if (XY.equals(YX))
                    return 0;

                return XY.compareTo(YX) > 0 ? -1 : 1;
            }

        });
        String result = "";
        for (int i = 0; i < al.size(); i++) {
            result += al.get(i);
        }
        return result;
    }

}

