package collectors.corejava;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterComparisonDemo {

    private static volatile int volatileCount = 0;
    private static final AtomicInteger atomicCount = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 1000;
        Thread[] threads = new Thread[numberOfThreads];

        // Each thread will increment both counters
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                // Volatile increment (not atomic!)
                volatileCount++;

                // Atomic increment (correct)
                atomicCount.incrementAndGet();
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread t : threads) {
            t.join();
        }

        // Results
        System.out.println("Final volatileCount (should be 1000): " + volatileCount);
        System.out.println("Final atomicCount   (should be 1000): " + atomicCount.get());
    }
}

