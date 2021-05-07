package practice.DSDesign;

public class LruNode {
    public int key;
    public int val;
    public LruNode prev;
    public LruNode next;

    public LruNode(int key, int val) {
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}
