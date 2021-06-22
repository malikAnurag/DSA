package practice.DSA.Trees.Construction;

import practice.DSA.Trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.
 *
 * Example 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 *  Example 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
public class ConstructBinaryTreeFromPreAndInOrder {

    static int preOrderIndex;
    static Map<Integer, Integer> hm;

    public static void main(String[] args) {

        preOrderIndex = 0;
        hm = new HashMap<>();

        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        for(int i = 0 ; i < inorder.length ; i++) {
            hm.put(inorder[i], i);
        }
        System.out.println(buildTree(preorder, 0, inorder.length -1));
    }

    public static TreeNode buildTree(int[] preorder, int start, int end) {

        if(start > end) {
            return null;
        }

        int rootVal = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(preorder, start, hm.get(rootVal) - 1);
        root.right = buildTree(preorder, hm.get(rootVal) + 1, end);
        return root;
    }
}
