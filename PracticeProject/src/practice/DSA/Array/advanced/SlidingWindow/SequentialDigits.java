package practice.DSA.Array.Advanced.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 *
 * Example 1:
 * Input: low = 100, high = 300
 * Output: [123,234]
 *
 * Example 2:
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 *
 * Constraints:
 * 10 <= low <= high <= 10^9
 */
public class SequentialDigits {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sequentialDigits(100, 300).toArray()));
        System.out.println(Arrays.toString(sequentialDigits(1000, 13000).toArray()));
    }

    /*
    * All integers that have sequential digits are substrings of string "123456789".
    * Hence to generate all such integers of a given length, just move the window of that
    * length along "123456789" string.
    * The advantage of this method is that it will generate the integers that are already in the sorted order.
    * */
    public static List<Integer> sequentialDigits(int low, int high) {

        String str = "123456789";
        int n = 10;
        List<Integer> al = new ArrayList();

        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();

        for (int i = lowLen; i <= highLen; i++) {

            for (int start = 0; start < n - i; start++) {

                int num = Integer.parseInt(str.substring(start, start + i));

                if (num >= low && num <= high)
                    al.add(num);
            }
        }
        return al;
    }
}
