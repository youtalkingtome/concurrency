package collectors.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String input = "swiss";

        Optional<Character> result = input.chars() // IntStream of char codes
                .mapToObj(c -> (char) c)          // Convert to Character
                .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new, Collectors.counting()
                ))                                // Count frequencies in order
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1) // Keep only non-repeated
                .map(Map.Entry::getKey)
                .findFirst();                     // Get the first one

        result.ifPresentOrElse(
                ch -> System.out.println("First non-repeating character: " + ch),
                () -> System.out.println("No non-repeating character found.")
        );
    }
}