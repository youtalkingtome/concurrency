package collectors.algorithms;

public class SubArrayMaxSumofKSize {

    public static int findMaxSumofSubArray(int k, int[] array) {
        int maxSubArraySum = 0, windowSum = 0;

        for (int end = 0; end < array.length; end++) {
            windowSum += array[end]; // Add the next element to the window
            // Adding the next element to calculate the subArray Sum

            // When the size of the subArray is equal to K , update
            // the max sum to the subarray Sum and forward the window
            // one element by subtracting the older element from the subArraySum
            if (end >= k - 1) {
                maxSubArraySum = Math.max(maxSubArraySum, windowSum);
                windowSum -= array[end - k + 1];
            }
        }

        return maxSubArraySum;
    }

    public static void main(String[] args) {
        int[] exampleArray = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum of a subarray of size " + k + ": " + findMaxSumofSubArray(k, exampleArray));
    }
}
