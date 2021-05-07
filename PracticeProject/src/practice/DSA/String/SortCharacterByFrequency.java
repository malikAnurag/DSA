package practice.DSA.String;

import java.util.*;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 */

public class SortCharacterByFrequency {

    public static void main(String[] args) {
        System.out.println(sortByFrequency("tree"));
        System.out.println(sortByFrequency("ccaaab"));
    }

    public static String sortByFrequency(String S) {

        Map<Character,Integer> hm = new HashMap<>();

        for(char c : S.toCharArray()) {
            if(!hm.containsKey(c))
                hm.put(c, 1);
            else
                hm.put(c, hm.get(c) + 1);
        }

        List<Map.Entry<Character, Integer>> al = new ArrayList<>(hm.entrySet());

        Collections.sort(al, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Character,Integer> entry : al) {
            for(int i = 0 ; i < entry.getValue() ; i++)
                sb.append(entry.getKey());
        }
        return sb.toString();
    }
}
