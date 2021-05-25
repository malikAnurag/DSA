package practice.DSA.String;

/**
 * A valid number can be split up into these components (in order):
 * 1. A decimal number or an integer.
 * 2. (Optional) An 'e' or 'E', followed by an integer.
 *
 * A decimal number can be split up into these components (in order):
 * 1. (Optional) A sign character (either '+' or '-').
 * 2. One of the following formats:
 *      1. At least one digit, followed by a dot '.'.
 *      2. At least one digit, followed by a dot '.', followed by at least one digit.
 *      3. A dot '.', followed by at least one digit.
 *
 * An integer can be split up into these components (in order):
 *      1. (Optional) A sign character (either '+' or '-').
 *      2. At least one digit.
 *
 * For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"],
 * while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].
 *
 * Given a string s, return true if s is a valid number.
 *
 * Example 1:
 * Input: s = "0"
 * Output: true
 *
 *  Example 2:
 * Input: s = "e"
 * Output: false
 *
 *  Example 3:
 * Input: s = "."
 * Output: false
 *
 *  Example 4:
 * Input: s = ".1"
 * Output: true
 */
public class ValidNumber {

    public static void main(String[] args) {

        System.out.println(isValidNumber("-0.1"));
        System.out.println(isValidNumber("-90E3"));
        System.out.println(isValidNumber("3."));
        System.out.println(isValidNumber(".1"));

    }

    public static boolean isValidNumber(String s) {

        boolean digitSeen = false, eSeen = false, dotSeen = false;
        int countPlusMinus = 0;

        for(int i = 0 ; i < s.length() ; i++) {

            char ch = s.charAt(i);

            // digit
            if(Character.isDigit(ch)) {
                digitSeen = true;
            }
            // -/+
            else if(ch == '-' || ch == '+') {

                if(countPlusMinus == 2) {
                    return false;
                }

                if(i > 0 && s.charAt(i -1) != 'e' && s.charAt(i-1) != 'E') {
                    return false;
                }

                if(i == s.length() - 1) {
                    return false;
                }
                countPlusMinus++;
            }

            // dot
            else if(ch == '.') {
                if(eSeen || dotSeen) {
                    return false;
                }

                if(i == s.length() - 1 && !digitSeen) { // "3." is valid
                    return false;
                }

                dotSeen = true;
            }

            // e/E
            else if(ch == 'e' || ch == 'E') {
                if(eSeen || !digitSeen || i == s.length()-1) {
                    return false;
                }
                eSeen = true;
            }
            else {
                return false;
            }
        }
        return true;
    }
}