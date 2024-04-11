package collectors;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

public class LockFreeStackTest {
    private final LockFreeStack<Integer> stack = new LockFreeStack<>();

    @Test
    public void testConcurrentPushAndPop() throws InterruptedException {
        int numberOfThreads = 10;
        int numberOfOperations = 1000;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        AtomicInteger pushCount = new AtomicInteger();
        AtomicInteger popCount = new AtomicInteger();

        // Concurrent push operations
        for (int i = 0; i < numberOfThreads / 2; i++) {
            executor.submit(() -> {
                for (int j = 0; j < numberOfOperations; j++) {
                    stack.push(j);
                    pushCount.incrementAndGet();
                }
                latch.countDown();
            });
        }

        // Concurrent pop operations
        for (int i = 0; i < numberOfThreads / 2; i++) {
            executor.submit(() -> {
                while (popCount.get() < numberOfOperations) {
                    Integer item = stack.pop();
                    if (item != null) {
                        popCount.incrementAndGet();
                    }
                }
                latch.countDown();
            });
        }

        latch.await(); // Wait for all threads to finish
        executor.shutdown();

        // Verify the stack is empty and counts match
       // assertTrue(stack.isEmpty());
        assertEquals(pushCount.get(), popCount.get());
    }
}
