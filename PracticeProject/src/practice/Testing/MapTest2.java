package practice.Testing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MapTest2 {

    public static void main(String[] args) {

        Map<Integer, LinkedList<Integer>> hm = new HashMap<>();

        int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};

        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {

                hm.computeIfAbsent(i + j, x -> new LinkedList<>());
            }
        }

    }

}
