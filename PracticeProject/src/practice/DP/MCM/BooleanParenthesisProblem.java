package practice.DP.MCM;

/**
 * Given a boolean expression s that contain symbols and operators. The task is to count the number of ways we can parenthesize the expression so that the value of the expression evaluates to true.
 * <p>
 * Symbols
 * T —> true
 * F —> false
 * <p>
 * Operators
 * & —> boolean AND
 * | —> boolean OR
 * ^ —> boolean XOR
 * <p>
 * Examples:
 * Input: s = T|T&F^T
 * Output: 4
 * Explanation: The expression evaluates to true in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
 * <p>
 * Input: s = T^F|F
 * Output: 2
 * Explanation: ((T^F)|F) and (T^(F|F)) are the only ways.
 */
public class BooleanParenthesisProblem {

    public static void main(String[] args) {
        String s1 = "T|T&F^T";
        System.out.println(solve(s1, 0, s1.length() - 1, true));

        String s2 = "T^F|F";
        System.out.println(solve(s2, 0, s2.length() - 1, true));
    }

    private static int solve(String s, int i, int j, boolean isTrue) {

        if (i > j)
            return 1;
        else if (i == j) {
            return isTrue == (s.charAt(i) == 'T') ? 1 : 0;
        }

        int ans = 0;

        // k has to start from the next position of i as it has to be ONLY on the operators
        // that's why it will increment with 2
        // k will go till j - 1 because the last operator will be at this position
        for (int k = i + 1; k <= j - 1; k += 2) {

            int leftTrue = solve(s, i, k - 1, true); // if operator is at k, this will go till k - 1
            int leftFalse = solve(s, i, k - 1, false);
            int rightTrue = solve(s, k + 1, j, true);
            int rightFalse = solve(s, k + 1, j, false);

            if (s.charAt(k) == '&') {
                if (isTrue) {
                    ans += leftTrue * rightTrue;
                } else {
                    ans += (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftFalse * rightFalse);
                }
            } else if (s.charAt(k) == '|') {
                if (isTrue) {
                    ans += (leftTrue * rightTrue) + (leftTrue * rightFalse) + (leftFalse * rightTrue);
                } else {
                    ans += leftFalse * rightFalse;
                }
            } else if (s.charAt(k) == '^') {
                if (isTrue) {
                    ans += (leftTrue * rightFalse) + (leftFalse * rightTrue);
                } else {
                    ans += (leftTrue * rightTrue) + (leftFalse * rightFalse);
                }
            }
        }
        return ans;
    }
}
