package practice.DSA.Trees.BST;

import practice.DSA.Trees.TreeNode;
/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Follow up: Can you solve it with time complexity O(height of tree)?
 */
// h - height of tree, N - total number of nodes in the tree

// Time Complexity : O(h) in the worst case.
// And according to the depth of recursion, the Space Complexity is also O(h) in the worst case.

// OR The Time Complexity and Space Complexity is O(logN) in the best case but O(N) in the worse case.

// The strength of a BST is that you can perform all search, insertion and deletion operations in O(h) time complexity even in the worst case.
public class DeleteNodeFromBST {
    /*
         1. If the target node has no child, we can simply remove the node.
         2. If the target node has one child, we can use its child to replace itself.
         3. If the target node has two children, replace the node with its in-order successor or predecessor node and delete that node.
    */
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null)
            return null;

        if(root.key == key) {

            // Case 1
            if(root.left == null && root.right == null) {
                return null;
            }
            // Case 3
            else if(root.left != null && root.right != null) {
                TreeNode successor = findSuccessor(root, key);
                root.key = successor.key;
                root.right = deleteNode(root.right, root.key);
            }
            else { // Case 2
                return root.left != null ? root.left : root.right;
            }
        }
        else if(root.key > key) {
            root.left = deleteNode(root.left, key);
        }
        else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode findSuccessor(TreeNode root, int key) {

        TreeNode successor = null;

        while(root != null) {

            if(root.key > key) {
                successor = root;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return successor;
    }
}