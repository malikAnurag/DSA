package practice.DSA.RecursionAndBacktracking;

public class PrintCombinations {

    public static void main(String[] args) {

        f(4, "");
    }

    static void f(final int N, String currentString) {

        if (currentString.length() == N) {
            System.out.println(currentString);
            return;
        }

        f(N, currentString + "A");
        f(N, currentString + "B");
    }
}
