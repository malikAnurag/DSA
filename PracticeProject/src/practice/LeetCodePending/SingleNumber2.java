package practice.LeetCodePending;

/**
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once.
 * Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
//TODO: https://www.youtube.com/watch?v=8IKjudrUGNE

public class SingleNumber2 {

    public static void main(String[] args) {

        System.out.println(singleNumber(new int[]{1,1,1,2}));
        System.out.println(singleNumber(new int[]{0,1,0,1,0,1,99}));
    }
/*
* Algorithm: For Bitwise solution
ones - At any point of time, this variable holds XOR of all the elements which have appeared "only" once.
twos - At any point of time, this variable holds XOR of all the elements which have appeared "only" twice.

So, at any point time below three cases can happen

A new number appears - It gets XOR'd to the variable ones.
A number gets repeated(appears twice) - It is removed from ones and XOR'd to the variable twice.
A number appears for the third time - It gets removed from both ones and twice.
The final answer we want is the value present in ones - coz, it holds the unique element.

How to remove common 1's bits from ones and twos.

not_threes = ~(ones & twos) --> first we are taking bitwise end between ones and twos and then negate it.
ones &= not_threes --> now if take bitwise & which will remove the common bits
twos &= not_threes  --> now if take bitwise & which will remove the common bits
* */
    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0, not_threes = 0;
        for(int n : nums) {
            twos |= (ones & n);
            ones ^= n;
            not_threes = ~(ones & twos);
            ones &= not_threes;
            twos &= not_threes;
        }

        return ones;
    }
}
