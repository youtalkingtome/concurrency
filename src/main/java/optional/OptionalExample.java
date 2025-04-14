package optional;

import java.util.Optional;

public class OptionalExample {

    private static Optional<String> docNumber = Optional.empty();

    public static void main(String[] args) {

        docNumber.orElse("");
        Optional<Optional<String>> nestedOptional = Optional.of(Optional.of("MACOS"));
        nestedOptional.get().ifPresent(System.out::println);// AVOID THIS

        Optional<String> flatOptional = Optional.of("MACOS");
        flatOptional.ifPresent(System.out::println);


    }
}
