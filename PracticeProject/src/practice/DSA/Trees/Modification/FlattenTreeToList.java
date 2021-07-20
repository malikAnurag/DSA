package practice.DSA.Trees.Modification;

import practice.DSA.Trees.TreeNode;

import java.util.Stack;

public class FlattenTreeToList {
	
	/*
	 * 	  1
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
        TreeNode head = flatten(root);
        System.out.print(head.key + " ");
        System.out.print(head.right.key + " ");
        System.out.print(head.right.right.key + " ");
        System.out.print(head.right.right.right.key + " ");
        System.out.print(head.right.right.right.right.key + " ");
        System.out.print(head.right.right.right.right.right.key + " ");
        System.out.print(head.right.right.right.right.right.right.key + " ");
        System.out.print(head.right.right.right.right.right.right.right.key + " ");
        System.out.print(head.right.right.right.right.right.right.right.right.key + " ");
	}
	
	public static TreeNode flatten(TreeNode root) {

		TreeNode head = root;
		Stack<TreeNode> st = new Stack<>();

		while (root != null || !st.empty()) {

			if (root.right != null) {
				st.push(root.right);
			}
			root.right = root.left;
			root.left = null;

			if (root.right == null && !st.empty()) {
				root.right = st.pop();
			}
			root = root.right;
		}
		return head;
	}
}
