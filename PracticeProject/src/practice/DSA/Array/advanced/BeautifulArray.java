package practice.DSA.Array.Advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * For some fixed n, an array nums is beautiful if it is a permutation of the integers 1, 2, ..., n, such that:
 * For every i < j, there is no k with i < k < j such that nums[k] * 2 = nums[i] + nums[j].
 * Given n, return any beautiful array nums.  (It is guaranteed that one exists.)
 *
 * Example 1:
 * Input: n = 4
 * Output: [2,1,4,3]
 *
 * Example 2:
 * Input: n = 5
 * Output: [3,1,2,5,4]
 *
 * Note:
 * 1 <= n <= 1000
 */

/*
Remember this formula to solve this question : Odd = 2*i - 1 and Even = 2*i
Keep on adding these to the list till its size becomes n
*/
public class BeautifulArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(beautifulArray(5)));
    }

    public static int[] beautifulArray(int n) {

        List<Integer> al = new ArrayList();
        al.add(1);

        while(al.size() < n) {

            List<Integer> temp = new ArrayList();

            for(int i : al) {
                if(2 * i - 1 <= n) {
                    temp.add(2 * i - 1);
                }
            }

            for(int i : al) {
                if(2 * i <= n) {
                    temp.add(2 * i);
                }
            }
            al = temp;
        }
        return al.stream().mapToInt(i -> i).toArray();
    }
}