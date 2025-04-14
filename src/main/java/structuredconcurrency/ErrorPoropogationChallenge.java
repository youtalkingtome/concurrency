package structuredconcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ErrorPoropogationChallenge {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            throw new RuntimeException("Task 1 failed!");
        });

        executor.submit(() -> {
            System.out.println("Task 2 completed.");
        });

        executor.shutdown();
        System.out.println("Executor shutdown complete.");
    }
}
