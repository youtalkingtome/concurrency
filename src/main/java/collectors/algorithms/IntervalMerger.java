package collectors.algorithms;

import java.util.*;

public class IntervalMerger {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals based on their starting points
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextBegin) {
                // There is overlap, so we merge the current and next intervals
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, move to the next interval
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge(intervals);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
