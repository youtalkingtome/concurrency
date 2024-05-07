package collectors;

public class StringReversal {
    public static void main(String[] args) {
        String str = "Hello, world!";

        // Convert string to char array
        char[] charArray = str.toCharArray();

        // Reverse the char array
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }

        // Convert char array back to string
        String reversed = new String(charArray);
        System.out.println("Reversed string using char array: " + reversed);
    }
}
