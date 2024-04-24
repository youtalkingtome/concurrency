package supplier;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Stream;
public class UnModifiableSet {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Java", "Unmodifiable ", "Example");

        Collector<String, Set<String>, Set<String>> immutableSet = Collector.of(
                HashSet::new,          // Supplier
                Set::add,               // Accumulator
                (left, right) -> {       // Combiner
                    left.addAll(right);
                    return left;
                },
                Collections::unmodifiableSet// Finisher
        );

        Set<String> result = stream.collect(immutableSet);
        System.out.println(result);
    }
}

