package practice.DSA.Trees;

public class LCAofBinaryTree {

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
        
        int n1 = 5, n2 = 7; 
        TreeNode t = LCA(root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key); 
   
        n1 = 6; 
        n2 = 9; 
        t = LCA(root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key); 
   
        n1 = 3; 
        n2 = 8; 
        t = LCA(root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key); 
	}
	
	public static TreeNode LCA(TreeNode root, int n1, int n2) {
		
		if(root==null)
			return null;
		
		if(root.key==n1 || root.key==n2)
			return root;
		
		TreeNode tempL = LCA(root.left,n1,n2);
		TreeNode tempR = LCA(root.right,n1,n2);
		
		if(tempL!=null && tempR!=null)
			return root;
		
		return tempL!=null ? tempL : tempR;
		
	}
	
	
}
