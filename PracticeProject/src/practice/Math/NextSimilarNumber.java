package practice.Math;

import java.util.Arrays;

/**
 * Given a number A in a form of string.
 * You have to find the smallest number that has same set of digits as A and is greater than A.
 * If A is the greatest possible number with its set of digits, then return -1.
 *
 * Input 1:
 *  A = "218765"
 *
 *  Input 2:
 *  A = "4321"
 *
 * Example Output
 *
 *  Output 1:
 *  "251678"
 *
 * Output 2:
 *  "-1"
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The smallest number greater then 218765 with same set of digits is 251678.
 * Explanation 2:
 *
 *  The given number is the largest possible number with given set of digits so we will return -1.
 */

public class NextSimilarNumber {

    public static void main(String[] args) {

        String A = "218765";
        char[] str = A.toCharArray();
        int n = A.length();

        System.out.println(findNext(str, n));
    }

    public String solve(String A) {

        char[] str = A.toCharArray();
        int n = A.length();
        return findNext(str, n);

    }

    public static void swap(char ar[], int i, int j)
    {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    // Given a number as a char array number[],
    // this function finds the next greater number.
    // It modifies the same array to store the result
    public static String findNext(char ar[], int n)
    {
        int i;

        // I) Start from the right most digit
        // and find the first digit that is smaller
        // than the digit next to it.
        for (i = n - 1; i > 0; i--)
        {
            if (ar[i] > ar[i - 1]) {
                break;
            }
        }

        // If no such digit is found, then all
        // digits are in descending order means
        // there cannot be a greater number with
        // same set of digits
        if (i == 0)
        {
            return "-1";
        }
        else
        {
            int x = ar[i - 1], min = i;

            // II) Find the smallest digit on right
            // side of (i-1)'th digit that is greater
            // than number[i-1]
            for (int j = i + 1; j < n; j++)
            {
                if (ar[j] > x && ar[j] < ar[min])
                {
                    min = j;
                }
            }

            // III) Swap the above found smallest
            // digit with number[i-1]
            swap(ar, i - 1, min);

            // IV) Sort the digits after (i-1)
            // in ascending order
            Arrays.sort(ar, i, n);
            StringBuilder sb = new StringBuilder();
            for (i = 0; i < n; i++)
                sb.append(ar[i]);
            return sb.toString();
        }
    }

}