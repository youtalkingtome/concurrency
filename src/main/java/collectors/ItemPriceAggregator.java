package collectors;

import collectors.model.Item;
import collectors.model.Orders;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ItemPriceAggregator {

    public static void main(String[] args) {

        List<Orders> orders = Arrays.asList(new Orders(Arrays.asList(new Item("Pears",200.45, 22),new Item("Mangoes",120.45, 45),new Item("Oranges",145.67, 22),new Item("Mandarins",207.45, 89))),
                new Orders(Arrays.asList(new Item("Pears",200.45, 21),new Item("Mangoes",120.45, 459),new Item("Oranges",345.67, 22),new Item("Mandarins",207.45, 89))));

        Map<String, Double> totalAmountPerItem = orders.stream()
                .flatMap(order -> order.items.stream())
                .collect(Collectors.groupingBy(Item::getName,
                        Collectors.summingDouble(item -> item.price * item.quantity)));
        totalAmountPerItem.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));

    }
}
