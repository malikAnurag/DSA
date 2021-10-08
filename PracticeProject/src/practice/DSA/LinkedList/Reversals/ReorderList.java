package practice.DSA.LinkedList.Reversals;

import practice.DSA.LinkedList.ListNode;
import practice.DSA.LinkedList.ListNodeUtil;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 *
 * Example 2:
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *
 * Constraints:
 * The number of nodes in the list is in the range [1, 5 * 104].
 * 1 <= Node.val <= 1000
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List : ");
        ListNodeUtil.printList(head);

        System.out.println("\n\nOrdered List : ");
        reorder(head);
        ListNodeUtil.printList(head);
    }

    /*
     The algorithm involves three steps:
     1. Dividing list from middle node
     2. Reversing the second half
     3. Merging both the lists
    * */
    static void reorder(ListNode head) {

        if(head == null)
            return;

        ListNode slow = head, fast = head;

        // 1. Finding the middle node
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reversing the list
        ListNode prev = null, curr = slow , next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3. Merging
        ListNode first = head, second = prev;

        while(second.next != null) {
            ListNode t = first.next;
            first.next = second;
            first = t;

            t = second.next;
            second.next = first;
            second = t;
        }
    }
}
