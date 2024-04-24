package supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<List<Integer>> supplier = ArrayList::new;
        BiConsumer<List<Integer>, Integer> accumulator = List::add;

        BinaryOperator<List<Integer>> combiner = (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
        Function<List<Integer>, List<Integer>> finisher = Function.identity();
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        List<Integer> result = numbers.collect(
                ArrayList::new,     // Supplier
                List::add,          // Accumulator
                List::addAll        // Combiner
        );
        System.out.println(result); // Output will be [1, 2, 3, 4, 5]

    }
}
