package collectors.corejava;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapMultiStateExample {
    public static void main(String[] args) {
        Stream<String> input = Stream.of("apple", "banana", "apple", "orange", "banana", "grape");

        // Use a Map to keep track of occurrences
        Map<String, Integer> state = new HashMap<>();

        // Use mapMulti to carry and update state while transforming
        Stream<String> resultStream = input.mapMulti((element, consumer) -> {
            // Update the count in the state map
            state.merge(element, 1, Integer::sum);

            // Emit the element only if it occurs for the first time
            if (state.get(element) == 1) {
                consumer.accept(element);
            }
        });

        // Collect the distinct elements
        List<String> distinctElements = resultStream.collect(Collectors.toList());

        // Print the distinct elements and the state map
        System.out.println("Distinct elements: " + distinctElements);
        System.out.println("State (occurrences): " + state);
    }
}