package practice.Math;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 */

public class HammingDistance {

    public static void main(String[] args) {

        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {

        StringBuilder x1 = getBinary(x);
        StringBuilder y1 = getBinary(y);

        int xl = x1.length();
        int yl = y1.length();

        if(xl != yl) {
            if(xl > yl) {
                while(xl != yl) {
                    y1.insert(0,'0');
                    yl++;
                }
            }
            else {
                while(xl != yl) {
                    x1.insert(0,'0');
                    xl++;
                }
            }

        }
        // System.out.println(x1);
        // System.out.println(y1);
        int counter = 0 ;

        for(int i = 0 ; i < x1.length() ; i++) {
            if(x1.charAt(i) != y1.charAt(i))
                counter++;
        }
        return counter;
    }

    public static StringBuilder getBinary(int x) {

        StringBuilder sb = new StringBuilder();

        while(x > 0) {
            int k = x % 2;
            sb.append(k);
            x /= 2;
        }
        sb = sb.reverse();
        return sb;
    }
}
