package collectors.algorithms;

import java.util.*;

public class IntervalInsertion {

    public static int[][] insertAndMerge(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        // Add all intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge all overlapping intervals to one considering newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            // Adjusting the newInterval to absorb the current interval
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the merged interval
        result.add(newInterval);

        // Add the rest of the intervals
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] mergedIntervals = insertAndMerge(intervals, newInterval);

        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
