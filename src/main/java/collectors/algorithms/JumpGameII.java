package collectors.algorithms;

public class JumpGameII {
    public static int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int jumps = 0, currentEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest point that can be reached
            farthest = Math.max(farthest, i + nums[i]);

            // If we have come to the end of the range covered by the current jump
            if (i == currentEnd) {
                jumps++;  // we need another jump
                currentEnd = farthest;  // update the range

                // If current end is the last or exceeds the last index, break the loop
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("Minimum jumps to reach the end: " + jump(nums));  // Output: 2
    }
}
