package collectors;

public class PairSumFinder {
    public static void main(String[] args) {
        int[] array = {10, 3, 4, 5, 6, 7}; // Example array
        findPairs(array);
    }

    public static void findPairs(int[] array) {
        if (array == null || array.length < 3) {
            System.out.println("No pairs found or array is too short!");
            return;
        }

        int targetSum = array[0]; // The first element is the target sum

        System.out.println("Pairs with sum " + targetSum + ":");
        boolean found = false;
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum) {
                    System.out.println("(" + array[i] + ", " + array[j] + ")");
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No pairs found.");
        }
    }
}
