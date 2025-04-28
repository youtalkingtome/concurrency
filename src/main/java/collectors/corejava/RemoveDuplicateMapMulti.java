package collectors.corejava;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class RemoveDuplicateMapMulti {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 2, 3, 3, 4, 5, 5);

        Stream.of(1, 2, 2, 3, 3, 4, 5, 5)
                .distinct()
                .forEach(System.out::println);


        Set<Integer> seen = new HashSet<>();

        List<Object> unique = numbers.stream()
                .mapMulti((number, consumer) -> {
                    if (seen.add(number)) { // add() returns true if not already present
                        consumer.accept(number);
                    }
                })
                .toList();

        System.out.println(unique); // [1, 2, 3, 4, 5]
    }
}
