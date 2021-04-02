package practice.DSA.Array;

public class FirstMissingIntConstSpace {


    public static void main(String[] args) {

        int[] A = new int[]{1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println("Missing integer: " + findFirst(A, A.length + 1));
    }


    public static int findFirst(int[] A, int n) {

        int sum = 0;

        for (int i : A)
            sum += i;

        int totalSum = (n * (n + 1)) / 2;

        return totalSum - sum;
    }
}
