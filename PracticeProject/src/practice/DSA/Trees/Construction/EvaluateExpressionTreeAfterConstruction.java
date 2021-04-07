package practice.DSA.Trees.Construction;

/**
 * Evaluate a given expression tree.
 */
public class EvaluateExpressionTreeAfterConstruction {

    public static void main(String[] args) {

        String postFix = "231*+9-";
        CharTreeNode root = ConstructExpressionTree.constructExpressionTree(postFix);
        System.out.println("PostFix Evaluation :: "+ evaluateExpression(root));
    }

    public static int evaluateExpression(CharTreeNode root) {

        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return Integer.parseInt(String.valueOf(root.value));

        int leftSum = evaluateExpression(root.left);
        int rightSum = evaluateExpression(root.right);

        switch(root.value) {
            case '+' :
                return leftSum + rightSum;
            case '-' :
                return leftSum - rightSum;
            case '*' :
                return leftSum * rightSum;
            case '/' :
                return leftSum / rightSum;
            case '^' :
                return leftSum ^ rightSum;
            default:
                return 0;
        }
    }
}
