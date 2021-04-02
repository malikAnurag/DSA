package amazon.arraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 */
public class GroupAnagrams {

    public static void main(String[] args) {

        for(List<String> list : groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"})) {
            System.out.print(list.toString() + " ");
        }
    }

    public static List<List<String>> groupAnagrams(String[] str) {

        Map<String, List<String>> hm = new HashMap<>();

        for(String s : str) {
            String key = getKey(s);
            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(s);
        }
        return new ArrayList<>(hm.values());
    }

    public static String getKey(String s) {

        char[] arr = new char[26];

        for(char c : s.toCharArray())
            arr[c - 'a']++;

        return new String(arr);
    }
}
