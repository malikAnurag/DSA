package practice.DSDesign;

import java.util.*;

public class InvertedIndex {

    // Map from term -> set of documents containing that term
    private final Map<String, Set<String>> map;

    public InvertedIndex() {
        map = new HashMap<>();
    }

    // Insert a document into the index
    public void insert(String doc) {

        String[] words = doc.toLowerCase().split("\\W+");

        for (String word : words) {
            if (word.isEmpty())
                continue; // skip empty tokens
            map.computeIfAbsent(word, k -> new HashSet<>()).add(doc);
        }
    }

    // Search for documents containing a single term
    public List<String> search(String term) {
        Set<String> result = map.getOrDefault(term.toLowerCase(), Collections.emptySet());
        return new ArrayList<>(result);
    }

    // Delete a document from the index
    public void delete(String doc) {

        // Iterate entries so we have the key, and use iterator.remove() to avoid CME
        Iterator<Map.Entry<String, Set<String>>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Set<String>> e = it.next();
            Set<String> docs = e.getValue();
            docs.remove(doc);
            if (docs.isEmpty()) {
                it.remove(); // remove the term key safely
            }
        }
    }

    // Search for documents containing BOTH term1 and term2
    public List<String> andSearch(String term1, String term2) {
        Set<String> set1 = map.getOrDefault(term1.toLowerCase(), Collections.emptySet());
        Set<String> set2 = map.getOrDefault(term2.toLowerCase(), Collections.emptySet());
        Set<String> result = new HashSet<>(set1);
        result.retainAll(set2); // intersection
        return new ArrayList<>(result);
    }
}

