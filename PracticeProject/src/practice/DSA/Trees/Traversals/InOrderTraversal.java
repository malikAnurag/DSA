package practice.DSA.Trees.Traversals;

import practice.DSA.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {


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
		List<Integer> inorderList = inOrderTraversal(root);
		for (int i : inorderList)
			System.out.print(i + " ");
	}

	public static ArrayList<Integer> inOrderTraversal(TreeNode root) {

		if (root == null)
			return null;

		ArrayList<Integer> al = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();

		while (root != null) {
			st.push(root);
			root = root.left;
		}

		while (!st.empty()) {
			TreeNode node = st.pop();
			al.add(node.key);

			if (node.right != null) {
				node = node.right;
				while (node != null) {
					st.push(node);
					node = node.left;
				}
			}
		}
		return al;
	}
}

