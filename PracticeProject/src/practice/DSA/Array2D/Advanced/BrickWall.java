package practice.DSA.Array2D.Advanced;

import java.util.*;

/**
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks.
 * The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
 *
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.
 *
 * If your line go through the edge of a brick, then the brick is not considered as crossed.
 * You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 *
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
 *
 *
 * Example:
 *
 * Input: [[1,2,2,1],
 *         [3,1,2],
 *         [1,3,2],
 *         [2,4],
 *         [3,1,2],
 *         [1,3,1,1]]
 *
 * Output: 2
 *
 * Explanation: TODO: brickWall.png
 */
public class BrickWall {

    public static void main(String[] args) {

        List<List<Integer>> wall = new ArrayList<>();

        List<Integer> bricks1 = Arrays.asList(1, 2, 2, 1);
        List<Integer> bricks2 = Arrays.asList(3, 1, 2);
        List<Integer> bricks3 = Arrays.asList(1, 3, 2);
        List<Integer> bricks4 = Arrays.asList(2, 4);
        List<Integer> bricks5 = Arrays.asList(3, 1, 2);
        List<Integer> bricks6 = Arrays.asList(1, 3, 1, 1);

        wall.add(bricks1);
        wall.add(bricks2);
        wall.add(bricks3);
        wall.add(bricks4);
        wall.add(bricks5);
        wall.add(bricks6);

        System.out.println(getTouchedBricks(wall));
    }

    public static int getTouchedBricks(List<List<Integer>> wall) {

        int untouched = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(List<Integer> list : wall) {

            int end = 0;

            for(int brick = 0; brick < list.size() - 1; brick++) {

                end += list.get(brick);
                map.put(end, map.getOrDefault(end, 0) + 1);
                untouched = Math.max(untouched, map.get(end));
            }
        }
        return wall.size() - untouched;
    }
}
