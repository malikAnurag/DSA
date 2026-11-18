package practice.DSDesign.Lyft.KeyValueStores;


import java.util.*;

/**
 * Design an in-memory key-value store that maintains historical versions of its data.
 * <p>
 * Unlike LC 981, the caller does not supply timestamps. Instead, the database assigns a globally increasing version number for every mutation, regardless of which key changes.
 * <p>
 * Implement the following API in Java:
 */

public class Versioned { // Space : O (N + K) // K - distinct keys, N - total mutations

    /**************************************************************************************/
    static class VersionedValue {
        int version;
        String val; // null represents deletion

        VersionedValue(int ver, String val) {
            this.version = ver;
            this.val = val;
        }

        @Override
        public String toString() {
            return "VersionedValue{" +
                    "version=" + version +
                    ", val='" + val + '\'' +
                    '}';
        }
    }
    /**************************************************************************************/

    private int globalVersion;
    private final Map<String, List<VersionedValue>> hm; // key -> [version + value]

    Versioned() {
        globalVersion = 0;
        hm = new HashMap<>();
    }

    // Stores a value and returns the new global version.
    public int set(String key, String value) { // O(1) amortized
        Objects.requireNonNull(key);
        Objects.requireNonNull(value);

        globalVersion++;
        hm.computeIfAbsent(key, k -> new ArrayList<>()).add(new VersionedValue(globalVersion, value));
        return globalVersion;
    }

    // Gets the value of a key at the specified version.
    public String get(String key, int version) { // O(Log N)

        if (version > globalVersion || version < 0) {
            throw new IllegalArgumentException("Invalid Version");
        }

        if (!hm.containsKey(key)) return null;

        List<VersionedValue> al = hm.get(key);

        int l = 0, r = al.size() - 1;
        int idx = -1;

        while (l <= r) {

            int m = l + (r - l) / 2;
            int ver = al.get(m).version;

            if (ver <= version) {
                idx = m; // stores the last valid candidate rather than assuming l is the answer
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return idx == -1 ? null : al.get(idx).val;
    }

    // Returns the latest value.
    public String getLatest(String key) {

        if (!hm.containsKey(key)) return null;

        List<VersionedValue> al = hm.get(key);

        return al.get(al.size() - 1).val;
    }

    // Deletes a key and returns the new global version.
    public int delete(String key) {
        globalVersion++;
        hm.computeIfAbsent(key, k -> new ArrayList<>()).add(new VersionedValue(globalVersion, null));
        return globalVersion;
    }

    // Returns the current global version.
    public int getCurrentVersion() {
        return globalVersion;
    }

    public static void main(String[] args) {

        Versioned db = new Versioned();

        db.set("A", "one");
        db.set("B", "two");
        db.set("C", "three");
        System.out.println(db.get("A", 3));
    }
}