package practice.ConcurrentSystems.rateLimiter.fineGrained;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FineGrainedRateLimiterMain {

    public static void main(String[] args) throws InterruptedException {

        FineGrainedRateLimiter rateLimiter = new FineGrainedRateLimiter(2.0, 3);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        String[] clients = {"client-A", "client-B"};

        for (String clientId : clients) {
            for (int request = 1; request <= 5; request++) {
                final int requestNumber = request;
                executor.submit(() -> {
                    boolean allowed = rateLimiter.tryAcquire(clientId);
                    System.out.printf("%s request-%d -> %s%n", clientId, requestNumber, allowed ? "allowed" : "rate limited");
                });
            }
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        Thread.sleep(1500);

        System.out.println("\nAfter waiting for token refill:");

        for (String clientId : clients) {
            boolean allowed = rateLimiter.tryAcquire(clientId);
            System.out.printf("%s follow-up -> %s%n", clientId, allowed ? "allowed" : "rate limited");
        }
    }
}
