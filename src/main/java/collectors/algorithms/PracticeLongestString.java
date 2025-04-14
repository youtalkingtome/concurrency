package collectors.algorithms;

import java.util.HashMap;
import java.util.Map;

public class PracticeLongestString {

    public static void main(String args[]) {
        String input = "bbbbbbbbaaaaaadabad";
        System.out.println(lengthofLongestSubStringString(input));

    }

    public static int lengthofLongestSubString(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        int maxSubStringLength = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            if (countMap.containsKey(currentChar))
            {
                start = Math.max(countMap.get(currentChar) + 1, start);

            }
            countMap.put(currentChar, end);
            maxSubStringLength = Math.max(maxSubStringLength, end - start + 1);
        }

        return maxSubStringLength;
    }
    public static String lengthofLongestSubStringString(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        int maxSubStringLength = 0;
        int maxStart= 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            if (countMap.containsKey(currentChar))
            {
                start = Math.max(countMap.get(currentChar) + 1, start);

            }
            countMap.put(currentChar, end);
            if(end-start+1 > maxSubStringLength)
            {
                maxSubStringLength = end - start + 1;
                maxStart = start;
            }

        }

        return s.substring(maxStart, maxStart + maxSubStringLength);
    }

    public void maxSumArray() {

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
