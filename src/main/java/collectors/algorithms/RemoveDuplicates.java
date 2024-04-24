package collectors.algorithms;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0; // Slow pointer
        for (int j = 1; j < nums.length; j++) { // Fast pointer
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j]; // Update nums[i] with the value of nums[j]
            }
        }

        // Length of the new array with duplicates removed
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates remover = new RemoveDuplicates();

        // Example usage:
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        System.out.println("Original Array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        int newLength = remover.removeDuplicates(nums);

        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
