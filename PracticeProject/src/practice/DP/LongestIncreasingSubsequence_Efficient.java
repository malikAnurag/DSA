package practice.DP;

import java.util.TreeSet;

// TIME : O(n log(n)) -> Removal in BST takes log(n) ; happens for every integer so n times the time
// SPACE : O(n)
public class LongestIncreasingSubsequence_Efficient {

    public static void main(String[] args) {
        System.out.println("Longest increasing subsequence : " + lengthOfLIS(new int[] {1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }

    static int lengthOfLIS(int[] nums) {

        TreeSet<Integer> ts = new TreeSet();

        for(int i : nums) {

            Integer highOrEqual = ts.ceiling(i);

            if(highOrEqual != null) {
                ts.remove(highOrEqual);
            }
            ts.add(i);
        }
        return ts.size();
    }
}
