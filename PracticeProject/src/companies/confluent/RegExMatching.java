package companies.confluent;

/**
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Example 1:
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 *  Example 2:
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 *  Example 3:
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 */
public class RegExMatching {

    public boolean isMatch(String text, String pattern) {

        if (pattern.isEmpty())
            return text.isEmpty();

        boolean first_match = !text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            // Two possibilities :
            // 1. x* matches zero occurrences → skip "x*" entirely in the pattern
            // 2. x* matches at least one occurrence :
            //      → only if the first character matches (first_match)
            //      → consume one character from text but keep the pattern
            return isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern));
        } else {
            //  If the second character in the pattern is not *, then we must have:
            //      - The first characters matching (first_match), and
            //      - The rest of the strings also match recursively.
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}
