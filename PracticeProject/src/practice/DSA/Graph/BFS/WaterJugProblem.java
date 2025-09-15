package practice.DSA.Graph.BFS;

import java.util.*;

public class WaterJugProblem {

    public boolean canMeasureWaterEasy(int x, int y, int target) {

        if(x + y < target) {
            return false;
        }

        return target % gcd(x,y) == 0;
    }

    private int gcd(int a, int b) {

        if(a == 0)
            return b;

        return gcd(b % a, a);
    }

    public boolean canMeasureWater(int x, int y, int target) {

        if (x + y < target) return false;

        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {

            // Get the current state of the jugs
            int[] state = queue.poll();
            int a = state[0], b = state[1];

            // If we've already visited this state, skip it
            String key = a + "," + b;

            if (visited.contains(key))
                continue;

            visited.add(key);

            // Check if we reached the target
            if (a == target || b == target || a + b == target) {
                return true;
            }

            // Generate all possible next states
            List<int[]> nextStates = new ArrayList<>();

            // Fill jug x or y
            nextStates.add(new int[]{x, b});
            nextStates.add(new int[]{a, y});

            // Empty jug x or y
            nextStates.add(new int[]{0, b});
            nextStates.add(new int[]{a, 0});

            // Pour x -> y
            int pourXY = Math.min(a, y - b);
            nextStates.add(new int[]{a - pourXY, b + pourXY});

            // Pour y -> x
            int pourYX = Math.min(b, x - a);
            nextStates.add(new int[]{a + pourYX, b - pourYX});

            queue.addAll(nextStates);
        }
        return false;
    }
}
