package practice.DSA.Trees.Traversals;

import practice.DSA.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    /*
   * 	 1
      /    \
     2      3
    / \    / \
   4   5  6   7
           \   \
            8   9
   *
   *
   * */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        postOrderTraversal(root);
    }

    public static void postOrderTraversal(TreeNode root) {

        if (root == null)
            return;

        List<Integer> al = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);

        while (!st1.isEmpty()) {
            TreeNode node = st1.pop();
            st2.push(node);

            if (node.left != null)
                st1.push(node.left);

            if (node.right != null)
                st1.push(node.right);
        }

        while (!st2.isEmpty()) {
            al.add(st2.pop().key);
        }
        System.out.println(al);
    }
}
