package collectors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenOddPrinter {
    public static void main(String[] args) {
        final int maxNumber = 20; // Define the max number to print to
        ExecutorService executor = Executors.newFixedThreadPool(2); // Create a thread pool with two threads

        Runnable printEven = () -> {
            for (int i = 2; i <= maxNumber; i += 2) { // Start from 2 for even numbers
                System.out.println("Even: " + i);
                try {
                    Thread.sleep(100); // Sleep to simulate some computation and make the output more readable
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore the interrupted status
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            }
        };

        Runnable printOdd = () -> {
            for (int i = 1; i <= maxNumber; i += 2) { // Start from 1 for odd numbers
                System.out.println("Odd: " + i);
                try {
                    Thread.sleep(100); // Sleep to simulate some computation and make the output more readable
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore the interrupted status
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            }
        };

        CompletableFuture<Void> evenFuture = CompletableFuture.runAsync(printEven, executor);
        CompletableFuture<Void> oddFuture = CompletableFuture.runAsync(printOdd, executor);

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(evenFuture, oddFuture);
        combinedFuture.join(); // Wait for both tasks to complete

        executor.shutdown(); // Shutdown the executor service
    }
}