package finalizer;

public class FinalizerExample {
    private String resourceName;

    public FinalizerExample(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Cleaning up resource: " + resourceName);
            // Perform cleanup logic here
        } finally {
            // Always call the superclass finalize method
            super.finalize();
        }
    }

    public static void main(String[] args) {
        FinalizerExample example = new FinalizerExample("TestResource");
        // Nullify reference to make the object eligible for garbage collection
        example = null;
        // Request garbage collection (not guaranteed to run immediately)
        System.gc();
        // Pause to give garbage collector time to run (for demonstration purposes)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Program finished.");
    }
}
