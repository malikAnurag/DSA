package practice.DSA.Graph;


import java.util.Random;

/**
 * Suppose you are at a party with n people (labeled from 0 to n - 1), and among them, there may exist one celebrity.
 * The definition of a celebrity is that all the other n - 1 people know him/her, but he/she does not know any of them.
 *
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is
 * to ask questions like:
 * "Hi, A. Do you know B?" to get information about whether A knows B. You need to find out the celebrity
 * (or verify there is not one) by asking as
 * few questions as possible (in the asymptotic sense).
 *
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int
 * findCelebrity(n).
 * There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity
 * in the party.
 * If there is no celebrity, return -1.
 *
 * Example 1:
 * Input: graph = [[1,1,0],[0,1,0],[1,1,1]]
 * Output: 1
 * Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j, otherwise
 * graph[i][j] = 0 means person i
 * does not know person j. The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.
 *
 * Example 2:
 * Input: graph = [[1,0,1],[1,1,0],[0,1,1]]
 * Output: -1
 * Explanation: There is no celebrity.
 *
 * Constraints:
 * n == graph.length
 * n == graph[i].length
 * 2 <= n <= 100
 * graph[i][j] is 0 or 1.
 * graph[i][i] == 1
 *
 * Follow up: If the maximum number of allowed calls to the API knows is 3 * n, could you find a solution without exceeding
 * the maximum number of calls?
 */
public class CelebrityProblem_Efficient {

    static boolean knows(int person1, int person2) {
        return new Random().nextInt(10) < 5;
    }

    /* With each call to knows(...), we can conclusively determine that exactly 1 of the people is not a celebrity!
    * Time Complexity : O(n).
    * Our code is split into 2 parts.
    * The first part finds a celebrity candidate. This requires doing n−1 calls to knows(...) API, and so is O(n).
    * The second part is the same as before—checking whether a given person is a celebrity. We determined that this is O(n).
    *
    * Therefore, we have a total time complexity of O(n + n) = O(n).
    * Space Complexity : O(1).
    * */

    static int findCelebrity(int n) {

        int candidate = 0;

        for(int i = 0 ; i < n ; i++) {
            if(knows(candidate, i))
                candidate = i;
        }

        if(isCelebrity(candidate, n)) {
            return candidate;
        }
        return -1;
    }

    static boolean isCelebrity(int i, int n) {

        for(int j = 0 ; j < n ; j++) {
            if(i == j)
                continue;
            if(knows(i, j) || !knows(j, i))
                return false;
        }
        return true;
    }
}