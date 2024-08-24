package exceptionhandling;
import java.util.List;
public class ImmutableListExample {
    public static void main(String[] args) {
        List<String> immutableList = List.of("Item1", "Item2", "Item3");

        // Guava's ImmutableList is immutable by definition, no additional actions are needed
        // immutableList.add("Item4"); // This will throw an exception

        immutableList.add("VIkas");

        System.out.println(immutableList);

    }
}