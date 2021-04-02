package practice;


/**
 * [1,0,1,1,1,0,0]
 * n = 2
 * Get the count of all substring where number of 1’s is greater than or equal to n
 *
 *
 * Ans:  5+4+4+3=16
 */
public class Wh {

    public static void main(String[] args) {
        System.out.println(countStrings(new int[]{1, 0, 1, 1, 1, 0, 0}, 2));
    }

    public static int countStrings(int[] arr, int n) {
        int result = 0;
        int count1 = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            count1 = arr[i];
            if(count1 >= n)
                result++;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] == 1) {
                    count1++;
                }
                if(count1 >= n)
                    result++;
            }
        }
        return result;
    }
}


//package practice;
//
//
///**
// * [1,0,1,1,1,0,0]
// * n = 2
// * Get the count of all substring where number of 1’s is greater than or equal to n
// *
// *
// * Ans:  5+4+4+3=16
// */
//public class Wh {
//
//    public static void main(String[] args) {
//        System.out.println(countStrings(new int[]{1, 0, 1, 1, 1, 0, 0}, 2));
//    }
//
//    public static int countStrings(int[] arr, int n) {
//        int result = 0;
//        StringBuilder sb = new StringBuilder();
//
//        for (int k : arr) {
//            sb.append(k);
//        }
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                String S = sb.toString().substring(i, j + 1);
//                int count1 = 0;
//                for (char c : S.toCharArray()) {
//                    if (c == '1') {
//                        count1++;
//                    }
//                }
//                if (count1 >= n) {
//                    result++;
//                }
//            }
//        }
//        return result;
//    }
//}
