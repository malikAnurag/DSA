package practice.Testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListTest1 {

    public static void main(String[] args) {

        Map<Long, String> hm = new HashMap<>();

        hm.put(1L, "abc1");
        hm.put(2L, "abc2");
        hm.put(3L, "abc3");

        List<Long> ids = new ArrayList<>(hm.keySet());

        System.out.println(ids);
    }
}
