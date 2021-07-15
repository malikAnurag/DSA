package practice.DSA.LinkedList.Reversals;

import practice.DSA.LinkedList.ListNode;
import practice.DSA.LinkedList.ListNodeUtil;

/**
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 *
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 *
 *  Example 2:
 * Input: head = []
 * Output: []
 *
 *  Example 3:
 * Input: head = [1]
 * Output: [1]
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Original List: ");
        ListNodeUtil.printList(head);

        System.out.println("\nResultant List: ");
        ListNodeUtil.printList(swapPairs(head));

    }

    public static ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null)
            return head;

        return swap(head);
    }

    static ListNode swap(ListNode head) {

        if(head == null)
            return null;

        ListNode copy = head.next != null ? head.next.next : null;

        ListNode t = head;
        head = head.next;

        if(head != null) {
            head.next = t;
            t.next = swap(copy);
        }
        else {
            return t;
        }
        return head;
    }
}
