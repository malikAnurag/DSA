package practice.DSA.String;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 * Example 1:
 *
 * Input: "USA"
 * Output: True
 *
 *
 * Example 2:
 *
 * Input: "FlaG"
 * Output: False
 *
 */
public class DetectCapital {

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("leetcode"));
        System.out.println(detectCapitalUse("Google"));
        System.out.println(detectCapitalUse("FlaG"));
    }

    public static boolean detectCapitalUse(String word) {

        char[] arr = word.toCharArray();
        boolean firstCapital = false;

        if (Character.isUpperCase(arr[0]))
            firstCapital = true;

        if (!firstCapital) {
            for (int i = 1; i < arr.length; i++) {
                if (Character.isUpperCase(arr[i])) {
                    return false;
                }
            }
        } else {
            int capitals = 1;
            for (int i = 1; i < arr.length; i++) {
                if (Character.isUpperCase(arr[i])) {
                    capitals++;
                }
            }
            if (capitals > 1 && capitals < arr.length)
                return false;
        }
        return true;
    }
}
