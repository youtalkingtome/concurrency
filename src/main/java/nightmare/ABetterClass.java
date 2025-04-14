package nightmare;

/**
 * Class using default methods from Processable interface.
 */
public class ABetterClass implements Proccess {

    // Public method to execute the main logic
    public void process() {
        System.out.println("Starting process...");

        setupConfiguration();
        allocateMemory();
        validateInputs(); // Using default method
        computeResult();
        saveAndLogResult();

        System.out.println("Process completed.");
    }

    // Custom implementation for initialization
    private void initializeResources() {
        System.out.println("Initializing resources...");
        setupConfiguration(); // Default method
        allocateMemory(); // Default method
    }

    // Private method to compute the result
    private void computeResult() {
        System.out.println("Performing computations...");
        System.out.println("Performing addition...");
        System.out.println("Performing multiplication...");
    }

    // Custom implementation for saving and logging the result
    private void saveAndLogResult() {
        System.out.println("Saving and logging result...");
        writeToFile("result.txt", "Sample Result"); // Default method
        logMessage("Process completed successfully."); // Default method
    }

    // Main method to test the class
    public static void main(String[] args) {
        ABetterClass instance = new ABetterClass();
        instance.process();
    }
}
