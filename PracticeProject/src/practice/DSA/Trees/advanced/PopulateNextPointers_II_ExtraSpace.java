package practice.DSA.Trees.advanced;

import practice.DSA.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
/**
 * Given a BINARY TREE, populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 *
 * Follow up:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 *
 * Constraints:
 * The number of nodes in the given tree is less than 6000.
 * -100 <= node.val <= 100
 */
public class PopulateNextPointers_II_ExtraSpace {

    public TreeNode connect(TreeNode root) {

        if(root == null)
            return null;

        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()) {

            int size = q.size();
            for(int i = 0 ; i < size; i++) {

                TreeNode node = q.remove();

                if(i < size - 1) {
                    node.next = q.peek();
                }

                if(node.left != null)
                    q.add(node.left);

                if(node.right != null)
                    q.add(node.right);
            }
        }
        return root;
    }
}