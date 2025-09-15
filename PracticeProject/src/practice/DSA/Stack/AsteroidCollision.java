package practice.DSA.Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode.
 * Two asteroids moving in the same direction will never meet.
 * <p>
 * Example 1:
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * <p>
 * Example 2:
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * <p>
 * Example 3:
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 * <p>
 * Constraints:
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 */
public class AsteroidCollision {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5}))); // Output: [5, 10]
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8}))); // Output: []
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 2, -5}))); // Output: [10]
    }

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int ast : asteroids) {
            while (!st.isEmpty() && st.peek() > 0 && ast < 0) {
                if (ast + st.peek() == 0) {
                    st.pop();
                } else if (st.peek() < -ast) {
                    st.pop();
                    continue;
                }
                ast = 0;
                break;
            }

            if (ast != 0) {
                st.push(ast);
            }
        }

        int[] ans = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}
