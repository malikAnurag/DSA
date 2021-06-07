package practice.DSA.Stack;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Example 1:
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 *
 *  Example 2:
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 *
 *  Example 3:
 * Input: s = "a##c", t = "#a#c"
 * Output: true
 * Explanation: Both s and t become "c".
 *
 *  Example 4:
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 */
public class BackSpaceCompare_WithoutStack {

    public static void main(String[] args) {
        System.out.println(compareStrings("ab#c", "ad#c"));
        System.out.println(compareStrings("ab##", "c#d#"));
        System.out.println(compareStrings("a##c", "#a#c"));
        System.out.println(compareStrings("a#c", "b"));
    }

    public static boolean compareStrings(String s1, String s2) {

        String S1 = getString(s1);
        String S2 = getString(s2);

        return S1.equals(S2);
    }

    private static String getString(String str) {

        StringBuilder sb = new StringBuilder();

        for(char c : str.toCharArray()) {
            if(c == '#' && sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
