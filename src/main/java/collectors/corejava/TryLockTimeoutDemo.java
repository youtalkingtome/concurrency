package collectors.corejava;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class TryLockTimeoutDemo {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 1: Lock acquired. Working...");
                try {
                    Thread.sleep(5000); // Holding the lock
                } catch (InterruptedException ignored) {}
            } finally {
                lock.unlock();
                System.out.println("Thread 1: Lock released.");
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2: Trying to acquire lock with timeout...");
            try {
                if (lock.tryLock(2, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Thread 2: Lock acquired.");
                    } finally {
                        lock.unlock();
                        System.out.println("Thread 2: Lock released.");
                    }
                } else {
                    System.out.println("Thread 2: Couldn't acquire lock within 2 seconds.");
                }
            } catch (InterruptedException e) {
                System.out.println("Thread 2 was interrupted.");
            }
        });

        t1.start();
        Thread.sleep(100); // Make sure t1 acquires the lock first
        t2.start();
    }
}
