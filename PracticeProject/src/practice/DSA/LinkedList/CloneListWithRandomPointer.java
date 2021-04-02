package practice.DSA.LinkedList;

/**
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of
 * its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers
 * in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 */
public class CloneListWithRandomPointer {

    public static void main(String[] args) {

    }


    public ListNode copyRandomList(ListNode head) {

        if (head == null) return null;

        ListNode temp1 = head;

        while (temp1 != null) {
            ListNode node = new ListNode(temp1.val);
            node.next = temp1.next;
            temp1.next = node;

            temp1 = node.next;
        }

        temp1 = head;

        while (temp1 != null && temp1.next != null) {
            temp1.next.random = temp1.random != null ? temp1.random.next : null;
            temp1 = temp1.next.next;
        }

        temp1 = head;
        ListNode res = head.next;
        ListNode ans = res;
        while (temp1 != null) {
            temp1.next = temp1.next != null ? temp1.next.next : null;
            temp1 = temp1.next;

            res.next = res.next != null ? res.next.next : null;
            res = res.next;
        }

        return ans;
    }

}
