package practice.DSA.Trees.Traversals;

import practice.DSA.Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalQ {
	


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
        List<Integer> inorderList = printLevelOrder(root);
        for(int i : inorderList)
        		System.out.print(i+" ");
	}

	public static ArrayList<Integer> printLevelOrder(TreeNode root) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			al.add(node.key);

			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
		}
		return al;
	}
}
