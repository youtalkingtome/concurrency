package finalizer;

import java.util.List;
import java.util.stream.Collectors;

public class MapMultiExample {

    public static void main(String[] args) {

        List<String> strings = List.of("a", "b", "c");

        List<String> result = strings.stream()
                .<String>mapMulti((element, consumer) -> {
                    consumer.accept(element.toUpperCase());
                    consumer.accept(element.toLowerCase());
                })
                .collect(Collectors.toList());

    }
}
