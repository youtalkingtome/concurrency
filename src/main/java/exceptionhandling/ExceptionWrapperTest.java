package exceptionhandling;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static exceptionhandling.ExceptionInterface.unchecked;

public class ExceptionWrapperTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c");
        List<String> uppercasedStrings = strings.stream()
                .map(unchecked(s -> exceptionThrowingMethod(s))) // Use the wrapper method
                .collect(Collectors.toList());
    }
    public static String exceptionThrowingMethod(String s) throws IOException {
        // Imagine this method could throw an IOException
        return s.toUpperCase();
    }

}
