package collectors.algorithms;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0; // Slow pointer
        for (int j = 0; j < nums.length; j++) { // Fast pointer
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i; // Length of the new array with occurrences of val removed
    }

    public static void main(String[] args) {
        RemoveElement remover = new RemoveElement();

        // Example usage:
        int[] nums = {3, 2, 2, 3, 4, 5, 3};
        int val = 3;
        System.out.println("Original Array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        int newLength = remover.removeElement(nums, val);

        System.out.println("Array after removing occurrences of " + val + ":");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
