package collectors.algorithms;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingString {


    public static int lengthOfLongestSubstringVikas(String s) {
       String string="abcabcabab";
       // Keep a map for character to Integers
        //use two pointers start and end.
        // store every unique character in the map
        //whenever you find a repeating character, move the window and the start pointer after the
        // repeating character
        //maximum length of the substring will be the length until you find the repeating character.
        return 5;
    }


    //Solution: Use a sliding window to maintain a substring without repeating characters.
    // Start with an empty window and expand it by adding characters from the string.
    // If a repeating character is found, shrink the window from the left until the repeating character is removed.
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> currentCharMap = new HashMap<>();
        int maxSubstringLength = 0;

        for (int start = 0, end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            if (currentCharMap.containsKey(currentChar)) {
                start = Math.max(currentCharMap.get(currentChar) + 1, start);
            }

            currentCharMap.put(currentChar, end);
            maxSubstringLength = Math.max(maxSubstringLength, end - start + 1);
        }

        return maxSubstringLength;
    }

    public static void main(String[] args) {
        String exampleString = "abcabcebba";
        System.out.println("Length of the longest substring: " + lengthOfLongestSubstring(exampleString));
    }
}