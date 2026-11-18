package practice.DSDesign.Lyft.KeyValueStores;


import java.util.*;

/**
 * Two Possible Designs :
 * 1. Snapshot Based
 * 2. Log Based
 */

public class TransactionalLog {
    /**************************************************************************************/
    static class PreviousValue {
        boolean existed;
        String value;

        PreviousValue(String v, boolean existed) {
            this.value = v;
            this.existed = existed;
        }
    }
    /**************************************************************************************/

    // V - distinct values in DB
    // U - no of undo log entries across active transactions

    // ADDITIONAL SPACE : O (V + U)

    private final Map<String, String> hm; // O (N) space
    private final Map<String, Integer> counts;
    private final Deque<Map<String, PreviousValue>> transactionLog;

    public TransactionalLog() {
        hm = new HashMap<>();
        counts = new HashMap<>();
        transactionLog = new ArrayDeque<>();
    }

    // Save the current database state.
    public void begin() {
        transactionLog.push(new HashMap<>());
    }

    // Restore the state before the most recent BEGIN
    public void rollback() { // O (M) ; M = distinct Keys in the current transaction's undo log

        if (transactionLog.isEmpty()) throw new IllegalStateException();

        Map<String, PreviousValue> currTxnLog = transactionLog.pop();

        for (Map.Entry<String, PreviousValue> entry : currTxnLog.entrySet()) {

            PreviousValue pV = entry.getValue();
            String key = entry.getKey();

            if (pV.existed) { // Only restore keys that previously existed
                put(key, pV.value);
            } else { // Remove the ones that didn't exist
                remove(key);
            }
        }
    }

    // Keep the current changes
    // Discard the most recent saved snapshot
    // Calls to commit() or rollback() without an active transaction throw IllegalStateException
    public void commit() {

        if (transactionLog.isEmpty()) throw new IllegalStateException();

        Map<String, PreviousValue> childLog = transactionLog.pop();

        if (!transactionLog.isEmpty()) { // if parent exists

            Map<String, PreviousValue> parentLog = transactionLog.peek();

            /* PARENT TXN SHOULD RETAIN THE ORIGINAL VALUE OF A KEY IF IT'S CHILD ALSO MODIFIED THAT KEY */
            for (Map.Entry<String, PreviousValue> entry : childLog.entrySet()) {
                parentLog.putIfAbsent(entry.getKey(), entry.getValue());
            }
        }
    }

    // Store or overwrite a value.
    public void set(String key, String value) {

        pushLogs(key);

        // Update the key
        put(key, value);
    }

    private void pushLogs(String key) {

        if (!transactionLog.isEmpty()) { // txn exists

            // push the logs
            Map<String, PreviousValue> currTxnLog = transactionLog.peek();

            assert currTxnLog != null;

            /* WITHIN A TXN, RECORD THE KEY'S ORIGINAL STATE ONLY */
            // Undo log preserves the key even if the key is modified 100 times!!
            if (!currTxnLog.containsKey(key)) {
                boolean existed = hm.containsKey(key);
                currTxnLog.put(key, new PreviousValue(hm.get(key), existed));
            }
        }
    }

    // Return the current value, or null if absent.
    public String get(String key) {
        return hm.get(key);
    }

    // Remove the key if present.
    public void delete(String key) {
        pushLogs(key);
        remove(key);
    }

    // Return the number of keys having this value.
    public int numWithValue(String value) {
        return counts.getOrDefault(value, 0);
    }

    /**************************************************** HELPER METHODS ******************************************************************/

    private void put(String key, String value) {

        if (hm.containsKey(key)) {
            String oldValue = hm.get(key);

            if (value.equals(oldValue)) {
                return;
            }
            decrementCount(oldValue);
        }

        hm.put(key, value);
        counts.putIfAbsent(value, 0);
        counts.put(value, counts.get(value) + 1);
    }

    private void decrementCount(String val) {

        int count = counts.get(val);

        if (count == 1) {
            counts.remove(val);
        } else {
            counts.put(val, count - 1);
        }
    }

    private void remove(String key) {
        if (hm.containsKey(key)) {
            String value = hm.get(key);
            decrementCount(value);
            hm.remove(key);
        }
    }

    /**********************************************************************************************************************/

    public static void main(String[] args) {

        TransactionalLog db = new TransactionalLog();

        db.set("A", "10");

        // t1
        db.begin();

        db.set("A", "20");

        // t2
        db.begin();
        db.set("A", "30");
        db.commit();
        db.rollback();

        System.out.println(db.get("A"));
    }
}
