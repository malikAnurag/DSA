package practice.DSA.LinkedList;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Given linked list -- head = [4,5,1,9], which looks like following:
 *
 * 4 -> 5 -> 1 -> 9
 */
public class DeleteNode {

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        deleteNode(head);

        while(head != null) {

            if(head.next != null)
                System.out.print(head.val + " -> ");
            else
                System.out.print(head.val);

            head = head.next;
        }

    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
