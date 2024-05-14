package collectors.algorithms;

import java.util.HashMap;
import java.util.Map;

public class TwoSumFinder {
        public int[] twoSum(int[] array, int target) {
            Map<Integer,Integer> countMap=new HashMap<Integer, Integer>();
            for( int j=0;  j< array.length-1; j++)
            {
                int complement = target-array[j];
                if (countMap.containsKey(complement)) {
                    return new int[]{countMap.get(complement), j};
                }
                countMap.put(array[j],j);
            }throw new IllegalArgumentException("No solution found.");
    }
}

