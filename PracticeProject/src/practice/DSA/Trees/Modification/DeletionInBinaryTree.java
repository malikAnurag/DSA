package practice.DSA.Trees.Modification;

import practice.DSA.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, delete a node from it by making sure that tree shrinks from the bottom (i.e. the deleted node is replaced by bottom most and rightmost node).
 *
 * This is different from BST deletion. Here we do not have any order among elements, so we replace with last element.
 */
public class DeletionInBinaryTree {

    /*
    * 	 10
       /    \
      11      9
     /  \    / \
    7    13 15  8
    *
    *
    * */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(11);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(13);

        root.right = new TreeNode(9);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(8);

        System.out.println("Inorder traversal before deletion ::");
        inOrder(root);

        delete(root, 11);

        System.out.println("\nInorder traversal after deletion ::");
        inOrder(root);

    }

    public static void delete(TreeNode root, int key) {

        if(root == null)
            return;

        if(root.left == null && root.right == null) {
            if(root.key == key) {
                root = null;
            }
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode node = null, keyNode = null;

        while(!q.isEmpty()) {

            node = q.poll();

            if(node.key == key) {
                keyNode = node;
            }

            if(node.left != null) {
                q.add(node.left);
            }

            if(node.right != null) {
                q.add(node.right);
            }
        }

        if(keyNode != null) {
            int x = node.key;
            deleteDeepest(root, node);
            keyNode.key = x;
        }
    }

    public static void deleteDeepest(TreeNode root, TreeNode delNode) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode node;

        while(!q.isEmpty()) {

            node = q.poll();

            if (node == delNode) {
                node = null;
                return;
            }

            if(node.right != null) {
                if(node.right == delNode) {
                    node.right = null;
                    return;
                }
                else {
                    q.add(node.right);
                }
            }

            if(node.left != null) {
                if(node.left == delNode) {
                    node.left = null;
                    return;
                }
                else {
                    q.add(node.left);
                }
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
