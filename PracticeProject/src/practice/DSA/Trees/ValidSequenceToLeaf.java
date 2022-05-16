package practice.DSA.Trees;

/**
 * Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a
 * valid sequence in such binary tree.
 * We get the given string from the concatenation of an array of integers arr and the concatenation of all values
 * of the nodes along a path results in a sequence in the given binary tree.
 */
public class ValidSequenceToLeaf {

    public static void main(String[] args) {

        int[] arr = {0,1,0,1};
        int[] arr1 = {0,1,1,0,1};
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.left.right = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(0);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);

        System.out.println(checkValidity(root,arr,0));
        System.out.println(checkValidity(root,arr1,0));

//                               0
//                            /     \
//                           1       0
//                          /  \     /
//                         0    1   0
//                          \  / \
//                           1 0  0
    }

    public static boolean checkValidity(TreeNode root, int[] arr, int index) {

        if(root == null)
            return arr.length == 0;

        if(root.left == null && root.right == null && index == arr.length - 1 && root.key == arr[index])
            return true;

        return (index < arr.length &&
                (root.key == arr[index] &&
                        (checkValidity(root.left, arr, index + 1) || checkValidity(root.right, arr, index + 1))));

    }
}
