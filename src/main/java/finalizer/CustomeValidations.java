package finalizer;

public class CustomeValidations {

    public class CustomValidatorExample {
        public static void main(String[] args) {
            CustomerValidator<String> emailValidator = email -> email.contains("@") && email.endsWith(".com");
            CustomerValidator<Integer> positiveNumberValidator = num -> num > 0;
            CustomerValidator<String> isNotBlank = string -> !string.isBlank();

            System.out.println(emailValidator.validate("test@example.com")); // true
            System.out.println(emailValidator.validate("invalid-email")); // false
            System.out.println(emailValidator.validate("")); // true

            System.out.println(positiveNumberValidator.validate(5)); // true
            System.out.println(positiveNumberValidator.validate(-2)); // false
        }
    }
}
