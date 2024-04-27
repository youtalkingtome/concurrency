package collectors.algorithms;

public class StringToIntegerWithoutLibrary {
    public static int stringToInteger(String str) {
        int intValue = 0;
        boolean isNegative = false;
        int i = 0;

        // Check if the string is empty
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String is empty");
        }

        // Check for leading whitespace
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
            i++;
        }

        // Check for sign
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            isNegative = (str.charAt(i) == '-');
            i++;
        }

        // Convert each character to integer
        while (i < str.length()) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                intValue = intValue * 10 + (ch - '0');
            } else {
                // If non-digit character is encountered, break the loop
                break;
            }
            i++;
        }

        // Apply sign
        if (isNegative) {
            intValue = -intValue;
        }

        return intValue;
    }

    public static void main(String[] args) {
        String str = "12345";
        System.out.println("String to integer: " + stringToInteger(str));

        String negativeStr = "-9876";
        System.out.println("String to integer (negative): " + stringToInteger(negativeStr));

        String invalidStr = "abc";
        try {
            System.out.println("String to integer (invalid): " + stringToInteger(invalidStr));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid string format: " + invalidStr);
        }
    }
}
