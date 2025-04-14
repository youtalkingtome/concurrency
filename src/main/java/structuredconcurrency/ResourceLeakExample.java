package structuredconcurrency;

public class ResourceLeakExample {
    public static void main(String[] args) {
        Thread task = new Thread(() -> {
            while (true) {
                System.out.println("Running forever...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break; // Gracefully exit
                }
            }
        });
        task.start();
        System.out.println("Task started, but never stopped.");
    }
}