package nightmare;

/**
 * Interface containing default methods for common processes.
 */
public interface Proccess {

    // Default method to set up configuration
    default void setupConfiguration() {
        System.out.println("Default: Setting up configuration...");
    }

    // Default method to allocate memory
    default void allocateMemory() {
        System.out.println("Default: Allocating memory...");
    }

    // Default method to validate inputs
    default void validateInputs() {
        System.out.println("Default: Validating inputs...");
        checkForNulls("input1", "input2");
        validateFormats("SampleInput");
    }

    // Helper methods (private in interfaces since Java 9)
    private void checkForNulls(Object... inputs) {
        System.out.println("Default: Checking for null values...");
        for (Object input : inputs) {
            if (input == null) {
                throw new IllegalArgumentException("Null value found!");
            }
        }
    }

    private void validateFormats(String input) {
        System.out.println("Default: Validating data format for: " + input);
        if (!input.matches("[a-zA-Z0-9]*")) {
            throw new IllegalArgumentException("Invalid format!");
        }
    }

    // Default method to log messages
    default void logMessage(String message) {
        System.out.println("Log: " + message);
    }

    // Default method to write to a file
    default void writeToFile(String filename, String content) {
        System.out.println("Writing to file: " + filename);
        // Simulate file writing
    }
}
