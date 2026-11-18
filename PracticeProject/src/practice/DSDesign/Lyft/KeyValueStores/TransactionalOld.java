package practice.DSDesign.Lyft.KeyValueStores;


import java.util.*;


/**
 * 1. Database: Use HashMap<String, String> to store current key-value pairs.
 * 2. Transactions: Use Deque<Map<String, String>> as a stack of undo logs.
 * 3. Begin: Push a new empty HashMap onto the stack.
 * 4. Set/Unset: Save the original value once in the top transaction using peek(), then update the database.
 * 5. Get: Directly read from the database.
 * 6. Rollback: Pop the top transaction and restore original values (null means remove the key).
 * 7. Commit: Pop the top transaction and merge its undo log into the parent without overwriting existing entries.
 * 8. Count: Iterate through database values and count matches.
 */

public class TransactionalOld {

    // 1. The current visible database.
    private final Map<String, String> database = new HashMap<>();

    // 2. Stack of transaction undo logs.
    // Each map stores: key -> value BEFORE modification.
    // null means the key did not exist before.
    private final Deque<Map<String, String>> transactions = new ArrayDeque<>();


    // Get the current value of a key.
    public String get(String key) {
        return database.get(key);
    }


    // Insert or update a key.
    public void set(String key, String value) {

        Objects.requireNonNull(key);
        Objects.requireNonNull(value);

        // Save old value so we can undo this change.
        saveOriginalValue(key);

        // Make the new value immediately visible.
        database.put(key, value);
    }


    // Delete a key.
    public void unset(String key) {

        Objects.requireNonNull(key);

        // Save old value before deleting.
        saveOriginalValue(key);

        database.remove(key);
    }


    // Start a new transaction.
    public void begin() {
        // Push an empty undo log onto the stack.
        transactions.push(new HashMap<>());
    }


    // Undo the innermost transaction.
    public boolean rollback() {

        if (transactions.isEmpty()) {
            return false;
        }

        // Remove the most recent transaction.
        Map<String, String> changes = transactions.pop();

        // Restore every key to its original value.
        for (Map.Entry<String, String> entry : changes.entrySet()) {

            String key = entry.getKey();
            String oldValue = entry.getValue();

            if (oldValue == null) {
                // Key did not exist before this transaction.
                database.remove(key);
            } else {
                // Restore the value from before the change.
                database.put(key, oldValue);
            }
        }
        return true;
    }


    // Commit the innermost transaction.
    public boolean commit() {

        if (transactions.isEmpty()) {
            return false;
        }

        // Remove the most recent transaction.
        Map<String, String> child = transactions.pop();

        // If there is a parent transaction, merge undo logs.
        if (!transactions.isEmpty()) {

            Map<String, String> parent = transactions.peek();

            for (Map.Entry<String, String> entry : child.entrySet()) {

                String key = entry.getKey();

                // Do not overwrite an original value already recorded by the parent.
                if (!parent.containsKey(key)) {
                    parent.put(key, entry.getValue());
                }
            }
        }

        // No database update needed because set/unset already modified the visible database.
        return true;
    }


    // Remember the original value before modifying a key.
    private void saveOriginalValue(String key) {

        // No active transaction: no undo information needed.
        if (transactions.isEmpty()) {
            return;
        }

        Map<String, String> current = transactions.peek();

        // Only save once per transaction. containsKey is important because the old value might be null (key didn't exist).
        if (!current.containsKey(key)) {
            current.put(key, database.get(key));
        }
    }


    // Count how many keys currently have a given value.
    public int count(String value) {

        int count = 0;

        for (String storedValue : database.values()) {
            if (Objects.equals(storedValue, value)) {
                count++;
            }
        }
        return count;
    }
}

