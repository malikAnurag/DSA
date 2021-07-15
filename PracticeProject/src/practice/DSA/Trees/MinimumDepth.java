package practice.DSA.Trees;

public class MinimumDepth {
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
        
        System.out.println("Minimum depth: "+computeDepth(root));
        System.out.println("Height: "+TreeHeight.height(root));
	}

	public static int computeDepth(TreeNode root) {
		return depth(root, 0);
	}

	public static int depth(TreeNode root, int level) {

		if(root == null)
			return level;

		level++;

		return Math.min(depth(root.left, level), depth(root.right, level));
	}
}
