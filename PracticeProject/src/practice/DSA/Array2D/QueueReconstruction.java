package practice.DSA.Array2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people in front of this person who have a height greater than or
 * equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 * Eg.:
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstruction {

    public static void main(String[] args) {

        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        people = constructQueue(people);

        System.out.println("\nAfter sorting: ");

        for(int i = 0 ; i < people.length ; i++) {
            System.out.print("[" +people[i][0] + " , " + people[i][1] + "] , ");
        }
    }

    public static int[][] constructQueue(int[][] people) {
        /*
        * Sorting 2D array based on the following conditions:
        *   1. If height is same, increasing order of the number of people in front of this person
        *   2. If height is not same, decreasing order of the height.
        * */
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                else {
                    return o2[0] - o1[0];
                }
            }
        });

        System.out.println("\nAfter sorting in comparator: ");

        for(int i = 0 ; i < people.length ; i++) {
            System.out.print("[" +people[i][0] + " , " + people[i][1] + "] , ");
        }

        List<int[]> list = new ArrayList<>();

        /*
        * Insert the arrays according to the number of people that would be in front of each one.
        * */
        for (int i = 0 ; i < people.length ; i++) {
            int[] arr = people[i];
            list.add(arr[1], arr);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
