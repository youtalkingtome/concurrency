package collectors.algorithms;

import java.util.*;

public class LongestChain {

    // Method to check if s2 is a subsequence of s1
    public static boolean isSubsequence(String s1, String s2) {
        int j = 0;
        for (int i = 0; i < s1.length() && j < s2.length(); i++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
        }
        return j == s2.length();
    }

    // Method to find the longest chain of strings
    public static int longestChain(String[] strings) {
        Arrays.sort(strings, Comparator.comparingInt(String::length));
        int n = strings.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxChainLength = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isSubsequence(strings[j], strings[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxChainLength = Math.max(maxChainLength, dp[i]);
        }

        return maxChainLength;
    }

    // Main method to test the longestChain function
    public static void main(String[] args) {
        String[] strings = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println("Longest chain length: " + longestChain(strings));
    }
}
