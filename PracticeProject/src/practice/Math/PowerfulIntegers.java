package practice.Math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given three integers x, y, and bound, return a list of all the powerful integers that have a value less than or equal to bound.
 *
 * An integer is powerful if it can be represented as x^i + y^j for some integers i >= 0 and j >= 0.
 *
 * You may return the answer in any order. In your answer, each value should occur at most once.
 *
 * Example 1:
 *
 * Input: x = 2, y = 3, bound = 10
 * Output: [2,3,4,5,7,9,10]
 * Explanation:
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 *
 *  Example 2:
 * Input: x = 3, y = 5, bound = 15
 * Output: [2,4,6,8,10,14]
 */

public class PowerfulIntegers {
    public static void main(String[] args) {
        System.out.println(powerfulIntegers(2, 3, 10));
        System.out.println(powerfulIntegers(3, 5, 15));
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {

        List<Integer> px = new ArrayList();
        List<Integer> py = new ArrayList();

        int powx = x, powy = y;
        px.add(1);
        py.add(1);

        if(x != 1) {
            while(powx <= bound) {
                px.add(powx);
                powx *= x;
            }
        }

        if(y != 1) {
            while(powy <= bound) {
                py.add(powy);
                powy *= y;
            }
        }

        Set<Integer> hs = new HashSet();

        for(int i : px) {
            for(int j : py) {
                if(i + j <= bound) {
                    hs.add(i + j);
                }
            }
        }
        return new ArrayList<>(hs);
    }
}
