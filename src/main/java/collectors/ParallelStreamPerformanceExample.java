package collectors;

import java.util.Random;

public class ParallelStreamPerformanceExample {

    public static void main(String[] args) {
        // Generate a large array of random integers
        int size = 10_000_000;
        int[] numbers = new Random().ints(size, 1, 100).toArray();

        // Sequential sum of squares
        long startTimeSequential = System.nanoTime();
        long sumSequential = java.util.Arrays.stream(numbers)
                .mapToLong(i -> i * i)
                .sum();
        long endTimeSequential = System.nanoTime();
        System.out.println("Sequential Sum: " + sumSequential);
        System.out.println("Time taken (Sequential): " + ((endTimeSequential - startTimeSequential) / 1_000_000) + " ms");

        // Parallel sum of squares
        long startTimeParallel = System.nanoTime();
        long sumParallel = java.util.Arrays.stream(numbers)
                .parallel()
                .mapToLong(i -> i * i)
                .sum();
        long endTimeParallel = System.nanoTime();
        System.out.println("Parallel Sum: " + sumParallel);
        System.out.println("Time taken (Parallel): " + ((endTimeParallel - startTimeParallel) / 1_000_000) + " ms");
    }
}
