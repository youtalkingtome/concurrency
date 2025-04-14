package finalizer;

public class VulnerableClass {
    private boolean initialized;

    public VulnerableClass() {
        if (!criticalInitialization()) {
            throw new IllegalStateException("Initialization failed");
        }
        initialized = true;
    }

    private boolean criticalInitialization() {
        // Simulate failure
        return false;
    }

    public void use() {
        if (!initialized) {
            throw new IllegalStateException("Object not properly initialized");
        }
        System.out.println("Using VulnerableClass object.");
    }
}


