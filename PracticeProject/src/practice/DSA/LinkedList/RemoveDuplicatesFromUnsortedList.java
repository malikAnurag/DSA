package practice.DSA.LinkedList;

import practice.Testing.HashCodeTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the head of a linked list, find all the values that appear more than once in the list and delete the nodes that have any of those values.
 * Return the linked list after the deletions.
 *
 * Example 1:
 * Input: head = [1,2,3,2]
 * Output: [1,3]
 * Explanation: 2 appears twice in the linked list, so all 2's should be deleted. After deleting all 2's, we are left with [1,3].
 *
 * Example 2:
 * Input: head = [2,1,1,2]
 * Output: []
 * Explanation: 2 and 1 both appear twice. All the elements should be deleted.
 *
 * Example 3:
 * Input: head = [3,2,2,1,3,2,4]
 * Output: [1,4]
 * Explanation: 3 appears twice and 2 appears three times. After deleting all 3's and 2's, we are left with [1,4].
 *
 *
 * Constraints:
 * The number of nodes in the list is in the range [1, 105]
 * 1 <= Node.val <= 105
 */
public class RemoveDuplicatesFromUnsortedList {

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(2);
//
//        removeDuplicates(head);
//        ListNodeUtil.printList(head);
//        System.out.println();

        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);
        head1.next.next.next.next = new ListNode(3);
        head1.next.next.next.next.next = new ListNode(2);
        head1.next.next.next.next.next.next = new ListNode(4);

        System.out.println("Before deleting : ");
        ListNodeUtil.printList(head1);

        removeDuplicates(head1);

        System.out.println("\n After deleting:");
        ListNodeUtil.printList(head1);

    }
// 3 2 2 1 3 2 4
    static ListNode removeDuplicates(ListNode head) {

        if(head == null)
            return null;

        Map<Integer, Integer> hm = new HashMap();

        for(ListNode node = head ; node != null ; node = node.next) {
            hm.putIfAbsent(node.val, 0);
            hm.put(node.val, hm.get(node.val) + 1);
        }

        ListNode curr = head, prev = null;
//        System.out.println(hm);

        while(curr != null) {

            if(hm.get(curr.val) > 1) {

                if(prev != null) {
                    prev.next = curr.next;
                }
                else {
                    head = curr.next;
                }
            }
            else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
