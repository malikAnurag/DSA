package practice.DSA.Hashing;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
 * reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the
 * itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical
 * order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order
 * than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * One must use all the tickets once and only once.
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 */

public class ReconstructItinerary {

    public static void main(String[] args) {

        String[][] str = new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},
                                        {"ATL","SFO"}};

        List<List<String>> tickets = Arrays.stream(str)
                                            .map(Arrays::asList)
                                            .collect(Collectors.toList());

        List<String> list = getItinerary(tickets);

        for(String s : list)
            System.out.print(s + " ");
    }

    public static List<String> getItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue> hashMap = new HashMap<>();

        for(List<String> al : tickets) {
            hashMap.computeIfAbsent(al.get(0), k -> new PriorityQueue<String>()).add(al.get(1));
        }

        List<String> result = new ArrayList<>();
        Stack<String> st = new Stack();
        st.push("JFK");

        while(!st.isEmpty()) {
            String src = st.peek();

            if(hashMap.containsKey(src) && !hashMap.get(src).isEmpty()) {
                st.push((String) hashMap.get(src).poll());
            }
            else {
                result.add(0, st.pop());
            }
        }

        return result;
    }
}
