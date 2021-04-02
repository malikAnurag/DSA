package practice.DSA.Array;

public class SubArrayWhoseSumIsNumber1 {

    public static void main(String[] args) {
        findSubArray(new int[]{42, 15, 12, 8, 6, 32}, 26);

        findSubArray(new int[]{12, 5, 31, 13, 21, 8}, 49);

        findSubArray(new int[]{15, 51, 7, 81, 5, 11, 25}, 41);
    }

    static void findSubArray(int[] inputArray, int inputNumber) {

        int start = 0;
        int sum = inputArray[0];

        for (int i = 1; i < inputArray.length; i++) {

            sum += inputArray[i];

            while (sum > inputNumber && start <= i - 1) {
                sum -= inputArray[start];
                start++;
            }
            if (sum == inputNumber) {
                System.out.println("Array for sum " + inputNumber + " is :");
                for (int j = start; j <= i; j++) {
                    System.out.print(inputArray[j] + " ");
                }
                System.out.println();
            }
        }

    }

}
