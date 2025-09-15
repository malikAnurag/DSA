package practice.DSA.Array2D.Advanced;

import java.util.*;

public class OrderDelayCalculator {

    public static int averageDelay(int[][] orders) {

        Arrays.sort(orders, (a,b) -> a[1] - b[1]);

        int currentTime = 0;
        int totalDelay = 0;

        for (int[] order : orders) {
            int processingTime = order[0];
            int arrivalTime = order[1];

            if (currentTime < arrivalTime) {
                currentTime = arrivalTime;
            }

            currentTime += processingTime;
            int delay = currentTime - arrivalTime;
            totalDelay += delay;
            System.out.println("Arrival : " + arrivalTime + ", Processing : " + processingTime + ", current time :" + currentTime + ", Delay : " + delay);
        }
        return totalDelay / orders.length;
    }

    public static void main(String[] args) {
        int[][] orders = { {4, 1}, {5, 2}, {2, 3} };
        int avgDelay = averageDelay(orders);
        System.out.println("Average Delay: " + avgDelay);
    }
}

