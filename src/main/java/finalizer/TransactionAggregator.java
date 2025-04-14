package finalizer;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Transaction {
    private String category;
    private double amount;

    public Transaction(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }
}

public class TransactionAggregator {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("Food", 10.5),
                new Transaction("Food", 20.0),
                new Transaction("Entertainment", 15.0),
                new Transaction("Entertainment", 25.5),
                new Transaction("Food", 5.5),
                new Transaction("Travel", 5.5),
                new Transaction("Travel", 9.5)
        );



        Map<String, Pair<Long, Double>> result = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.summarizingDouble(Transaction::getAmount),
                                summary -> Pair.of(summary.getCount(), summary.getSum())
                        )
                ));

        result.forEach((category, pair) ->
                System.out.println(category + " -> Count: " + pair.getLeft() + ", Total Amount: " + pair.getRight())
        );
    }
}