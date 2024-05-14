package collectors.algorithms;

public class TrappingRainWater {
    public static int trap(int[] height) {
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

    public static void main(String[] args) {
        int[] elevationMap = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped water: " + trap(elevationMap));
    }
}

