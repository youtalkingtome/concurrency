import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

    public class LargeListExample {
        public static void main(String[] args) {
            List<Integer> oneMillionNumbers = IntStream.range(0, 1000000)
                    .boxed()
                    .collect(Collectors.toList());

            // Use the list as needed
            System.out.println("List size: " + oneMillionNumbers.size());
        }
    }

