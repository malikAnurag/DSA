package amazon.arraysAndStrings;

import java.util.*;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of
 * banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.
 * Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 *
 *
 * Example:
 *
 * Input:
 *
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 *
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 */
public class MostCommonWord {

    public static void main(String[] args) {

        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {

        List<String> bannedWords = Arrays.asList(banned);

        paragraph = paragraph.replace(",", " ");

        String[] arr = paragraph.split(" ");
        Map<String, Integer> hm = new HashMap();

        for (String s : arr) {

            s = s.toLowerCase().trim();

            if (!s.isEmpty()) {
                char lastChar = s.charAt(s.length() - 1);

                if (!Character.isLetter(lastChar)) {
                    s = s.substring(0, s.length() - 1);
                }

                if (!hm.containsKey(s)) {
                    hm.put(s, 1);
                } else {
                    hm.put(s, hm.get(s) + 1);
                }
            }
        }
        // System.out.println(hm);
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue(new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e2.getValue() > (e1.getValue()))
                    return 1;
                else if (e2.getValue() == e1.getValue())
                    return 0;
                else
                    return -1;
            }
        });

        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            pq.add(entry);
        }

        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> entry = pq.poll();

            if (bannedWords.contains(entry.getKey())) {
                continue;
            } else {
                return entry.getKey();
            }
        }
        return null;
    }
}
