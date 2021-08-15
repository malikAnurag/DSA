package practice.DSA.Trees.BST;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
 * You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list.
 * For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
 * We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor,
 * and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.
 *
 * Example 1:
 * Input: root = [4,2,5,1,3]
 * Output: [1,2,3,4,5]
 * Explanation: The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.
 *
 * Example 2:
 * Input: root = [2,1,3]
 * Output: [1,2,3]
 *
 * Example 3:
 * Input: root = []
 * Output: []
 * Explanation: Input is an empty tree. Output is also an empty Linked List.
 *
 * Example 4:
 * Input: root = [1]
 * Output: [1]
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 * All the values of the tree are unique.
 */

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int _val) {
        val = _val;
    }
}

public class BST_SortedDLinkedList {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);

        Node result = treeToDoublyList(root);

        while(result != null) {
            System.out.print(result.val);
            result = result.right;
        }
    }

    public static Node treeToDoublyList(Node root) {

        if(root == null)
            return null;

        List<Node> al = new ArrayList();
        inorder(root, al);
        Node prev = null, head = null;

        for(int i = 0 ; i < al.size() ; i++) {

            Node node = al.get(i);

            if(i == 0) {
                head = node;
            }

            node.left = prev;

            if(i != al.size() - 1) {
                node.right = al.get(i + 1);
            }
            else {
                node.right = head;
            }
            prev = node;
        }
        head.left = al.get(al.size()-1);
        return head;
    }

    static void inorder(Node root, List<Node> al) {

        if(root == null)
            return;

        inorder(root.left, al);
        al.add(root);
        inorder(root.right, al);
    }
}