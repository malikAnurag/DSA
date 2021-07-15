package practice.DSA.Trees;

public class TreeHeight {

	public static int height(TreeNode root) {

		if(root == null)
			return 0;
		int lh = height(root.left);
		int rh = height(root.right);

		if(lh > rh)
			return lh + 1;
		else
			return rh + 1;
	}
}
