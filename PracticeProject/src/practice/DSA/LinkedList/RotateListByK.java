package practice.DSA.LinkedList;

/**
 * Input : a -> b -> c -> d , 2
 * Output : c -> d -> a -> b
 */

public class RotateListByK {

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);

        ListNode t = head;
        System.out.println("Original List :");
        while(t != null) {
            System.out.print(t.val + " -> ");
            t = t.next;
        }
        System.out.println("\nNew List: ");
        ListNode newHead = rotateList(head, 2);

        while(newHead != null) {
            System.out.print(newHead.val + " -> ");
            newHead = newHead.next;
        }

    }

    public static ListNode rotateList(ListNode head, int k) {

        ListNode temp = head;
        ListNode prev = null;
        int count = 0;

        while (temp != null) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = head;
        temp = head;

        while (count < k) {
            prev = temp;
            temp = temp.next;
            count++;
        }
        prev.next = null;
        head = temp;

        return head;
    }


}
