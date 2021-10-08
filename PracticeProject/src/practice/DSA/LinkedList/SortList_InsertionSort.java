package practice.DSA.LinkedList;

/**
 * Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
 * The steps of the insertion sort algorithm:
 *
 * Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
 * It repeats until no input elements remain.
 * The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list.
 * One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.
 *
 * Example 1:
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 *
 * Example 2:
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 *
 * Constraints:
 * The number of nodes in the list is in the range [1, 5000].
 * -5000 <= Node.val <= 5000
 */
public class SortList_InsertionSort {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println("Original List : ");
        ListNodeUtil.printList(head);

        System.out.println("\n\nSorted List : ");
        head = insertionSort(head);
        ListNodeUtil.printList(head);
    }

    static ListNode insertionSort(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode();
        ListNode prev = dummy, next, curr = head;

        while(curr != null) {

            next = curr.next;

            // move prev until the next node is greater than curr
            // and then insert the node between prev and next in the sorted list
            while(prev.next != null && prev.next.val < curr.val)
                prev = prev.next;

            curr.next = prev.next;
            prev.next = curr;

            prev = dummy;
            curr = next;
        }
        return dummy.next;
    }
}
