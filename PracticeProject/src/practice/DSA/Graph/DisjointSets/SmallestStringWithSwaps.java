package practice.DSA.Graph.DisjointSets;

import java.util.*;

/**
 * You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 * You can swap the characters at any pair of indices in the given pairs any number of times.
 * Return the lexicographically smallest string that s can be changed to after using the swaps.
 *
 * Example 1:
 * Input: s = "dcab", pairs = [[0,3],[1,2]]
 * Output: "bacd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[1] and s[2], s = "bacd"
 *
 * Example 2:
 * Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * Output: "abcd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[0] and s[2], s = "acbd"
 * Swap s[1] and s[2], s = "abcd"
 *
 * Example 3:
 * Input: s = "cba", pairs = [[0,1],[1,2]]
 * Output: "abc"
 * Explaination:
 * Swap s[0] and s[1], s = "bca"
 * Swap s[1] and s[2], s = "bac"
 * Swap s[0] and s[1], s = "abc"
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s only contains lower case English letters.
 */
public class SmallestStringWithSwaps {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> al1 = new ArrayList<>();
        al1.add(0);al1.add(3);

        List<Integer> al2 = new ArrayList<>();
        al2.add(1);al2.add(2);
        list.add(al1);list.add(al2);
        System.out.println(getSmallestString("dcab", list));
    }

    static String getSmallestString(String s, List<List<Integer>> pairs) {

        int n = s.length();
        PathCompressionAndUnionByRank uf = new PathCompressionAndUnionByRank(n);
        Map<Integer, PriorityQueue<Character>> hm = new HashMap<>();

        for(List<Integer> al : pairs) {
            uf.union(al.get(0), al.get(1));
        }

        for(int i = 0 ; i < n ; i++) {
            hm.computeIfAbsent(uf.find(i), k -> new PriorityQueue<>()).offer(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n ; i++) {
            sb.append(hm.get(uf.find(i)).poll());
        }
        return sb.toString();
    }
}