package optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalInStreams {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> result = numbers.stream()
                .filter(num -> num > 5)
                .findFirst();
        int value = result.orElse(-1);  // Result will be -1 if no number > 5

    // Instead, a simpler approach:
        int number = numbers.stream()
                .filter(num -> num > 5)
                .findFirst()
                .orElse(-1);

    }
}
