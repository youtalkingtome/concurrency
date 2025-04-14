package finalizer;

import java.util.Map;

@FunctionalInterface
interface DiscountStrategy {
    double applyDiscount(double amount);
}

public class DiscountServiceFunctional {
    private static final Map<String, DiscountStrategy> STRATEGIES = Map.of(
            "REGULAR", amount -> amount * 0.1,
            "VIP", amount -> amount * 0.2,
            "NEW", amount -> amount * 0.05,
            "PREMIUM", amount -> amount * 0.20
    );

    public double calculateDiscount(String customerType, double amount) {
        return STRATEGIES.getOrDefault(customerType, amt -> 0.0).applyDiscount(amount);
    }
    public static void main(String[] args) {
        DiscountService service = new DiscountService();
        System.out.println(service.calculateDiscount("VIP", 1000)); // 200.0
    }
}