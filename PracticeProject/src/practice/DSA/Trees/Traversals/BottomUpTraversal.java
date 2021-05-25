package practice.DSA.Trees.Traversals;

import practice.DSA.Trees.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BottomUpTraversal {
    /*
	 * 	  1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9
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
        Stack<TreeNode> stack = printBottomUp(root);

        while(!stack.isEmpty()) {
            System.out.print(stack.pop().key + " ");
        }
    }

    private static Stack<TreeNode> printBottomUp(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();

        q.add(root);

        while(!q.isEmpty()) {

            TreeNode node = q.poll();

            if(node.right != null)
                q.add(node.right);

            if(node.left != null)
                q.add(node.left);

            st.push(node);
        }
        return st;
    }
}