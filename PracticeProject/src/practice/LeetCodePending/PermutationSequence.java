package practice.LeetCodePending;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class PermutationSequence {

    public static void main(String[] args) {

        System.out.println(getPermutation(3,3));
        System.out.println(getPermutation(4,9));

    }

    public static String getPermutation(int n, int k) {

        // factorial calculation and store in array
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++)
            fact[i] = fact[i - 1] * i;

        // create list of numbers from 1 to n, can also done using simple for loop
        List<Integer> numbers = IntStream.range(1, n + 1)
                                         .mapToObj(x -> x)
                                         .collect(Collectors.toList());

        // place the numbers according to the approach given above
        StringBuilder sb = new StringBuilder();
        k--;

        for(int i = 1; i <= n; i++) {
            int index = k / fact[n - i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * fact[n - i];
        }

        return sb.toString();
    }
}
