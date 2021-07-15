package practice.DSA.Trees;

public class TreeNode {

	public int key;
	public int hd;
	public int count;
	public TreeNode left;
	public TreeNode right;
	public TreeNode next;

	public TreeNode(int key) {
		this.key = key;
		left = right = next = null;
	}

	public TreeNode(int key, int count) {
		this.key = key;
		this.count = count;
		left = right = next = null;
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
