package practice.DSA.Trees.Traversals;

import practice.DSA.Trees.TreeNode;

public class BoundaryTraversal {


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

		printBoundaryNodes(root);
	}

	public static void printBoundaryNodes(TreeNode node) {

		if (node == null)
			return;

		System.out.print(node.key + " ");
		printBoundaryLeft(node.left);

		printLeaves(node.left);
		printLeaves(node.right);

		printBoundaryRight(node.right);
	}

	public static void printBoundaryLeft(TreeNode node) {
		if (node == null)
			return;

		if (node.left != null) {
			System.out.print(node.key + " ");
			printBoundaryLeft(node.left);
		}
		else if (node.right != null) {
			System.out.print(node.key + " ");
			printBoundaryLeft(node.right);
		}
	}

	public static void printBoundaryRight(TreeNode node) {
		if (node == null)
			return;

		if (node.right != null) {
			printBoundaryRight(node.right);
			System.out.print(node.key + " ");
		}
		else if (node.left != null) {
			printBoundaryRight(node.left);
			System.out.print(node.key + " ");
		}
	}

	public static void printLeaves(TreeNode node) {
		if (node == null)
			return;

		printLeaves(node.left);

		if (node.left == null && node.right == null)
			System.out.print(node.key + " ");

		printLeaves(node.right);
	}
}
