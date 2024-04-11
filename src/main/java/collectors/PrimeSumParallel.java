package collectors;

import java.util.stream.IntStream;

public class PrimeSumParallel {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long sum = IntStream.iterate(2, i -> i + 1) // Generate an infinite stream of integers starting from 2
                .parallel() // Convert the stream to parallel
                .filter(PrimeSumParallel::isPrime) // Filter to get only prime numbers
                .limit(1000) // Limit to the first 100,000 primes
                .asLongStream() // Convert to a LongStream for a larger sum
                .sum(); // Sum the primes
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime; // elapsed time in milliseconds
        System.out.println("Elapsed Time in milliseconds Summation Using Parallel Stream: " + elapsedTime);

        System.out.println("The sum of the first 100,000 prime numbers (using parallel stream) is: " + sum);
    }

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
