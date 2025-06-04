package practice.DSA.Hashing;


/**
 * Given an infinite number line, you would like to build some blocks and obstacles on it.
 * Specifically, you have to implement code which supports two types of operations. [1,x] - builds an obstacle at coordinate x
 * along the number line. It is guaranteed that coordinate x does not contain any obstacles when the operation is performed.
 * [2,x,size] - checks whether it's possible to build a block centered on x and extending size -1 in each direction.
 * For example, for size = 3, and x = 0, it will check -2 through 2 on the number line for obstacles.
 * Produces 1 if it is possible, i.e. if there are no obstacles at the specified coordinates, and produces 0 otherwise.
 * <p>
 * Please note that this operation does not actually build the block, it only checks whether it can be built.
 * <p>
 * Given an array of operations containing both types of operations, your task is to return a binary string representing the
 * <p>
 * outputs for all [2,x,size] operations.
 */

import java.util.*;

public class BlockBuilder {
    public static String processOperations(List<int[]> operations) {

        TreeSet<Integer> obstacles = new TreeSet<>();
        StringBuilder result = new StringBuilder();

        for (int[] op : operations) {
            if (op[0] == 1) {
                // Add obstacle
                int x = op[1];
                obstacles.add(x);
            } else if (op[0] == 2) {
                // Check if block can be built
                int x = op[1];
                int size = op[2];
                int left = x - (size - 1);
                int right = x + (size - 1);

                // Check if there is any obstacle in range [left, right]
                Integer obstacle = obstacles.ceiling(left);

                if (obstacle != null && obstacle <= right) {
                    result.append('0');
                } else {
                    result.append('1');
                }
            }
        }
        return result.toString();
    }

    // Example usage
    public static void main(String[] args) {
        List<int[]> operations = Arrays.asList(
                new int[]{1, 5},
                new int[]{2, 3, 2},  // checks [-1, 7], so 5 is obstacle => 0
                new int[]{2, 10, 3}, // checks [8, 12] => 1
                new int[]{1, 9},
                new int[]{2, 10, 2}  // checks [9, 11], 9 is obstacle => 0
        );

        System.out.println(processOperations(operations));  // Output: 010
    }
}

