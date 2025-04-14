package structuredconcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskOutlivingScopeExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit tasks
        executor.submit(() -> {
            try {
                Thread.sleep(5000); // Simulate long-running task
                System.out.println("Task 1 completed.");
            } catch (InterruptedException e) {
                System.out.println("Task 1 interrupted.");
            }
        });

        executor.submit(() -> System.out.println("Task 2 completed."));

        // Shutdown executor immediately after task submission
        executor.shutdownNow(); // Interrupts running tasks
        System.out.println("Executor shut down.");
    }
}

