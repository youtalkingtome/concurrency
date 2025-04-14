package finalizer;

@FunctionalInterface
interface CustomerValidator<T> {
    boolean validate(T input);
}