package finalizer;

public class StringConcatenationExample {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // Using string concatenation in a loop
        String result = "";
        for (int i = 0; i < 100000; i++) {
            result += i; // Each iteration creates a new String object
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with string concatenation: " + (endTime - startTime) + "ms");
    }
}