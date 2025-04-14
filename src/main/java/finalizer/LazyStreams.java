package finalizer;

import java.util.List;
import java.util.stream.Stream;

public class LazyStreams {
    public static void main(String[] args) {
        List<String> names = List.of("Vikas", "Ali", "Dev", "Stephan");
        // Creating a stream pipeline
        Stream<String> stream = names.stream()
                .filter(name -> {
                    System.out.println("Filtering: " + name);
                    return name.startsWith("A") || name.startsWith("C");
                })
                .map(name -> {
                    System.out.println("Mapping: " + name);
                    return name.toUpperCase();
                });
        System.out.println("Pipeline is created, but nothing executed yet!");

        // Triggering execution with a terminal operation
        stream.forEach(System.out::println);
    }
}
