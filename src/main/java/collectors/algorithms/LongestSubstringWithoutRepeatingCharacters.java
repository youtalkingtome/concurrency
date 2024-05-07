package collectors.algorithms;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int[] charIndex = new int[256]; // Array to store the last index of every character seen
        for (int i = 0; i < charIndex.length; i++) {
            charIndex[i] = -1; // Initialize all elements to -1
        }

        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);



            // If the character has been seen and is in the current window
            if (charIndex[currentChar] >= left) {
                System.out.println("Window Change");
                left = charIndex[currentChar] + 1; // Move the left pointer to the right of the last occurrence
            }

            charIndex[currentChar] = right; // Update the last index of the character
            maxLength = Math.max(maxLength, right - left + 1); // Calculate the max length
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(s));  // Output: 3
    }
}
