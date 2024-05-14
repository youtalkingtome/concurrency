package collectors.algorithms;

public class PalindromeCheck {

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "radara";
        System.out.println(input + " is palindrome? " + isPalindrome(input));
    }
}
