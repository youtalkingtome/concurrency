package exceptionhandling;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class ExceptionHandler {

    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://example.com", "malformed://url");
        urls.stream()
                .map(url -> {
                    try {
                        return new URL(url);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                })
                .forEach(System.out::println);
    }
}
