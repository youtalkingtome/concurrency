package finalizer;

public class FinalizerAttack {
    public static void main(String[] args) {
        try {
            // Attempt to create a VulnerableClass object
            new ExploitingSubclass();
        } catch (IllegalStateException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Trigger garbage collection
        System.gc();

        // Wait for finalizer to run
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check if the object has been resurrected
        ExploitingSubclass resurrected = ExploitingSubclass.getResurrectedInstance();
        if (resurrected != null) {
            System.out.println("Exploit successful: Object resurrected!");
            resurrected.use(); // Will throw an exception because it's not properly initialized
        } else {
            System.out.println("Exploit failed: Object not resurrected.");
        }
    }
}