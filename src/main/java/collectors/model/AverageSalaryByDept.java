package collectors.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageSalaryByDept {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee("Vikas",new Department("IT"),new BigDecimal(212345.67)),
                new Employee("Ravi",new Department("Commercial"),new BigDecimal(12345.67)),
                new Employee("Rajni",new Department("Procurment"),new BigDecimal(322345.67)),
                new Employee("Sinha",new Department("Commercial"),new BigDecimal(42345.67)));

        Map<Department, Double> averageSalaryByDepartment = employees.stream()
                .filter(e -> e.getSalary().compareTo(new BigDecimal("50000")) > 0)
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getSalary,
                                Collectors.averagingDouble(BigDecimal::doubleValue))));

        averageSalaryByDepartment.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey().getName() + " = " + entry.getValue()));
    }
}
