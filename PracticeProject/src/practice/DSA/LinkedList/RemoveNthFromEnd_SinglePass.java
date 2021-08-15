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
public class RemoveNthFromEnd_SinglePass {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Original List: ");
        ListNodeUtil.printList(head);
        System.out.println("\nList after removal: ");
        removeNthFromEndSinglePass(head, 2);
        ListNodeUtil.printList(head);
    }

    /* The idea is to maintain two pointers at a distance of n */
    static ListNode removeNthFromEndSinglePass(ListNode head, int n) {

        ListNode ptr1 = head, ptr2 = head, prev = null;
        int counter = 0;
        boolean flag = false;

        while(ptr2 != null) {

            if(counter == n) {
                flag = true;
            }

            ptr2 = ptr2.next;
            counter++;

            if(flag) {
                prev = ptr1;
                ptr1 = ptr1.next;
            }
        }

        if(prev != null) {
            prev.next = prev.next.next;
        }
        else {
            head = head.next;
        }
        return head;
    }
}