package amazon.linkedList;

import practice.DSA.LinkedList.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes
 * is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * Follow up:
 *
 * Could you solve the problem in O(1) extra memory space?
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesInKGroups {

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        ListNode temp = root;

        System.out.print("Original List :: ");
        while (temp != null) {
            if (temp.next != null)
                System.out.print(temp.val + "->");
            else
                System.out.print(temp.val);
            temp = temp.next;
        }

        ListNode reversed = reverseLinkedList(root, 3);

        System.out.print("\n\nReversed List :: ");

        while (reversed != null) {
            if (reversed.next != null)
                System.out.print(reversed.val + "->");
            else
                System.out.print(reversed.val);

            reversed = reversed.next;
        }
    }


    public static ListNode reverseLinkedList(ListNode head, int k) {

        ListNode ptr = head;
        ListNode newHead = null;
        ListNode ktail = null;

        while (ptr != null) {

            int count = 0;
            ptr = head;

            while (count < k && ptr != null) {
                ptr = ptr.next;
                count++;
            }

            if (count == k) {
                ListNode revHead = reverseList(head, k);

                if (newHead == null) {
                    newHead = revHead;
                }

                if (ktail != null) {
                    ktail.next = revHead;
                }

                ktail = head;
                head = ptr;
            }
        }

        if (ktail != null) {
            ktail.next = head;
        }
        return newHead == null ? head : newHead;
    }

    public static ListNode reverseList(ListNode head, int k) {

        ListNode curr = head;
        ListNode newHead = null;

        int count = 0;

        while (count < k) {
            ListNode temp = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = temp;
            count++;
        }
        return newHead;
    }
}
