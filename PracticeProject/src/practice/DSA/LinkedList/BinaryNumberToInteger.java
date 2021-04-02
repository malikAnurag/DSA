package practice.DSA.LinkedList;

/**
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list
 * is either 0 or 1.
 * The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 * Example 1:
 *
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 *
 *  Example 2:
 *
 * Input: head = [0]
 * Output: 0
 *
 * Example 3:
 *
 * Input: head = [1]
 * Output: 1
 *
 * Example 4:
 *
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 * Example 5:
 *
 * Input: head = [0,0]
 * Output: 0
 */
public class BinaryNumberToInteger {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        System.out.println(getDecimalValue(head));
    }

    public static int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        int power = 0;
        int result = 0;

        for (int i = sb.length() - 1; i >= 0; i--) {
            result += Integer.valueOf(String.valueOf(sb.toString().charAt(i))) * Math.pow(2, power++);
        }
        return result;
    }
}
