package finalizer;

public class StringBuilderExample {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // Using StringBuilder for efficient concatenation
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            result.append(i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with StringBuilder: " + (endTime - startTime) + "ms");
    }
}