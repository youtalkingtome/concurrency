package collectors.algorithms;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;  // Add one to the current digit
                return digits;  // Return the modified array
            }
            digits[i] = 0;  // Set current digit to 0 if it was 9
        }

        // If all digits are 9, e.g., [9, 9, 9], the resulting array will be [1, 0, 0, 0]
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;  // Set the first element to 1
        // All other elements are initialized to 0 by default in Java
        return newDigits;
    }

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        digits = plusOne(digits);
        for (int digit : digits) {
            System.out.print(digit);
        }
        System.out.println();  // Output should be 1000
    }
}

