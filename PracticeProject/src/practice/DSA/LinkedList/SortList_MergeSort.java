package practice.DSA.LinkedList;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Example 1:
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 *
 * Example 2:
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 *
 * Example 3:
 * Input: head = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 */
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

public class SortList_MergeSort {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println("Original List : ");
        ListNodeUtil.printList(head);

        System.out.println("\n\nSorted List : ");
        head = sortList(head);
        ListNodeUtil.printList(head);
    }

    /*
      head - head of left half
      temp - end of left half

      slow - head of right half
      fast - end of right half
    */

    static ListNode sortList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp = head, slow = head, fast = head;

        while(fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null; // breaking list into two halves

        ListNode leftHalf = sortList(head);
        ListNode rightHalf = sortList(slow);

        return merge(leftHalf, rightHalf);
    }

    static ListNode merge(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        ListNode newHead = res;

        while(l1 != null && l2 != null) {

            if(l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
            }
            else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }

        if(l1 != null) {
            res.next = l1;
        }

        if(l2 != null) {
            res.next = l2;
        }
        return newHead.next;
    }
}