package collectors.algorithms;

public class PalindromeChecker {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false; // Negative numbers can't be palindromes
        }

        int reversed = 0;
        int original = x;

        while (x != 0) {
            int digit = x % 10; //121 %10=1
            System.out.println(digit);

            reversed = reversed * 10 + digit; //1*10+21=21
            System.out.println(reversed);
            x /= 10;//121 =121/10=
            System.out.println(x);

        }

        return original == reversed;
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();

        // Example usage:
        int num1 = 121;
        int num2 = -121;
        int num3 = 10;

        System.out.println("Is " + num1 + " a palindrome? " + checker.isPalindrome(num1));
        System.out.println("Is " + num2 + " a palindrome? " + checker.isPalindrome(num2));
        System.out.println("Is " + num3 + " a palindrome? " + checker.isPalindrome(num3));
    }
}
