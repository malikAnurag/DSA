package amazon.arraysAndStrings;

import java.util.*;

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

public class GroupAnagrams_TLE {

    public static void main(String[] args) {

        for(List<String> al : groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"})) {
            System.out.println(al.toString());
        }

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList();

        Map<String,Boolean> hm = new HashMap();

        for(String s : strs) {
            hm.put(s, true);
        }

        for(int i = 0 ; i < strs.length - 1; i++) {

            if(hm.get(strs[i])) {

                List<String> al = new ArrayList();
                al.add(strs[i]);
                hm.put(strs[i], false);

                for(int j = i+1 ; j < strs.length ; j++) {
                    if(areAnagrams(strs[i],strs[j])) {
                        al.add(strs[j]);
                        hm.put(strs[j], false);
                    }
                }
                result.add(al);
            }
        }

        if(hm.get(strs[strs.length-1])) {
            List<String> al = new ArrayList();
            al.add(strs[strs.length-1]);

            result.add(al);
        }

        return result;
    }

    public static boolean areAnagrams(String s1, String s2) {

        int[] index = new int[256];
        Arrays.fill(index,0);

        for(char c : s1.toCharArray()) {
            index[c]++;
        }

        for(char c : s2.toCharArray()) {
            index[c]--;
        }

        for(int i = 0 ; i < index.length ; i++) {
            if(index[i] != 0)
                return false;
        }
        return true;
    }


}
