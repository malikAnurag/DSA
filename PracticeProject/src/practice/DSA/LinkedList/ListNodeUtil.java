package practice.DSA.LinkedList;

public class ListNodeUtil {

    public static void printList(ListNode head) {
        ListNode dummy = head;

        while(dummy != null) {
            if(dummy.next != null)
                System.out.print(dummy.val + " -> ");
            else
                System.out.print(dummy.val);

            dummy = dummy.next;
        }
    }
}
