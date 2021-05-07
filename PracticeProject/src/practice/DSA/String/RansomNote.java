package practice.DSA.String;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 */
public class RansomNote {

    public static void main(String[] args) {
        System.out.println("Is Ransom possible?");

        System.out.println("Answer: " + isRansomPossible("a", "b"));

        System.out.println("Answer: " + isRansomPossible("aa", "ab"));

        System.out.println("Answer: " + isRansomPossible("aa", "aab"));
    }

    public static boolean isRansomPossible(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length())
            return false;

        int[] mag = new int[256];
        boolean flag = true;

        for (char c : magazine.toCharArray())
            mag[c]++;

        for (char x : ransomNote.toCharArray()) {
            mag[x]--;
            if (mag[x] < 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
