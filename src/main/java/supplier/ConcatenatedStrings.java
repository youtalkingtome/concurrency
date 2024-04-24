package supplier;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class ConcatenatedStrings {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("This ", "is ", "Example", "from",  "Vikas Taank");

        // Supplier Creates and Object and Provide
        // In this case its a String Builder
        Supplier<StringBuilder> supplier = StringBuilder::new;

        // Accumulator is used to append the strings
        BiConsumer<StringBuilder, String> accumulator = StringBuilder::append;

        // Combiner: it is mostly the parallel processing use case where in this combine the two
        //Strings in to one.
        BinaryOperator<StringBuilder> combiner = (sb1, sb2) -> sb1.append(sb2.toString());

        // Finisher converts the String Builder to String.
        Function<StringBuilder, String> finisher = StringBuilder::toString;

        // Create a Collector
        Collector<String, ?, String> collector = Collector.of(supplier, accumulator, combiner, finisher);

        // Collect the elements
        String result = stream.collect(collector);

        System.out.println(result);
    }
}
