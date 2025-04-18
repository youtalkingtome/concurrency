package collectors.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListMerge {


    public static void main(String[] args) {
        // Two sample ArrayLists
        List<String> list1 = Arrays.asList("apple", "banana", "orange");
        List<String> list2 = Arrays.asList("banana", "grape", "apple");

        // Merge and remove duplicates using streams
        List<String> mergedList = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .collect(Collectors.toList());

        // Print the result
        System.out.println("Merged List without duplicates: " + mergedList);
    }
}
