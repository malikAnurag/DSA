package practice.DSA.Trees;

import java.util.Stack;

/**
 * Convert preorder traversal to a BST.
 */
public class PreOrderTraversalToBST {

    public static void main(String[] args) {
        int[] preorder = {10, 5, 1, 7, 40, 50};
        System.out.println(getNode(preorder));
    }


    public static TreeNode getNode(int[] preorder) {

        if(preorder == null)
            return null;
        else if(preorder.length == 1)
            return new TreeNode(preorder[0]);

        Stack<TreeNode> st = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);

        st.push(root);

        for(int i = 1; i < preorder.length ; i++) {

            TreeNode temp = null;

            while(!st.empty() && preorder[i] > st.peek().key)
                temp = st.pop();

            if(temp != null) {
                temp.right = new TreeNode(preorder[i]);
                st.push(temp.right);
            }
            else {
                temp = st.peek();
                temp.left = new TreeNode(preorder[i]);
                st.push(temp.left);
            }
        }
        return root;
    }
}