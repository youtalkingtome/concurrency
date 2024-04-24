package collectors.algorithms;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false; // No opening parenthesis to match
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
                    return false; // Mismatched parenthesis
                }
            }
        }
        return stack.isEmpty(); // Check if there are any remaining opening parenthesis
    }

    public static void main(String[] args) {
        ValidParentheses validator = new ValidParentheses();

        // Example usage:
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";

       // System.out.println("Is '" + s1 + "' valid? " + validator.isValid(s1));
        System.out.println("Is '" + s2 + "' valid? " + validator.isValid(s2));
        //System.out.println("Is '" + s3 + "' valid? " + validator.isValid(s3));
       // System.out.println("Is '" + s4 + "' valid? " + validator.isValid(s4));
       // System.out.println("Is '" + s5 + "' valid? " + validator.isValid(s5));
    }
}
