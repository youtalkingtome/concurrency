package finalizer;

public class StringBufferExample {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            result.append(i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with StringBuffer: " + (endTime - startTime) + "ms");
    }
}