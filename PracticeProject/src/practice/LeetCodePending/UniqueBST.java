package practice.LeetCodePending;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */

/*
* Solution -> nth Catalan number
* */
public class UniqueBST {

    public static void main(String[] args) {

        System.out.println(countBST(3));
    }

    public static int countBST(int n) {

        int[] T = new int[n + 1];
        T[0] = 1;
        T[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                T[i] += T[j] * T[i - j - 1];
            }
        }
        return T[n];
    }
}
