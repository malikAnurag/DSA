package practice.DSA.Trees.Construction;

import java.util.Stack;

/**
 * Construction of an expression Tree from given postfix expression.
 */
public class ConstructExpressionTree {

    public static void main(String[] args) {
        String postFix = "ab+ef*g*-";
        CharTreeNode root = constructExpressionTree(postFix);
        inOrderTraversal(root);
    }

    public static CharTreeNode constructExpressionTree(String postFix) {

        char[] arr = postFix.toCharArray();
        Stack<CharTreeNode> st = new Stack<>();

        for(char c : arr) {

            if(!isOperator(c)) {
                st.push(new CharTreeNode(c));
            }
            else {
                CharTreeNode node = new CharTreeNode(c);
                node.right = st.pop();
                node.left = st.pop();
                st.push(node);
            }
        }
        return st.pop();
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    public static void inOrderTraversal(CharTreeNode root) {

        if(root == null)
            return;

        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }
}

class CharTreeNode {

    char value;
    CharTreeNode left, right;

    CharTreeNode(char item) {
        value = item;
        left = right = null;
    }
}