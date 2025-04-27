package practice.DSA.PriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MachineReliability {

    static class Machine {
        int speed;
        int reliability;

        Machine(int speed, int reliability) {
            this.speed = speed;
            this.reliability = reliability;
        }
    }

    public static long maxAccuracy(int[] speed, int[] reliability, int n) {
        int len = speed.length;
        List<Machine> machines = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            machines.add(new Machine(speed[i], reliability[i]));
        }

        // Sort machines by descending reliability
        machines.sort((a, b) -> b.reliability - a.reliability);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long maxAccuracy = 0;
        long speedSum = 0;

        for (Machine machine : machines) {
            minHeap.offer(machine.speed);
            speedSum += machine.speed;

            if (minHeap.size() > n) {
                speedSum -= minHeap.poll(); // remove the smallest speed
            }

            if (minHeap.size() == n) {
                long currentAccuracy = speedSum * machine.reliability;
                maxAccuracy = Math.max(maxAccuracy, currentAccuracy);
            }
        }

        return maxAccuracy;
    }

    // Sample usage
    public static void main(String[] args) {
        int[] speed = {10, 5, 8, 7};
        int[] reliability = {90, 80, 75, 60};
        int n = 3;

        long result = maxAccuracy(speed, reliability, n);
        System.out.println("Max Accuracy: " + result);
    }
}