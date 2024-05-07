package collectors.algorithms;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                // Push the current number and reset k
                countStack.push(k);
                k = 0;
                // Push current string and start a new one
                stringStack.push(currentString);
                currentString = "";
            } else if (c == ']') {
                StringBuilder decodedString = new StringBuilder(stringStack.pop());
                int count = countStack.pop();
                // Append currentString count times
                for (int i = 0; i < count; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString.toString();
            } else {
                currentString += c;
            }
        }

        return currentString;
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println("Decoded string: " + decodeString(s));  // Output: "aaabcbc"

    }
}
