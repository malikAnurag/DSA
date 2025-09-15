package practice.DSDesign;

import java.util.HashMap;
import java.util.Map;

public class LRUGeneric<K, V> {

    private final Map<K, ListNode<K, V>> map;
    private final ListNode<K, V> start;
    private final ListNode<K, V> end;
    private final int capacity;

    public LRUGeneric(int capacity) {
        this.map = new HashMap<>();
        this.start = new ListNode<>(null, null);
        this.end = new ListNode<>(null, null);
        start.next = end;
        end.prev = start;
        this.capacity = capacity;
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        ListNode<K, V> node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.value;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            ListNode<K, V> existingNode = map.get(key);
            removeNode(existingNode);
        } else if (map.size() == capacity) {
            ListNode<K, V> leastUsed = end.prev;
            removeNode(leastUsed);
            map.remove(leastUsed.key);
        }

        ListNode<K, V> newNode = new ListNode<>(key, value);
        addNode(newNode);
        map.put(key, newNode);
    }

    private void removeNode(ListNode<K, V> node) {
        ListNode<K, V> nextNode = node.next;
        ListNode<K, V> prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void addNode(ListNode<K, V> node) {
        ListNode<K, V> nextNode = start.next;
        start.next = node;
        node.prev = start;
        node.next = nextNode;
        nextNode.prev = node;
    }
}

class ListNode<K, V> {
    K key;
    V value;
    ListNode<K, V> prev;
    ListNode<K, V> next;

    ListNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}