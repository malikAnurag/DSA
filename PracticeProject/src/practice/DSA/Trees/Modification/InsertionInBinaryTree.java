package practice.DSA.Trees.Modification;

import practice.DSA.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree and a key, insert the key into the binary tree at the first position available in level order
 */
public class InsertionInBinaryTree {

    /*
    * 	 10
       /    \
      11      9
     /       / \
    7       15  8
    *
    *
    * */

    static TreeNode nullRoot = null;
    static TreeNode temp = nullRoot;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(11);
        root.left.left = new TreeNode(7);

        root.right = new TreeNode(9);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(8);

        System.out.println("PreOrder traversal before insertion:: ");
        inOrder(root);

        insert(root, 12);

        System.out.println("\nPreOrder traversal after insertion:: ");
        inOrder(root);

        insert(temp, 4);

        System.out.println("\nPreOrder traversal after insertion in null Root:: ");
        inOrder(nullRoot);
    }


    public static void insert(TreeNode root, int i) {

        if(root == null) {
            nullRoot = new TreeNode(i);
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if(node.left != null) {
                q.add(node.left);
            } else {
                node.left = new TreeNode(i);
                break;
            }

            if(node.right != null) {
                q.add(node.right);
            } else {
                node.right = new TreeNode(i);
                break;
            }
        }
    }


    public static void inOrder(TreeNode root) {
        if(root == null)
            return;

        inOrder(root.left);
        System.out.print(root.key + " ");
        inOrder(root.right);
    }
}
