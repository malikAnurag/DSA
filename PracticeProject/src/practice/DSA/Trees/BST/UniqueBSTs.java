package practice.DSA.Trees.BST;

import practice.DSA.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 *
 * Example 1:
 * Input: n = 3
 * Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 *
 * Example 2:
 * Input: n = 1
 * Output: [[1]]
 */
public class UniqueBSTs {

    public static void main(String[] args) {

    }

    public static List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public static List<TreeNode> helper(int start, int end) {

        List<TreeNode> list = new ArrayList();

        if(start > end) {
            list.add(null);
            return list;
        }
        else if(start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        for(int i = start ; i <= end ; i++) {

            List<TreeNode> leftPossibleNodes = helper(start, i -1);
            List<TreeNode> rightPossibleNodes = helper(i + 1, end);

            for(TreeNode left : leftPossibleNodes) {
                for(TreeNode right : rightPossibleNodes) {

                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;

                    list.add(root);
                }
            }
        }
        return list;
    }
}