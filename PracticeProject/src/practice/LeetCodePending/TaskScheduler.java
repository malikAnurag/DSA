package practice.LeetCodePending;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where each letter represents
 * a different task. Tasks could be done without the original order of the array. Each task is done in one unit of time. For each
 * unit of time, the CPU could complete either one task or just be idle.
 *
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the
 * array), that is that there must be at least n units of time between any two same tasks.
 *
 * You need to return the least number of units of times that the CPU will take to finish all the given tasks.
 *
 * Example 1:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 * Example 2:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 0
 * Output: 6
 * Explanation: On this case any permutation of size 6 would work since n = 0.
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * And so on.
 * Example 3:
 *
 * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * Output: 16
 * Explanation:
 * One possible solution is
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 */
public class TaskScheduler {

    static PriorityQueue<Task> pq;

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G',}, 2));
    }

    public static int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : tasks) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        pq = new PriorityQueue<>((a, b) -> {
            if (a.cool < b.cool) {
                return -1;
            } else if (a.cool > b.cool) {
                return 1;
            } else if (a.total > b.total) {
                return -1;
            } else if (a.total < b.total) {
                return 1;
            } else {
                return 0;
            }
        });

        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            Task temp = new Task(entry.getKey(), entry.getValue(), 0);
            pq.add(temp);
        }

        int result = 0;

        while (!pq.isEmpty()) {
            Task t = pq.poll();
            result++;
            if (t.cool == 0) {
                updatePriorityQueue();
                t.total--;
                t.cool = t.cool + n;
                if (t.total > 0) {
                    pq.add(t);
                }
            } else {
                pq.add(t);
                updatePriorityQueue();
            }
        }
        return result;
    }

    static class Task {
        char name;
        int total;
        int cool;

        Task(char name, int total, int cool) {
            this.name = name;
            this.total = total;
            this.cool = cool;
        }

        public String toString() {
            return this.name + " " + this.total + " " + this.cool;
        }
    }

    public static void updatePriorityQueue() {
        ArrayList<Task> ar = new ArrayList<Task>(pq);
        for (Task t : ar) {
            if (t.cool > 0) {
                t.cool--;
            }
        }
        pq.clear();
        for (Task t : ar) {
            pq.add(t);
        }
    }
}
