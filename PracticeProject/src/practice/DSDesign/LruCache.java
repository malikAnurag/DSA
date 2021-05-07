package practice.DSDesign;

import java.util.HashMap;
import java.util.Map;

public class LruCache {

    Map<Integer, LruNode> map;
    LruNode start;
    LruNode end;
    int capacity;

    public LruCache(int capacity) {
        map = new HashMap<>();
        start = new LruNode(0, 0);
        end = new LruNode(0, 0);
        this.capacity = capacity;
        start.next = end;
        end.prev = start;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LruNode node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.val;
        }
        return -1;
    }

    private void addNode(LruNode node) {
        node.next = start.next;
        start.next = node;
        node.prev = start;
        node.next.prev = node;
    }

    private void removeNode(LruNode node) {
        LruNode temp = node.next;
        node.prev.next = temp;
        temp.prev = node.prev;
    }

    public void set(int key, int value) {
        LruNode node = new LruNode(key, value);

        if (map.containsKey(key)) {
            LruNode temp = map.get(key);
            removeNode(temp);
        } else {
            if (capacity == map.size()) {
                LruNode temp = end.prev;
                removeNode(temp);
                map.remove(temp.key);
            }
        }
        addNode(node);
        map.put(key, node);
    }
}
