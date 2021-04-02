package practice.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(4, 2, 8, 9, 5, 6, 7);

        Stream<Integer> numbersGreaterThan5 = numbers.stream().filter(i -> i > 5);

        numbersGreaterThan5.forEach(System.out::println); //Traversing numbersGreaterThan5 stream first time

        //Second time traversal will throw error

        numbersGreaterThan5.forEach(System.out::println); //Error : stream has already been operated upon or closed
    }

}
