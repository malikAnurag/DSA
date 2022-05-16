package practice.DSA.Array2D.Advanced;

public class MaxSumOfRectangle {

    static int maxUp = -1, maxDown = -1, maxLeft = 0, maxRight = 0, maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {

//        int arr[][] = new int[][] { { 1, 2, -1, -4, -20 },
//                                    { -8, -3, 4, 2, 1 },
//                                    { 3, 8, 10, 1, 3 },
//                                    { -4, -1, 1, 7, -6 } }; // 29

        int[][] arr = new int[][] { { 2, 1, -3, -4, -5 },
                                    { 0, 6, 3, 4, 1 },
                                    { 2, -2, -1, 4, -5 },
                                    { -3, 3, 1, 0, 3 } }; // 18

        System.out.println(maxSumSubmatrix(arr));
    }

    /* Take an array of size equal to the number of rows and keep on adding the values as you go from left to right
    and start with L = R.
    *  This will be done starting from every column to the end(total number of columns)
    *  And before starting every iteration, the 1-D array will be populated by the numbers present in that particular column
    *  For every 1-D array prepared (after the iteration of one full column), apply kadane's algorithm to find out the
    max sum and update the global max.
    * */

    public static int maxSumSubmatrix(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int[] sumArr = new int[row];
        int L = 0, R = 0;

        while(L < col) {

            while(R < col) {

                if(L == R) {
                    for(int j = 0 ; j < row ; j++) {
                        sumArr[j] = matrix[j][L];
                    }
                }
                else {
                    for(int j = 0 ; j < row ; j++) {
                        sumArr[j] += matrix[j][R];
                    }
                }
                findMaxSum(sumArr, L, R);
                R++;
            }
            L++;
            R = L;
        }
        return maxSum;
    }

    public static void findMaxSum(int[] arr, int L, int R) {

        if(arr.length == 1) {
            if(arr[0] > maxSum) {
                maxSum = arr[0];
            }
            return;
        }

        int max = 0;
        int maxStart = -1;
        int maxEnd = -1;
        int currentStart = 0;
        int maxSoFar = 0;

        for(int i = 0; i < arr.length; i++) {

            maxSoFar += arr[i];

            if(maxSoFar < 0){
                maxSoFar = 0;
                currentStart = i+1;
            }

            // Updating local max
            if(max < maxSoFar) {
                maxStart = currentStart;
                maxEnd = i;
                max = maxSoFar;
            }
        }
        // Updating global max
        if(max > maxSum) {
            maxLeft = L;
            maxRight = R;
            maxUp = maxStart;
            maxDown = maxEnd;
            maxSum = max;
        }
    }
}
