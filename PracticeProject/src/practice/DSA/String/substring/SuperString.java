package practice.DSA.String.substring;

/**
 * Return the maximum length of substring that has at most 2 matching characters.
 */
public class SuperString {

    public static void main(String[] args) {
        System.out.println(getMaxLength("aabccba"));
        System.out.println(getMaxLength("aaabbcrrcbeea"));
    }

    public static int getMaxLength(String S) {

        int[] count = new int[256];
        int result = 0;
        int left = 0;

        for (int right = 0; right < S.length(); right++) {

            ++count[S.charAt(right)];

            while (count[S.charAt(right)] > 2) {
                --count[S.charAt(left)];
                left++;
            }

            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
//aabccba