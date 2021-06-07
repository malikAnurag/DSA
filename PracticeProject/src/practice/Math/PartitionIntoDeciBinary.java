package practice.Math;

/**
 * A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros.
 * For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
 * Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.
 *
 * Example 1:
 * Input: n = "32"
 * Output: 3
 * Explanation: 10 + 11 + 11 = 32
 *
 *  Example 2:
 * Input: n = "82734"
 * Output: 8
 *
 *  Example 3:
 * Input: n = "27346209830709182346"
 * Output: 9
 *
 * //TODO : Hints
 *                1. Think about if the input was only one digit. Then you need to add up as many ones as the value of this digit.
 *                2. If the input has multiple digits, then you can solve for each digit independently, and merge the answers to form numbers that add up to that input.
 *                3. Thus the answer is equal to the max digit.
 */
public class PartitionIntoDeciBinary {

    public static void main(String[] args) {
        System.out.println(minPartitions("32"));
        System.out.println(minPartitions("82734"));
        System.out.println(minPartitions("27346209830709182346"));
    }

    public static int minPartitions(String n) {

        int count = 0;
        for(char c : n.toCharArray()) {
            count = Math.max(count, Integer.parseInt(String.valueOf(c)));
        }
        return count;
    }
}
