package collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CartesianProduct {

    List<Integer> list1 = Arrays.asList(1, 2, 3);
    List<Integer> list2 = Arrays.asList(4, 5);

    List<int[]> cartesianProduct = list1.stream()
            .flatMap(i -> list2.stream().map(j -> new int[]{i, j}))
            .collect(Collectors.toList());

}
