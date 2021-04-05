package practice.DSA.Trees;

/**Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 Example 1:


 Input: root = [1,2,2,3,4,4,3]
 Output: true
 Example 2:


 Input: root = [1,2,2,null,3,null,3]
 Output: false
 **/


public class Symmetric {

      /*
	 * 	  1
        /    \
       2      2
      / \    / \
     4   5  5   4

	  	  1
        /    \
       2      2
      / \    / \
     4   5  5   6
	 *
	 *
	 * */


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(isSymmetric(root, root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(isSymmetric(root, root));

    }

    public static boolean isSymmetric(TreeNode t1, TreeNode t2) {

        if(t1 == null && t2 == null)
            return true;

        if(t1 == null || t2 == null)
            return false;

        return t1.key == t2.key && isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }
}
