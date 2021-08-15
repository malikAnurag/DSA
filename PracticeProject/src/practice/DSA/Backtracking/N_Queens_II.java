package practice.DSA.Backtracking;

import java.util.HashSet;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example 1:
 * Input: n = 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
 *
 * Example 2:
 * Input: n = 1
 * Output: 1
 *
 * Constraints:
 * 1 <= n <= 9
 */
public class N_Queens_II {

    static int size;

    public static void main(String[] args) {
        System.out.println(getSolutions(4));
        System.out.println(getSolutions(1));
    }

    static int getSolutions(int n) {
        size = n;
        return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private static int backtrack(int row, HashSet<Integer> cols, HashSet<Integer> diagonals, HashSet<Integer> antiDiagonals) {

        int result = 0;

        if(row == size)
            return 1;

        for(int col = 0; col < size; col++) {

            int diagonal = row - col;
            int antiDiagonal = row + col;

            if(cols.contains(col) || diagonals.contains(diagonal) || antiDiagonals.contains(antiDiagonal)) {
                continue;
            }

            cols.add(col);
            diagonals.add(diagonal);
            antiDiagonals.add(antiDiagonal);

            result += backtrack(row + 1, cols, diagonals, antiDiagonals);

            cols.remove(col);
            diagonals.remove(diagonal);
            antiDiagonals.remove(antiDiagonal);
        }
        return result;
    }
}
