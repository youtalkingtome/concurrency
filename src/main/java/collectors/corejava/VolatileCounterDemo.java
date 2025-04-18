package collectors.corejava;

public class VolatileCounterDemo {
    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 1000;

        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                count++; // not atomic!
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join(); // wait for all threads to finish
        }

        System.out.println("Final count (should be 1000): " + count);
    }
}


