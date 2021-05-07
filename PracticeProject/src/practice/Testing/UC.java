package practice.Testing;

import java.util.HashMap;
import java.util.Map;

/**
 * DLL
 * 1->2->3->4->5->null
 * 3    1   2   4   null
 *
 * You are given the head of this list. Clone this list and return the new head.
 */

public class UC {

    public static DLL copyDLL (DLL head) {

        Map<Integer, Integer> keysToRandomValuesMap = new HashMap<>(); // maps keys to their random key values 1 -> 3, 2->1 , 3->2...
        Map<Integer, DLL> valuesToNodeMap = new HashMap<>(); // maps keys to their actual Nodes (new ones)

        DLL temp = head;

        while(temp != null) {
            if(!keysToRandomValuesMap.containsKey(temp.key)) {
                keysToRandomValuesMap.put(temp.key, temp.random.key);
            }
            temp = temp.next;
        }

        DLL newHead = new DLL(head.key);
        valuesToNodeMap.put(head.key, newHead);

        DLL node1 = newHead;
        DLL node2 = node1;

        while(head != null) { // construction of new list WITHOUT random pointers
            head = head.next;
            newHead.next = new DLL(head.key);
            valuesToNodeMap.put(head.key, newHead);
            newHead = newHead.next;
        }

        while(node1 != null) { // setting the random pointers to the nodes of new list
            DLL dll = valuesToNodeMap.get(keysToRandomValuesMap.get(node1.key));
            node1.random = dll;
            node1 = node1.next;
        }

        return node2;
    }


}


class DLL {

    DLL next;
    DLL random;
    int key;

    public DLL(int key) {
        this.key = key;
    }
}
