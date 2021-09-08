package practice.DSA.LinkedList.Reversals;

import practice.DSA.LinkedList.ListNode;
import practice.DSA.LinkedList.ListNodeUtil;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 *
 * Example 2:
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10^9
 */

public class RotateListByK {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode t = head;
        System.out.println("Original List :");
        ListNodeUtil.printList(t);

        System.out.println("\nNew List: ");
        ListNodeUtil.printList(rotateList(head, 3));
    }

    public static ListNode rotateList(ListNode head, int k) {

        if(head == null || k == 0)
            return head;

        int n = 0;
        int counter = 0;

        ListNode copy = head;
        ListNode prev = null;

        while(copy != null) {
            n++;
            prev = copy;
            copy = copy.next;
        }

        prev.next = head;
        copy = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        while(counter < (n - k % n) - 1)  {
            copy = copy.next;
            counter++;
        }

        head = copy.next;
        copy.next = null;

        return head;
    }
}
