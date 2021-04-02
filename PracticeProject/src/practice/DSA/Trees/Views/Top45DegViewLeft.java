package practice.DSA.Trees.Views;

import practice.DSA.Trees.TreeNode;

import java.util.TreeMap;

public class Top45DegViewLeft {

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
	static TreeMap<Integer, Integer> hm = new TreeMap<>();

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
		printSideView(root);

		for (int i : hm.keySet()) {
			System.out.print(hm.get(i) + " ");
		}
	}

	public static void printSideView(TreeNode root) {

		int dist = 0;

		populateMap(root, hm, dist);
	}

	public static void populateMap(TreeNode root, TreeMap<Integer, Integer> hm, int dist) {

		if (root == null)
			return;

		if (!hm.containsKey(dist)) {
			hm.put(dist, root.key);
		}

		populateMap(root.left, hm, dist + 1);
		populateMap(root.right, hm, dist);
	}

}
