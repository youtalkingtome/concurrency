package collectors.corejava;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class LazyDeduplicationExample {
    private static final int MAX_CACHE_SIZE = 10000; // tune based on memory

    public static void main(String[] args) throws IOException {
        try (Stream<String> lines = new BufferedReader(new FileReader("hugefile.txt")).lines()) {

            Set<String> recentSeen = Collections.newSetFromMap(
                    new LinkedHashMap<>() {
                        protected boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
                            return size() > MAX_CACHE_SIZE;
                        }
                    }
            );

            lines
                    .mapMulti((line, consumer) -> {
                        if (recentSeen.add(line)) {
                            consumer.accept(line);
                        }
                    })
                    .forEach(System.out::println);
        }
    }
}
