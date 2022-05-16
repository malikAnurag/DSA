package practice.DSA.Trees.Construction;

import practice.DSA.Trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BinaryTreeFromInAndPostOrder {

    static Map<Integer,Integer> hm = new HashMap<>();
    static int i;

    public static void main(String[] args) {

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode tree = getBinaryTree(inorder, postorder);

        System.out.println(tree.toString());
    }

    /*
    * The algorithm stores the indices of inorder traversal values mapped to them. The post order array is traversed from the
    * end towards the beginning. Last element would be the root of the tree in post order array. While traversing, for every element
    * encountered in the post order array, its index is checked in inorder array and all the elements to the left of that index
    * constitute for the left subtree and all the elements to the right correspond to the right subtree.
    * */

    public static TreeNode getBinaryTree(int[] inorder, int[] postorder) {

        for(i = 0 ; i < inorder.length ; i++) {
            hm.put(inorder[i], i);
        }

        return helper(postorder, 0, postorder.length - 1);
    }

    public static TreeNode helper(int[] postorder, int start, int end) {

        if(start > end)
            return null;

        --i;
        TreeNode root = new TreeNode(postorder[i]);

        int index = hm.get(postorder[i]);

        root.right = helper(postorder, index + 1, end);
        root.left = helper(postorder, start, index - 1);

        return root;
    }
}
