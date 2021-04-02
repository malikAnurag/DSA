package practice.DSA.String;

/**
 * Generate all substrings of a given String.
 */
public class AllSubstringsOfString {

    public static void main(String[] args) {
        generateSubstrings("abcd");
    }

    public static void generateSubstrings(String S) {

        for(int i = 0 ; i < S.length() ; i++) {

            for(int j = i + 1 ; j <= S.length() ; j++) {
                System.out.println(S.substring(i, j));
            }
        }
    }
}
