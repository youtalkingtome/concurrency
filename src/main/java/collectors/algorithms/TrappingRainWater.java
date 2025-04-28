package collectors.algorithms;

public class TrappingRainWater {
    public static int trap(int[] height) {


        // min(leftmax,rightMax) -height[i]
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int result = 0;

        // Precalculate leftMax
        int maxLeft = height[0];
        for (int i = 0; i < n; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            leftMax[i] = maxLeft;
        }

        // Precalculate rightMax
        int maxRight = height[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i]);
            rightMax[i] = maxRight;
        }

        // Calculate trapped water
        for (int i = 0; i < n; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return result;
    }


    /*
    You use left and right pointers to scan from both ends.
   leftMax and rightMax track the highest walls on each side.
   Water is trapped where the current height is less than the min of those maxes.
     */
    public static int trapWater(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int[] elevationMap = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped water: " + trap(elevationMap));
        System.out.println("Trapped water: " + trapWater(elevationMap));
    }
}

