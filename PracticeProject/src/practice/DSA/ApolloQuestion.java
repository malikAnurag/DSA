package practice.DSA;

import java.util.Stack;

/**
 * You are given two integer arrays, one of which is a sequence of numbers pushed into a stack (supposing all numbers are unique).
 * Please check whether the other array is a corresponding sequence popped from the stack.
 * For example, if the pushing sequence is {1, 2, 3, 4, 5}, the sequence {4, 5, 3, 2, 1} is a corresponding popping sequence, but
 * {4, 3, 5, 1, 2} is not.
 * <p>
 * Action              Stack
 * None                []
 * Push 1,2,3,4    [1,2,3,4]
 * Pop 4               [1,2,3]
 * Push 5             [1,2,3,5]
 * Pop 5,3,2,1      []
 */


public class ApolloQuestion {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 3, 2, 1};

        System.out.println(checkSequence(arr1, arr2));
    }

    public static boolean checkSequence(int[] arr1, int[] arr2) {

        Stack<Integer> st = new Stack<>();
        int size = arr1.length;
        int counter = 0;

        for (int i = 0; i < size; i++) {
            st.push(arr1[i]);

            while (!st.isEmpty() && counter < size && arr2[counter] == st.peek()) {
                st.pop();
                counter++;
            }
        }
        return counter == size;
    }
}
