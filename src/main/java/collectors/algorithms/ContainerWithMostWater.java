package collectors.algorithms;
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static int maxAreaBruteForce(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i+1; j < height.length; j++) {
                int width=j-i;
                int h = Math.min(height[i], height[j]);
                int area = h * width;
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxAreaBruteForce(height)); // Output: 49
    }
}
