package practice.DSA.Trees.advanced;

import practice.DSA.Trees.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a binary tree, we install cameras on the nodes of the tree.
 * Each camera at a node can monitor its parent, itself, and its immediate children.
 * Calculate the minimum number of cameras needed to monitor all nodes of the tree.
 *
 *  Example 1:
 * Input: [0,0,null,0,0] TODO : treeCamera.png
 * Output: 1
 * Explanation: One camera is enough to monitor all nodes if placed as shown.
 *
 *  Example 2:
 * Input: [0,0,null,0,null,0,null,null,0] TODO : treeCamera1.png
 * Output: 2
 * Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.
 *
 * Note:
 * The number of nodes in the given tree will be in the range [1, 1000].
 * Every node has value 0.
 */
public class BinaryTreeCameras$ {

    static int cameras;
    static Set<TreeNode> covered;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);

        System.out.println(getCameras(root));

        root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.left.left = new TreeNode(0);
        root.left.left.left.right = new TreeNode(0);

        System.out.println(getCameras(root));
    }

    public static int getCameras(TreeNode root) {
        cameras = 0;
        covered = new HashSet<>();
        covered.add(null); // Skip the leaf nodes and start from one level above
        dfs(root, null);
        return cameras;
    }

    private static void dfs(TreeNode root, TreeNode parent) {
        if(root != null) {

            dfs(root.left, root);
            dfs(root.right, root);

            /*
            * Check if I need to add camera at node
            * Parent is null && node is uncovered
            * OR
            * If any of its right or left children are uncovered
            * */

            if((parent == null && !covered.contains(root)) || !covered.contains(root.left) || !covered.contains(root.right)) {
                covered.add(parent);
                covered.add(root);
                covered.add(root.left);
                covered.add(root.right);
                cameras++;
            }
        }
    }
}
