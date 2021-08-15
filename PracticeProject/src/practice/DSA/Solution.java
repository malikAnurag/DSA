package practice.DSA;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class Solution {

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