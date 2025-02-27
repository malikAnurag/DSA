package practice.DSA.Trees.advanced;

import practice.DSA.Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, replace the value of each node in the tree with the sum of all its cousins' values.
 *
 * Two nodes of a binary tree are cousins if they have the same depth with different parents.
 *
 * Return the root of the modified tree.
 *
 * Note that the depth of a node is the number of edges in the path from the root node to it.
 */
public class Cousins_II {
    public TreeNode replaceValueInTree(TreeNode root) {

        if (root == null) return null;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        List<Integer> levelSums = new ArrayList<>();

        // First BFS: Calculate sum of nodes at each level
        while (!nodeQueue.isEmpty()) {
            int levelSum = 0;
            int n = nodeQueue.size();

            for (int i = 0; i < n; ++i) {

                TreeNode currentNode = nodeQueue.poll();
                levelSum += currentNode.key;

                if (currentNode.left != null)
                    nodeQueue.offer(currentNode.left);

                if (currentNode.right != null)
                    nodeQueue.offer(currentNode.right);
            }
            levelSums.add(levelSum);
        }

        // Second BFS: Update each node's value to sum of its cousins
        nodeQueue.offer(root);
        int levelIndex = 1;
        root.key = 0; // Root has no cousins

        while (!nodeQueue.isEmpty()) {

            int n = nodeQueue.size();

            for (int i = 0; i < n; ++i) {

                TreeNode currentNode = nodeQueue.poll();

                int siblingSum =
                        (currentNode.left != null ? currentNode.left.key : 0) +
                                (currentNode.right != null ? currentNode.right.key : 0);

                if (currentNode.left != null) {
                    currentNode.left.key = levelSums.get(levelIndex) - siblingSum;
                    nodeQueue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    currentNode.right.key = levelSums.get(levelIndex) - siblingSum;
                    nodeQueue.offer(currentNode.right);
                }
            }
            ++levelIndex;
        }

        return root;
    }
}
