package collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {

    public static void main(String[] args) {

        String content = "Java is Java Java , is, is, is";
   Map<String,Long > wordCount=      Arrays.stream(content.toLowerCase().
                replaceAll("[^a-zA-Z ]", "")
                .split("\\s+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Optional<Map.Entry<String, Long>> maxEntry = wordCount.entrySet().stream().max(Map.Entry.comparingByValue());
        maxEntry.ifPresent(entry -> {
            System.out.println("Most frequent word: " + entry.getKey());
            System.out.println("Frequency: " + entry.getValue());
        });

        List<String> list1 = Arrays.asList("apple", "banana", "orange");
        List<String> list2 = Arrays.asList("banana", "grape", "apple");

        // Merge and remove duplicates using streams
        List<String> mergedList = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .collect(Collectors.toList());

        // Print the result
        System.out.println("Merged List without duplicates: " + mergedList);

        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String input = "swiss";
        input.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new , Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() ==1)
                .map(Map.Entry::getKey)
                .findFirst();

       // Group strings by length
        List<String> wordsGrp = Arrays.asList("apple", "banana", "kiwi", "pear", "grape");

        wordsGrp.stream().collect(Collectors.groupingBy(String::length));

        //Group by first character and count frequency
        wordsGrp.stream().collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.counting()));

        //Group Employees by department

        List<Employee> employees = Arrays.asList(
                new Employee("Bob", "IT", new BigDecimal(20000)),
                new Employee("Charlie", "HR", new BigDecimal(20000)),
                new Employee("David", "IT", new BigDecimal(500000)));

        employees.stream().collect(Collectors.groupingBy(employee -> employee.getDepartment()));

        //sort employees by salary
        employees.stream().sorted(Comparator.comparing(e -> e.getSalary())).collect(Collectors.toList());

        //Group by department and sort employees by name inside each group
        employees.stream().
                collect(Collectors.groupingBy(emp -> emp.getDepartment(), Collectors.collectingAndThen(Collectors.toList(),
                list -> list.stream().
                        sorted(Comparator.comparing(e -> e.getName())).
                        collect(Collectors.toList()) )));

        //. Find the highest-paid employee in each department
        employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.
                comparing(e -> e.getSalary())
                ), Optional::get)));





}

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Employee {
        private String name;
        private String department;
        private BigDecimal salary;
    }
}

