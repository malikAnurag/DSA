package practice.DSA.LinkedList.Reversals;

import practice.DSA.LinkedList.ListNode;
import practice.DSA.LinkedList.ListNodeUtil;

/**
 * Rotate the given list by k i.e put first k nodes to the end of the resultant list.
 *
 * Input : a -> b -> c -> d , 2
 * Output : c -> d -> a -> b
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

        ListNode temp = head;
        ListNode prev = null;
        int count = 0;

        while (temp != null) {
            prev = temp;
            temp = temp.next;
        }
        // prev here is the last node of the list
        // Attaching last node of the list to the head and forming a cycle

        prev.next = head;
        temp = head;

        while (count < k) {
            prev = temp;
            temp = temp.next;
            count++;
        }
        prev.next = null;
        head = temp;

        return head;
    }
}
