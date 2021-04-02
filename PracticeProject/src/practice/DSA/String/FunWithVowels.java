package practice.DSA.String;

import java.util.HashMap;
import java.util.Map;

class FunWithVowels {

    /*
     * Complete the 'longestVowelSubsequence' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    private static final Character a = 'a';
    private static final Character e = 'e';
    private static final Character i = 'i';
    private static final Character o = 'o';
    private static final Character u = 'u';

    public static int longestVowelSubsequence(String s) {
        // Write your code here
        Map<Character, Character> cMap = new HashMap<>();
        char[] charArray = s.toCharArray();

        cMap.put(e, a); cMap.put(i, e); cMap.put(o, i); cMap.put(u, o);

        Map<Character, String> longSeqMap = new HashMap<>();

        for (char c : charArray) {
            String currentCharseq;
            String prevCharseq = null;
            if (c == a) {
                currentCharseq = longSeqMap.getOrDefault(c, "");
            } else {
                currentCharseq = longSeqMap.get(c);
                char precChar = cMap.get(c);
                prevCharseq = longSeqMap.get(precChar);
            }

            if (prevCharseq == null && currentCharseq != null) {
                updateMap(currentCharseq, c, longSeqMap);
            } else if (currentCharseq == null && prevCharseq != null) {
                updateMap(prevCharseq, c, longSeqMap);
            } else if (currentCharseq != null && prevCharseq != null) {
                if (currentCharseq.length() < prevCharseq.length()) {
                    updateMap(prevCharseq, c, longSeqMap);
                } else {
                    updateMap(currentCharseq, c, longSeqMap);
                }
            }
        }

        if (longSeqMap.get(u) == null) {
            return 0;
        }

        return longSeqMap.get(u).length();
    }

    private static void updateMap(String longestSub, char c, Map<Character, String> longSeqMap){
        String currCharLongestSub = longestSub + c;
        longSeqMap.put(c, currCharLongestSub);
    }

}
