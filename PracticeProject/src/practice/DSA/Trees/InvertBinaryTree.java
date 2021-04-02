package practice.DSA.Trees;


public class InvertBinaryTree {

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

            invert(root);

            System.out.println(root);
        }

        public static void invert(TreeNode root) {

            if(root == null)
                return;

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invert(root.left);
            invert(root.right);
        }
}
