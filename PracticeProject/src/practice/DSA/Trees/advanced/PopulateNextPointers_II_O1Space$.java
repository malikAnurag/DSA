package practice.DSA.Trees.advanced;

import practice.DSA.Trees.TreeNode;

public class PopulateNextPointers_II_O1Space$ {

    public TreeNode connect(TreeNode root) {

        if(root == null)
            return null;

        TreeNode leftMost = root;

        while(leftMost.left != null) {

            TreeNode head = leftMost;

            while(head != null) {

                head.left.next = head.right;

                if(head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
