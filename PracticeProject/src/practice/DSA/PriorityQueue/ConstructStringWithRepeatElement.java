package practice.DSA.PriorityQueue;

import java.util.PriorityQueue;

/**
 * You are given a string s and an integer repeatLimit. Construct a new string repeatLimitedString using the characters of s such that no letter
 * appears more than repeatLimit times in a row. You do not have to use all characters from s.
 * Return the lexicographically largest repeatLimitedString possible.
 * A string a is lexicographically larger than a string b if in the first position where a and b differ, string a has a letter that appears later in the
 * alphabet than the corresponding letter in b. If the first min(a.length, b.length) characters do not differ, then the longer string is the lexicographically larger one.
 *
 * Example 1:
 * Input: s = "cczazcc", repeatLimit = 3
 * Output: "zzcccac"
 * Explanation: We use all of the characters from s to construct the repeatLimitedString "zzcccac".
 * The letter 'a' appears at most 1 time in a row.
 * The letter 'c' appears at most 3 times in a row.
 * The letter 'z' appears at most 2 times in a row.
 * Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
 * The string is the lexicographically largest repeatLimitedString possible so we return "zzcccac".
 * Note that the string "zzcccca" is lexicographically larger but the letter 'c' appears more than 3 times in a row, so it is not a valid repeatLimitedString.
 *
 * Example 2:
 * Input: s = "aababab", repeatLimit = 2
 * Output: "bbabaa"
 * Explanation: We use only some of the characters from s to construct the repeatLimitedString "bbabaa".
 * The letter 'a' appears at most 2 times in a row.
 * The letter 'b' appears at most 2 times in a row.
 * Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
 * The string is the lexicographically largest repeatLimitedString possible so we return "bbabaa".
 * Note that the string "bbabaaa" is lexicographically larger but the letter 'a' appears more than 2 times in a row, so it is not a valid repeatLimitedString.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= repeatLimit <= s.length <= 105
 * s consists of lowercase English letters.
 */
public class ConstructStringWithRepeatElement {

    public static void main(String[] args) {
        System.out.println(getString("cczazcc", 3));
        System.out.println(getString("aababab", 2));
    }

    private static String getString(String s, int repeatLimit) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int[] freq = new int[26];

        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for(int i = 0 ; i < 26 ; i++) {
            if(freq[i] > 0) pq.offer(new int[]{i + 'a', freq[i]});
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int ch = curr[0], count = curr[1];

            int used = Math.min(count, repeatLimit);

            for(int i = 0 ; i < used ; i++) {
                sb.append((char)ch);
                count--;
            }

            if(count > 0) {
                if (pq.isEmpty()) break;

                int[] next = pq.poll();
                sb.append((char)next[0]);
                next[1]--;

                if(next[1] > 0) pq.offer(next);
                pq.offer(new int[]{ch, count});
            }
        }
        return sb.toString();
    }
}
