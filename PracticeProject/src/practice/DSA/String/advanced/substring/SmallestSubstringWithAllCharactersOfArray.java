package practice.DSA.String.advanced.substring;

import java.util.HashMap;
import java.util.Map;


/**
 * Given an array of unique characters arr and a string str, Implement a function getShortestUniqueSubstring that finds the
 * smallest substring of str containing all the characters in arr.
 *
 * Return "" (empty string) if such a substring doesn’t exist.
 *
 * Come up with an asymptotically optimal solution and analyze the time and space complexities.
 *
 * Example:
 * input:  arr = ['x','y','z'], str = "xyyzyzyx"
 * output: "zyx"
 */
class SmallestSubstringWithAllCharactersOfArray {

    /*
    * HINTS:
    * If your peer is stuck, ask how they can determine if a given substring is valid and then ask how to apply that in their solution.
    * Recall that a substring is considered valid if it contains all the characters in the input array, arr.
    *
    * If your peer is using a brute force approach by checking all the possible substrings, ask how they can avoid duplicate computations.
    * Make sure proper initializations are made.
    *
    * Watch out for unnecessary variables and steps.
    *
    * For other solutions, make sure that any permutation of the characters in the input array arr can be found by the algorithm your peer proposes.
    *
    * If still no progress, point your peer in the right direction by hinting them to use two indices (the start and end positions of a sliding window) in order to
    * efficiently traverse the array and check potential substrings.
    * */


    /* ALGORITHM:
    * We scan the input string str from left to right while maintaining two indices - headIndex and tailIndex.
    *
    * At each iteration, we examine a temporary substring [str.charAt(headIndex),str.charAt(headIndex+1),..., str.charAt(tailIndex)] and keep a copy of
    * the shortest valid substring we’ve seen so far. Said differently, we keep incrementing tailIndex until the above substring contains every unique
    * character in arr.
    *
    * If the size of the resulting substring equals to arr.length then we return it since by definition there can’t be a shorter valid substring
    *  (otherwise, it’ll be missing 1 or more unique characters from arr).
    *
    * Once we found a valid substring, we increment headIndex as long the substring remains valid. At every increment we also check if the current
    * valid substring is shorter than the previously kept one. If it is, we update result to be the current substring.
    *
    * We keep repeating the above steps in a loop until we either reach the end of the input string str or return the shortest valid substring,
    * whichever comes first.
    *
    * To examine the validity of str substrings we use 2 counters:
        uniqueCounter (Integer) - the number of unique characters of arr that our current substring contains.
        countMap (Map/Hash Table) - the number of occurrences of each character of arr in our current substring.
    *
    * */

    static String getShortestUniqueSubstring(char[] arr, String str) {

        int start = 0;
        int uniqueCounter = 0;
        int patLen = arr.length;
        String result = "";
        char headChar;

        // compute the unique character
        Map<Character, Integer> map = new HashMap<>();

        for(char c : arr) {
            map.put(c, 0);
        }

        for(int i = start; i < str.length(); i++) {

            char c = str.charAt(i);

            if(!map.containsKey(c))
                continue;

            int charCount = map.get(c);

            if(charCount == 0) {
                uniqueCounter = uniqueCounter + 1;
            }

            map.put(c, map.get(c) + 1);

            // push the head forward to make the length smaller
            while(uniqueCounter == patLen) {

                int tempLength = i - start + 1;

                if(tempLength == patLen)
                    return str.substring(start, i + 1);

                // if current length is smaller update the result
                if(result.equals("") || tempLength < result.length()) {
                    result = str.substring(start, i + 1);
                }
                // try to make the string smaller from beginning and check
                headChar = str.charAt(start);

                // reduce headchar counter
                if(map.containsKey(headChar)) {
                    int headCount = map.get(headChar) - 1;// we are reducing
                    // after removing first character, if value is zero
                    // it means unique character count should be reduced
                    if(headCount == 0) {
                        uniqueCounter = uniqueCounter - 1;
                    }

                    // update the map
                    map.put(headChar, headCount);
                }

                // move head
                start = start + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getShortestUniqueSubstring(new char[] {'x', 'y', 'z'}, "xyyzyzyx"));
    }
}