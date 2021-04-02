package practice.Math;

import java.util.Arrays;

public class GoldBachConjecture {

    public static void main(String[] args) {

        int num = 30;
        boolean[] primes = sieveOfEratosthenes(num);
        int[] result = new int[2];

        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                int diff = num - i;
                if (primes[diff]) {
                    result[0] = i;
                    result[1] = diff;
                    break;
                }
            }
        }
        for (int i : result)
            System.out.println(i);
    }

    /*
        According to the algorithm we will mark all the numbers which are divisible by 2 and are greater
        than or equal to the square of it.
    */

    public static boolean[] sieveOfEratosthenes(int n) {

        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        for (int p = 2; p * p <= n; p++) {
            if (primes[p]) {
                for (int i = p * p; i <= n; i += p) {
                    primes[i] = false;
                }
            }
        }
        return primes;
    }
}
