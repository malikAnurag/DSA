package practice.DSA.Trees.Traversals;

import practice.DSA.Trees.TreeNode;

import java.util.ArrayList;
import java.util.TreeMap;

public class DiagonalTraversal {

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
        printDiagonal(root);

    }

    public static void printDiagonal(TreeNode root) {

        TreeMap<Integer, ArrayList<Integer>> hm = new TreeMap<>();

        int dist = 0;

        print(root, dist, hm);

        for(int k : hm.keySet()) {
            System.out.println(hm.get(k));
        }
    }

    public static void print(TreeNode node, int dist, TreeMap<Integer, ArrayList<Integer>> hm) {

        if(node == null)
            return;

        ArrayList<Integer> al = hm.get(dist);

        if(al == null) {
            al = new ArrayList<>();
        }
        al.add(node.key);

        hm.put(dist, al);
        print(node.left, dist + 1, hm);
        print(node.right, dist, hm);
    }
}