package practice.DSA.Array;

/**
 *
 * Find smallest and second smallest numbers in array!
 *
 * */
public class FirstAndSecond {

    public static void main(String[] args) {
        int[] arr = new int[]{22, 3, 4, 77, 12, 34, 56, 90, 7};
        print(arr);
    }


    public static void print(int[] arr) {

        int first, second;
        first = second = Integer.MAX_VALUE;

        for (int i : arr) {
            if (i < first) {
                second = first;
                first = i;
            } else if (i < second && i != first)
                second = i;
        }
        System.out.println("Smallest: " + first);
        System.out.println("Second Smallest: " + second);
    }
}
