import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompletableFutureUseCases {

    private static String callApi (String get_inventory_from_store1){

        return get_inventory_from_store1;
    }
    public static void main(String[] args) {

        // Combine results of both API calls
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() ->
                callApi("get_inventory_from_store1"));
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() ->
                callApi("get_inventory_from_store2"));


        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (response1, response2) -> response1 + ", " + response2);
        combinedFuture.thenAccept(System.out::println);
        System.out.println("Hello world!");


        CompletableFuture.supplyAsync(() -> fetchDataFromDatabase())
                .thenApply(data -> processData(data))
                .thenAccept(processedData -> System.out.println("Processed Data: " + processedData));


        CompletableFuture<Double> futureA = CompletableFuture.supplyAsync(() -> getService1Data());
        CompletableFuture<Double> futureB = CompletableFuture.supplyAsync(() -> getService2Data());

        futureA.thenCombine(futureB, (result1, result2) -> result1 + result2)
                .thenAccept(result -> System.out.println("Combined Result: " + result));

        //Heavy Computation
        List<Integer> oneMillionNumbers = IntStream.range(0, 1000000)
                .boxed()
                .collect(Collectors.toList());
        CompletableFuture.supplyAsync(() -> calculateStandardDeviation())
                .thenAccept(result -> System.out.println("Computation Result: " + result));



    }

    private static <U> U getService2Data() {
        return null;
    }

    private static <U> U getService1Data() {
        return null;
    }

    private static Object processData(Object data) {
        return data;
    }

    private static <U> U fetchDataFromDatabase() {
        return null;
    }

    public static double calculateStandardDeviation() {
        // Calculate the mean
        OptionalDouble meanOptional = IntStream.range(0, 1000000).average();
        double mean = meanOptional.isPresent() ? meanOptional.getAsDouble() : 0;

        // Calculate the standard deviation
        double variance = IntStream.range(0, 1000000)
                .mapToDouble(i -> Math.pow(i - mean, 2))
                .average()
                .orElse(0.0);
        double standardDeviation = Math.sqrt(variance);

        System.out.println("Standard Deviation: " + standardDeviation);
        return standardDeviation;
    }
}