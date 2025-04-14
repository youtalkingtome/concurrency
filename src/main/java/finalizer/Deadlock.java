package finalizer;

class DeadLockConstrcut {
    void methodA(DeadLockConstrcut r1, DeadLockConstrcut r2) {
        synchronized (r1) {  // Lock the first resource
            System.out.println(Thread.currentThread().getName() + " locked " + r1);
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (r2) {  // Lock the second resource
                System.out.println(Thread.currentThread().getName() + " locked " + r2);
            }
        }
    }
    }


public class Deadlock {
    public static void main(String[] args) {
        DeadLockConstrcut r1 = new DeadLockConstrcut();
        DeadLockConstrcut r2 = new DeadLockConstrcut();

        Thread t1 = new Thread(() -> r1.methodA(r1, r2), "Thread-1");
        Thread t2 = new Thread(() -> r2.methodA(r1, r2), "Thread-2");

        t1.start();
        t2.start();
    }
}
