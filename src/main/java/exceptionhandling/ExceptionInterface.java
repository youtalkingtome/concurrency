package exceptionhandling;

import java.util.function.Function;

@FunctionalInterface
public interface ExceptionInterface<T, R, E extends Exception> {
    R apply(T t) throws E;

    public static <T, R, E extends Exception> Function<T, R> unchecked(ExceptionInterface<T, R, E> function) {
        return t -> {
            try {
                return function.apply(t);
            } catch (Exception e) {
                // Wrap and rethrow the checked exception as an unchecked one
                throw new RuntimeException(e);
            }
        };
    }

}