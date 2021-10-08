package practice.DSA.LinkedList;
/**
 * Given the head of a linked list and two integers m and n. Traverse the linked list and remove some nodes in the following way:
 *
 * Start with the head as the current node.
 * Keep the first m nodes starting with the current node.
 * Remove the next n nodes
 * Keep repeating steps 2 and 3 until you reach the end of the list.
 * Return the head of the modified list after removing the mentioned nodes.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5,6,7,8,9,10,11,12,13], m = 2, n = 3
 * Output: [1,2,6,7,11,12]
 * Explanation: Keep the first (m = 2) nodes starting from the head of the linked List  (1 ->2) show in black nodes.
 * Delete the next (n = 3) nodes (3 -> 4 -> 5) show in read nodes.
 * Continue with the same procedure until reaching the tail of the Linked List.
 * Head of linked list after removing nodes is returned.
 *
 * Example 2:
 * Input: head = [1,2,3,4,5,6,7,8,9,10,11], m = 1, n = 3
 * Output: [1,5,9]
 * Explanation: Head of linked list after removing nodes is returned.
 *
 * Example 3:
 * Input: head = [1,2,3,4,5,6,7,8,9,10,11], m = 3, n = 1
 * Output: [1,2,3,5,6,7,9,10,11]
 *
 * Example 4:
 * Input: head = [9,3,7,7,9,10,8,2], m = 1, n = 2
 * Output: [9,7,8]
 *
 * Follow up question: How can you solve this problem by modifying the list in-place?
 */
public class DeleteNnodesAfterMnodes {

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(3);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next = new ListNode(2);

        System.out.println("Original List :");
        ListNodeUtil.printList(head);
        head = deleteNodes(head, 1, 2);
        System.out.println("\nFinal List:");
        ListNodeUtil.printList(head);
    }

    public static ListNode deleteNodes(ListNode head, int m, int n) {

        if(head == null)
            return null;

        ListNode copy = head;
        int i;

        while(copy != null) {

            i = 1;

            while(i < m && copy != null) {
                copy = copy.next;
                i++;
            }

            ListNode prev = copy;
            int j = 0;

            while(j < n && copy != null) {
                copy = copy.next;
                j++;
            }

            if(prev != null) {
                prev.next = copy != null ? copy.next : null;
                copy = prev.next;
            }
        }
        return head;
    }
}