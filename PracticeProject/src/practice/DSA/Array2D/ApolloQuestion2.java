package practice.DSA.Array2D;

import java.util.ArrayList;
import java.util.List;

public class ApolloQuestion2 {

    public static void main(String[] args) {

        int[][] matrix = new int[][] { {1, 1, 0},
                                       {1, 1, 1},
                                       {0, 0, 0} };

        int[][] matrix2 = new int[][] { {1, 1, 1}};

        List<List<Integer>> result = getCoordinates(matrix);

        for(List<Integer> list : result) {
            System.out.println(list.get(0) + " , "+ list.get(1));
        }
    }

    public static List<List<Integer>> getCoordinates(int[][] matrix) {

        if(matrix.length == 1 || matrix.length == 0)
            return new ArrayList<>();

        int rows = matrix.length;
        int columns = matrix[0].length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < columns; j++) {

                if (matrix[i][j] == 1) {

                    boolean isDropping = false;
                    int level = i + 1;
                    while (level != rows) {
                        if (matrix[level][j] == 0) {
                            isDropping = true;
                            break;
                        }
                        level++;
                    }
                    if (isDropping) {
                        List<Integer> al = new ArrayList<>();
                        al.add(i);
                        al.add(j);
                        result.add(al);
                    }
                }
            }
        }
        return result;
    }
}
