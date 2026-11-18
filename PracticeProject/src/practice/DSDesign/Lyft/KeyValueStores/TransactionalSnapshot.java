package practice.DSDesign.Lyft.KeyValueStores;


import java.util.*;

/**
 * Two Possible Designs :
 *                       1. Snapshot Based
 *                       2. Log Based
 */

public class TransactionalSnapshot {

    private Map<String, String> hm;
    private final Deque<Map<String, String>> transactionSnapshots;

    public TransactionalSnapshot() {
        hm = new HashMap<>();
        transactionSnapshots = new ArrayDeque<>();
    }

    // Save the current database state.
    public void begin() {
        transactionSnapshots.push(new HashMap<>(hm));
    }

    // Restore the state before the most recent BEGIN.
    public void rollback() {
        if(transactionSnapshots.isEmpty()) throw new IllegalStateException();

        hm = transactionSnapshots.pop();
    }

    // Keep the current changes
    // Discard the most recent saved snapshot
    // Calls to commit() or rollback() without an active transaction throw IllegalStateException
    public void commit() {

        if(transactionSnapshots.isEmpty()) throw new IllegalStateException();

        transactionSnapshots.pop();
    }

    // Store or overwrite a value.
    public void set(String key, String value) {
        hm.put(key, value);
    }

    // Return the current value, or null if absent.
    public String get(String key) {
        return hm.get(key);
    }

    // Remove the key if present.
    public void delete(String key) {
        hm.remove(key);
    }

    // Return the number of keys having this value.
    public int numWithValue(String value) {
        return (int) hm.values().stream().filter(v -> Objects.equals(v, value)).count();
    }

    public static void main(String[] args) {

        TransactionalSnapshot db = new TransactionalSnapshot();

        db.set("A", "10");

        // t1
        db.begin(); // insert in stack

        db.set("A", "20");

            // t2
            db.begin();
                db.set("A", "30");
            db.rollback();

        System.out.println(db.get("A"));
    }
}
