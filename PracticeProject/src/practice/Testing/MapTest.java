package practice.Testing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapTest {

    public static void main(String[] args) {

//        Map<Integer, Account> hm = new HashMap();
//
//        populateMap(hm);
//
//        Account ac = hm.get(1);
//        System.out.println("Exiting name: " + ac.getName());
//        ac.setName("Malik");
//
//        for(Map.Entry<Integer,Account> entry : hm.entrySet())
//            System.out.println(entry.getValue().getName());
//
        Set<Account> hs = new HashSet<>(1);

        Account ac = new Account();
        hs.add(ac);

        System.out.println(hs.isEmpty());
    }

    public static void populateMap(Map<Integer, Account> hm) {

        Map<Integer,Account> newHm = new HashMap()
        {{
            put(1, new Account("Anurag" , 1));
            put(2, new Account("Malik" , 2));
        }};

        hm.putAll(newHm);
    }

}
class Account {

    private String name;
    private int num;

    public Account(){}

    public Account(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}