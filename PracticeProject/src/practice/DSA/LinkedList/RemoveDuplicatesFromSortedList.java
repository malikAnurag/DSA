package practice.DSA.LinkedList;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 *
 * Example 1:
 * Input: head = [1,1,2]
 * Output: [1,2]
 *
 * Example 2:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicatesFromSortedList {

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

        if(head == null)
            return null;

        ListNode curr = head, prev = null;

        while(curr != null && curr.next != null) {

            if(curr.val != curr.next.val) {
                prev = curr;
            }
            else {
                while(curr.next != null && curr.val == curr.next.val)
                    curr = curr.next;

                if(prev != null) {
                    prev.next = curr;
                    prev = prev.next;
                }
                else {
                    head = curr;
                    prev = curr; // for the case of 1->1->3->3->3
                }
            }
            curr = curr.next;
        }
        return head;
    }
}