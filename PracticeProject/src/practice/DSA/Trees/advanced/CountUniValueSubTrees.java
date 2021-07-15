package practice.DSA.Trees.advanced;

import practice.DSA.Trees.TreeNode;

public class CountUniValueSubTrees {

    int count = 0;
    boolean is_valid_part(TreeNode node, int val) {

        // considered a valid subtree
        if (node == null) return true;

        // check if node.left and node.right are univalue subtrees of value node.val
        // note that || short circuits but | does not - both sides of the or get evaluated with | so we explore all possible routes
        if (!is_valid_part(node.left, node.key) | !is_valid_part(node.right, node.key)) return false;

        // if it passed the last step then this a valid subtree - increment
        count++;

        // at this point we know that this node is a univalue subtree of value node.val
        // pass a boolean indicating if this is a valid subtree for the parent node
        return node.key == val;
    }
    public int countUnivalSubtrees(TreeNode root) {
        is_valid_part(root, 0);
        return count;
    }
}
