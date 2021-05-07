package practice.Testing;

import java.util.*;

public class SetTest {

        public static void main(String[] args)
        {

            // Creating a list of strings
            List<String> aList = Arrays.asList("Geeks", "for",
                    "GeeksQuiz", "GeeksforGeeks", "GFG");

            // Creating a hash set using constructor
            Set<String> hSet = new HashSet<>(aList);

            System.out.println("Created HashSet is");
            for (String x : hSet)
                System.out.println(x);


        }
}
