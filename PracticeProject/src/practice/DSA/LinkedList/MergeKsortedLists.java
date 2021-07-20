package practice.DSA.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 * Example 2:
 * Input: lists = []
 * Output: []
 *
 * Example 3:
 * Input: lists = [[]]
 * Output: []
 */
public class MergeKsortedLists {

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[3];

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        nodes[0] = node1;
        nodes[1] = node2;
        nodes[2] = node3;

        ListNode result = mergeKLists(nodes);

        System.out.println("Resultant List : ");
        while(result != null) {
            if(result.next  != null)
                System.out.print(result.val + " -> ");
            else
                System.out.print(result.val);

            result = result.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue(new Comparator<ListNode>() {

            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });

        for(ListNode list : lists) {
            if(list != null) {
                pq.add(list);
            }
        }

        ListNode head = new ListNode(0);
        ListNode point = head;

        while(!pq.isEmpty()) {

            point.next = pq.poll();
            point = point.next;

            ListNode next = point.next;

            if(next != null) {
                pq.add(next);
            }
        }
        return head.next;
    }
}
