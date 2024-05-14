package collectors.algorithms;

public class BinaryAddition {

    public static String addBinary(String a, String b) {
        // Initialize the StringBuilder to build the result string
        StringBuilder result = new StringBuilder();

        // Start from the end of both strings
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Iterate until all digits are processed or until the carry is 0
        while (i >= 0 || j >= 0 || carry != 0) {
            // Sum the carry with the current digits from a and b
            int sum = carry;
            if (i >= 0) sum += a.charAt(i) - '0'; // Subtract '0' to convert char to int
            if (j >= 0) sum += b.charAt(j) - '0'; // Subtract '0' to convert char to int

            // Append the rightmost digit of the sum to the result
            result.append(sum % 2);

            // Calculate the new carry
            carry = sum / 2;

            // Move to the next digits
            i--;
            j--;
        }

        // Reverse the result to get the correct order
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println("Sum of " + a + " and " + b + " is " + addBinary(a, b));
    }
}
