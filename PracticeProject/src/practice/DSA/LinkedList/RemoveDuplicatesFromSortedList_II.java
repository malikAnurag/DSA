package practice.DSA.LinkedList;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * Return the linked list sorted as well.
 *
 * Example 1:
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 *
 * Example 2:
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */

/* COMPLETE REMOVAL OF DUPLICATES FROM THE LIST */

public class RemoveDuplicatesFromSortedList_II {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        System.out.println("Original List: ");
        ListNodeUtil.printList(head);

        System.out.println("\n\nNew List: ");
        ListNodeUtil.printList(removeDuplicates(head));
    }

    static ListNode removeDuplicates(ListNode head) {

        ListNode prev = null, curr = head;

        while(curr != null && curr.next != null) {

            if(curr.val != curr.next.val) {
                prev = curr;
            }
            else {
                while(curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }

                if(prev != null) {
                    prev.next = curr.next;
                }
                else {
                    head = curr.next;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}
