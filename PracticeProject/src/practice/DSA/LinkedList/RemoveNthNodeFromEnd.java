package practice.DSA.LinkedList;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 *
 * Follow up: Could you do this in one pass?
 */
public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Original List: ");
        ListNodeUtil.printList(head);
        System.out.println("\nList after removal: ");
        removeNthFromEnd(head, 2);
        ListNodeUtil.printList(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;
        ListNode copy = head;

        while(copy != null) {
            len++;
            copy = copy.next;
        }

        if(len == 1 && n == 1) {
            return null;
        }

        copy = head;

        for(int i = 0; i < len - n - 1; i++) {
            copy = copy.next;
        }

        if(copy != head) {
            copy.next = copy.next.next;
        }
        else {
            if(len == n) {
                head = head.next;
            }
            else {
                head.next = head.next.next;
            }
        }
        return head;
    }
}
