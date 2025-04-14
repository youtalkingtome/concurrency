package structuredconcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskCancellationExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<?> task1 = executor.submit(() -> {
            try {
                Thread.sleep(3000); // Simulate a long task
                System.out.println("Task 1 completed.");
            } catch (InterruptedException e) {
                System.out.println("Task 1 interrupted.");
            }
        });

        Future<?> task2 = executor.submit(() -> {
            throw new RuntimeException("Task 2 failed!");
        });

        try {
            task2.get(); // Throws an exception
        } catch (Exception e) {
            System.out.println("Task 2 failed, canceling Task 1.");
            task1.cancel(true); // Manual cancellation required
        } finally {
            executor.shutdown();
        }
    }
}