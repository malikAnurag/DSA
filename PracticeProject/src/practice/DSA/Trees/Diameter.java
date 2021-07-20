package practice.DSA.Trees;


public class Diameter {

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
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        int dia = diameter(root);
        System.out.println("Diameter of tree is : " + dia);
        System.out.println("Height of tree : " + TreeHeight.height(root));
    }

    public static int diameter(TreeNode root) {

        if (root == null)
            return 0;

        int lh = TreeHeight.height(root.left);
        int rh = TreeHeight.height(root.right);

        int diameterL = diameter(root.left);
        int diameterR = diameter(root.right);

        return Math.max(lh + rh + 1, Math.max(diameterL, diameterR));
    }
}
