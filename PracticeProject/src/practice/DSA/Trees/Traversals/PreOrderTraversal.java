package practice.DSA.Trees.Traversals;

import practice.DSA.Trees.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
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
        List<Integer> preOrderList = getPreOrder(root);
        for(int i : preOrderList)
        		System.out.print(i+" ");
	}
	
	public static ArrayList<Integer> getPreOrder(TreeNode root) {

		Stack<TreeNode> st = new Stack<>();
		ArrayList<Integer> al = new ArrayList<>();

		st.push(root);

		while (!st.empty()) {

			TreeNode node = st.pop();
			al.add(node.key);

			if (node.right != null)
				st.push(node.right);

			if (node.left != null)
				st.push(node.left);
		}
		return al;
	}
}
