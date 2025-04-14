package finalizer;

public class DiscountService {
    public double calculateDiscount(String customerType, double amount) {
        if (customerType.equals("REGULAR")) {
            return amount * 0.1;
        } else if (customerType.equals("VIP")) {
            return amount * 0.2;
        } else if (customerType.equals("NEW")) {
            return amount * 0.05;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        DiscountService service = new DiscountService();
        System.out.println(service.calculateDiscount("VIP", 1000)); // 200.0
    }
}
