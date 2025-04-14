package finalizer;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamExample {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // Use streams to build the string
        String result = IntStream.range(0, 100000)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with streams: " + (endTime - startTime) + "ms");
    }
}