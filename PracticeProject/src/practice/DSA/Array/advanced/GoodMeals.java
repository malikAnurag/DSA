package practice.DSA.Array.advanced;

import java.util.HashMap;
import java.util.Map;

/**
 * A good meal is a meal that contains exactly two different food items with a sum of deliciousness equal to a power of two.
 * <p>
 * You can pick any two different foods to make a good meal.
 * <p>
 * Given an array of integers deliciousness where deliciousness[i] is the deliciousness of the ith item of food,
 * return the number of different good meals you can make from this list modulo 109 + 7.
 * <p>
 * Note that items with different indices are considered different even if they have the same deliciousness value.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: deliciousness = [1,3,5,7,9]
 * Output: 4
 * Explanation: The good meals are (1,3), (1,7), (3,5) and, (7,9).
 * Their respective sums are 4, 8, 8, and 16, all of which are powers of 2.
 * Example 2:
 * <p>
 * Input: deliciousness = [1,1,1,3,3,3,7]
 * Output: 15
 * Explanation: The good meals are (1,1) with 3 ways, (1,3) with 9 ways, and (1,7) with 3 ways.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= deliciousness.length <= 105
 * 0 <= deliciousness[i] <= 220
 */
public class GoodMeals {

    public int countPairs(int[] deliciousness) {

        int MOD = 1_000_000_007;
        long count = 0;
        Map<Integer, Integer> hm = new HashMap<>();

        for (int num : deliciousness) {
            int pow = 1;
            for (int i = 0; i < 22; i++) {
                if (hm.containsKey(pow - num)) {
                    count += hm.get(pow - num);
                    count %= MOD;
                }
                pow *= 2;
            }
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        return (int) count;
    }
}
