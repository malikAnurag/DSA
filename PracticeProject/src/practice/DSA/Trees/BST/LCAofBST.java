package practice.DSA.Trees.BST;

import practice.DSA.Trees.TreeNode;

public class LCAofBST {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        int n1 = 10, n2 = 14;
        TreeNode t = findLCA(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);

        n1 = 14;
        n2 = 8;
        t = findLCA(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);

        n1 = 10;
        n2 = 22;
        t = findLCA(root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);
    }


    public static TreeNode findLCA(TreeNode root, int n1, int n2) {

        if(root == null)
            return null;

        if(n1 < root.key && n2 < root.key)
            return findLCA(root.left, n1, n2);

        if(n1 > root.key && n2 > root.key)
            return findLCA(root.right, n1, n2);

        return root;
    }
}
