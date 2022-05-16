package practice.DSA.String.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * You are given an array of logs. Each log is a space-delimited string of words,
 * where the first word is the identifier.
 *
 * There are two types of logs:
 *
 * Letter-logs: All words (except the identifier) consist of lowercase English letters.
 * Digit-logs: All words (except the identifier) consist of digits.
 * Reorder these logs so that:
 *
 * The letter-logs come before all digit-logs.
 * The letter-logs are sorted lexicographically by their contents.
 * If their contents are the same, then sort them lexicographically by their identifiers.
 * The digit-logs maintain their relative ordering.
 * Return the final order of the logs.
 *
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * Explanation:
 * The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
 * The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
 *
 *  Example 2:
 *
 * Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 *
 * Constraints:
 * 1 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * All the tokens of logs[i] are separated by a single space.
 * logs[i] is guaranteed to have an identifier and at least one word after the identifier.
 */
public class ReorderDataInLogs {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
        System.out.println(Arrays.toString(reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"})));
    }

    public static String[] reorderLogFiles(String[] logs) {

        List<String> digits = new ArrayList();
        List<String> words = new ArrayList();

        for(String str : logs) {
            String[] s = str.split(" ");

            if(Character.isDigit(s[1].charAt(0))) {
                digits.add(str);
            }
            else {
                words.add(str);
            }
        }

        Collections.sort(words, (s1, s2) -> {

            /* If this is the case then the pattern will be applied at most limit-1 {2-1 = 1 time here} times,
            the resulting array’s length will not be more than n,
            and the resulting array’s last entry will contain all input beyond the last matched pattern. */
            String[] S1 = s1.split(" ", 2);
            String[] S2 = s2.split(" ", 2);

            int val = S1[1].compareTo(S2[1]);

            if(val != 0) {
                return val;
            }
            return S1[0].compareTo(S2[0]);
        });

        int n = words.size() + digits.size();
        int count = 0;
        String[] result = new String[n];

        while(count < words.size()) {
            result[count] = words.get(count);
            count++;
        }

        int counter = 0;
        while(counter < digits.size()) {
            result[count++] = digits.get(counter++);
        }

        return result;
    }
}