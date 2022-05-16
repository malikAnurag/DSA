package practice.DSA.Array.Advanced;

/**
 * N/3 repeated number in an array with O(1) space
 * We are given a read only array of n integers.
 * Find any element that appears more than n/3 times in the array in linear time and constant additional space.
 * If no such element exists, return -1.
 *
 * Examples:
 *
 * Input : [10, 10, 20, 30, 10, 10]
 * Output : 10
 * 10 occurs 4 times which is more than 6/3.
 *
 * Input : [20, 30, 10, 10, 5, 4, 20, 1, 2]
 * Output : -1
 */
public class RepeatedNumber_X {

    public static void main(String[] args) {
        System.out.println(getRepeatedNumber(new int[]{30, 20, 10, 10, 10, 10}));
        System.out.println(getRepeatedNumber(new int[]{20, 30, 10, 10, 5, 4, 20, 1, 2}));
    }

    public static int getRepeatedNumber(int[] arr) {

        int count1 = 0, count2 = 0;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for(int i = 0 ; i < arr.length ; i++) {

            if(first == arr[i]) {
                count1++;
            }
            else if(second == arr[i]) {
                count2++;
            }
            else if(count1 == 0) {
                first = arr[i];
                count1++;
            }
            else if(count2 == 0) {
                second = arr[i];
                count2++;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int i = 0 ; i < arr.length ; i++) {
            if(first == arr[i]) {
                count1++;
            }
            else if(second == arr[i]) {
                count2++;
            }
        }

        if(count1 > arr.length/3) {
            return first;
        }
        else if(count2 > arr.length/3) {
            return second;
        }
        else {
            return -1;
        }
    }
}