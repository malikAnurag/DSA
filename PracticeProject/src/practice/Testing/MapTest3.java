package practice.Testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest3 {

    public static void main(String[] args) {

        List<Integer> al = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        al.add(1);
        al.add(2);
        al.add(3);

        map.put(0, al);

        modifyList(map.get(0));

        System.out.println(map);
        System.out.println(al);
    }

    private static void modifyList(List<Integer> list) {
        list.clear();
    }
}
