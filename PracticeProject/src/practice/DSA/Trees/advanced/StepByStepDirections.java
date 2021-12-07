package practice.DSA.Trees.advanced;

import practice.DSA.Trees.TreeNode;

/**
 * You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n.
 * You are also given an integer startValue representing the value of the start node s, and a different integer
 * destValue representing the value of the destination node t.
 *
 * Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path
 * as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:
 *
 * 'L' means to go from a node to its left child node.
 * 'R' means to go from a node to its right child node.
 * 'U' means to go from a node to its parent node.
 * Return the step-by-step directions of the shortest path from node s to node t.
 *
 * Example 1:
 * Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
 * Output: "UURL"
 * Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
 *
 * Example 2:
 * Input: root = [2,1], startValue = 2, destValue = 1
 * Output: "L"
 * Explanation: The shortest path is: 2 → 1.
 *
 * Constraints:
 * The number of nodes in the tree is n.
 * 2 <= n <= 105
 * 1 <= Node.val <= n
 * All the values in the tree are unique.
 * 1 <= startValue, destValue <= n
 * startValue != destValue
 */
public class StepByStepDirections {

    public String getDirections(TreeNode root, int startValue, int destValue) {

        if(root == null)
            return "";

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        find(root, startValue, sb1);
        find(root, destValue, sb2);
        // System.out.println(sb1);
        // System.out.println(sb2);

        String path1 = sb1.toString();
        String path2 = sb2.toString();
        int i = 0;

        if(path1.length() > 0 && path2.length() > 0) {
            while(i < path1.length() && i < path2.length() && path1.charAt(i) == path2.charAt(i)) {
                i++;
            }
            path1 = path1.substring(i);
            path2 = path2.substring(i);
        }

        path1 = path1.replaceAll("L", "U");
        path1 = path1.replaceAll("R", "U");

        return path1 + path2;
    }

    boolean find(TreeNode root, int val, StringBuilder sb) {

        if(root == null)
            return false;

        else if(root.key == val)
            return true;

        sb.append("L");
        boolean isFound = find(root.left, val, sb);

        if(isFound) {
            return true;
        }

        sb.deleteCharAt(sb.length() - 1);

        sb.append("R");
        isFound = find(root.right, val, sb);

        if(isFound) {
            return true;
        }
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }
}
