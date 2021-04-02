package practice.DSA.Trees;

public class TreeNode {

	public int key;
	public int hd;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int key) {
		this.key = key;
		left = right = null;
	}

	@Override
	public String toString() {
		return "TreeNode{" +
				"key=" + key +
				", left=" + left +
				", right=" + right +
				'}';
	}
}
