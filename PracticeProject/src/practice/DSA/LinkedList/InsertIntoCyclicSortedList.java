package practice.DSA.LinkedList;
/**
 * Given a Circular Linked List node, which is sorted in ascending order, write a function to insert a value insertVal into the list such that it
 * remains a sorted circular list. The given node can be a reference to any single node in the list and may not necessarily be the smallest value in the circular list.
 *
 * If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the circular list should remain sorted.
 *
 * If the list is empty (i.e., the given node is null), you should create a new single circular list and return the reference to that single node.
 * Otherwise, you should return the originally given node.
 *
 * Example 1:
 * Input: head = [3,4,1], insertVal = 2
 * Output: [3,4,1,2]
 * Explanation: In the figure above, there is a sorted circular list of three elements. You are given a reference to the node with value 3, and we need to insert 2
 * into the list. The new node should be inserted between node 1 and node 3. After the insertion, the list should look like this, and we should still return node 3.
 *
 * Example 2:
 * Input: head = [], insertVal = 1
 * Output: [1]
 * Explanation: The list is empty (given head is null). We create a new single circular list and return the reference to that single node.
 *
 * Example 3:
 * Input: head = [1], insertVal = 0
 * Output: [1,0]
 *
 * Constraints:
 * 0 <= Number of Nodes <= 5 * 104
 * -106 <= Node.val, insertVal <= 106
 */
public class InsertIntoCyclicSortedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(1);
        head.next.next.next = head;

        getUpdatedList(head, 2);
        ListNodeUtil.printList(head); // endless loop as it is a circular list
    }

    static ListNode getUpdatedList(ListNode head, int insertVal) {

        if(head == null)
            return null;

        ListNode copy = head;
        ListNode newNode = new ListNode(insertVal);

        /* 3 cases
            case 1: insertVal is between 2 nodes
            e.g. 1->2->4, insert 3
            condition: insertVal >= n.val && insertVal <= n.next.val

            case 2: insertVal is >= largest node value or <= smalles node value
            e.g. 1->2->4, insert 0 or 1->2->4, insert 5
            condition: n.next.val < n.val && (insertVal >= n.val || insertVal <= n.next.val)

            case 3: all the nodes in the tree have same value
            e.g. 1->1->1, insert 2
            condition: n.next == head
        */

        while(true) {

            if( (insertVal >= head.val && insertVal <= head.next.val) ||
                (head.val >= head.next.val && (insertVal >= head.val || insertVal <= head.next.val)) ||
                 copy.next == head) {

                newNode.next = copy.next;
                copy.next = newNode;
                break;
            }
            copy = copy.next;
        }
        return head;
    }
}
