package assignment3_Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Change {
    private static int getChange(int m) {

        int[] deno = new int[]{1, 5, 10};
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = deno.length - 1; i >= 0; i--) {

            while (m >= deno[i]) {
                m -= deno[i];
                al.add(deno[i]);
            }
        }
//    		System.out.println(al);
        return al.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

