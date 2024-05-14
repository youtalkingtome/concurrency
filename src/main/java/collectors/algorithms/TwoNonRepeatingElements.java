package collectors.algorithms;

public class TwoNonRepeatingElements {

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 9, 2, 4,2,4,2,4};  // Example array
        findTwoNonRepeating(arr);
    }

    private static void findTwoNonRepeating(int[] arr) {
        int xor = 0;
        for (int value : arr) {
            xor ^= value;
        }

        // Get the rightmost set bit (bit position where the two non-repeating elements differ)
        int rightmostSetBit = xor & -xor;

        int num1 = 0;
        int num2 = 0;

        // Divide elements into two groups based on the rightmost set bit
        for (int value : arr) {
            if ((value & rightmostSetBit) != 0) {  // Bit is set
                num1 ^= value;
            } else {  // Bit is not set
                num2 ^= value;
            }
        }

        System.out.println("The two non-repeating elements are " + num1 + " and " + num2);
    }
}
