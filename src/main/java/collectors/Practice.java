package collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

        //Find out first non repeating characeter in the String.
        String input = "swwiss";
        var result = input.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new , Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() ==1)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println("Problem 49" +result);

        String input1 = "programming";

        var map = input1.chars() // stream of int
                .mapToObj(c -> (char) c) // convert to Character
                .filter(Character::isLetter) // optional: only letters
                .map(Character::toLowerCase) // ignore case
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));

        System.out.println("Problem 49" +result);


                /*.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1) // keep duplicates
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());*/


        // Group strings by length
        List<String> wordsGrp = Arrays.asList("apple", "banana", "kiwi", "pear", "grape");

        wordsGrp.stream().collect(Collectors.groupingBy(String::length));

        //Group by first character and count frequency
        wordsGrp.stream().collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.counting()));

        //Group Employees by department

        List<Employee> employees = Arrays.asList(
                new Employee("Bob", "IT", new BigDecimal(20000), LocalDate.of(2020, 5, 20), "22"),
                new Employee("Charlie", "HR", new BigDecimal(20000),LocalDate.of(2023, 5, 20),"23"),
                new Employee("David", "IT", new BigDecimal(500000), LocalDate.of(2024, 5, 20), "35"));

        employees.stream().collect(Collectors.groupingBy(employee -> employee.getDepartment()));

        //sort employees by salary
        employees.stream().sorted(Comparator.comparing(e -> e.getSalary())).collect(Collectors.toList());

        //Group by department and sort employees by name inside each group
        var res1= employees.stream().
                collect(Collectors.groupingBy(emp -> emp.getDepartment(), Collectors.collectingAndThen(Collectors.toList(),
                list -> list.stream().
                        sorted(Comparator.comparing(e -> e.getName())).
                        collect(Collectors.toList()) )));

        //. Find the highest-paid employee in each department
        employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.
                comparing(e -> e.getSalary())
                ), Optional::get)));


        // find most repeaated String

        List<String> wordsList = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        var count = wordsList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                        .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println("Count of the most repeated String" +count);

        employees.stream().sorted(Comparator.comparing(emp ->emp.joiningDate)).limit(3).collect(Collectors.toList());

        employees.stream().collect(Collectors.groupingBy(emp ->emp.department, Collectors.counting()));

       var occuranceOfALetter=  wordsList.stream().flatMap(word -> word.chars().mapToObj(c -> (char)c))
                .collect(Collectors.groupingBy(c -> c , Collectors.counting()));

        var occuranceOfALetterLeast=  wordsList.stream().flatMap(word -> word.chars().mapToObj(c -> (char)c))
                .collect(Collectors.groupingBy(c -> c , Collectors.counting()));
        System.out.println("occuranceOfALetter" +occuranceOfALetter);


        Optional<Character> leastRepeated =
                wordsList.stream()                     // Stream<String>
                        .flatMapToInt(String::chars)   // IntStream of all characters
                        .mapToObj(c -> (char) c)       // Stream<Character>
                        // ---------------- aggregate counts, preserving first‑seen order
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,    // keeps insertion order
                                Collectors.counting()))
                        // ---------------- now pick the minimum‑frequency entry
                        .entrySet().stream()           // Stream<Map.Entry<Character,Long>>
                        .min(Comparator.comparingLong(Map.Entry::getValue)) // smallest count
                        .map(Map.Entry::getKey);       // Optional<Character>

        leastRepeated.ifPresent(System.out::println);   // → prints ‘o

        //Finding duplicates from an inTeger Array
        int[] arr= {1,2,3,4,4,4,6};
        Arrays.stream(arr).boxed().collect(Collectors.groupingBy(n->n , Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() >1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        Product product1 = new Product("Laptop", "Electronics", 1200.99);
        Product product2 = new Product("Smartphone", "Electronics", 799.49);
        Product product3 = new Product("T-Shirt", "Apparel", 19.99);
        Product product4 = new Product("Shoes", "Apparel", 59.99);
        Product product5 = new Product("Headphones", "Electronics", 149.99);

        // Create orders
        Order order1 = new Order(1, Arrays.asList(product1, product3), new Date(2025, 4, 1));
        Order order2 = new Order(2, Arrays.asList(product2, product4), new Date(2025, 4, 5));
        Order order3 = new Order(3, Arrays.asList(product5), new Date(2025, 4, 10));

        // Create customers
        Customer customer1 = new Customer(101, "Alice", Arrays.asList(order1, order2));
        Customer customer2 = new Customer(102, "Bob", Arrays.asList(order3));

        List<Customer> customers = Arrays.asList(customer1, customer2);

        var customersWithNoOrders = customers.stream()
                .filter(c -> c.getOrders().isEmpty())
                .collect(Collectors.toList());

        //Extract and Flatten Products from All Orders
        var productForAllOrders = customers.stream().flatMap(cust -> cust.getOrders().stream()).
                flatMap(product ->product.getProducts().stream()).collect(Collectors.toList());
        //Calculate Total Spent by Each Customer

        var sumPfProductPrice = customers.stream().collect(Collectors.toMap(Function.identity(), cust ->cust.getOrders().stream()
                .flatMap(o ->o.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum()));
        customers.stream().collect(Collectors.groupingBy(Function.identity(),
                Collectors.summingDouble((cust -> cust.getOrders().stream()
                        .flatMap(order ->order.getProducts().stream()).mapToDouble(Product::getPrice).sum())
                )));

        // Group Orders by Date
        customers.stream().flatMap(cust -> cust.getOrders().stream())
                .collect(Collectors.groupingBy(Order::getOrderDate));
        //Find Most Expensive Product Ordered

        Product mostExpensiveProduct = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .flatMap(o -> o.getProducts().stream())
                .max(Comparator.comparing(Product::getPrice))
                .orElseThrow(NoSuchElementException::new);

        //Count Orders for Each Product
        customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .flatMap(o -> o.getProducts().stream()).collect(Collectors.groupingBy(Product::getName, Collectors.counting()));


        //Filter Orders with Products Above a Price

        double priceThreshold = 100.0;
        List<Order> highValueOrders = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .filter(o -> o.getProducts().stream()
                        .anyMatch(p -> p.getPrice() > priceThreshold))
                .collect(Collectors.toList());

        //Find Customers Who Ordered Specific Product Category
        String category = "Electronics";
        List<Customer> customersWithCategory = customers.stream()
                .filter(c -> c.getOrders().stream()
                        .flatMap(o -> o.getProducts().stream())
                        .anyMatch(p -> p.getCategory().equals(category)))
                .collect(Collectors.toList());

        //Calculate Average Price of Products per Order

        Map<Integer, Double> avgPricePerOrder = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .collect(Collectors.toMap(
                        Order::getOrderId,
                        o -> o.getProducts().stream()
                                .mapToDouble(Product::getPrice)
                                .average()
                                .orElse(0.0)
                ));
        customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .collect(Collectors.groupingBy(order -> order.getOrderId(),Collectors.averagingDouble(o ->o.getProducts().stream()
                        .mapToDouble(Product::getPrice).average().orElse(0.0)) ));


        // Find Customers with Orders in Last Month
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        List<Customer> recentCustomers = customers.stream()
                .filter(c -> c.getOrders().stream()
                        .anyMatch(o -> o.getOrderDate().toInstant()
                                .atZone(ZoneId.systemDefault()).toLocalDate().isAfter(oneMonthAgo)))
                .collect(Collectors.toList());
        // Sort Customers by Total Spending

        List<Customer> sortedCustomers = customers.stream()
                .sorted(Comparator.comparingDouble(c -> -c.getOrders().stream()
                        .flatMap(o -> o.getProducts().stream())
                        .mapToDouble(Product::getPrice)
                        .sum()))
                .collect(Collectors.toList());

        List<Map.Entry<String, Double>> sortedCustomerSpendings = customers.stream()
                .map(c -> Map.entry(
                        c.getName(),
                        c.getOrders().stream()
                                .flatMap(o -> o.getProducts().stream())
                                .mapToDouble(Product::getPrice)
                                .sum()))
                .sorted(Map.Entry.<String, Double>comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());


        //Merging two Arrays:
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};

        int[] merged = Arrays.stream(new int[][]{arr1, arr2})
                .flatMapToInt(Arrays::stream)
                .toArray();

        System.out.println(Arrays.toString(merged));
        //Extract all Digits from the Strings.

        List<String> lines = List.of("Room 101", "Level 42B", "3rd floor");
        IntStream digits = lines.stream()
                .flatMapToInt(line ->
                        line.chars()            // IntStream of code points
                                .filter(Character::isDigit));
        System.out.println(digits.summaryStatistics());


        String s= "I am learning Java I";
        List<String> tokenList = Arrays.stream(s.split(" ")).collect(Collectors.toList());

        Arrays.stream(s.split(" ")).max(Comparator.comparing(String::length));

        var resultOne=  Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        resultOne.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));
        var wordMap =Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));

        long maxLength = resultOne.values().stream()
                .max(Comparator.naturalOrder())
                .orElse(0L);

        System.out.println("maxiumm length" +maxLength);

        // Remove duplicates from the string and return in the same order
        String duplicates ="dabdfg";
        duplicates.chars().distinct().mapToObj(x ->(char)x).forEach(System.out::println);

        //Suppose, if we want to total all the salaries of Female employees we can do it as below.

        //03 Find the word that has the second highest length
        Arrays.stream(s.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get();
        //Given a sentence, find the occurrence of each word

        List<Integer> list = Arrays.asList(2, 5, 1, 9, 6);
        list.stream().max(Integer::compare).get();
        list.stream().min(Integer::compare).get();

        int secondHighest = list.stream().sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .orElseThrow();
        int secondLowest = list.stream()
                .sorted()
                .distinct()
                .skip(1)
                .findFirst()
                .orElseThrow();
        list.stream().filter(n -> n/2==0).collect(Collectors.toList());

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicateSet = list.stream()
                .filter(x -> !seen.add(x))
                .collect(Collectors.toSet());
        List<String> names = Arrays.asList("John", "Paul", "Tom", "Jerry");
        names.stream().collect(Collectors.groupingBy(String::length));



    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Employee {
        private String name;
        private String department;
        private BigDecimal salary;
        private LocalDate joiningDate;
        private String age;
        public enum Sex { MALE, FEMALE }
    }
    static class Product {
        String name;
        String category;
        double price;

        Product(String name, String category, double price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public String getName() { return name; }
        public String getCategory() { return category; }
        public double getPrice() { return price; }
    }

    static class Order {
        int orderId;
        List<Product> products;
        Date orderDate;

        Order(int orderId, List<Product> products, Date orderDate) {
            this.orderId = orderId;
            this.products = products;
            this.orderDate = orderDate;
        }

        public int getOrderId() { return orderId; }
        public List<Product> getProducts() { return products; }
        public Date getOrderDate() { return orderDate; }
    }

    static class Customer {
        int customerId;
        String name;
        List<Order> orders;

        Customer(int customerId, String name, List<Order> orders) {
            this.customerId = customerId;
            this.name = name;
            this.orders = orders;
        }

        public int getCustomerId() { return customerId; }
        public String getName() { return name; }
        public List<Order> getOrders() { return orders; }
    }
}

