package practice.Testing;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

    public static void main(String[] args) {

        Set<Integer> hs = new HashSet() {{
            add(1);
            add(2);
        }};

        System.out.println(hs.iterator().next());
        System.out.println(hs.iterator().next());
    }

}
