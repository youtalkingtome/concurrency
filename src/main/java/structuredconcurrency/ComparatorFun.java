package structuredconcurrency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ComparatorFun {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", 90000),
                new Employee("Bob", 120000),
                new Employee("Charlie", 110000)
        );

        // Sorting by salary
        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList(); // Java 16+

        System.out.println(sortedBySalary);

        List<Employee> sortedByNameThenSalary = employees.stream()
                .sorted(Comparator.comparing(Employee::getName)
                        .thenComparing(Employee::getSalary))
                .toList();

        System.out.println(sortedByNameThenSalary);

        List<Employee> employeesWithNulls = new ArrayList<>(employees);
        employeesWithNulls.add(null);

        List<Employee> sortedWithNullsFirst = employeesWithNulls.stream()
                .sorted(Comparator.nullsFirst(Comparator.comparing(Employee::getSalary)))
                .toList();

        System.out.println(sortedWithNullsFirst);

        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparing(Employee::getSalary));

        highestPaid.ifPresent(System.out::println);





    }
}