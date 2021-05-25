package practice.DSA.Array2D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class FallingBoxes_Efficient {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 1}};

        List<List<Integer>> result = Foo(matrix);

        for(List<Integer> list : result) {
            System.out.println(list.get(0) + " , " + list.get(1));
        }
    }

    public static List<List<Integer>> Foo(int[][] matrix) {

        List<List<Integer>> result = new ArrayList();
        Map<Integer, Pair> zeros = new HashMap<>();

        int i = matrix.length - 1;
        int j = matrix[i].length - 1;

        while(i >= 0 && j >= 0) {
            if(matrix[i][j] == 0) {
                List<Integer> al = new ArrayList();
                al.add(i);
                al.add(j);
                zeros.put(j, new Pair(i, j));
                j--;
                i = matrix.length - 1;
            } else {
                i--;
            }
        }

        for(int r = 0; r < matrix.length - 1; r++) {
            for(int c = 0; c < matrix[0].length; c++) {
                if(matrix[r][c] == 1 && zeros.containsKey(c) && zeros.get(c).x > r) {
                    List<Integer> box = new ArrayList();
                    box.add(r);
                    box.add(c);
                    result.add(box);
                }
            }
        }
        return result;
    }
}