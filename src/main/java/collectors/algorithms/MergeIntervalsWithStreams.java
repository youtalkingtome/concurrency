package collectors.algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class MergeIntervalsWithStreams {
    public static void main(String[] args) {
        List<int[]> intervals = List.of(
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        );

        List<int[]> merged = merge(intervals);

        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }

    static List<int[]> merge(List<int[]> intervals) {
        if (intervals.isEmpty()) return List.of();

        // Sort intervals based on starting point
        List<int[]> sorted = intervals.stream()
                .sorted(Comparator.comparingInt(a -> a[0]))
                .collect(Collectors.toList());

        // Merge using a LinkedList
        LinkedList<int[]> merged = new LinkedList<>();
        sorted.forEach(interval -> {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        });

        return merged;
    }
}
