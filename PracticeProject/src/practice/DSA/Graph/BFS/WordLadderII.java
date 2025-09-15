package practice.DSA.Graph.BFS;

import java.util.*;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * <p>
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * <p>
 * Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists.
 * <p>
 * Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
 * <p>
 * Example 1:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * Explanation: There are 2 shortest transformation sequences:
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 * <p>
 * Example 2:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: []
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 * <p>
 * Constraints:
 * 1 <= beginWord.length <= 5
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 500
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 * The sum of all shortest transformation sequences does not exceed 105.
 */


// N -> number of words in wordList
// K -> the maximum length of a word
// α -> number of possible paths from beginWord to endWord in the directed graph we have
//
// Time complexity: O(N K^2 +α)

// Space complexity: O(NK)

public class WordLadderII {

    Map<String, List<String>> adjList = new HashMap<>();
    List<String> currPath = new ArrayList<>();
    List<List<String>> shortestPaths = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        // copying the words into the set for efficient lookups in BFS
        Set<String> copiedWordList = new HashSet<>(wordList);

        // build the DAG using BFS
        bfs(beginWord, copiedWordList);

        // every path will start from the endWord
        currPath.add(endWord);

        // traverse the DAG to find all the paths between endWord and beginWord
        backtrack(endWord, beginWord);

        return shortestPaths;
    }

    private void bfs(String beginWord, Set<String> wordList) {

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        // remove the root word which is the first layer in the BFS
        wordList.remove(beginWord);

        // To prevent enqueuing the same word more than once in the BFS queue
        Map<String, Integer> isEnqueued = new HashMap<>();
        isEnqueued.put(beginWord, 1);

        while (!q.isEmpty()) {

            // visited will store the words of current level
            List<String> visited = new ArrayList<>();

            for (int i = q.size() - 1; i >= 0; i--) {

                String currWord = q.remove();

                // findNeighbors will have the adjacent words of the currWord
                List<String> neighbors = findNeighbors(currWord, wordList);

                for (String word : neighbors) {

                    visited.add(word);

                    if (!adjList.containsKey(word)) {
                        adjList.put(word, new ArrayList<>());
                    }

                    // add the edge from word to currWord in the list
                    // This creates a reversed edge from word → currWord
                    adjList.get(word).add(currWord);

                    if (!isEnqueued.containsKey(word)) {
                        q.add(word);
                        isEnqueued.put(word, 1);
                    }
                }
            }
            // removing the words of the previous layer
            for (String s : visited) {
                wordList.remove(s);
            }
        }
    }

    private List<String> findNeighbors(String word, Set<String> wordList) {

        List<String> neighbors = new ArrayList<>();
        char[] charList = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {

            char oldChar = charList[i];

            // replace the i-th character with all letters from a to z except the original character
            for (char c = 'a'; c <= 'z'; c++) {

                charList[i] = c;

                // skip if the character is same as original or if the word is not present in the wordList
                if (c == oldChar || !wordList.contains(String.valueOf(charList))) {
                    continue;
                }
                neighbors.add(String.valueOf(charList));
            }
            charList[i] = oldChar;
        }
        return neighbors;
    }

    private void backtrack(String source, String destination) {

        // store the path if we reached the endWord
        if (source.equals(destination)) {
            List<String> tempPath = new ArrayList<>(currPath);
            Collections.reverse(tempPath);
            shortestPaths.add(tempPath);
        }

        if (!adjList.containsKey(source)) {
            return;
        }

        for (int i = 0; i < adjList.get(source).size(); i++) {
            currPath.add(adjList.get(source).get(i));
            backtrack(adjList.get(source).get(i), destination);
            currPath.remove(currPath.size() - 1);
        }
    }
}
