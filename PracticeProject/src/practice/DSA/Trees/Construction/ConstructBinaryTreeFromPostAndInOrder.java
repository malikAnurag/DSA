package practice.DSA.Trees.Construction;

import practice.DSA.Trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal
 * of the same tree, construct and return the binary tree.
 *
 * Example 1:
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 *
 *  Example 2:
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 * Constraints:
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 */
public class ConstructBinaryTreeFromPostAndInOrder {

    static Map<Integer,Integer> map = new HashMap();
    static int postOrderIndex;

    public static void main(String[] args) {

        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};

        System.out.println(buildTree(inorder, postorder));
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        postOrderIndex = postorder.length - 1;

        for(int i = 0 ; i < inorder.length ; i++) {
            map.put(inorder[i], i);
        }
        return construct(postorder, 0 , postorder.length-1);
    }

    static TreeNode construct(int[] postorder, int start, int end) {

        if(start > end)
            return null;

        int val = postorder[postOrderIndex--];

        TreeNode root = new TreeNode(val);
        root.right = construct(postorder, map.get(val) + 1, end);
        root.left = construct(postorder, start, map.get(val) - 1);
        return root;
    }
}
