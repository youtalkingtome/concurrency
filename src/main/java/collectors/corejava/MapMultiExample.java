package collectors.corejava;

import java.util.List;
import java.util.stream.Collectors;

public class MapMultiExample {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2);

        List<Integer> result = numbers.stream()
                .<Integer>mapMulti((num, consumer) -> {
                    if (num % 2 == 0) {
                        consumer.accept(num);
                        consumer.accept(num * 2);
                        consumer.accept(num -5);
                    }
                })
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}
