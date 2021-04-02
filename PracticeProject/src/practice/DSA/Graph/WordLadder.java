package practice.DSA.Graph;

import java.util.*;
/**
 * Given two words beginWord and endWord, and a dictionary wordList, return the length of the shortest
 * transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Return 0 if there is no such transformation sequence.
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.

 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {

    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
        System.out.println(ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"))));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord))
            return 0;

        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int q = 0; q < size; q++) {

                char[] cur = queue.poll().toCharArray();

                for (int i = 0; i < cur.length; i++) {

                    char tmp = cur[i];
                    for (char chr = 'a'; chr <= 'z'; chr++) {

                        cur[i] = chr;
                        String dest = new String(cur);
                        if (dict.contains(dest)) {
                            if (dest.equals(endWord)) {
                                return level + 1;
                            }
                            queue.add(dest);
                            dict.remove(dest);
                        }
                    }
                    cur[i] = tmp;
                }
            }
            level++;
        }
        return 0;
    }
}
