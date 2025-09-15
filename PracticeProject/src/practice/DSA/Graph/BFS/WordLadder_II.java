package practice.DSA.Graph.BFS;

import java.util.*;

public class WordLadder_II {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> results = new ArrayList<>();
        Map<String, List<String>> wordToParentsMap = new HashMap<>(); // word -> list of parents
        Set<String> currentLevel = new HashSet<>(); // words being processed at the current level
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>(); // keeps track of all visited words to avoid cycles
        boolean found = false;

        if (!dict.contains(endWord)) return results;
        currentLevel.add(beginWord);

        while (!currentLevel.isEmpty() && !found) { // BFS Loop

            Set<String> nextLevel = new HashSet<>();
            visited.addAll(currentLevel);

            for (String word : currentLevel) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char oldChar = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (dict.contains(newWord) && !visited.contains(newWord)) {
                            if (newWord.equals(endWord)) {found = true;}
                            nextLevel.add(newWord);
                            wordToParentsMap.computeIfAbsent(newWord, k -> new ArrayList<>()).add(word);
                        }
                    }
                    chars[i] = oldChar;
                }
            }
            currentLevel = nextLevel;
        }
        if (!found) return results;
        // Backtracking
        List<String> path = new LinkedList<>();
        backtrack(endWord, beginWord, wordToParentsMap, path, results);
        return results;
    }
    private void backtrack(String word, String beginWord, Map<String, List<String>> parentMap, List<String> path, List<List<String>> results) {
        path.add(0, word); // add current word to the front of the path
        if (word.equals(beginWord)) {
            results.add(new ArrayList<>(path));
        } else if (parentMap.containsKey(word)) {
            for (String parent : parentMap.get(word)) {
                backtrack(parent, beginWord, parentMap, path, results);
            }
        }
        path.remove(0);
    }
}
