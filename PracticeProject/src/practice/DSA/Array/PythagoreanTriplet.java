package practice.DSA.Array;

import java.util.Arrays;

/**
 * Check if there is a pythagorean triplet present in the given array.
 * */
public class PythagoreanTriplet {

    public static void main(String[] args) {

        int[] arr = {3, 1, 4, 6, 5};
        System.out.println("Pythagorean triplet present: " + findTriplet(arr));
    }

    public static boolean findTriplet(int[] arr) {

        int n = arr.length;

        for(int i = 0; i < n; i++) {
            arr[i] = (int) Math.pow(arr[i], 2);
        }

        Arrays.sort(arr);

        for(int i = n - 1; i >= 2; i--) {

            int l = 0, r = i - 1;

            while(l < r) {
                if(arr[l] + arr[r] == arr[i])
                    return true;
                else if(arr[l] + arr[r] < arr[i])
                    l++;
                else
                    r--;
            }
        }
        return false;
    }
}
