package practice.Testing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ByteTest {

    public static void main(String[] args) {

       List<Consumer<Integer>> functions = new ArrayList<Consumer<Integer>>();
       int[] nums = new int[]{0,1,2};

       for(int i : nums)
           functions.add((j) -> System.out.print(i-nums[j]));

       for(int i : nums) {
           functions.get(i).accept(i);
           System.out.print(" ");
       }
    }

}
