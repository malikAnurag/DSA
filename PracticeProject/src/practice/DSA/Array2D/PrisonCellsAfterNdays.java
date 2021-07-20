package practice.DSA.Array2D;

import java.util.Arrays;

/**
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.
 *
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 *
 * If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
 * Otherwise, it becomes vacant.
 * (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
 *
 * We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
 *
 * Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
 *
 * Example 1:
 * Input: cells = [0,1,0,1,1,0,0,1], N = 7
 * Output: [0,0,1,1,0,0,0,0]
 * Explanation:
 * The following table summarizes the state of the prison on each day:
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 *
 * Example 2:
 * Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
 * Output: [0,0,1,1,1,1,1,0]
 */
public class PrisonCellsAfterNdays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0}, 1000000000)));
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {

        int[] arr = cells.clone();

        N = N % 14 == 0 ? 14 : N % 14;

        while(N > 0) {

            for(int i = 1 ; i < cells.length-1 ; i++) {

                if(arr[i-1] == arr[i+1]) {
                    cells[i] = 1;
                }
                else {
                    cells[i] = 0;
                }
            }
            cells[0] = 0;
            cells[cells.length-1] = 0;
            arr = cells.clone();
            N--;
        }
        return cells;
    }

}
