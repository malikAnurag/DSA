package practice.DSA.LinkedList;

/**
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * // TODO : check partitionList.png
 * Example 1:
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 *
 *  Example 2:
 *
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 */
public class PartitionList {

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        root.next = new ListNode(4);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(2);

        ListNode copy = root;
        System.out.println("Before partitioning the list:: ");
        while(copy != null) {
            if(copy.next != null) {
                System.out.print(copy.val + " -> ");
            } else {
                System.out.print(copy.val);
            }
            copy = copy.next;
        }

        ListNode newNode = partition(root, 3);

        System.out.println("\n\nAfter partitioning the list:: ");
        while(newNode != null) {
            if(newNode.next != null) {
                System.out.print(newNode.val + " -> ");
            } else {
                System.out.print(newNode.val);
            }
            newNode = newNode.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {

        if(head == null) {
            return null;
        } else if(head.next == null) {
            return head;
        }

        ListNode copyHead = head, small = null, res1 = null, big = null, res2 = null;

        while(head != null) {

            if(head.val < x) {
                if(small == null) {
                    small = new ListNode(head.val);
                    res1 = small;
                } else {
                    small.next = new ListNode(head.val);
                    small = small.next;
                }
            } else {
                if(big == null) {
                    big = new ListNode(head.val);
                    res2 = big;
                } else {
                    big.next = new ListNode(head.val);
                    big = big.next;
                }
            }
            head = head.next;
        }

        if(small != null) {
            small.next = res2;
            return res1;
        } else
            return copyHead;
    }
}
