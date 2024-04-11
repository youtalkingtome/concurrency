package collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelStreamsDemo {

        public static void main(String[] args) {
            // Create a large list of random integers
            List<Integer> numbers = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 1_000_000; i++) {
                numbers.add(random.nextInt(100));
            }

            // Calculate the sum using parallel stream
            long startTime = System.currentTimeMillis();
            int sum = numbers.stream().reduce(0, Integer::sum);
            long endTime = System.currentTimeMillis();

            System.out.println("Sum: " + sum);
            System.out.println("Time taken with parallel stream: " + (endTime - startTime) + " ms");
        }
}
