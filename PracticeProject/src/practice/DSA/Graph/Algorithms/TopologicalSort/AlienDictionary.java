package practice.DSA.Graph.Algorithms.TopologicalSort;

import java.util.*;

/**
 * There is a new alien language that uses the English alphabet. However, the order of the letters is unknown to you.
 * <p>
 * You are given a list of strings words from the alien language's dictionary. Now it is claimed that the strings in words are sorted lexicographically
 * by the rules of this new language.
 * <p>
 * If this claim is incorrect, and the given arrangement of string in words cannot correspond to any order of letters, return "".
 * <p>
 * Otherwise, return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules.
 * If there are multiple solutions, return any of them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 * <p>
 * Example 2:
 * Input: words = ["z","x"]
 * Output: "zx"
 * <p>
 * Example 3:
 * Input: words = ["z","x","z"]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 */
public class AlienDictionary {
    public static void main(String[] args) {
        System.out.println(alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
        System.out.println(alienOrder(new String[]{"z", "x"}));
        System.out.println(alienOrder(new String[]{"wrt","wrtkj"}));
        System.out.println(alienOrder(new String[]{"z", "x", "z"}));
    }

    public static String alienOrder(String[] words) {

        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();

        for (String s : words) {
            for (char c : s.toCharArray()) {
                graph.put(c, new ArrayList<>());
                indegree.put(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {

            String s1 = words[i];
            String s2 = words[i + 1];

            if (s1.length() > s2.length() && s1.startsWith(s2))
                return "";

            for (int j = 0; j < Math.min(s1.length(), s2.length()); j++) {

                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);

                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    indegree.put(c2, indegree.get(c2) + 1);
                    break;
                }
            }
        }

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.add(c);
            }
        }

        while (!q.isEmpty()) {

            char c = q.poll();
            sb.append(c);

            if (graph.containsKey(c)) {
                for (char x : graph.get(c)) {
                    indegree.put(x, indegree.get(x) - 1);

                    if (indegree.get(x) == 0) {
                        q.add(x);
                    }
                }
            }
        }

        if (sb.length() != indegree.size())
            return "";
        return sb.toString();
    }
}
