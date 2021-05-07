package practice.DSA.String;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 */
public class ReverseString {

    public static void main(String[] args) {

        char[] arr = new char[] {'h','e','l','l','o'};

        for(char c : arr)
            System.out.print(c + " ");

        reverseString(arr);

        System.out.println("\nReversed: ");
        for(char c : arr)
            System.out.print(c + " ");
    }


    public static void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while(left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
