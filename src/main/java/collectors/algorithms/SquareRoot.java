package collectors.algorithms;

public class SquareRoot {

    public static int mySqrt(int x) {
        if (x < 2) {
            return x; // Return x itself if 0 or 1, since sqrt(0)=0 and sqrt(1)=1
        }

        long left = 2; // Start with 2 to avoid unnecessary checks for numbers less than 2
        long right = x / 2; // No square root will be more than x/2 if x > 1
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long squared = mid * mid;

            if (squared == x) {
                return (int) mid; // Found the exact square root
            } else if (squared < x) {
                left = mid + 1; // Move the left boundary up if squared is less than x
            } else {
                right = mid - 1; // Move the right boundary down if squared is greater than x
            }
        }

        return (int) right; // When left > right, right is the floor value of sqrt(x)
    }

    public static void main(String[] args) {
        int x = 7;
        System.out.println("The integer square root of " + x + " is " + mySqrt(x));
    }
}
