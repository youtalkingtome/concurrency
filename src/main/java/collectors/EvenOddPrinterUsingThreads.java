package collectors;

public class EvenOddPrinterUsingThreads {
    private static final Object lock = new Object();
    private static final int MAX_NUMBER = 20;
    private static int current = 1;

    public static void main(String[] args) {
        Thread evenThread = new Thread(() -> printEvenNumbers());
        Thread oddThread = new Thread(() -> printOddNumbers());

        evenThread.start();
        oddThread.start();
    }

    private static void printEvenNumbers() {
        while (current <= MAX_NUMBER) {
            synchronized (lock) {
                if (current % 2 == 1) { // If current is odd, wait
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    System.out.println("Even: " + current);
                    current++;
                    lock.notifyAll(); // Notify the other thread
                }
            }
        }
    }

    private static void printOddNumbers() {
        while (current <= MAX_NUMBER) {
            synchronized (lock) {
                if (current % 2 == 0) { // If current is even, wait
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    System.out.println("Odd: " + current);
                    current++;
                    lock.notifyAll(); // Notify the other thread
                }
            }
        }
    }
}