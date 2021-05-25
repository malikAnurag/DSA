package practice.DSA.Array2D;

import java.util.ArrayList;
import java.util.List;

public class FallingBoxes {

    public static void main(String[] args) {

        int[][] matrix = {{1,1,1},
                          {1,0,1},
                          {0,1,0},
                          {1,1,1},
                          {0,1,1}};

        List<List<Integer>> result = Foo(matrix);

        for(List<Integer> list : result) {
            System.out.println(list.get(0) + " , " + list.get(1));
        }
    }

    public static List<List<Integer>> Foo(int[][] matrix) {

        List<List<Integer>> result = new ArrayList();
        List<List<Integer>> zeros = new ArrayList();

        int i = matrix.length - 1;
        int j = matrix[i].length - 1;

        while(i >= 0 && j >= 0) {
            if(matrix[i][j] == 0) {
                List<Integer> al = new ArrayList();
                al.add(i);
                al.add(j);
                zeros.add(al);
                j--;
                i = matrix.length - 1;
            } else {
                i--;
            }
        }

        for(int r = 0; r < matrix.length - 1; r++) {
            for(int c = 0; c < matrix[0].length; c++) {
                if(matrix[r][c] == 1) {
                    for(List<Integer> z : zeros) {
                        if(z.get(0) > r && z.get(1) == c) {
                            List<Integer> box = new ArrayList();
                            box.add(r);
                            box.add(c);
                            result.add(box);
                        }
                    }
                }
            }
        }
        return result;
    }
}