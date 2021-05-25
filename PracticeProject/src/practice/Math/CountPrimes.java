package practice.Math;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 *  Example 1:
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * Example 2:
 * Input: n = 0
 * Output: 0
 *
 * Example 3:
 * Input: n = 1
 * Output: 0
 */
public class CountPrimes {

    public static void main(String[] args) {

        System.out.println(countPrimes(10));
        System.out.println(countPrimes(0));
        System.out.println(countPrimes(1));

    }

    public static int countPrimes(int n) {

        int count = 0;

        boolean[] primes = getPrimes(n);

        for(boolean b : primes) {
            if(b) {
                count++;
            }
        }
        return count;
    }


    public static boolean[] getPrimes(int n) {

        boolean[] primes = new boolean[n];
        for(int i = 2 ; i < n ; i++) {
            primes[i] = true;
        }

        for(int i = 2; i * i < n ; i++) {
            if(!primes[i])
                continue;

            for(int j = i * i ; j < n ; j+=i) {
                primes[j] = false;
            }
        }
        return primes;
    }


}
