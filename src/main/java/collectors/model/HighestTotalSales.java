package collectors.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HighestTotalSales {

    public static void main(String[] args) {

        List<Transaction> transactions = null;

        Optional<Map.Entry<LocalDate, BigDecimal>> highestSalesDay;
        highestSalesDay = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getDate,
                        Collectors.reducing(BigDecimal.ZERO, Transaction::getAmount, BigDecimal::add)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }
}
