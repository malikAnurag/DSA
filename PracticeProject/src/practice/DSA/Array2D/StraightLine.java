package practice.DSA.Array2D;

/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 */
public class StraightLine {

    public static void main(String[] args) {
        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println("Is straight line possible? -> " + isStraightLine(coordinates));
    }

    public static boolean isStraightLine(int[][] coordinates) {

        if (coordinates.length == 2)
            return true;

        for (int i = 1; i < coordinates.length - 1; i++) {

            int x1 = coordinates[i - 1][0], y1 = coordinates[i - 1][1];
            int x2 = coordinates[i][0], y2 = coordinates[i][1];
            int x3 = coordinates[i + 1][0], y3 = coordinates[i + 1][1];

            if ((y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1))
                return false;
        }
        return true;
    }
}
