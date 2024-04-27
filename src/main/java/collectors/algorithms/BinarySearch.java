package collectors.algorithms;

public class BinarySearch {
    // Iterative implementation of binary search
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (array[mid] == target)
                return mid;

            // If target is greater, ignore left half
            if (array[mid] < target)
                left = mid + 1;
                // If target is smaller, ignore right half
            else
                right = mid - 1;
        }

        // If the element is not present in the array
        return -1;
    }

    // Recursive implementation of binary search
    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (array[mid] == target)
                return mid;

            // If target is greater, search right half
            if (array[mid] < target)
                return binarySearchRecursive(array, target, mid + 1, right);
                // If target is smaller, search left half
            else
                return binarySearchRecursive(array, target, left, mid - 1);
        }

        // If the element is not present in the array
        return -1;
    }

    // Test the binary search algorithm
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 10, 40};
        int target = 10;

        int result = binarySearch(array, target);
        if (result != -1)
            System.out.println("Element found at index " + result);
        else
            System.out.println("Element not found in the array");

        int resultRecursive = binarySearchRecursive(array, target, 0, array.length - 1);
        if (resultRecursive != -1)
            System.out.println("Element found at index " + resultRecursive + " (using recursive approach)");
        else
            System.out.println("Element not found in the array (using recursive approach)");
    }
}
