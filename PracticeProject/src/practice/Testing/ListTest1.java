package practice.Testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListTest1 {

    public static void main(String[] args) {

        Map<String, String> hm = new HashMap<>();

        hm.put("1", "abc1");
        hm.put("2", "abc2");
        hm.put("3", "abc3");

        List<Long> ids = new ArrayList(hm.keySet());

        for(Long l : ids) {
            System.out.println(l);
        }
    }
}
