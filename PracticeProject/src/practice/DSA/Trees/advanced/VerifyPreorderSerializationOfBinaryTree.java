package practice.DSA.Trees.advanced;

/**
 * One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the node's value.
 * If it is a null node, we record using a sentinel value such as '#'.
 *
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node.
 * Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree.
 * It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer.
 * You may assume that the input format is always valid.
 *
 * For example, it could never contain two consecutive commas, such as "1,,3".
 * Note: You are not allowed to reconstruct the tree.
 *
 *
 * Example 1:
 * Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 *
 * Example 2:
 * Input: preorder = "1,#"
 * Output: false
 *
 * Example 3:
 * Input: preorder = "9,#,#,1"
 * Output: false
 *
 * Constraints:
 * 1 <= preorder.length <= 104
 * preoder consist of integers in the range [0, 100] and '#' separated by commas ','.
 *
 * TODO: https://www.youtube.com/watch?v=RzNYwhSQjHQ
 */
public class VerifyPreorderSerializationOfBinaryTree {

    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(isValidSerialization("1,#"));
        System.out.println(isValidSerialization("9,#,#,1"));
    }

    public static boolean isValidSerialization(String preorder) {

        // number of available slots
        int slots = 1;

        int n = preorder.length();

        for(int i = 0; i < n; ++i) {

            if (preorder.charAt(i) == ',') {
                // one node takes one slot
                --slots;

                // no more slots available
                if (slots < 0)
                    return false;

                // non-empty node creates two children slots
                if (preorder.charAt(i - 1) != '#')
                    slots += 2;
            }

        }
        // the last node
        slots = (preorder.charAt(n - 1) == '#') ? slots - 1 : slots + 1;
        // all slots should be used up
        return slots == 0;
    }
}