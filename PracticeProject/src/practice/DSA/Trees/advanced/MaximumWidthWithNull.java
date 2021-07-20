package practice.DSA.Trees.advanced;

import practice.DSA.Trees.TreeNode;

import java.util.LinkedList;

/**
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width
 * among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level,
 * where the null nodes between the end-nodes are also counted into the length calculation.
 *
 * Example 1:
 *
 * Input:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 *
 * Example 2:
 *
 * Input:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 *
 * Example 3:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 *
 * Example 4:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 */
public class MaximumWidthWithNull {

    /*
		    1(0)
         /      \
        3(0)      2 (1)
       / \      /    \
     5(0) 3(1) null(2) 9 (3)
		 *
		 *
		 * */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(getMaxWidthWithNull(root));
    }

    /*
    * Basically all the nodes in the left straight leg have 0 position which increments as you move towards the right on every level
    * */

    public static int getMaxWidthWithNull(TreeNode root) {

        LinkedList<Holder> list = new LinkedList<>();
        int max = 1;

        list.add(new Holder(root, 0));

        while(!list.isEmpty()) {

            int size = list.size();

            // this evaluation happens when the whole level is filled
            max = Math.max(max, list.peekLast().pos - list.peekFirst().pos + 1);

            for(int i = 0; i < size; i++) {

                Holder holder = list.poll();

                if(holder.node.left != null) {
                    list.add(new Holder(holder.node.left, 2 * holder.pos));
                }

                if(holder.node.right != null) {
                    list.add(new Holder(holder.node.right, 2 * holder.pos + 1));
                }
            }
        }
        return max;
    }
}

class Holder {
    TreeNode node;
    int pos;

    Holder(TreeNode node, int pos) {
        this.node = node;
        this.pos = pos;
    }
}
