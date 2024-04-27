package collectors.algorithms;

public class MaxSubArraySum {

    public static void main(String[] args) {

        int[] exampleArray = {2, 1, 5, 1, 3, 2};
        int maxSum = 0;
        int windowSum = 0;
        int k = 3;
        for (int j = 0; j < exampleArray.length; j++) {
            windowSum += exampleArray[j];

            if (j >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= exampleArray[j - k + 1];

            }
        }
        System.out.print(maxSum);
    }
}
