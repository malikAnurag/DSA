package practice.Math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 *
 * Input  : n = 7
 * Output : 8
 *
 * Input  : n = 10
 * Output : 12
 *
 * Input  : n = 15
 * Output : 24
 *
 * Input  : n = 150
 * Output : 5832
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */

public class UglyNumber {

    public static void main(String[] args) {

        System.out.println(nthUglyNumber(7));
        System.out.println(nthUglyNumber(10));
        System.out.println(nthUglyNumber(15));
        System.out.println(nthUglyNumber(150));
    }

    public static int nthUglyNumber(int n) {

        int counter = 1;
        int i = 2;
        List<Integer> al = new ArrayList();
        al.add(1);

        while(true) {

            if(counter == n)
                break;

            if(getPrimeFactors(i)){
                al.add(i);
                counter++;
            }
            i++;
        }

        // for(int t : al)
        //     System.out.println(t);

        return al.get(al.size()-1);
    }

    public static boolean getPrimeFactors(int k) {

        Set<Integer> hs = new HashSet();

        while (k % 2 == 0) {
            hs.add(2);
            k /= 2;
        }

        for (int i = 3; i <= Math.sqrt(k); i += 2) {
            while (k % i == 0) {
                hs.add(i);
                k /= i;
            }
        }

        if (k > 2)
            hs.add(k);

        if (hs.size() == 1) {
            if (hs.contains(2) || hs.contains(3) || hs.contains(5))
                return true;
            else
                return false;
        } else if (hs.size() == 2) {
            if ((hs.contains(2) && hs.contains(3)) || (hs.contains(3) && hs.contains(5))
                    || (hs.contains(2) && hs.contains(5)))
                return true;
            else
                return false;
        } else if (hs.size() == 3) {
            if (hs.contains(2) && hs.contains(3) && hs.contains(5))
                return true;
            else
                return false;
        }

        return false;
    }

}
