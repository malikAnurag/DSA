package practice.DSA.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * TreeNode -> print all branches from rootNode to the leaf Node.
 * 1,2,4
 * 1,2,5
 * 1,3,6,8
 * 1,3,7,9
 */

public class BranchesOfTree {


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
        List<Integer> al = new ArrayList<>();
        printBranches(root, al);

    }

    public static void printBranches(TreeNode root, List<Integer> al) {

        if(root == null)
            return;

        if(root.left == null && root.right == null){
            for (int i : al) {
                System.out.print(i + ",");
            }
            System.out.println(root.key);
            return;
        }
        
        al.add(root.key);

        if(root.left != null)
            printBranches(root.left, al);

        if(root.right != null) {
            printBranches(root.right, al);
        }
        al.remove(al.size() - 1);
    }
}
