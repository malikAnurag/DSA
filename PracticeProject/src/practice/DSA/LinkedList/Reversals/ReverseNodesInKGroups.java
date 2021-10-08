package practice.DSA.LinkedList.Reversals;

import practice.DSA.LinkedList.ListNode;
import practice.DSA.LinkedList.ListNodeUtil;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 *  Example 2:
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 *  Example 3:
 * Input: head = [1,2,3,4,5], k = 1
 * Output: [1,2,3,4,5]
 *
 *  Example 4:
 * Input: head = [1], k = 1
 * Output: [1]
 *
 * Constraints:
 * The number of nodes in the list is in the range sz.
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 *
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 */
public class ReverseNodesInKGroups {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original: ");
        ListNodeUtil.printList(head);
        System.out.println();
        ListNodeUtil.printList(reverseKGroup(head, 2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode ptr = head, newHead = null, ktail = null;

        while(ptr != null) {

            ptr = head;
            int count = 0;

            while(ptr != null && count < k) {
                ptr = ptr.next;
                count++;
            }

            if(count == k) {

                ListNode revHead = reverseList(head, k);

                if(newHead == null) {
                    newHead = revHead;
                }

                if(ktail != null) {
                    ktail.next = revHead;
                }
                ktail = head;
                head = ptr;
            }
        }

        if(ktail != null) {
            ktail.next = head;
        }
        return newHead == null ? head : newHead;
    }

    static ListNode reverseList(ListNode head, int k) {

        ListNode prev = null, curr = head;
        int count = 0;

        while(count < k && curr != null) {

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        return prev;
    }
}
