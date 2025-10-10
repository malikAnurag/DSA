package companies.amazon.arraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WarehouseDispatch {

    public static void main(String[] args) {
        int[] warehouse = {10, 6, 12, 8, 15, 1};
        int dispatch1 = 2;
        int dispatch2 = 3;
        int skips = 3;

        int result = maxCredits(warehouse, dispatch1, dispatch2, skips);
        System.out.println("Maximum Credits: " + result);
    }

    public static int maxCredits(int[] warehouse, int dispatch1, int dispatch2, int totalSkips) {
        int credits = 0;
        List<Integer> skipCosts = new ArrayList<>();

        for (int units : warehouse) {
            int result = simulate(units, dispatch1, dispatch2, 0);
            if (result != -1) {
                credits++; // No skips needed
            } else {
                int skipNeeded = simulateWithSkipCounting(units, dispatch1, dispatch2);
                if (skipNeeded != -1) {
                    skipCosts.add(skipNeeded);
                }
            }
        }

        // Use skips greedily on warehouses requiring the fewest
        Collections.sort(skipCosts);
        for (int cost : skipCosts) {
            if (totalSkips >= cost) {
                totalSkips -= cost;
                credits++;
            } else {
                break;
            }
        }

        return credits;
    }

    // Simulates with 0 skips, returns -1 if not possible to empty
    private static int simulate(int units, int d1, int d2, int allowedSkips) {
        boolean yourTurn = true;
        int skipsUsed = 0;

        while (units > 0) {
            if (yourTurn) {
                units -= d1;
            } else {
                if (skipsUsed < allowedSkips) {
                    skipsUsed++;
                    // coworker skips
                } else {
                    units -= d2;
                }
            }
            yourTurn = !yourTurn;
        }

        return units <= 0 ? skipsUsed : -1;
    }

    // Tries to simulate with increasing skips and returns the actual number needed
    private static int simulateWithSkipCounting(int units, int d1, int d2) {
        int maxSkips = 1000; // Enough for even large values
        for (int allowedSkips = 1; allowedSkips <= maxSkips; allowedSkips++) {
            int result = simulate(units, d1, d2, allowedSkips);
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }
}