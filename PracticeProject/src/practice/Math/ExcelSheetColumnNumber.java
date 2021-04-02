package practice.Math;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 */
public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println(getColumnNumber("A"));
        System.out.println(getColumnNumber("CDA"));
        System.out.println(getColumnNumber("ZY"));
    }

    /*
    Approach: The process is similar to binary to decimal conversion.
    For example, to convert AB, the formula is 26 * 1 + 2.
    As another example,

    To convert CDA,
        3*26*26 + 4*26 + 1
        = 26(3*26 + 4) + 1
        = 26(0*26 + 3*26 + 4) + 1
    So it is very much similar to converting binary to decimal keeping the base as 26.
     */
    public static int getColumnNumber(String s) {

        char[] arr = s.toCharArray();
        int counter = 0;
        int result = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            result += Math.pow(26, counter++) * (arr[i] - 'A' + 1);
        }
        return result;
    }
}
