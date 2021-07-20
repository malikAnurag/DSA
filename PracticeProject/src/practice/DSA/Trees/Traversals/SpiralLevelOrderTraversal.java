package practice.DSA.Trees.Traversals;

import practice.DSA.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SpiralLevelOrderTraversal {

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
        List<Integer> inorderList = spiralLevelOrder(root);
        for(int i : inorderList)
        		System.out.print(i+" ");
	}
	
	public static ArrayList<Integer> spiralLevelOrder(TreeNode root) {

		boolean flag = false;
		ArrayList<Integer> result = new ArrayList<Integer>();

		int h = height(root);

		for (int i = 1; i <= h; i++) {
			print(root, i, result, flag);
			flag = !flag;
		}
		return result;
	}

	public static void print(TreeNode node, int level, ArrayList<Integer> al, boolean flag) {

		if (node == null)
			return;

		if (level == 1)
			al.add(node.key);

		else if (level > 1) {
			if (flag) {
				print(node.right, level - 1, al, true);
				print(node.left, level - 1, al, true);
			} else {
				print(node.left, level - 1, al, false);
				print(node.right, level - 1, al, false);
			}
		}
	}

	public static int height(TreeNode root) {
		if (root == null)
			return 0;

		int lh = height(root.left);
		int rh = height(root.right);

		if (lh > rh)
			return lh + 1;
		else
			return rh + 1;
	}
}
