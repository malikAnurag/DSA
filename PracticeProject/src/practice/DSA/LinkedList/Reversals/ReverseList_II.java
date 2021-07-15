package practice.DSA.LinkedList.Reversals;

import practice.DSA.LinkedList.ListNode;
import practice.DSA.LinkedList.ListNodeUtil;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from POSITION left to position right, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 *
 *  Example 2:
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */
public class ReverseList_II {

    static ListNode tail = null;

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("ORIGINAL: ");
        ListNodeUtil.printList(head);

        System.out.println("\nREVERSED :");
        ListNodeUtil.printList(reverseBetween(head, 2, 4));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode ptr1 = head, ptr2 = head;
        ListNode rev1 = null, ahead = null;
        int count1 = 1, count2 = 1;

        if(head == null || head.next == null || left == right)
            return head;

        while(ptr1 != null && count1 != left) {
            rev1 = ptr1;
            ptr1 = ptr1.next;
            count1++;
        }

        while(ptr2 != null && count2 != right) {
            ptr2 = ptr2.next;
            ahead = ptr2.next;
            count2++;
        }

        if(rev1 != null) {
            rev1.next = reverseList(ptr1, count2 - count1 + 1);
        }
        else {
            head = reverseList(ptr1, count2);
        }
        tail.next = ahead;
        return head;
    }

    static ListNode reverseList(ListNode ptr1, int end) {

        int start = 1;
        ListNode prev = null, curr = ptr1, next;
        tail = ptr1;

        while(curr != null && start != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            start++;
        }
        curr.next = prev;
        return curr;
    }
}
