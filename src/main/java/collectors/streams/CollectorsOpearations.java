package collectors.streams;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsOpearations {


    public static void main(String[] args) {


        // Group words by length and count how many words are in each group

        String[] arr = {"cat", "dog", "lion", "tiger", "goat", "ant"};

        List<String> words = Arrays.asList("cat", "dog", "lion", "tiger", "goat", "ant");

        //Count of each word
        words.stream().collect(Collectors.groupingBy(String::length,Collectors.counting()));
        Map<Integer, Long> result = words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(result);

        //Group names by first character and sort them
        List<String> names = Arrays.asList("Alice", "Andy", "Bob", "Ben", "Charlie");

        var sortAndGroup =names.stream().collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.collectingAndThen(Collectors.toList(),
                list -> list.stream().sorted().collect(Collectors.toList()))));

        System.out.println(sortAndGroup);

        Map<Character, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(
                        name -> name.charAt(0),
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream().sorted().collect(Collectors.toList())
                        )
                ));

        grouped.forEach((ch, list) -> System.out.println(ch + ": " + list));

        //Highest paid employee in each department
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "HR", 60000),
                new Employee("Charlie", "IT", 70000),
                new Employee("David", "IT", 65000)
        );


        Map<String, Employee> highestPaid = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(e -> e.salary)),
                                Optional::get
                        )
                ));

        highestPaid.forEach((dept, emp) -> System.out.println(dept + " -> " + emp));

        // Count character frequency in a string
        String str = "banana";

        Map<Character, Long> freq = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(freq);

        //Group numbers into even and odd
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Map<Boolean, List<Integer>> groupedNumbers = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0));


        // 1. Sort a list of strings alphabetically
        List<String> list1 = Arrays.asList("banana", "apple", "cherry");
        System.out.println("1: " + list1.stream().sorted().collect(Collectors.toList()));

        // 2. Sort by length
        List<String> list2 = Arrays.asList("kiwi", "apple", "banana");
        System.out.println("2: " + list2.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList()));

        // 3. Sort by length, then alphabetically
        List<String> list3 = Arrays.asList("apple", "bat", "ant", "banana");
        System.out.println("3: " + list3.stream().sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder())).collect(Collectors.toList()));

        // 4. Sort integers descending
        List<Integer> list4 = Arrays.asList(5, 1, 9, 3);
        System.out.println("4: " + list4.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));


        // 7. Sort dates in reverse order
        List<LocalDate> dates = Arrays.asList(LocalDate.now(), LocalDate.of(2020, 1, 1));
        System.out.println("7: " + dates.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        // 8. Sort by last character
        List<String> list8 = Arrays.asList("dog", "cat", "apple");
        System.out.println("8: " + list8.stream().sorted(Comparator.comparing(s -> s.charAt(s.length() - 1))).collect(Collectors.toList()));

        // 9. Sort by number of vowels
        List<String> list9 = Arrays.asList("apple", "banana", "kiwi");
        System.out.println("9: " + list9.stream().sorted(Comparator.comparing(CollectorsOpearations::countVowels)).collect(Collectors.toList()));

        // 10. Sort by absolute value
        List<Integer> list10 = Arrays.asList(-5, -1, 3, 2, -9);


    }
    public static long countVowels(String s) {
        return s.chars().filter(c -> "aeiouAEIOU".indexOf(c) != -1).count();
    }

    static class Employee {
        String name;
        String department;
        int salary;

        Employee(String name, String department, int salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String toString() {
            return name + " (" + salary + ")";
        }
    }



}
