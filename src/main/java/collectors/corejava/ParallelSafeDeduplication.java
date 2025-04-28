package collectors.corejava;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelSafeDeduplication {
    public static void main(String[] args) {
        // Simulate a huge data source
        var data = IntStream.range(0, 10_000)
                .boxed()
                .flatMap(i -> Stream.of(i, i)) // duplicate everything
                .collect(Collectors.toList());

        // Thread-safe set to track seen elements
        Set<Integer> seen = ConcurrentHashMap.newKeySet();

        // Parallel stream deduplication
        List<Object> unique = data.parallelStream()
                .mapMulti((element, consumer) -> {
                    if (seen.add(element)) { // thread-safe add()
                        consumer.accept(element);
                    }
                })
                .toList();

        System.out.println("Unique elements: " + unique.size()); // 10,000
    }
}
