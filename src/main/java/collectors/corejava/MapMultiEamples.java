package collectors.corejava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapMultiEamples {

    public static void main(String[] args) {
        List<String> input = List.of("apple,banana,apple", "cherry", "date,fig,grape");

        List<String> result = input.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        result.forEach(System.out::println);

        List<String> resultMapMulti = input.stream()
                .<String>mapMulti((str, consumer) -> {
                    for (String word : str.split(",")) {
                        consumer.accept(word);
                    }
                })
                .collect(Collectors.toList());

        //Expand Numbers into Digits
        List<Integer> numbers = List.of(123, 45, 6);
        List<Integer> resultDigits = numbers.stream()
                .map(String::valueOf)
                .flatMap(str -> str.chars().mapToObj(c -> c - '0'))
                .collect(Collectors.toList());

        resultDigits.forEach(System.out::println);

        List<Integer> resultNumberMapMulti = numbers.stream()
                .<Integer>mapMulti((num, consumer) -> {
                    for (char c : String.valueOf(num).toCharArray()) {
                        consumer.accept(c - '0');
                    }
                })
                .collect(Collectors.toList());

        //3: Expand Valid Ranges
        //Goal: Emit all numbers from start to end (inclusive), but only if start ≤ end.
        record Range(int start, int end) {}
        List<Range> ranges = List.of(new Range(1, 3), new Range(5, 5), new Range(8, 6));
        List<Integer> resultRange = ranges.stream()
                .filter(r -> r.start() <= r.end())
                .flatMap(r -> IntStream.rangeClosed(r.start(), r.end()).boxed())
                .collect(Collectors.toList());
        System.out.println("Ranges");
        resultRange.forEach(System.out::println);
        // Explode Word Repetition Instructions
        List<String> inputList = List.of("hello:3", "world:1");
       /* Goal: Use mapMulti() to expand each word by its count.

        "hello:3" → ["hello", "hello", "hello"]
        "world:1" → ["world"]
        Expected Output:

       ["hello", "hello", "hello", "world"]*/


        var resultCount = inputList.stream().flatMap(entry -> {

            String[] parts=entry.split(":");
            String word = parts[0];
            int count = Integer.parseInt(parts[1]);
            return IntStream.range(0,count ).mapToObj(i ->word);
        }).collect(Collectors.toList());
        System.out.println("Expanded");
        resultCount.forEach(System.out::println);

        List<String> resultCountMapMulti = input.stream()
                .<String>mapMulti((entry, consumer) -> {
                    String[] parts = entry.split(":");
                    String word = parts[0];
                    int count = Integer.parseInt(parts[1]);
                    for (int i = 0; i < count; i++) {
                        consumer.accept(word);
                    }
                })
                .collect(Collectors.toList());




    }
}
