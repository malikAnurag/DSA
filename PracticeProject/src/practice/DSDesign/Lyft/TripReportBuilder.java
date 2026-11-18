package practice.DSDesign.Lyft;

/**
 * Given trip records in this format:
 * <p>
 * 2024-03-08T09:15:00, trip_8841, driver_17, Toronto, 12.4, 18.50, COMPLETED
 * 2024-03-08T09:40:00, trip_8842, driver_03, Ottawa, 5.1, 0.00, CANCELLED
 * <p>
 * Fields: timestamp, trip_id, driver_id, city, distance_km, fare, status
 * <p>
 * Implement a TripReport class with:
 * • addRecord(line): parses and stores a record, and safely ignores malformed lines
 * • getCityRevenue(city): total fare from completed trips in that city
 * • getPeakHour(city): the hour of day (0-23) with the most trips in that city
 * • getTopDrivers(n): the top N drivers by total completed fare
 */

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.math.BigDecimal;

public class TripReportBuilder {

    // Represents a validated trip record.
    record Trip(LocalDateTime timestamp, String tripId, String driverId, String city, double distance, BigDecimal fare, String status) {}

    // Store all valid trip records.
    private final List<Trip> trips = new ArrayList<>();

    // City -> Total revenue from completed trips
    private final Map<String, BigDecimal> cityRevenue = new HashMap<>();

    // City -> Number of trips for each hour (0-23).
    private final Map<String, int[]> cityHours = new HashMap<>();

    // Driver -> Total revenue from completed trips.
    private final Map<String, BigDecimal> driverRevenue = new HashMap<>();


    // 1. Parse and store a trip record. Ignore malformed records without throwing exceptions.
    // L - length of input record
    public void addRecord(String line) { // Time : O (L)

        if (line == null) return;

        String[] parts = line.split(",", -1);

        if (parts.length != 7)
            return;

        try {
            // Parse fields.
            LocalDateTime time = LocalDateTime.parse(parts[0].trim());

            String tripId = parts[1].trim();
            String driver = parts[2].trim();
            String city = parts[3].trim();

            double distance = Double.parseDouble(parts[4].trim());
            BigDecimal fare = new BigDecimal(parts[5].trim());
            String status = parts[6].trim();

            // Validate all fields BEFORE updating state.
            if (tripId.isEmpty() || driver.isEmpty() || city.isEmpty() || !Double.isFinite(distance) || distance < 0 ||
                    fare.signum() < 0 || (!status.equals("COMPLETED") && !status.equals("CANCELLED"))) {
                return;
            }

            // Store the valid trip.
            trips.add(new Trip(time, tripId, driver, city, distance, fare, status));

            // Count all valid trips, including cancelled ones.
            cityHours.putIfAbsent(city, new int[24]);
            cityHours.get(city)[time.getHour()]++;

            // Only completed trips contribute to revenue.
            if (status.equals("COMPLETED")) {
                // Update total revenue for the city.
                cityRevenue.put(city, cityRevenue.getOrDefault(city, BigDecimal.ZERO).add(fare));

                // Update total revenue for the driver.
                driverRevenue.put(driver, driverRevenue.getOrDefault(driver, BigDecimal.ZERO).add(fare));
            }

        } catch (DateTimeParseException | NumberFormatException e) {
            // Ignore malformed timestamps or numbers.
        }
    }


    // 2. Return total completed-trip revenue for a city. Expected Time: O(1), Space: O(1)
    public BigDecimal getCityRevenue(String city) {
        return cityRevenue.getOrDefault(city, BigDecimal.ZERO);
    }


    // 3. Return the hour with the highest trip count.
    // Time: O(24) = O(1), Space: O(1)
    public int getPeakHour(String city) {

        int[] hours = cityHours.get(city);

        // No trips found for this city.
        if (hours == null) return -1;

        int peak = 0;

        // Find the hour with maximum trips. Using > ensures earliest hour wins ties.
        for (int i = 1; i < 24; i++) {
            if (hours[i] > hours[peak]) {
                peak = i;
            }
        }
        return peak;
    }


    // 4. Return Top N drivers by completed-trip revenue. Uses a MIN-HEAP of size at most N.
    // D - drivers with completed trips, K = min(n, D)
    public List<String> getTopDrivers(int n) { // O (D Log(K + 1) + K Log(K + 1)), Space : O (K)

        if (n <= 0)
            return new ArrayList<>();

        // Min-heap: driver with the LOWEST revenue at top.
        // On ties, alphabetically larger ID is considered worse and gets removed first.
        PriorityQueue<String> minHeap = new PriorityQueue<>(
                (a, b) -> {

                    int cmp = driverRevenue.get(a).compareTo(driverRevenue.get(b));

                    if (cmp != 0) return cmp;

                    return b.compareTo(a);
                }
        );

        // Process each driver exactly once.
        for (String driver : driverRevenue.keySet()) {

            minHeap.offer(driver);

            // Keep only the best N drivers. Remove the lowest-ranked driver.
            if (minHeap.size() > n) {
                minHeap.poll();
            }
        }

        List<String> result = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            // Removes the lowest-revenue selected driver first.
            result.add(minHeap.poll());
        }
        // Reverse to get highest revenue first.
        Collections.reverse(result);
        return result;
    }
}

