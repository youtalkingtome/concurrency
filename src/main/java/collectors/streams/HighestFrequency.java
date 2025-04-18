package collectors.streams;


import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HighestFrequency {
    public static void main(String[] args) throws IOException {
        // Read all lines from the file into a single string
        String content = Files.readString(Paths.get("input.txt"));

        // Process the content using streams
        Map<String, Long> wordCounts = Arrays.stream(content
                        .toLowerCase()
                        .replaceAll("[^a-zA-Z ]", "") // Remove punctuation
                        .split("\\s+"))               // Split into words
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Find the word with the highest frequency
        Optional<Map.Entry<String, Long>> maxEntry = wordCounts.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        // Print the result
        maxEntry.ifPresent(entry -> {
            System.out.println("Most frequent word: " + entry.getKey());
            System.out.println("Frequency: " + entry.getValue());
        });
    }
}
