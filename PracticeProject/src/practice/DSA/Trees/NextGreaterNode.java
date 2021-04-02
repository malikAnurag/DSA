package practice.DSA.Trees;

public class NextGreaterNode {
	
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
        
        TreeNode result = nextGreater(root,4);
        System.out.println(result.key);
	}
	
	public static TreeNode nextGreater(TreeNode root,int n) {
		
		TreeNode current = Find(root,n);
        
        if(current.right!=null){
            current = current.right;
            while(current.left!=null)
                current = current.left;
            return current;    
        }else{
            TreeNode successor = null;
            TreeNode ancestor = root;
            
            while(ancestor!=current){
                if(ancestor.key>current.key){
                    successor = ancestor;
                    ancestor = ancestor.left;
                }
                else{
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }
        
    }
    
    
    public static TreeNode Find(TreeNode root,int data){
        TreeNode current = null ;
        
        while(root!=null){
            if(root.key == data){
                current = root;
                break;
            }
            else if(data < root.key){
                root = root.left;
            }    
            else
                root = root.right;
        }
        return current;
    }
}