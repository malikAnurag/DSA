package practice.DSA.String.advanced;

import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> hm = new HashMap();

        for (String word : words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<String>(
                (a, b) -> !hm.get(a).equals(hm.get(b)) ? hm.get(a) - hm.get(b) : b.compareTo(a)
        );

        for (String word : hm.keySet()) {

            pq.add(word);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> al = new ArrayList();

        while (!pq.isEmpty()) {
            al.add(pq.poll());
        }

        Collections.reverse(al);
        return al;

    }
}
