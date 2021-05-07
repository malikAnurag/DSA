package practice.Testing;

import java.util.Scanner;

public class InputTest {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        scan.nextLine();

        for(int i = 0 ; i < T ; i++) {
            String S1 = scan.nextLine();
            String S2 = scan.nextLine();
            char C = scan.nextLine().charAt(0);
            int l = scan.nextInt();

            System.out.println(S1);
            System.out.println(S2);
            System.out.println(C);
            System.out.println(l);

        }

    }

}
