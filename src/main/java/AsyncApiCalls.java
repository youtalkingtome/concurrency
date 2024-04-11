import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.time.Duration;
import java.time.Instant;

public class AsyncApiCalls {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Instant start = Instant.now();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> apiCall1());
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> apiCall2());

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);

        combinedFuture.get(); // Wait for all to complete

        String result1 = future1.get();
        String result2 = future2.get();

        System.out.println("Result from API 1: " + result1);
        System.out.println("Result from API 2: " + result2);
        Instant end = Instant.now();
        System.out.println("Time taken for Main Thread: " + Duration.between(start, end).toMillis() + " ms");
    }

    private static String apiCall1() {
        Instant start = Instant.now();
        // Simulate API call
        try {
            Thread.sleep(2000); // Simulating delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Instant end = Instant.now();
        System.out.println("Time taken for API 1: " + Duration.between(start, end).toMillis() + " ms");
        return "Response from API 1";
    }

    private static String apiCall2() {
        Instant start = Instant.now();
        // Simulate API call
        try {
            Thread.sleep(3000); // Simulating delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Instant end = Instant.now();
        System.out.println("Time taken for API 2: " + Duration.between(start, end).toMillis() + " ms");
        return "Response from API 2";
    }
}
