package practice.DSA.Trees.advanced;

import practice.DSA.Trees.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format,
 * so please be creative and come up with different approaches yourself.
 *
 * Example 1:
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 *
 *  Example 2:
 * Input: root = []
 * Output: []
 *
 *  Example 3:
 * Input: root = [1]
 * Output: [1]
 *
 *  Example 4:
 * Input: root = [1,2]
 * Output: [1,2]
 */
public class SerializeAndDeserializeTree {

    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    private String rserialize(TreeNode root, String str) {

        if(root == null) {
            str += "null,";
            return str;
        }

        str += root.key + ",";
        str = rserialize(root.left, str);
        str = rserialize(root.right, str);
        return str;
    }

    public TreeNode deserialize(String data) {

        String[] str = data.split(",");
        List<String> al = new LinkedList<>(Arrays.asList(str));
        return deserialize(al);
    }

    private TreeNode deserialize(List<String> al) {

        if(al.get(0).equals("null")) {
            al.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(al.get(0)));
        al.remove(0);
        root.left = deserialize(al);
        root.right = deserialize(al);
        return root;
    }
}
