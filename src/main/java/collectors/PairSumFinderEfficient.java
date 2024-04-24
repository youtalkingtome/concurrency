package collectors;

import java.util.HashMap;
import java.util.Map;

public class PairSumFinderEfficient {
    public static void main(String[] args) {
        int[] array = {11, 4, 9, 8, 2, 7,3}; // Example array
        findPairs(array);
    }

    public static void findPairs(int[] array) {
        if (array == null || array.length < 3) {
            System.out.println("No pairs found or array is too short!");
            return;
        }

        int targetSum = array[0]; // The first element is the target sum
        Map<Integer, Integer> map = new HashMap<>(); // Store elements and their indices

        System.out.println("Pairs with sum " + targetSum + ":");
        boolean found = false;
        for (int i = 1; i < array.length; i++) {
            int complement = targetSum - array[i];

            if (map.containsKey(complement)) {
                System.out.println("(" + complement + ", " + array[i] + ")");
                found = true;
            }

            map.put(array[i], i); // Add current element to the map
        }

        if (!found) {
            System.out.println("No pairs found.");
        }
    }
}
