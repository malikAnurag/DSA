package practice.DSA.Trees;

/**
 * Given a complete binary tree, count the number of nodes.
 */
public class CountTreeNodes {


    /*
    * Input:
    1
   / \
  2   3
 / \  /
4  5 6
    * */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        System.out.println(countNodes(root));

    }

    public static int countNodes(TreeNode root) {
        Node n = new Node(0);
        count(root, n);
        return n.value;
    }

    public static void count(TreeNode root, Node n) {
        if(root == null)
            return ;

        count(root.left, n);
        n.value += 1;
        count(root.right, n);
    }
}

class Node {
    int value;
    Node(int value) {
        this.value = value;
    }
}
