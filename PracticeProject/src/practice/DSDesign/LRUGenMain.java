package practice.DSDesign;

public class LRUGenMain {

    public static void main(String[] args) {

        LRUGeneric<String,String> cache = new LRUGeneric<>(2);

        cache.put("key", "value");
        cache.put("key1", "value1");

        System.out.println(cache.get("key1"));

    }

}
