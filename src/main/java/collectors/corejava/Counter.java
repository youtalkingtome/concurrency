package collectors.corejava;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public void increment() {
        lock.lock(); // acquire
        try {
            count++;
        } finally {
            lock.unlock(); // release
        }
    }

    public int getCount() {
        return count;
    }
}
